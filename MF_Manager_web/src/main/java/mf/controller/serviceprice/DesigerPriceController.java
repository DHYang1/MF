package mf.controller.serviceprice;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import MF_Utils.Result;
import mf.pojo.Goodaspect;
import mf.service.serviceprice.DesigerServicePrice;

@Controller
public class DesigerPriceController {

	
	@Autowired DesigerServicePrice desigerServicePrice;
	
	
	
	
	//获取设计师服务的价格
	@RequestMapping("/serviceprice")
    @ResponseBody
    public  Result getDesigerPrice(long desigerId){
		return  desigerServicePrice.getDesigerPrice(desigerId);	
		
	}
	//修改设计师服务的价格

	@RequestMapping(value="/updateprice")
    @ResponseBody
    public  Result updateDesigerPrice(long desigerId,int id,double price){
		//  
		 
		return desigerServicePrice.updateDesigerPrice(desigerId, id,price);
	
	}
	
	
	
	
}
