/*package mf.controller.pay.weixin;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WxController {

	@RequestMapping(value = "/createOrder", method = {RequestMethod.GET, RequestMethod.POST})
	public String createOrder(Map<String, String> model) throws Exception{
	log.debug("WeChatPayController.createOrder,parameter[{trade_no,subject,total_fee},{"
	+ request.getParameter("trade_no")
	+ ","
	+ request.getParameter("subject")
	+ ","
	+ request.getParameter("total_fee") + "}]");

	WeChatRsp response = new WeChatRsp();
	WeChat weChat = new WeChat();

	 //订单信息
	String orderNo = request.getParameter("trade_no"); //订单号
	String money = request.getParameter("total_fee"); //订单金额
	String body = request.getParameter("subject"); //商品描述根据情况修改

	//金额转化为分为单位
	float sessionmoney = Float.parseFloat(money);
	String finalmoney = String.format("%.2f", sessionmoney);
	finalmoney = finalmoney.replace(".", "");

	//商户相关资料 
	String appid = CommonUtils.getPropertiesValue("config", "appid");
	String appsecret = CommonUtils.getPropertiesValue("config", "appsecret");
	String partner = CommonUtils.getPropertiesValue("config", "partnerId");
	String partnerkey = CommonUtils.getPropertiesValue("config", "partnerkey");

	//商户号
	//String mch_id = partner;
	//随机数 
	Random random = new Random();
	String nonce_str = cn.emagsoftware.utils.MD5Util.getMD5String(String.valueOf(random.nextInt(10000)));

	//商户订单号
	String out_trade_no = orderNo;
	int intMoney = Integer.parseInt(finalmoney);

	//总金额以分为单位，不带小数点
	//int total_fee = intMoney;
	//订单生成的机器 IP
	String spbill_create_ip = request.getRemoteAddr();
	System.out.println("订单生成的机器IP："+spbill_create_ip);

	//这里notify_url是 支付完成后微信发给该链接信息，可以判断会员是否支付成功，改变订单状态等。
	String notify_url = CommonUtils.getPropertiesValue("config", "weChat_notify_url");
	//交易类型
	String trade_type = CommonUtils.getPropertiesValue("config", "trade_type");

	SortedMap<String, String> packageParams = new TreeMap<String, String>();
	packageParams.put("appid", appid); 
	packageParams.put("mch_id", mch_id); 
	packageParams.put("nonce_str", nonce_str); 
	packageParams.put("body", body); 
	packageParams.put("out_trade_no", out_trade_no); 

	packageParams.put("total_fee", total_fee+""); 
	packageParams.put("spbill_create_ip", spbill_create_ip); 
	packageParams.put("notify_url", notify_url); 

	packageParams.put("trade_type", trade_type);

	HttpServletResponse httpServletResponse = null;
	RequestHandler reqHandler = new RequestHandler(request, httpServletResponse);
	reqHandler.init(appid, appsecret, partnerkey);

	String sign = reqHandler.createSign(packageParams);
	String xml="<xml>"+
	"<appid>"+appid+"</appid>"+
	"<body><![CDATA["+body+"]]></body>"+
	"<mch_id>"+mch_id+"</mch_id>"+
	"<nonce_str>"+nonce_str+"</nonce_str>"+
	"<notify_url>"+notify_url+"</notify_url>"+
	"<out_trade_no>"+out_trade_no+"</out_trade_no>"+
	"<sign>"+sign+"</sign>"+
	"<spbill_create_ip>"+spbill_create_ip+"</spbill_create_ip>"+
	"<total_fee>"+total_fee+"</total_fee>"+
	"<trade_type>"+trade_type+"</trade_type>"+
	"</xml>";
	log.debug("xml = "+xml);
	String createOrderURL = WECHAT_CREATE_ORDER_URL;
	String prepay_id="";
	//获取预支付交易号
	try {
	prepay_id = new GetWxOrderno().getPayNo(createOrderURL, xml, "prepay_id");
	} catch (Exception e1) {
	e1.printStackTrace();
	response.setResultCode(Constant.ERROR_CODE_9998);
	response.setResultMessage(Constant.ERROR_MESSAGE.get(Constant.ERROR_CODE_9998));
	}

	if (prepay_id!=null& !prepay_id.equals("")) {
	response.setResultCode(Constant.SUCCESS_CODE);
	response.setResultMessage(Constant.ERROR_MESSAGE.get(Constant.SUCCESS_CODE));
	weChat.setAppid(appid);
	weChat.setPrepayid(prepay_id);
	String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
	String nonce_string = cn.emagsoftware.utils.MD5Util.getMD5String(timestamp);
	weChat.setTimestamp(timestamp);
	weChat.setNoncestr(nonce_string);
	weChat.setPackages("Sign=WXPay");
	weChat.setPartnerid(partner);

	//二次签名
	SortedMap<String, String> finalpackage = new TreeMap<String, String>();
	finalpackage.put("appid", appid); 
	finalpackage.put("timestamp", timestamp); 
	finalpackage.put("noncestr", nonce_string); 
	finalpackage.put("package", "Sign=WXPay"); 
	finalpackage.put("partnerid", mch_id);
	finalpackage.put("prepayid", prepay_id);
	String finalsign = reqHandler.createSign(finalpackage);
	weChat.setSign(finalsign);
	response.setData(weChat);
	}else {
	log.debug("预支付交易号生成失败。。。");
	response.setResultCode(Constant.ERROR_CODE_9998);
	response.setResultMessage(Constant.ERROR_MESSAGE.get(Constant.ERROR_CODE_9998));
	}

	try{
	model.put(Constant.RETURN_MESSAGE, JsonUtils.getJSONString(response));
	log.debug("WeChatPayController.createOrder.response=="+JsonUtils.getJSONString(response));
	} catch (Exception ex) {
	log.error("VersionController.getVersion", ex);
	}
	return RET_JSP;
	}
	
	
	
}
*/