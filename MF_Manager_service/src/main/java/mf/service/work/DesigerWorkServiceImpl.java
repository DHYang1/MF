package mf.service.work;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSSClient;

import MF_Utils.IDUtils;
import MF_Utils.Result;
import OssUtils.FileUpDownloadAndProgress;
import mf.mapper.DesignerMapper;
import mf.mapper.DesignworkMapper;
import mf.mapper.LabelMapper;
import mf.mapper.WorkLabelMapper;
import mf.mapper.WorksCollectionMapper;
import mf.mapper.WorksListMapper;
import mf.pojo.Designer;
import mf.pojo.Designwork;
import mf.pojo.Label;
import mf.pojo.LookWork;
import mf.pojo.WorkLabel;
import mf.pojo.WorksCollection;
import mf.pojo.WorksCollectionExample;
import mf.pojo.WorksCollectionExample.Criteria;

@Service
public class DesigerWorkServiceImpl implements DesigerWorkService {
	@Autowired  WorkLabelMapper   workLabelMapper;
	@Autowired  DesignworkMapper designworkMapper;
	@Autowired   LabelMapper  labelMapper;
	@Autowired  DesignerMapper  designerMapper;
	@Autowired  WorksCollectionMapper worksCollectionMapper;
	@Autowired   WorksListMapper  worksListMapper;
  
	String baseUrl="http://jykj666.oss-cn-shenzhen.aliyuncs.com/";
	@Override
	public Result publishWork(long desigerId,int ageType,String title, String introduction, Integer gender, Integer face, Long[] labelId ,
			MultipartFile uploadFile1, MultipartFile uploadFile2) {
		
		//发布作品
		try {
	
		 Designwork designwork2 = new   Designwork();
		 long workId = IDUtils.getUserId();
		 designwork2.setWorkId(workId);
		 designwork2.setDesignerId(desigerId);
		 designwork2.setTitle(title);
		 designwork2.setIntroduction(introduction);
		 designwork2.setFace(face);
		 designwork2.setSex(gender);
		 System.out.println("------------------------------------------");
		 System.out.println(ageType);
		 System.out.println("--------------------------------------");
		 byte b=(byte)ageType;
		 designwork2.setAgeType((byte) (ageType));
		//保存标签
		 for (Long long1 : labelId) {
			WorkLabel workLabel = new WorkLabel();
			workLabel.setWorkLabelId(IDUtils.getUserId());
			workLabel.setLabelId(long1);
			workLabel.setWorkId(workId);
			workLabelMapper.insertSelective(workLabel); 
		}
		 //保存图片
		 
		    String remoteFilePath="work";
			String fileName1="work"+uploadFile1.getOriginalFilename();
			String fileName2="work"+uploadFile1.getOriginalFilename();
		
			boolean uploadFileByInputStream1 = FileUpDownloadAndProgress.uploadFileByInputStream(uploadFile1.getInputStream(), remoteFilePath, fileName1);
			boolean uploadFileByInputStream2 = FileUpDownloadAndProgress.uploadFileByInputStream(uploadFile2.getInputStream(), remoteFilePath, fileName2);
         if(uploadFileByInputStream1&&uploadFileByInputStream2){
         	//拼接url
         	String coverImg=baseUrl+remoteFilePath+"/"+fileName1;
         	String contentPicture=baseUrl+remoteFilePath+"/"+fileName2;
         	 designwork2.setCoverImage(coverImg);
 		    designwork2.setContentPicture(contentPicture);
 		    //设置发布时间
 		    designwork2.setLastupdateTime(new Date());
 		    designworkMapper.insertSelective(designwork2);
         
         }
		 
			return Result.ok(1);
		    
		} catch (Exception e) {
		
			e.printStackTrace();
			return Result.ok(2);
		}
    
			 
		}
		

	
	
