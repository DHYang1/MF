package mf.controller.pay;

public class AlipayConfig {
	
	
    // 交易安全检验码，由数字和字母组成的32位字符串  
    public static String key = "";  
      
    // 当前页面跳转后的页面 要用 http://格式的完整路径，不允许加?id=123这类自定义参数  
    // 域名不能写成http://localhost/alipay.auth.authorize_jsp_utf8/return_url.jsp ，否则会导致return_url执行无效  
    public static String return_url = "http://127.0.0.1:8080/alipay.auth.authorize_jsp_utf8/return_url.jsp";  
	
	
	
		    //合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
		    public static String partner = "2**************1";

		    //商户的私钥,需要PKCS8格式，RSA公私钥生成：https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
		  public static String private_key = "*************=";

		    //支付宝的公钥，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
		  public static String alipay_public_key  = "*********";

		    // 签名方式
		    public static String sign_type = "RSA";

		    // 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
		    public static String log_path ="C://";

		    // 字符编码格式 目前支持 gbk 或 utf-8
		    public static String input_charset = "utf-8";

		    // 接收通知的接口名
		    public static String service = "http://60.***.***.00/callbacks.do";
		    //public static String service = "mobile.securitypay.pay";

		    //APPID
		    public static String app_id="2016**********12";

			public static String getKey() {
				return key;
			}

			public static void setKey(String key) {
				AlipayConfig.key = key;
			}

			public static String getReturn_url() {
				return return_url;
			}

			public static void setReturn_url(String return_url) {
				AlipayConfig.return_url = return_url;
			}

			public static String getPartner() {
				return partner;
			}

			public static void setPartner(String partner) {
				AlipayConfig.partner = partner;
			}

			public static String getPrivate_key() {
				return private_key;
			}

			public static void setPrivate_key(String private_key) {
				AlipayConfig.private_key = private_key;
			}

			public static String getAlipay_public_key() {
				return alipay_public_key;
			}

			public static void setAlipay_public_key(String alipay_public_key) {
				AlipayConfig.alipay_public_key = alipay_public_key;
			}

			public static String getSign_type() {
				return sign_type;
			}

			public static void setSign_type(String sign_type) {
				AlipayConfig.sign_type = sign_type;
			}

			public static String getLog_path() {
				return log_path;
			}

			public static void setLog_path(String log_path) {
				AlipayConfig.log_path = log_path;
			}

			public static String getInput_charset() {
				return input_charset;
			}

			public static void setInput_charset(String input_charset) {
				AlipayConfig.input_charset = input_charset;
			}

			public static String getService() {
				return service;
			}

			public static void setService(String service) {
				AlipayConfig.service = service;
			}

			public static String getApp_id() {
				return app_id;
			}

			public static void setApp_id(String app_id) {
				AlipayConfig.app_id = app_id;
			}

		//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
		    
		    
		}
