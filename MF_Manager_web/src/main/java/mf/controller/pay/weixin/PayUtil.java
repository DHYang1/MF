package mf.controller.pay.weixin;

import java.util.Random;

public class PayUtil {
	 /** 
     * 随机字符串 
     *  
     * @return 
     */  
    public static String create_nonce_str() {  
        Random random = new Random();  
        return MD5Util.MD5Encode(String.valueOf(random.nextInt(10000)), "UTF-8");  
    }  
  
    /** 
     * 生成系统当前时间戳 
     *  
     * @return 
     */  
    public static String create_timestamp() {  
        return Long.toString(System.currentTimeMillis() / 1000);  
    }  
  
}  
