package mf.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MF_Utils.Result;
import mf.pojo.UserCenter;

public interface LoginService {

	
	public Result login(String phoneNum,String Icode,HttpServletRequest request,HttpServletResponse response);
	public Result update(String phoneNum ,Integer gender,Integer face,String email,Integer userAge,HttpServletRequest request, HttpServletResponse response);
}
