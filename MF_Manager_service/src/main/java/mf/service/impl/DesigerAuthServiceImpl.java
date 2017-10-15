package mf.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import MF_Utils.IDUtils;
import MF_Utils.Result;
import OssUtils.FileUpDownloadAndProgress;
import mf.mapper.DesignerMapper;
import mf.mapper.DesignworkMapper;
import mf.mapper.GoodaspectMapper;
import mf.mapper.UserCenterMapper;
import mf.pojo.Designer;
import mf.pojo.Designwork;
import mf.pojo.Goodaspect;
import mf.pojo.GoodaspectExample;
import mf.pojo.GoodaspectExample.Criteria;
import mf.pojo.UserCenter;
import mf.service.Auth.DesigerAuthService;
@Service
public class DesigerAuthServiceImpl implements DesigerAuthService {

	@Autowired  UserCenterMapper userCenterMapper;
	@Autowired DesignerMapper designerMapper;
	@Autowired   GoodaspectMapper  aspectMapper;
	@Autowired   DesignworkMapper  designworkMapper;
	String baseUrl="http://jykj666.oss-cn-shenzhen.aliyuncs.com/";
	@Override
	 public  Result desigerAuth(long userId,long[] goodIds,MultipartFile[] uploadFile,Integer startworkDate){
		try {
			
		 
			UserCenter user = userCenterMapper.selectByPrimaryKey(userId);
			user.setType(2);
			Designer designer = new Designer();
			designer.setUserId(userId);
			long desigerId = IDUtils.getUserId();
			designer.setDesignerId(desigerId);
			designer.setJobYear(startworkDate);
			//保存擅长方面
           for (long goodId : goodIds) {
        	   GoodaspectExample example = new GoodaspectExample();
        	   Criteria criteria = example.createCriteria();
        	   criteria.andGoodIdEqualTo(goodId);
        	   List<Goodaspect> selectByExample = aspectMapper.selectByExample(example);
        	   if(selectByExample.size()>0){
        		   Goodaspect goodaspect1 = selectByExample.get(0);
        		  Goodaspect goodaspect = new Goodaspect();
             	  goodaspect.setDesigerid(desigerId);
             	  goodaspect.setGoodId(IDUtils.getUserId());
             	  goodaspect.setGoodName(goodaspect1.getGoodName());
             	 aspectMapper.insertSelective(goodaspect);
  	   
        		   
        	   }
      	   
		}	
       	designerMapper.insert(designer);
        		List<String> urlLists =new ArrayList(); 
             //保存作品
  		for (MultipartFile multipartFile : uploadFile) {
	       String remoteFilePath="work";
			String fileName="work"+multipartFile.getOriginalFilename();
		
  			boolean uploadFileByInputStream = FileUpDownloadAndProgress.uploadFileByInputStream(multipartFile.getInputStream(), remoteFilePath, fileName);
            if(uploadFileByInputStream){
            	//拼接url
            	String url=baseUrl+remoteFilePath+"/"+fileName;
            	urlLists.add(url);
            	 Designwork designwork = new  Designwork();
         		  designwork.setWorkId(IDUtils.getUserId());
         		  designwork.setDesignerId(desigerId);
         	 	  designwork.setContentPicture(url);
         	 	  designworkMapper.insert(designwork);	
            	
            }
  			
  
  		   	
		} 
  		userCenterMapper.updateByPrimaryKey(user);
  	
          Map<String,Object> map =new HashMap();
          map.put("status",1);
          map.put("desigerId", desigerId);
	  return Result.ok(map);
	  
		}
	  
	  catch (Exception e) {
			// TODO: handle exception
		}
		 Result result = new Result();
		 result.setStatus(2);
		 result.setMsg("认证失败");
		 Map<String,Object> map =new HashMap();
	     map.put("status",1);
	     result.setData(map);
		 
		return result;
	}
	
	//返回标签
	@Override
	public Result getDesigerAuth() {

		GoodaspectExample example = new GoodaspectExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo((byte)1);
		List<Goodaspect> goodaspect = aspectMapper.selectByExample(example);
		  List<Map<String,Object>> list=new ArrayList();
		for (Goodaspect goodaspect2 : goodaspect) {
			Map<String,Object> map =new HashMap();
			map.put("id", goodaspect2.getGoodId());
			map.put("name", goodaspect2.getGoodName());
			list.add(map);
		}
		return Result.ok(list);
	}}
