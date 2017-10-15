package mf.controller.pay;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.druid.util.StringUtils;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayResponse;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;

import MF_Utils.JsonUtils;
import MF_Utils.Result;
import mf.mapper.CommodityMapper;
import mf.mapper.DesignerMapper;
import mf.mapper.PayInOrderDetailMapper;
import mf.mapper.PayInOrderMapper;
import mf.pojo.Commodity;
import mf.pojo.Designer;
import mf.pojo.PayInOrder;
import mf.pojo.PayInOrderDetail;
import mf.pojo.PayInOrderDetailExample;
import mf.pojo.PayInOrderDetailExample.Criteria;
import net.sf.json.JSONObject;

@Controller
public class PayController {

	@Autowired   PayInOrderMapper  orderMapper;
	@Autowired   PayInOrderDetailMapper detailMapper;
	@Autowired   DesignerMapper   designerMapper;
	@Autowired  CommodityMapper  commodityMapper;
	Log logger=LogFactory.getLog(PayController.class);
	
	// 基础配置

	// 交易安全检验码，由数字和字母组成的32位字符串
	public static String key = "";

	// 当前页面跳转后的页面 要用 http://格式的完整路径，不允许加?id=123这类自定义参数
	// 域名不能写成http://localhost/alipay.auth.authorize_jsp_utf8/return_url.jsp
	// ，否则会导致return_url执行无效
	//public static String return_url = "http://120.78.68.30:8080/alipay.auth.authorize_jsp_utf8/return_url.jsp";
	public static String return_url ="http://120.78.68.30:8080/MF_Manager_web/fankui.jsp";
	// 合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
	public static String partner = "2088421779867467"; //PID

	// 商户的私钥,需要PKCS8格式，RSA公私钥生成：https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
	public static String private_key="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCXl0U0ZFdACrb76I+tnTh+WFMzTnmhZhJsq4fnga5Riopn8FRtPlWvKjc/UhR47DWw2lP5uNOpBhitxMQfJiocyQoNX4PssFjJcExzGKPmb8B7ziirtNZPN7BZAl1gXKmoAvyij7Xt9PYudoAciTJsKXv4EImsw6v1gtBS4yZASHLP9QrBR2nRFXSRm+7nd4+BixMYi6mWg+wc2XTQ9HDTBwpKygrube2dskgqWgZ9rwperE8YLhF2/iVNayHdwf4dIru5f/Hn/ttdRVsk8YfI/u0osSQv8lUwhhXoZWxN1THhOSRLWZtMWkNyfZGMBHS/E76UrlteL7q3DQyWj7gBAgMBAAECggEAB7iSs8pwjzh8fXQo7UTWvcit5C0ZENlsEtDhyS7XvBt8VTLueen030kdK0J4/He7fFiCcnOxhChlVWRyQMvm1TSAKJI22/VXcFsh6bLVlkUW3rdvZt99EufZOY9fRisyEPal+3mqYIZbi55JhCqQwOWUBNyCxqPovEZ/adlb92YlHh/X4NDroKw1Cc/mhGM7GHKQZU1KwUktieqIxs3KJT9Hrk+gJ+YHE9zdb7jBNjtAWGUj/acIW4Zc1r6GTh5fwezcSRsOe9c2dR9hv/HcqB0SVKx4mIv942iF+1FvnIM6EdQkmIBQL4sRk5drmjE4dADADmS2NJX4ht4oD7ryqQKBgQDW7HNm9jGCwcgsD5huTaaPpcRWrRbaB6aOe6Q/qdVQhPdynwfwjjPzMCCi9y/rCB2Tufa+XeIcl6YziioZMIWS1fMXAhLy3V5lthjK5VUtuk58pvp6Nx+1WYiCvmUAQ6VnCHTqi/1D/W+8wzdofuGH7KnpmqI/KH5F4A1k4cRKRwKBgQC0kCT+sz/lZ1uR+llfcpGw48dI7lFf2WpDeGbZ8HkXLPlHyd/6M5PJgaqza3E02HdX/lNegooTqP1rT/UHF/Cn/uTtuwELZZuHREC+UNHWTSNKfJcfYxLcA0mMHtlkEVTd8F8ctVIqOViSI09s4JdyyWy94ZmjjKYsh/PtMszHdwKBgBVPSHny+yG92P0VZsW5CUTA6OC3NMbVb1w9QiHV0wKyzF4fCoh9cQUxxmqiG6wwF86n56EkaeDv4FjH4DizKOtQL1QeroZKEKwBDCBB8Noh2NpfLAKmKIywnepoulb2XhYDLqR60NfG7ydGK94+hloVyxsQa/nbJ/oBpxJTmETNAoGBALDWj3TnpweMr5ELaCZjta5RlualiQrfiwQjUk/WBTIeeNHHM9X+V5o9pSnta0T/T/rc+VeRb5uLoQ5Nk8NrveU6bYkq4f4AeE8FGIeL7cb9azfTR8qUpG7XxVs3B1/K3Zwzg2NBbgQuf8E4VdxjJdBk11wsK+WSpVjtmYdQfmBHAoGAAT4L+kSO68p1gZ+3HkWhUl71eMFOzDEfxyLx7oEfg+vlxbqG8zbgiZzxQH11wqztkC8Khir3/VPwJYxtFnN6jDO/H5wRRcaimjxoYmyHheIAag0Blxn/TH1qzYaWy32zQBfRVJdqEtjYyaQTJGnyTuxCxVpm1B3e1xZl1JjFV7I=";
	//已写
	// 支付宝的公钥，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
	public static String alipay_public_key ="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";
	// 签名方式
	public static String sign_type = "RSA";

	// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
	//public static String log_path = "C://";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";

	// 接收通知的接口名
	public static String service = "http://120.78.68.30:8080/MF_Manager_web/callbacks";
	// public static String service = "mobile.securitypay.pay";
	// APPID
	public static String app_id = "2017092108852519";//APPID

	static AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", app_id, private_key,
			"json",input_charset, alipay_public_key, "RSA");
//, produces = "text/html;charset=UTF-8", method = { RequestMethod.GET }
	// 支付下订单
	@RequestMapping(value = "/alipay")
	@ResponseBody
	public Result alipay(HttpServletRequest request1) {
		//long userId,long designerId,long shopId,String designerServiceIds,String shopServiceIds,String dateTime,Integer 
		//period,String out_trade_no,
		// 用户ID,设计师ID,设计师服务IDs,店铺服务IDS,预约的时间 ，预约时间段
		long userId=12;
		long designerId=123;
		long shopId=1;
		String designerServiceIds="1,2";
		String shopServiceIds="1";
		StringBuilder sb = new StringBuilder();
		//总金额
		Double totalAcount=0d;
		if(designerId!=0){
			sb.append(designerId);
			//查询出设计师 
			Designer designer = designerMapper.selectByPrimaryKey(designerId);
			
			//  设计师ID-服务id+价格+服务的名字
			String[] split = designerServiceIds.split(",");
			for (String string : split) {
				Long  strLong =new Long(string);
				List<Long> lists =new ArrayList();
				lists.add(strLong);
				for (Long long1 : lists) {
					  if(long1==1){
						  Double haircutPrice = designer.getHaircut(); 
						  totalAcount=totalAcount+haircutPrice;
						  sb.append("-").append(long1).append("+").append(haircutPrice+"").append("+").append("烫染");
					  }
					if(long1==2){
						Double hotPrice  = designer.getHotDyed(); 
						  totalAcount=totalAcount+hotPrice;
						  sb.append("-").append(long1).append("+").append(hotPrice+"").append("+").append("烫染");
					}
					if(long1==3){
						  Double makeUpPrice = designer.getMakeups(); 
						  totalAcount=totalAcount+makeUpPrice;
						  sb.append("-").append(long1).append("+").append(makeUpPrice+"").append("美妆");		
					}
				}
			}
			
			
			
		}
		//店铺，
		sb.append(",").append(shopId);
		String[] split = shopServiceIds.split(",");
		for (String string : split) {
			Long  strLong =new Long(string);
			List<Long> lists =new ArrayList();
			lists.add(strLong);
			for (Long long1 : lists) {
				Commodity commodity = commodityMapper.selectByPrimaryKey(long1);
				sb.append("-").append(long1).append("+").append(commodity.getPrice()+"").append("+").append(commodity.getCommodityName());
				
				
			}
			}
		
		
		
		
/*		Long  noNum= new Long(out_trade_no);
		//获取订单号
		PayInOrder inorder = orderMapper.selectByPrimaryKey(noNum);
		//获取商品名称
		PayInOrderDetailExample example = new PayInOrderDetailExample();
		Criteria criteria = example.createCriteria();
		criteria.andPayInOrderIdEqualTo(noNum);
		List<PayInOrderDetail> selectByExample = detailMapper.selectByExample(example);
		
		*/
		System.out.println("-----------------------------------------");
		System.out.println(sb);
		AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
		// SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		//String body,String subject,String total_amount, subject
		/*String total_amount="120";
		String subject="苹果";*/
		model.setOutTradeNo(System.currentTimeMillis()+"");
		model.setTimeoutExpress("30m");
		//model.setTotalAmount(inorder.getAmount()+"");
		model.setTotalAmount(0.01+"");
		model.setProductCode("QUICK_MSECURITY_PAY");
		//model.setSubject(selectByExample.get(0).getProductName());
		model.setSubject("iphoneX");
		model.setBody(sb+"");
		request.setBizModel(model);
		request.setNotifyUrl("http://120.78.68.30:8080/MF_Manager_web/callbacks");

		AlipayTradeAppPayResponse response;
		try {
			response = alipayClient.sdkExecute(request);
			if(response.isSuccess()){
				
				System.out.println("下单成功");
			}
			else{	
				System.out.println("下单成功");
			}
			String body2 = response.getBody();
			System.out.println(body2);
			System.out.println(response);
			Map map=new HashMap();
			map.put("data", body2);
			map.put("userId", userId);
			return Result.ok(map);
		} catch (AlipayApiException e) {
			e.printStackTrace();
			return null;
		}
	


	}
	

	
	
	
	//
	// 支付宝支付结果异步通知业务处理
	@RequestMapping(value = "/callbacks",produces = "text/html;charset=UTF-8",method=RequestMethod.POST)
	@ResponseBody
	public String callbacks(HttpServletRequest request) throws Exception {		
		  String   retValue=null;
		//获取支付宝POST过来反馈信息
		  System.out.println("------------支付宝异步回调---------");
		  System.out.println(request);
		  
		  DataInputStream in;  
	      String wxNotifyXml = "";  
	      try {  
	      in = new DataInputStream(request.getInputStream());  
	      byte[] dataOrigin = new byte[request.getContentLength()];  
	      in.readFully(dataOrigin); // 根据长度，将消息实体的内容读入字节数组dataOrigin中  
	  
	      if(null != in) in.close(); // 关闭数据流  
	      wxNotifyXml = new String(dataOrigin); // 从字节数组中得到表示实体的字符串  
	      System.out.println(wxNotifyXml+"}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}");
	      String[] split = wxNotifyXml.split("&");
	      List<Map<String,String>> lists =new ArrayList<>();
	    for (String string : split) {
	    	System.out.println("进入遍历");
	    	String[] split2 = string.split("=");
	    	//获取支付宝的流水号
	    	String trade_no="";
	    	if(split2[0].equals("trade_no")){
	    		trade_no=split2[1];
	    		
	    	}
	    	//支付宝金额
	    	String total_amount="";
	    	  if(split2[0].equals(total_amount)){
	    		  total_amount=split2[1]+"";
	    		  
	    	  }
	    	
	    	if(split2[0].equals("trade_status")){
	    		System.out.println("进入判断‘’‘’‘’‘’‘’‘’‘’‘’");
	    		String string2 = split2[1]; 
	    		System.out.println(string2);
	    		if(string2.equals("TRADE_SUCCESS")){
	    			System.out.println("成功支付=====================");
	    			  PayInOrder payInOrder = new PayInOrder();//创建订单
	    			  PayInOrderDetail payDetail = new PayInOrderDetail();
	    			  long id=System.currentTimeMillis();
	    			  payInOrder.setPayInOrderId(id); 
	    			  Double amount = new Double(total_amount);
	    			  payInOrder.setAmount(amount);//支付金额
	    			  payInOrder.setRmake(trade_no);//支付宝流水号
	    			  payInOrder.setCtime(new Date());
	    			  Long payId=new Long(1);
	    			  payInOrder.setPayVendorId(payId);//设置支付方式
	    			  //设置订单详情
	    			  payDetail.setPayInOrderDetailId(System.currentTimeMillis());
	    			  payDetail.setPayInOrderId(id);
	    			
	    		}
	    		else{
	    			System.out.println("支付失败++++++++++++++++++++++++");
	    			
	    		}
	    	}
		}

	    
	      } catch (IOException e) {  
	      e.printStackTrace();  
	      }
	      
	      
		return wxNotifyXml;   

		
		
		}
		

	// 退款


	@RequestMapping(value = "/pay/refund", method = RequestMethod.POST)
	public String orderPayRefund(HttpServletRequest request, HttpServletResponse response, String tradeno,
			String orderno, String total_amount,String refund_reason) {
		   String strResponse = null;
		logger.info("[/pay/refund]");
		// 实例化客户端
		AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", app_id,
				private_key, "json", "utf-8", alipay_public_key, "RSA2");
