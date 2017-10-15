package mf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import MF_Utils.Result;
import mf.mapper.DesignerMapper;
import mf.mapper.DesignworkMapper;
import mf.pojo.Designer;
import mf.pojo.Designwork;
import mf.pojo.DesignworkExample;
import mf.pojo.HotDesigerWork;
import mf.pojo.HotDesigner;
import mf.pojo.IndexWorkAd;
import mf.pojo.DesignworkExample.Criteria;
import mf.service.IndexService;
import mf.service.LoginService;
import mf.service.impl.IndexServiceImpl;

@Controller
@RequestMapping("/index")
public class IndexController {

	@Autowired  IndexService indexService;
	@Autowired   DesignworkMapper  workMapper;
	@Autowired  DesignerMapper designerMapper;
	 @RequestMapping("/desiger")
	 @ResponseBody
	 public Result getDesigers(){
		 List<Designer> hotDesigers = indexService.getHotDesigers();
	 List<HotDesigner> desigers= new ArrayList<>();
	 int count=0;
		 for (Designer designer : hotDesigers) {
			 //显示10个
			if(count<15){
			 HotDesigner designer2 = new HotDesigner();
			  designer2.setDesignerId(designer.getDesignerId());
			  designer2.setHeadPath(designer.getHeadPath());
			  System.out.println("-------------------");
			  System.out.println(designer.getHeadPath());
			  System.out.println("----------------");
			  designer2.setDesigerName(designer.getDesigerName());
			  desigers.add(designer2);
			  count++;
			  
		}}
		 return Result.ok(desigers);	 
	 }
	 
	 
    //查询设计师作品 
	 @RequestMapping("/desigerWork")
	 @ResponseBody
	 public Result getDesigersWork(){
		 //中间那个	
		/* page=page-1;
		 List<Designwork> selectBypage = workMapper.selectBypage(page);*/
		 DesignworkExample example = new   DesignworkExample();
			Criteria criteria = example.createCriteria();
			criteria.andStatusEqualTo((byte)1);
			//分页查询
			List<Designwork> selectByExample = workMapper.selectByExample(example);
		
			List<HotDesigerWork> lists =new ArrayList<>();
			if(selectByExample.size()>0){
				for (Designwork designwork : selectByExample) {	
					 int count=0;
					 if(count<10){
					Designer designer = designerMapper.selectByPrimaryKey(designwork.getDesignerId());
					HotDesigerWork hotDesigerWork =new HotDesigerWork();
					hotDesigerWork.setAutograph(designer.getAutograph());
					hotDesigerWork.setCoverImage(designwork.getCoverImage());
					hotDesigerWork.setDesigerName(designer.getDesigerName());
					hotDesigerWork.setHeadPath(designer.getHeadPath());
					hotDesigerWork.setWorkId(designwork.getWorkId());
					//设计师作品
					hotDesigerWork.setDesignerId(designer.getDesignerId());
					lists.add(hotDesigerWork);
					count++;
					 }
				}
				
				
				
			}
		 return Result.ok(lists);	 
	 }
	 
	//广告位
	 @RequestMapping("/advertisement")
	 @ResponseBody
	 public Result getAdvertisement(){
		return indexService.getAdvertisement();
	 
	 } 
	 
	 //作品广告
	 @RequestMapping("/adverWork")
	 @ResponseBody
	 public Result getadverWork(Integer page){
		 page=page-1;
		  List<IndexWorkAd> getadverWork = indexService.getadverWork(page);
	 
		 return Result.ok(getadverWork);
	 }

	 
	 
}
