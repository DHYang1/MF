package mf.controller.pay.weixin;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
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

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class WxUtils {


	//微信签名方式
	 public static String createSign(String characterEncoding,SortedMap<Object,Object> parameters){  
	        StringBuffer sb = new StringBuffer();  
	        Set es = parameters.entrySet();//所有参与传参的参数按照accsii排序（升序）  
	        Iterator it = es.iterator();  
	        while(it.hasNext()) {  
	            Map.Entry entry = (Map.Entry)it.next();  
	            String k = (String)entry.getKey();  
	            Object v = entry.getValue();  
	            if(null != v && !"".equals(v)  && !"sign".equals(k) && !"key".equals(k)) {  
	                sb.append(k + "=" + v + "&");  
	            }  
	            
	            //sb.append("key=" +PARTNER_KEY);//最后加密时添加商户密钥，由于key值放在最后，所以不用添加到SortMap里面去，单独处理，编码方式采用UTF-8
	        }  
	      
	        System.out.println("字符串拼接后是："+sb.toString());  
	        String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();  
	        return sign;  
	    }  

	 /**
	 * @author
	 * @date 2014-12-5下午2:32:05
	 * @Description：将请求参数转换为xml格式的string
	 * @param parameters
	 *            请求参数
	 * @return
	 */

	 public static String getRequestXml(SortedMap<Object, Object> parameters) {
		 StringBuffer sb = new StringBuffer();
		 sb.append("<xml>");
		 Set es = parameters.entrySet();
		 Iterator it = es.iterator();
		 while (it.hasNext()) {
		 Map.Entry entry = (Map.Entry) it.next();
		 String k = (String) entry.getKey();
		 String v = (String) entry.getValue();
		 if ("attach".equalsIgnoreCase(k) || "body".equalsIgnoreCase(k) || "sign".equalsIgnoreCase(k)) {
		 sb.append("<" + k + ">" + "<![CDATA[" + v + "]]></" + k + ">");
		 } else {
		 sb.append("<" + k + ">" + v + "</" + k + ">");
		 }
		 }
		 sb.append("</xml>");
		 return sb.toString();
		 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 //掉用统一接口
	 public static String httpsRequest(String requestUrl, String requestMethod, String outputStr) {  
         try {  
              
             URL url = new URL(requestUrl);  
             HttpURLConnection conn = (HttpURLConnection) url.openConnection();  
             
             conn.setDoOutput(true);  
             conn.setDoInput(true);  
             conn.setUseCaches(false);  
             // 设置请求方式（GET/POST）  
             conn.setRequestMethod(requestMethod);  
             conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");  
             // 当outputStr不为null时向输出流写数据  
             if (null != outputStr) {  
                 OutputStream outputStream = conn.getOutputStream();  
                 // 注意编码格式  
                 outputStream.write(outputStr.getBytes("UTF-8"));  
                 outputStream.close();  
             }  
             // 从输入流读取返回内容  
             InputStream inputStream = conn.getInputStream();  
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
             String str = null;  
             StringBuffer buffer = new StringBuffer();  
             while ((str = bufferedReader.readLine()) != null) {  
                 buffer.append(str);  
             }  
             // 释放资源  
             bufferedReader.close();  
             inputStreamReader.close();  
             inputStream.close();  
             inputStream = null;  
             conn.disconnect();  
             return buffer.toString();  
         } catch (ConnectException ce) {  
             System.out.println("连接超时：{}"+ ce);  
         } catch (Exception e) {  
             System.out.println("https请求异常：{}"+ e);  
         }  
         return null;  
     } 
	 
	 
	 
	 
	   /**
	     * 解析xml,返回第一级元素键值对。如果第一级元素有子节点，则此节点的值是子节点的xml数据。
	     * @param strxml
	     * @return
	     * @throws JDOMException
	     * @throws IOException
	     */
	    public static Map doXMLParse(String strxml) throws JDOMException, IOException {
	        strxml = strxml.replaceFirst("encoding=\".*\"", "encoding=\"UTF-8\"");

	        if(null == strxml || "".equals(strxml)) {
	            return null;
	        }
	        
	        Map m = new HashMap();
	        
	        InputStream in = new ByteArrayInputStream(strxml.getBytes("UTF-8"));
	        SAXBuilder builder = new SAXBuilder();
	        Document doc = builder.build(in);
	        Element root = doc.getRootElement();
	        List list = root.getChildren();
	        Iterator it = list.iterator();
	        while(it.hasNext()) {
	            Element e = (Element) it.next();
	            String k = e.getName();
	            String v = "";
	            List children = e.getChildren();
	            if(children.isEmpty()) {
	                v = e.getTextNormalize();
	            } else {
	                v = getChildrenText(children);
	            }
	            
	            m.put(k, v);
	        }
	        
	        //关闭流
	        in.close();
	        
	        return m;
	    }
	    
	 
	    /**
	     * 获取子结点的xml
	     * @param children
	     * @return String
	     */
	    public static String getChildrenText(List children) {
	        StringBuffer sb = new StringBuffer();
	        if(!children.isEmpty()) {
	            Iterator it = children.iterator();
	            while(it.hasNext()) {
	                Element e = (Element) it.next();
	                String name = e.getName();
	                String value = e.getTextNormalize();
	                List list = e.getChildren();
	                sb.append("<" + name + ">");
	                if(!list.isEmpty()) {
	                    sb.append(getChildrenText(list));
	                }
	                sb.append(value);
	                sb.append("</" + name + ">");
	            }
	        }
	        
	        return sb.toString();
	    }
	 
	 
	    /** 
	     * 是否签名正确,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。 
	     * @return boolean 
	     */  
	    public static boolean isTenpaySign(String characterEncoding, SortedMap<Object, Object> packageParams) {  
	        StringBuffer sb = new StringBuffer();  
	        Set es = packageParams.entrySet();  
	        Iterator it = es.iterator();  
	        while(it.hasNext()) {  
	            Map.Entry entry = (Map.Entry)it.next();  
	            String k = (String)entry.getKey();  
	            String v = (String)entry.getValue();  
	            if(!"sign".equals(k) && null != v && !"".equals(v)) {  
	                sb.append(k + "=" + v + "&");  
	            }  
	        }  

	        //sb.append("key=" + ConfigUtil.API_KEY);  
	        //TODO

	        //算出摘要  
	        String mysign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toLowerCase();  
	        String tenpaySign = ((String)packageParams.get("sign")).toLowerCase();  

	        //System.out.println(tenpaySign + "    " + mysign);  
	        return tenpaySign.equals(mysign);  
	    }  
	    
	   //随机码的自动生成
	    
	    public static String getRandomStringByLength(int length) {  
	        String base = "abcdefghijklmnopqrstuvwxyz0123456789";  
	        Random random = new Random();  
	        StringBuffer sb = new StringBuffer();  
	        for (int i = 0; i < length; i++) {  
	            int number = random.nextInt(base.length());  
	            sb.append(base.charAt(number));  
	        }  
	        return sb.toString();  
	    }  
	    
	    
}
