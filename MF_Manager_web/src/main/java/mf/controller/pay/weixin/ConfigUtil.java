package mf.controller.pay.weixin;

public class ConfigUtil {
	public final static String APPID = "";//服务号的应用号
	public final static String APP_SECRECT = "";//服务号的应用密码
	public final static String WXTOKEN = "";//公众平台设置token
	public final static String TOKEN = "";//服务号的配置token
	public final static String ENCODINGAESKEY = "";//消息加密密钥
	public final static String MCH_ID = "";//商户号
	public final static String API_KEY = "";//API密钥
	public final static String SIGN_TYPE = "MD5";//签名加密方式
	public final static String CERT_PATH = "";//微信支付证书存放
	public static String getAppid() {
		return APPID;
	}
	public static String getAppSecrect() {
		return APP_SECRECT;
	}
	public static String getWxtoken() {
		return WXTOKEN;
	}
	public static String getToken() {
		return TOKEN;
	}
	public static String getEncodingaeskey() {
		return ENCODINGAESKEY;
	}
	public static String getMchId() {
		return MCH_ID;
	}
	public static String getApiKey() {
		return API_KEY;
	}
	public static String getSignType() {
		return SIGN_TYPE;
	}
	public static String getCertPath() {
		return CERT_PATH;
	}

	
	
	
}
