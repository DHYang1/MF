package mf.controller.user;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSSClient;

import MF_Utils.Result;
import mf.pojo.Designwork;
import mf.service.user.UserCenterService;

@Controller
public class UserCenterController {

@Autowired   UserCenterService userCenterService;

    //个人信息的查看
	 @RequestMapping("/getUserInformat")
	 @ResponseBody
	 public Result  getUserInformation(long userId){
		return  userCenterService.getUserInformation(userId);
	
	 }
	 
	 
	 // ,String userName
	//个人信息头像的修改
	 @RequestMapping("/updateUserTouXiang")
	 @ResponseBody
	 public Result  updateUserTouXiang(long userId,MultipartFile uploadFile){
	           //1为成功  2为失败
					  try {
					  System.out.println("-----------------------------------------");
							System.out.println(uploadFile);
							System.out.println("-----------------------");
						return userCenterService.updateUserTouXiang(userId, uploadFile);
					} catch (Exception e) {
						e.printStackTrace();	
						return Result.ok(2);
					}
				

	 }
	
	 
	//姓名的修改
	@RequestMapping("/updateName")
	@ResponseBody
	public Result updateName(long userId,String userName){
		try {
			//iso8859-1
			//userName = new String(userName.getBytes("iso8859-1"),"utf-8");
			return userCenterService.updateName(userId, userName);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Result.ok(2);
		}
			
	
			}

	 
	 //头像的修改
		@RequestMapping("/uploadTouXiang")
		@ResponseBody
		public Result uploadTouXiang(MultipartFile uploadFile) throws Exception  {
			  // endpoint以杭州为例，其它region请按实际情况填写
			 String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
			// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建
			String accessKeyId = "LTAIjb6mQH7kdlhp";
			String accessKeySecret = "IelMKDdDjME1BAKjxKhOpKfD5nKTyL";
			// 创建OSSClient实例
			OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
			// 获取 bucketName的名字
			//String bucketName = ossUtils.getBucketName();
				String originalFilename=uploadFile.getOriginalFilename();
				String picName= "touxiang/"+originalFilename;			
				InputStream inputStream = uploadFile.getInputStream();
				ossClient.putObject("jykj666", picName,inputStream);
				Date expiration = new Date(System.currentTimeMillis()+1000*60*60*24*365*10);
				//Date expiration = new Date (new Date().getTime() + 1000 * 60);
			    URL url = ossClient.generatePresignedUrl("jykj666", picName, expiration, HttpMethod.GET);
			    //ossClient.generatePresignedUrl(bucketName, key, expiration, method)
			   // ossClient.getObject(signedUrl, requestHeaders);
			    String strUrl=url+"";
			    
			  
				 return Result.ok(strUrl);
				 
	
		}

		
		

		
		
		

		
		
	 
	 
	
	
}
