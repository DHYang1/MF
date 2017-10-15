package mf.controller.work;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.util.StringUtils;
import com.ctc.wstx.util.StringUtil;

import MF_Utils.Result;
import mf.mapper.LabelMapper;
import mf.pojo.Designwork;
import mf.service.work.DesigerWorkService;

@Controller
public class DesigerWorkController {
//作品
	@Autowired   DesigerWorkService  workService;
	
	//点击发布作品返回标签IDS和 名字 
	 @RequestMapping("get/publish/workLable")
	 @ResponseBody
	 public Result getWorkLable(){
		 
		 return workService.getWorkLable();
	 }
	
	
	
	
	 @RequestMapping("/publish/desigerwork")
	 @ResponseBody
	public Result publishWork(long desigerId,int ageType,String title, String introduction, Integer gender, Integer face, String labelId,
			MultipartFile uploadFile1, MultipartFile uploadFile2) {
		 System.out.println(labelId);
		 String[] split = labelId.split(",");
		 Long[] lableIda =new Long[20];
		 for (String string : split) {
			 int i=1;
			 Long long1=new Long(string);
			
			 lableIda[i]=long1;
			 i++;
		}
		 System.out.println(lableIda);
		 System.out.println("---------------------------------------");
		 System.out.println(title);

		return workService.publishWork(desigerId, ageType, title, introduction, gender, face, lableIda, uploadFile1, uploadFile2);

	 }
	 
	 
	 //查询设计师作品
	
	 @RequestMapping("/get/desigerwork")
	 @ResponseBody
	 public Result getDesigerWork(long workId){
		 return workService.getDesigerWork(workId);
	 }
	 
  
	 
	 
	 
	 //删除作品
	
	 @RequestMapping("/delete/desigerwork")
	 @ResponseBody
	 public Result deleteDesigerWork(String workIds){
		 return workService.deleteDesigerWork(workIds);
	 }
	 
	 //删除作品集
	 
	 @RequestMapping("/delete/desigerworks")
	 @ResponseBody
	 public Result deleteDesigerWorks(String workIdlists){
		 return workService.deleteDesigerWorks(workIdlists);
	 }
	 
	 
	 
	 
	 
 
}
