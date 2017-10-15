package mf.controller;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import MF_Utils.IDUtils;
import OssUtils.FileUpDownloadAndProgress;
import mf.mapper.DesignerMapper;
@Controller
public class Demo {

	
	@Autowired   DesignerMapper  designerMapper;
	
	
	
	
	
	
	
	@RequestMapping("/getFile")
	@ResponseBody
	public boolean getfile(MultipartFile uploadFile){
		String remoteFilePath="test";
		
		String fileName="DDD.jpg";
		//String fileName=uploadFile.getOriginalFilename();
		//String picName= "work/"+originalFilename;		
		try {
		
			 boolean uploadFileByInputStream = FileUpDownloadAndProgress.uploadFileByInputStream(uploadFile.getInputStream(), remoteFilePath, fileName);
			 
			return uploadFileByInputStream;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
		
	
		
	}

	/*	public static void main(String[] args) {
			
		// endpoint以杭州为例，其它region请按实际情况填写
			String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
			// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建
			String accessKeyId = "LTAIjb6mQH7kdlhp";
			String accessKeySecret = "IelMKDdDjME1BAKjxKhOpKfD5nKTyL";
			// 创建OSSClient实例
			OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
			// 上传文件
			 ossClient.putObject("jykj666", "good13.jpg", new File("D:/Desert.jpg"));
			OSSObject object = ossClient.getObject("jykj666","good13.jpg");
			Date expiration = new Date(System.currentTimeMillis() + 3600000);
			    URL url = ossClient.generatePresignedUrl("jykj666", "good13.jpg", expiration, HttpMethod.GET);
	        System.out.println(url);
			
			designerMapper
		
			
			
			
			
			
		
		}*/
	
	}
	
	
	
