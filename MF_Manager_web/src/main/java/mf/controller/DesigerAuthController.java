package mf.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import MF_Utils.IDUtils;
import MF_Utils.Result;
import OssUtils.FileUpDownloadAndProgress;
import mf.mapper.DesignerCertificationMapper;
import mf.mapper.DesignerMapper;
import mf.mapper.DesignerWalletMapper;
import mf.mapper.DesignworkMapper;
import mf.mapper.UserCenterMapper;
import mf.pojo.Designer;
import mf.pojo.DesignerCertification;
import mf.pojo.DesignerExample;
import mf.pojo.DesignerExample.Criteria;
import mf.pojo.DesignerWallet;
import mf.pojo.UserCenter;
import mf.service.Auth.DesigerAuthService;

@Controller
public class DesigerAuthController {
	@Autowired  DesigerAuthService authService;
	@Autowired  DesignerCertificationMapper designerCertificationMapper;
   @Autowired     DesignworkMapper  designworkMapper;
   @Autowired    UserCenterMapper  userCenterMapper;
	@Autowired DesignerMapper designerMapper;
	@Autowired   DesignerWalletMapper  walletMapper;
	
	
	String baseUrl="http://jykj666.oss-cn-shenzhen.aliyuncs.com/";
	//设计师认证 ，返回擅长选择 
   @RequestMapping("/getdesigerAuth")
   @ResponseBody
	public Result getDesigerAuth(){
		return authService.getDesigerAuth();
		
	}


	//基本设计师信息保存
	@RequestMapping("/desigerAuth")
    @ResponseBody
    public  Result desigerAuth(long userId,long[] goodIds,@RequestParam MultipartFile[] uploadFile,Integer startworkDate){
		return authService.desigerAuth(userId, goodIds, uploadFile,startworkDate);
	}

	//身份证保存
	@RequestMapping("/idCardAuth")
    @ResponseBody
    public  Result IdCardAuth(MultipartFile uploadFile1,MultipartFile uploadFile2,long userId){
		try {
		
			String remoteFilePath="IDCARDS";
			
 			String fileName1="IDCARDS"+uploadFile1.getOriginalFilename();
			String fileName2="IDCARDS"+uploadFile2.getOriginalFilename();
	
			boolean uploadFileByInputStream1 = FileUpDownloadAndProgress.uploadFileByInputStream(uploadFile1.getInputStream(), remoteFilePath, fileName1);
			//拼接身份证URL 正面
			String ZUrl=baseUrl+remoteFilePath+"/"+fileName1;
			
			boolean uploadFileByInputStream2 = FileUpDownloadAndProgress.uploadFileByInputStream(uploadFile2.getInputStream(), remoteFilePath, fileName2);
			//身份证URL,反面
			String FUrl=baseUrl+remoteFilePath+"/"+fileName2;
 
			if(uploadFileByInputStream1&&uploadFileByInputStream2){
				  DesignerCertification designerCertification = new  DesignerCertification();
				  designerCertification.setCertificationId(IDUtils.getUserId());
				  DesignerExample designerExample = new DesignerExample();
				DesignerExample example = designerExample;
				  Criteria criteria = example.createCriteria();
				  criteria.andUserIdEqualTo(userId);
				  List<Designer> desiger = designerMapper.selectByExample(example);	
				  if(desiger.size()>0){
					  designerCertification.setDesigerId(desiger.get(0).getDesignerId());
					  designerCertification.setTheCard(ZUrl);
					  designerCertification.setOsitiveCard(FUrl);
					  designerCertificationMapper.insertSelective(designerCertification);
				  
					  
				  }
		
			}
			
			
			//创建设计师的钱包
			DesignerExample example=new DesignerExample();
			Criteria criteria = example.createCriteria();
			criteria.andUserIdEqualTo(userId);
			List<Designer> lists = designerMapper.selectByExample(example);
			
			if(lists.size()>0){
				Designer  designer= lists.get(0);
				 DesignerWallet designerWallet = new DesignerWallet();
				 designerWallet.setDesignerId(designer.getDesignerId());
				 walletMapper.insert(designerWallet);
			}
  
				  Map<String,Object> map =new HashMap();
				  map.put("status",1);
					return Result.ok(map);
		} catch (Exception e) {
			e.printStackTrace();
			 Map<String,Object> map =new HashMap();
			  map.put("status",2);
			  return Result.ok(map);
	
		}

	 }
	
}
