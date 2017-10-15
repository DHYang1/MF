package mf.controller.starDesigner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import MF_Utils.Result;
import mf.service.star.StarDesignerService;

@Controller
public class StarDesignerController {

	
	@Autowired   StarDesignerService starDesignerService;

    //默认查看
	 @RequestMapping("/getStarDesigner")
	 @ResponseBody
	 public Result  getStarDesigner(){
		
			Result starDesigner = starDesignerService.getStarDesigner();
		
		return starDesigner;

	 }
	 

	    //根据出道时间排名
		 @RequestMapping("/getStarDesignerByTime")
		 @ResponseBody
		 public Result  getStarDesignerByTime(){
			 try {
				 //有数据 成功
				 return starDesignerService.getStarDesignerByTime();
			} catch (Exception e) {
				return null;
			}
			
		
		
		 }
	 //筛选    
		 

	
}