/*
		if (StringUtils.isEmpty(tradeno) && StringUtils.isEmpty(orderno)) {
			return Result.build(500, "请输入订单号和支付号");
			
			 * WebUtil.response(response, WebUtil.packJsonp(callback, JSON
			 * .toJSONString(new JsonResult(-1, "订单号不能为空", new ResponseData()),
			 * SerializerFeatureUtil.FEATURES)));
			 
		}*/
		AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest(); // 统一收单交易退款接口
		// 只需要传入业务参数
		Map<String, Object> param = new HashMap<>();
		param.put("out_trade_no", orderno); // 商户订单号
		param.put("trade_no", tradeno);// 退款单号
		param.put("refund_amount",total_amount);// 退款金额
		param.put("refund_reason", refund_reason);// 退款金额
		param.put("out_request_no",System.currentTimeMillis() + ""); // 退款单号
		alipayRequest.setBizContent(JSONUtils.toJSONString(param)); // 不需要对json字符串转
		Map<String, Object> restmap = new HashMap<>();// 返回支付宝退款信息
		boolean flag = false; // 查询状态
		try {

			AlipayTradeRefundResponse alipayResponse = alipayClient.execute(alipayRequest);
			// AlipayTradeRefundResponse alipayResponse =
			// AlipayUtil.getAlipayClient().execute(alipayRequest);
			if (alipayResponse.isSuccess()) {
				// 调用成功，则处理业务逻辑
				if ("10000".equals(alipayResponse.getCode())) {
					// 订单创建成功
					flag = true;
					restmap.put("out_trade_no", alipayResponse.getOutTradeNo());
					restmap.put("trade_no", alipayResponse.getTradeNo());
					restmap.put("buyer_logon_id", alipayResponse.getBuyerLogonId());// 用户的登录id
					restmap.put("gmt_refund_pay", alipayResponse.getGmtRefundPay()); // 退看支付时间
					restmap.put("buyer_user_id", alipayResponse.getBuyerUserId());// 买家在支付宝的用户id
					logger.info("订单退款结果：退款成功");
					   strResponse="退款成功";
					
				} else {

					logger.info("订单查询失败：" + alipayResponse.getMsg() + ":" + alipayResponse.getSubMsg());
					 strResponse=((AlipayResponse) response).getSubMsg();
				}
				
			}
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}

			return strResponse;
		
	}

}
