package mf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import MF_Utils.EUDataGridResult;
import MF_Utils.Result;
import mf.service.DesigerConditionService;

@Controller
public class IndexDesiger {	
@Autowired  DesigerConditionService conditionService;
	






   //烫染 为1    理发2   美妆3 设计4

	 //点击设计师  两次请求  
	@RequestMapping("/getDesigerConditio")
    @ResponseBody
    public Result getDesigerCondition(Integer condition){
		//  @RequestParam(defaultValue="烫染")String condition
		
		
		
	return conditionService.getDesigerCondition(condition);
	}
   //查询设计	
	@RequestMapping("/getDesigerConditioAdd")
    @ResponseBody
    public Result getDesiger(Integer page,Integer condition){
		// Integer page, 
		//Integer rows=2;
		page =page-1;
	return conditionService.getDesiger(page,condition);
	}

}
