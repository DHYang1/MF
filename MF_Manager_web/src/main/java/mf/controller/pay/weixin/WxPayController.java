package mf.controller.pay.weixin;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mf.mapper.PayInOrderDetailMapper;
import mf.mapper.PayInOrderMapper;
import mf.pojo.PayInOrder;
import mf.pojo.PayInOrderDetail;
import mf.pojo.PayInOrderDetailExample;
import mf.pojo.PayInOrderDetailExample.Criteria;
import mf.service.wx.GoodsTrade;
import mf.service.wx.GoodsTradeService;

@Controller
public class WxPayController {

	@Autowired GoodsTradeService goodsTradeService;
	@Autowired PayInOrderMapper payInOrderMapper;
	@Autowired  PayInOrderDetailMapper  detailMapper;
	
	
	Log logger=LogFactory.getLog(WxPayController.class);
	//微信统一下单的接口
	@RequestMapping(value = "/createOrder", method = {RequestMethod.GET, RequestMethod.POST})
	public  Map<String,Object> createOrder(HttpServletRequest request,HttpServletResponse response,String tradeId) throws Exception{
		 Map<String, Object> resultMap = new HashMap<String, Object>();
		 //TODO 需要差选 订单
	       // GoodsTrade goodsTrade = goodsTradeService.queryGoodsTradeById(request.getParameter("tradeId"));//获取订单，根据需要自己编写
	        long tradeId1= new Long(tradeId);
	        PayInOrder goodsOrder = payInOrderMapper.selectByPrimaryKey(tradeId1);//获取订单，根据需要自己编写
	        // 获取订单详情信息
	           PayInOrderDetailExample example = new  PayInOrderDetailExample();
	           Criteria criteria = example.createCriteria();
	           criteria.andPayInOrderIdEqualTo(tradeId1);
	        List<PayInOrderDetail> selectByExample = detailMapper.selectByExample(example);
	        PayInOrderDetail detail = null;
	        if(selectByExample!=null && selectByExample.size()>0){
	        	detail=selectByExample.get(0);	        	
	        }
	        
	        String price = goodsOrder.getAmount()+"";
	        int price100 = new BigDecimal(price).multiply(new BigDecimal(100)).intValue();
	        if(price100<=0){
	            resultMap.put("msg","付款金额错误");
	            resultMap.put("code","500");
	            return resultMap;
	        }
	         //设置回调地址-获取当前的地址拼接回调地址
	         String url = request.getRequestURL().toString();
	         String domain = url.substring(0, url.length()-13);
	       //订单生成的机器 IP
	         String spbill_create_ip = request.getRemoteAddr();
	         System.out.println("订单生成的机器IP："+spbill_create_ip);
	         
	         //生产环境
	         String notify_url= domain+"wxNotify.html";
	         //测试环境
	         //String notify_url = "http://1f504p5895.51mypc.cn/cia/app/wxNotify.html";
            //创造签名  下单的参数
	         
	          UnifiedOrderRequest orderRequest = new UnifiedOrderRequest();
	         SortedMap<Object,Object> parameters = new TreeMap<Object,Object>();
	         parameters.put("appid",orderRequest.getAppid()); //应用ID
	         parameters.put("mch_id",orderRequest.getMch_id());  // 商户号 
	         parameters.put("nonce_str",PayUtil.create_nonce_str());// 随机字符串
	         parameters.put("body",detail.getProductName()); //测试   订单的名字
	         //parameters.put("out_trade_no", orderRequest.getOut_trade_no()); //订单id goodsOrder
	         parameters.put("out_trade_no", goodsOrder.getPayInOrderId());
	         parameters.put("fee_type", "CNY");  
	         parameters.put("total_fee",price);  
	         parameters.put("spbill_create_ip",spbill_create_ip);//  CommonUtil.toIpAddr(request)
	         parameters.put("notify_url", orderRequest.getNotify_url()); 
	         parameters.put("trade_type", "APP");  
	         //设置签名
	         String sign = WxUtils.createSign("UTF-8",parameters);
	         parameters.put("sign", sign);// 签名  
	     
	         //封装请求参数结束
	         String requestXML =WxUtils.getRequestXml(parameters);  
	        //调用统一下单接口
	         
	        String UNIFIED_ORDER_URL="https://api.mch.weixin.qq.com/pay/unifiedorder";    
	         String result =WxUtils.httpsRequest(UNIFIED_ORDER_URL, "POST", requestXML);
	         //TODO
	         System.out.println("\n"+result);
	         try {
	             /**统一下单接口返回正常的prepay_id，再按签名规范重新生成签名后，将数据传输给APP。参与签名的字段名为appId，partnerId，prepayId，nonceStr，timeStamp，package。注意：package的值格式为Sign=WXPay**/
	                Map<String, String> map = WxUtils.doXMLParse(result);
	                SortedMap<Object, Object> parameterMap2 = new TreeMap<Object, Object>();  
	                
	                
	                parameterMap2.put("appid", "APPID");  
	                parameterMap2.put("partnerid", "ConfigUtil.MCH_ID"); // TODO 
	                
	                
	                parameterMap2.put("prepayid", map.get("prepay_id"));  
	                parameterMap2.put("package", "Sign=WXPay");  
	                parameterMap2.put("noncestr","");  
	                //本来生成的时间戳是13位，但是ios必须是10位，所以截取了一下
	                parameterMap2.put("timestamp", Long.parseLong(String.valueOf(System.currentTimeMillis()).toString().substring(0,10)));  
	                String sign2 = WxUtils.createSign("UTF-8",parameterMap2);
	                parameterMap2.put("sign", sign2);  
	                resultMap.put("code","200");
	                resultMap.put("msg",parameterMap2);
	            } catch (JDOMException e) {
	                e.printStackTrace();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	            return resultMap;
	        
	
	
	}
	
	
	/**
     * 微信异步通知

     */
    @RequestMapping("/wxNotify.html")
    public Map<String, String>  wxNotify(HttpServletRequest request,HttpServletResponse response) throws IOException, JDOMException{
    	Map<String, String> mapVal = new HashMap<String, String>();
        //读取参数  
        InputStream inputStream ;  
        StringBuffer sb = new StringBuffer();  
        inputStream = request.getInputStream();  
        String s ;  
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));  
        while ((s = in.readLine()) != null){  
            sb.append(s);  
        }  
        in.close();  
        inputStream.close();  
        //解析xml成map  
        Map<String, String> m = new HashMap<String, String>();  
        m = WxUtils.doXMLParse(sb.toString());  
        for(Object keyValue : m.keySet()){
            System.out.println(keyValue+"="+m.get(keyValue));
        }
        //过滤空 设置 TreeMap  
        SortedMap<Object,Object> packageParams = new TreeMap<Object,Object>();        
        Iterator it = m.keySet().iterator();  
        while (it.hasNext()) {  
            String parameter = (String) it.next();  
            String parameterValue = m.get(parameter);  

            String v = "";  
            if(null != parameterValue) {  
                v = parameterValue.trim();  
            }  
            packageParams.put(parameter, v);  
        }  
    
