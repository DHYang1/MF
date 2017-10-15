package mf.controller;


import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;

import MF_Utils.Result;
/*import mf.controller.redis.JedisClient;*/
import mf.service.LoginService;
import mf.service.SmsDemo;

@Controller
public class LoginController {
	@Autowired  LoginService loginService;
/*	@Autowired  JedisClient jedisClient;*/
    @RequestMapping(value="/login",method=RequestMethod.POST)
    @ResponseBody
	public Result login(String phoneNum,String Icode,HttpServletRequest request, HttpServletResponse response){
    	
    	
    	/*Cookie[] cookies = request.getCookies();
    	String value = cookies[0].getValue();
    	String[] split = value.split("=");
    	String jds=split[1];*/
    
    
    	 HttpSession session = request.getSession();
    	// String string = jedisClient.get("code");
    	// System.out.println(string);
    	System.out.println("???????????????????");
    
    	
    	//取不到值
    	
    	String attribute = (String) session.getAttribute("user_token");
    	System.out.println(attribute);
   
    	/*String phoneNum="13540439363";
    	String Icode="123456";*/
    	System.out.println(phoneNum);
    	System.out.println(Icode);
    	Result result = loginService.login(phoneNum,Icode, request, response);
    	return result;
    
	}
  
    
    
    //发送验证码端口
    @RequestMapping(value="/getIcode",method=RequestMethod.POST)
    @ResponseBody
    public Result getIcode(String phoneNum,HttpServletRequest request){
    	Enumeration parameterNames = request.getParameterNames();
    	System.out.println("++++++++++++++++++++");
    	System.out.println(request);
      while (parameterNames.hasMoreElements()) {
		Object object = (Object) parameterNames.nextElement();
		System.out.println("````````````````````"+object.toString());
	}
    	try {
	
    		//String phoneNum="13540439363";
    		System.out.println(phoneNum);
			SendSmsResponse sendSmsResponse = SmsDemo.sendSms(phoneNum);
			String code = sendSmsResponse.getCode();
			HttpSession session = request.getSession();
			session.setAttribute("user_token",code);
			session.setMaxInactiveInterval(5*60);

			/*Cookie[] cookies = request.getCookies();
			String value = cookies[0].getValue();
			System.out.println(value);
			session.setAttribute("cookie", value);*/
			/*jedisClient.set("code", code);
			jedisClient.expire("code", 7200);
			String string = jedisClient.get("code");*/
			System.out.println("使用redis---------------------");
			//System.out.println(string+"code");
			String code1 = (String) session.getAttribute("user_token");
			System.out.println("????????????????????"+code1);
			System.out.println(session);
			System.out.println(sendSmsResponse.getCode());
			System.out.println(sendSmsResponse.getMessage());
			return Result.ok(1);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("--jinru2");
			return Result.ok(2);
			
		}
    	
    }


    @RequestMapping(value="/update")
    @ResponseBody
    public Result update(String phoneNum,Integer gender,Integer userAge,Integer face,String email,HttpServletRequest request, HttpServletResponse response){
    	//String phoneNum,Integer gender,Integer userAge,Integer face
  /* 	String phoneNum="13540439363";
    	Integer gender=1;
    	Integer userAge=10;
    	Integer face=1;
    	String email="117176978";*/
    return loginService.update(phoneNum, gender, face, email, userAge, request, response);
    		
    }
}
