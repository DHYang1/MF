package mf.service.PicUpload;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;

import MF_Utils.Result;
import mf.mapper.DesignerMapper;
import mf.mapper.DesignworkMapper;
import mf.pojo.Designwork;
@Service
public class PicServiceImpl implements PicService {
	@Autowired  DesignworkMapper workMapper;
   //发布作品图片
	@Override
	public Result uploadPublishWork(MultipartFile[] uploadFile) throws Exception  {
		  // endpoint以杭州为例，其它region请按实际情况填写
		 String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
		// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建
		String accessKeyId = "LTAIjb6mQH7kdlhp";
		String accessKeySecret = "IelMKDdDjME1BAKjxKhOpKfD5nKTyL";
		// 创建OSSClient实例
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		// 获取 bucketName的名字
		//String bucketName = ossUtils.getBucketName();
		List<String> urlLists =new ArrayList();
		for (MultipartFile multipartFile : uploadFile) {
			String originalFilename=multipartFile.getOriginalFilename();
			String picName= "work/"+originalFilename;			
			InputStream inputStream = multipartFile.getInputStream();
			ossClient.putObject("jykj666", picName,inputStream);
			Date expiration = new Date(System.currentTimeMillis()+1000*60*60*24*365*10);
			//Date expiration = new Date (new Date().getTime() + 1000 * 60);
		    URL url = ossClient.generatePresignedUrl("jykj666", picName, expiration, HttpMethod.GET);
		    //ossClient.generatePresignedUrl(bucketName, key, expiration, method)
		   // ossClient.getObject(signedUrl, requestHeaders);
		    String strUrl=url+"";
		    
		    urlLists.add(strUrl);
		      Designwork designwork = new Designwork();
		      designwork.setWorkId((long)12);
		      designwork.setDesignerId((long) 123);
		      designwork.setContentPicture(strUrl);
		      designwork.setCoverImage(strUrl);
		      workMapper.insert(designwork);
			 return Result.ok(urlLists);
			 
		}
		return null;
	}

	
	
}
