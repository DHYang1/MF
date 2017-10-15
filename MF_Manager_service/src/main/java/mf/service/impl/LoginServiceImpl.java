package mf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;

import MF_Utils.CookieUtils;
import MF_Utils.IDUtils;
import MF_Utils.JsonUtils;
import MF_Utils.Result;
import mf.mapper.DesignerMapper;
import mf.mapper.UserCenterMapper;
import mf.pojo.Designer;
import mf.pojo.DesignerExample;
import mf.pojo.UserCenter;
import mf.pojo.UserCenterExample;
import mf.pojo.UserCenterExample.Criteria;
import mf.service.LoginService;
import mf.service.SmsDemo;
@Service
public class LoginServiceImpl implements LoginService {
@Autowired  UserCenterMapper  userMapper;
@Autowired  DesignerMapper  designerMapper;


	@Override
	public Result login(String phoneNum,String Icode,HttpServletRequest request,HttpServletResponse response) {

			//SendSmsResponse sendSmsResponse = SmsDemo.sendSms(phoneNum);
		  UserCenterExample example = new UserCenterExample();
	  Criteria criteria = example.createCriteria();
			criteria.andPhoneNumEqualTo(phoneNum);
			  List<UserCenter> list = userMapper.selectByExample(example);
			  HttpSession session = request.getSession();
				String code1 = (String) session.getAttribute("user_token");
				System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<"+code1);
			  //String code1="123456";
				//判断 是否注册了
             System.out.println("+++++++++++++++++++++++++"+Icode);
			if(list.size()>0 && !list.isEmpty()){
			//String code = sendSmsResponse.getCode();
				//String code ="123";
				 if(Icode.equals(code1)){
					 //判断是否注册
					 if(list.get(0).getStatus()!=null){		 
		//判断是普通用户 还是设计师 1为普通用户 2为设计师
					 if(list.get(0).getType()==1){
						 String token = UUID.randomUUID().toString();
						 CookieUtils.setCookie(request, response, token, JsonUtils.objectToJson(list.get(0)));
						 Result result = new Result();
						 Map<String,Object> map =new HashMap();
						 map.put("status",1);
						 map.put("token", token);
						 map.put("userId",list.get(0).getUserId());
						 map.put("designerid", null);
						 result.setStatus(200);
						 result.setData(map);
					 	 return result; 
					 } 
					 if(list.get(0).getType()==2){
						 String token = UUID.randomUUID().toString();
						  CookieUtils.setCookie(request, response, token, JsonUtils.objectToJson(list.get(0)));
						  DesignerExample example1= new DesignerExample();
						  mf.pojo.DesignerExample.Criteria criteria1 = example1.createCriteria();
						  criteria1.andUserIdEqualTo(list.get(0).getUserId());
						  List<Designer> selectByExample = designerMapper.selectByExample(example1);
						  Result result = new Result();
						  Map<String,Object> map =new HashMap();
						  long id=selectByExample.get(0).getDesignerId();
						  map.put("token",token);
						  map.put("status",2);
						  map.put("userId", list.get(0).getUserId());
						  map.put("designerid", id);
						  result.setStatus(200);
						  result.setData(map);
					 	    return result; 
					 	
					 } 	
				 }	 
					 else{
						 Map<String,Object> map =new HashMap();
						  map.put("token",null);
						  map.put("status",3);
						  map.put("userId", null);
						  map.put("designerid", null);
						return  Result.ok(map);
					 }	
		
			} 
			}
			if(Icode.equals(code1)){
							UserCenter user = new  UserCenter();
							  long userId = IDUtils.getUserId();
							  user.setUserId(userId);
							  user.setPhoneNum(phoneNum);
							  userMapper.insert(user);
							  Map<String,Object> map =new HashMap();
							  map.put("token",null);
							  map.put("status",3);
							  map.put("userId", null);
							  map.put("designerid", null);
							return  Result.ok(map);	
					 	 
				}
   
			  Map<String,Object> map =new HashMap();
			  map.put("token",null);
			  map.put("status",4);
			  map.put("userId", null);
			  map.put("designerid", null);
			
		return Result.ok(map);
	}

	@Override
	public Result update(String phoneNum ,Integer gender,Integer face,String email,Integer userAge,HttpServletRequest request, HttpServletResponse response) {
		UserCenterExample example = new UserCenterExample();
		Criteria criteria = example.createCriteria();
		criteria.andPhoneNumEqualTo(phoneNum);
		List<UserCenter> selectByExample = userMapper.selectByExample(example);
		if(selectByExample.size()>0){
			UserCenter user = selectByExample.get(0);
			user.setCreateTime(new Date());
			user.setEmail(email);
			user.setFace(face);
			user.setGender(gender);
			user.setType(1);
			user.setStatus((byte) 1);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			String dateNowStr = sdf.format(date); 
			int i1 = Integer.parseInt(dateNowStr); 
			user.setUserAge(i1-userAge);
			userMapper.updateByPrimaryKey(user);
			String token = UUID.randomUUID().toString();
			CookieUtils.setCookie(request, response, token, JsonUtils.objectToJson(user));
			Map<String,Object> map =new HashMap();
			map.put("token", token);
			map.put("status",1);
			map.put("userId", user.getUserId());
			 map.put("designerid", null);
			return Result.ok(map);
			
		}
		 Map<String,Object> map =new HashMap();
		 map.put("status",2);
		 map.put("token", null);
		 map.put("userId", null);
		 map.put("designerid", null);
		return Result.ok(map);
	}
	

	
	  //保存日志
}