	@Override
	public Result getDesigerWork(long workId) {
		//设计师头像  设计师名字 访问量  作品发布时间 适合年龄段
		Designwork work = designworkMapper.selectByPrimaryKey(workId);
		Designer designer = designerMapper.selectByPrimaryKey(work.getDesignerId());
		Date lastupdateTime = work.getLastupdateTime();
		LookWork lookWork = new  LookWork();
		
		 SimpleDateFormat sf1 = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy", Locale.ENGLISH); 
	        Date date;
			try {
				date = sf1.parse(lastupdateTime+"");
				 SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd");
			     System.out.println(sf2.format(date));
			     lookWork.setPublishTime(sf2.format(date));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		lookWork.setContentImg(work.getContentPicture());
		lookWork.setDesigerId(work.getDesignerId());
		lookWork.setAgeType(work.getAgeType());
		lookWork.setDesignerName(designer.getDesigerName());
		lookWork.setHeadPath(designer.getHeadPath());
		//lookWork.setPageView(pageView);  访问量
		
		return Result.ok(lookWork);
	}
	//查询出所有的标签
	@Override
	public Result getWorkLable() {
		List<Label> selectByExample = labelMapper.selectByExample(null);
		List<Map<String,Object>> lists =new ArrayList();
		if(selectByExample.size()>0){
		for (Label label : selectByExample) {
			 Map<String,Object> map = new HashMap();
			 map.put("labelId",label.getLabelId());
			 map.put("labelName", label.getName());
			 lists.add(map);	
		}
		return Result.ok(lists);	
		}
		
		return null;
	}

	
	
	
	
	
	
	public String getUrl(MultipartFile uploadFile) throws Exception{
	
		//保存图片
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
			String picName= "work/"+originalFilename;			
			InputStream inputStream =uploadFile.getInputStream();
			ossClient.putObject("jykj666", picName,inputStream);
			Date expiration = new Date(System.currentTimeMillis()+1000*60*60*24*365*10);
			//Date expiration = new Date (new Date().getTime() + 1000 * 60);
		    URL url = ossClient.generatePresignedUrl("jykj666", picName, expiration, HttpMethod.GET);
		    //ossClient.generatePresignedUrl(bucketName, key, expiration, method)
		   // ossClient.getObject(signedUrl, requestHeaders);
		    String strUrl=url+"";
		    inputStream.close();
		    ossClient.shutdown();
		    return   strUrl;
		
	
	}




	@Override
	public Result deleteDesigerWork(String workIds) {
		 String[] split = workIds.split(",");
		 List<Long> lists=new ArrayList();
		 for (String string : split) {	
			 Long long1=new Long(string);
			 lists.add(long1);
			
		}
		for (Long long1 : lists) {
		/*	Long workcollecId=new Long(workIds);
			//查询出作品
			
			
		*/
			
			  designworkMapper.deleteByPrimaryKey(long1);
		
			return Result.ok(1);
		}
		
		
		
		return Result.ok(2);
	}




	@Override
	public Result deleteDesigerWorks(String workIdlists) {
		 String[] split = workIdlists.split(",");
		 List<Long> lists=new ArrayList();
		 for (String string : split) {	
			 Long long1=new Long(string);
			 lists.add(long1);	
		}
	 
		for (Long long1 : lists) {
			  WorksCollectionExample example = new WorksCollectionExample();
			  Criteria criteria = example.createCriteria();
			  criteria.andWorksIdEqualTo(long1);
			  List<WorksCollection> selectByExample = worksCollectionMapper.selectByExample(example);
			  if(selectByExample.size()>0){
				  for (WorksCollection worksCollection : selectByExample) {
					  designworkMapper.deleteByPrimaryKey(worksCollection.getWorkId());
						worksCollectionMapper.deleteByPrimaryKey(worksCollection.getWorksCollectionId());
				}
				  
			  }
			
			  worksListMapper.deleteByPrimaryKey(long1);
		
		return Result.ok(1);
	}
		return Result.ok(2);
}
}