package mf.controller.pay.weixin;


	/** 
	 * 统一下单请求参数(必填) 
	 * @author Y 
	 * 
	 */  
	public class UnifiedOrderRequest {  
	    private String appid;               //公众账号ID  
	    private String mch_id;              //商户号  
	    private String nonce_str;           //随机字符串  
	    private String sign;                //签名  
	    private String body;                //商品描述  
	    private String out_trade_no;        //商户订单号  
	    private String total_fee;           //总金额  
	    private String spbill_create_ip;    //终端IP  
	    private String notify_url;          //通知地址  
	    private String trade_type;          //交易类型  
		public String getAppid() {
			return appid;
		}
		public String getMch_id() {
			return mch_id;
		}
		public String getNonce_str() {
			return nonce_str;
		}
		public String getSign() {
			return sign;
		}
		public String getBody() {
			return body;
		}
		public String getOut_trade_no() {
			return out_trade_no;
		}
		public String getTotal_fee() {
			return total_fee;
		}
		public String getSpbill_create_ip() {
			return spbill_create_ip;
		}
		public String getNotify_url() {
			return notify_url;
		}
		public String getTrade_type() {
			return trade_type;
		}
	
	}  
