package mf.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import MF_Utils.Result;
import mf.service.SearchService;

@Controller
public class SearchController {

	
@Autowired SearchService searchService;

	// 模糊搜索
	@RequestMapping("/likeSearch")
	@ResponseBody
	public Result likeSearch(String condition,Integer type) {
		//  1 设计师2 作品3店铺
	
			//condition = new String(condition.getBytes("iso8859-1"),"utf-8");
			return searchService.likeSearch(condition,type);
			
	}
   //热门查询
	@RequestMapping("/search")
    @ResponseBody
    public Result search(String condition,Integer type){
		
    	//String condition="三";
		
				//condition = new String(condition.getBytes("iso8859-1"),"utf-8");
				return searchService.search(condition,type);
	
	}

  @RequestMapping("/hotsearch")
    @ResponseBody
    public Result hotsearch(Integer type){
    	//String condition="三";
				//condition = new String(condition.getBytes("iso8859-1"),"utf-8");
				return searchService.hotsearch(type);
		
			
		
		
	}
  
}
