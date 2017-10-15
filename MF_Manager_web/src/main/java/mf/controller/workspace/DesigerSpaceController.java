package mf.controller.workspace;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.util.StringUtils;

import MF_Utils.Result;
import mf.service.desigerSpace.DesigerSpaceService;

@Controller
public class DesigerSpaceController {
@Autowired  DesigerSpaceService  spaceService; 	
     //设计师点击主页
	@RequestMapping("/goToDesigerWork")
    @ResponseBody
    public Result goToWorkSpace(long designerId){
		//参数  
		//long designerId=123;
		return spaceService.goToWorkSpace(designerId);
	
	}
	
	//我的发布 只显示作品
	@RequestMapping("/goToWork")
    @ResponseBody
    public Result goToWork(long designerId,int page){
		
		return spaceService.goToWork(designerId,page);
	
	}  
	
	
	
	//查看作品集
	@RequestMapping("/goToWorkList")
    @ResponseBody
    public Result goToWorkList(long designerId){
		try {
			return spaceService.goToWorkList(designerId);
		} catch (Exception e) {
			
			Map<String,Object> map= new HashMap();
			map.put("status",2);
			map.put("data",null);
			
			return  Result.ok(map);
		}
		
		
		
		
	
	}  
	
	
	
	
	
	
	//设计师新增作品集
	
	@RequestMapping("/publishWorkList")
    @ResponseBody
    public Result publishWorkList(@RequestParam MultipartFile[] uploadFile,long desigerId,String name){
	 try {
			return spaceService.publishWorkList(uploadFile, desigerId, name);
		} catch (Exception e) {
			e.printStackTrace();
			Map<String,Integer> map =new HashMap();
			map.put("status",2);
			return Result.ok(map);
			
		}
		 
	}
	
	
	//单查看作品集

	@RequestMapping("/getWorkList")
    @ResponseBody
    public Result getWorkList(long  worksId){
		
		return spaceService.getWorkList(worksId);
	}
	
	
	
	
	//详情介绍查看
	@RequestMapping("/getIntroduce")
    @ResponseBody
    public Result  getIntroduce(long designerId){
		
		return spaceService.getIntroduce(designerId);
    }
	
	//介绍更改
	@RequestMapping("/updateIntroduce")
    @ResponseBody
    public Result  updateIntroduce( String introduction,String specialty,String autograph,String match,Long designerId){
		//参数 introduction 介绍   specialty擅长  autograph签名  match比赛
	
		try {
			if(!StringUtils.isEmpty(introduction)){
				introduction = new String(introduction.getBytes("iso8859-1"),"utf-8");
		     }
		  if(!StringUtils.isEmpty(specialty)){ 
			  specialty = new String(specialty.getBytes("iso8859-1"),"utf-8");
			  
		  }
		  if(!StringUtils.isEmpty(autograph)){ 
			autograph = new String(autograph.getBytes("iso8859-1"),"utf-8");
		  }
		  if(!StringUtils.isEmpty(match)){ 
			match = new String(match.getBytes("iso8859-1"),"utf-8");
		  }
			return spaceService.updateIntroduce(introduction,specialty,autograph,match,designerId);
		} catch (Exception e) {
			
			e.printStackTrace();
			return Result.ok(2);
		}
		
		
    }
 
	
	//个人中心查看
	
	 @RequestMapping("/getDesigerInfor")
	 @ResponseBody
	 public Result  getDesigerInfor(long desigerId){
		 
		 return  spaceService.getDesigerInfor(desigerId);
	 }

		//个人中心修改
		
		 @RequestMapping("/updateDesigerInfor")
		 @ResponseBody
		 public Result  updateDesigerHeahPath(long desigerId){
			 
			 return  spaceService.updateDesigerInfor(desigerId);
		 }
		
	
	
	
	

	
	
}