        //判断签名是否正确  
        String resXml = "";  
        if(WxUtils.isTenpaySign("UTF-8", packageParams)) {
             if("SUCCESS".equals((String)packageParams.get("result_code"))){ 
                 // 这里是支付成功  
            	 
            	 String total_fee = (String)packageParams.get("total_fee"); 
            	 mapVal.put("trade_state", "SUCCESS");
            	 mapVal.put("total_fee", total_fee);
            	 mapVal.put("status", "支付成功"); 	
            	  String transaction_id = (String)packageParams.get("transaction_id");//微信支付订单号
                  String out_trade_no = (String)packageParams.get("out_trade_no"); //商户订单号
                  String mch_id = (String)packageParams.get("mch_id"); //商户号 
                  String openid = (String)packageParams.get("openid");  //用户标识
                    long long1 =new Long(out_trade_no);
                  PayInOrder order = payInOrderMapper.selectByPrimaryKey(long1);
                  order.setStatus((byte) 2);
                  payInOrderMapper.insertSelective(order);
              	return mapVal;
             }
          
             
             mapVal.put("status","支付失败");
         	return mapVal;
        
        }
		return null;
            	
	//  微信退款  TODO
            	 
            	
            	 
            	 
                 //////////执行自己的业务逻辑////////////////  
                /* String mch_id = (String)packageParams.get("mch_id"); //商户号 
                 String openid = (String)packageParams.get("openid");  //用户标识
                 String out_trade_no = (String)packageParams.get("out_trade_no"); //商户订单号
                 
                 String transaction_id = (String)packageParams.get("transaction_id"); //微信支付订单号
                 GoodsTrade gt = new GoodsTrade();*/
               /*  gt.setOut_trade_no(out_trade_no);
				// TODO
				// 查询订单 根据订单号查询订单 GoodsTrade -订单实体类
				//GoodsTrade trade = "订单查询";
                 GoodsTrade trade =new GoodsTrade();
                 
                //TODO
				if (!ConfigUtil.MCH_ID.equals(mch_id) || trade == null || new BigDecimal(total_fee)
						.compareTo(new BigDecimal(trade.getPrice()).multiply(new BigDecimal(100))) != 0) {
					logger.info("支付失败,错误信息：" + "参数错误");
					resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
							+ "<return_msg><![CDATA[参数错误]]></return_msg>" + "</xml> ";
				} else {
					if ("no_pay".equals(trade.getPayStatus())) {// 支付的价格
						
						//&& "wait_buyer_pay".equals(trade.getStatus())
						// 订单状态的修改。根据实际业务逻辑执行

						resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
								+ "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";

					} else {
						resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
								+ "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
						logger.info("订单已处理");
					}
				}

			} else {
				logger.info("支付失败,错误信息：" + packageParams.get("err_code"));
				resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
						+ "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
			}

		}
        
        else {
			resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
					+ "<return_msg><![CDATA[通知签名验证失败]]></return_msg>" + "</xml> ";
			logger.info("通知签名验证失败");
		}

		// ------------------------------
		// 处理业务完毕
		// ------------------------------
		BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
		out.write(resXml.getBytes());
		out.flush();
		out.close();

    }*/
    
             }

	 
}
