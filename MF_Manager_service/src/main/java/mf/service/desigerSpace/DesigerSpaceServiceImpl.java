package mf.service.desigerSpace;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import MF_Utils.IDUtils;
import MF_Utils.Result;
import OssUtils.FileUpDownloadAndProgress;
import mf.mapper.DesignerMapper;
import mf.mapper.DesignerPageMapper;
import mf.mapper.DesignerParticularMapper;
import mf.mapper.DesignworkMapper;
import mf.mapper.UserCenterMapper;
import mf.mapper.WorkImgPath;
import mf.mapper.WorksCollectionMapper;
import mf.mapper.WorksListMapper;
import mf.pojo.DesigerWorkSpace;
import mf.pojo.Designer;
import mf.pojo.DesignerInfo;
import mf.pojo.DesignerParticular;
import mf.pojo.DesignerParticularAdd;
import mf.pojo.DesignerParticularExample;
import mf.pojo.Designwork;
import mf.pojo.DesignworkExample;
import mf.pojo.MyWorkList;
import mf.pojo.UserCenter;
import mf.pojo.UserCenterExample;
import mf.pojo.Work;
import mf.pojo.WorksCollection;
import mf.pojo.WorksCollectionExample;
import mf.pojo.WorksList;
import mf.pojo.WorksListExample;
import mf.pojo.WorksListExample.Criteria;

@Service
public class DesigerSpaceServiceImpl implements DesigerSpaceService {
@Autowired DesignerMapper designerMapper;
@Autowired WorksListMapper worksListMapper;
@Autowired   DesignworkMapper  designworkMapper;
@Autowired  WorksCollectionMapper worksCollectionMapper;
@Autowired  WorkImgPath  workImgPathMapper;
@Autowired  DesignerParticularMapper introduceMapper;
@Autowired    UserCenterMapper   userCenterMapper;
@Autowired  DesignerPageMapper  designerPageMapper;
String baseUrl="http://jykj666.oss-cn-shenzhen.aliyuncs.com/";
	@Override
	public Result goToWorkSpace(long designerId) {
		  DesigerWorkSpace desigerWorkSpace = new DesigerWorkSpace();
		   //创建作品集的集合
		    List<MyWorkList> workLists = new ArrayList();
		Designer selectByPrimaryKey2 = designerMapper.selectByPrimaryKey(designerId);
	/*	Designer selectByPrimaryKey = selectByPrimaryKey2;
		Designer desiger = selectByPrimaryKey;*/
		   WorksListExample example = new  WorksListExample();
		   Criteria criteria = example.createCriteria();
		   criteria.andDesignerIdEqualTo(designerId);
		   List<WorksList> lists = worksListMapper.selectByExample(example);
		   if(!lists.isEmpty()&& lists.size()>0){
			   for (WorksList worksList : lists) {
				   MyWorkList myWorkList = new  MyWorkList();
				   myWorkList.setName(worksList.getName());
				   //随机设置一张图片
				   Long worksId = worksList.getWorksId();
				   WorksCollectionExample example1 = new WorksCollectionExample();
				   mf.pojo.WorksCollectionExample.Criteria criteria1 = example1.createCriteria();
				   criteria1.andWorksIdEqualTo(worksId);
				   List<WorksCollection> selectByExample = worksCollectionMapper.selectByExample(example1);
				   if(selectByExample.size()>0){
					   Long workId = selectByExample.get(0).getWorkId();
					   Designwork selectByPrimaryKey = designworkMapper.selectByPrimaryKey(workId);  
					   myWorkList.setImg_path(selectByPrimaryKey.getCoverImage());
				   }
				  
				    //设计作品集的ID
				   myWorkList.setWorksId(worksId);   
				   workLists.add(myWorkList);   
			}
			   
			 
			  /* WorksList worksList = lists.get(0);
			   String workname=worksList.getName();
			   myWorkList.setName(workname);
			  //查询图片的地址
			   String img_path = workImgPathMapper.getWorkImgPath(designerId);
			   myWorkList.setImg_path(img_path);*/
			   
		   }
		  
		//设置工作年限
		Integer jobYear = selectByPrimaryKey2.getJobYear();
		Date date = new Date();
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		  String dateNowStr = sdf.format(date); 
		  int i = Integer.parseInt(dateNowStr); 
		  System.out.println("格式化后的日期：" + dateNowStr);
		  System.out.println(i-jobYear);
		  desigerWorkSpace.setJobYear(i-jobYear);
		  desigerWorkSpace.setJob(selectByPrimaryKey2.getJob());
		  desigerWorkSpace.setPosition(selectByPrimaryKey2.getPosition());
		  desigerWorkSpace.setMyWorkList(workLists);
		//设计师作品展示
		  DesignworkExample example1 = new DesignworkExample();
			 mf.pojo.DesignworkExample.Criteria criteria1 = example1.createCriteria();
			 criteria.andDesignerIdEqualTo(designerId);
			List<Designwork> list = designworkMapper.selectByExample(example1);
			 List<Work> workList=new ArrayList<>();
			for (Designwork designwork : list) {
				//String coverImage = designwork.getCoverImage();
				Work work = new  Work();
				work.setWorkId(designwork.getWorkId());
				work.setWorkUrl(designwork.getCoverImage());
				workList.add(work);
				
			}
		  //添加作品集  
			desigerWorkSpace.setWorkList(workList);
		 //添加头像		
			desigerWorkSpace.setDesigerHeadImg(selectByPrimaryKey2.getHeadPath());
		//设计师名字
			String desigerName = selectByPrimaryKey2.getDesigerName();
			desigerWorkSpace.setDesigerName(desigerName);
			
	   //设计师电话	
			Long userId = selectByPrimaryKey2.getUserId();
			UserCenter user = userCenterMapper.selectByPrimaryKey(userId);
			desigerWorkSpace.setDesigerPhone(user.getPhoneNum());
			/*UserCenterExample example2 = new UserCenterExample();
			mf.pojo.UserCenterExample.Criteria criteria2 = example2.createCriteria();
			criteria2.and
			userCenterMapper.selectByExample(example2);*/
			
		return Result.ok(desigerWorkSpace);
	}
	
	
	
	
	
   //查询设计师的基本介绍
	@Override
	public Result getIntroduce(long designerId) {
		DesignerParticular particular = introduceMapper.selectByPrimaryKey(designerId);
		Designer desiger = designerMapper.selectByPrimaryKey(designerId);
		  DesignerParticularAdd particularAdd = new DesignerParticularAdd();
		  
		  particularAdd.setAutograph(particular.getAutograph());
		  particularAdd.setDesigerHeadImg(desiger.getHeadPath());
		  particularAdd.setDesigerName(desiger.getDesigerName());
		  particularAdd.setDesignerId(designerId);
		  particularAdd.setIntroduction(particular.getIntroduction());
		  particularAdd.setMatch(particular.getMatchgame());
		  particularAdd.setSpecialty(particular.getSpecialty());
		return Result.ok(particularAdd);
	}
	//介绍更改
	@Override
	public Result updateIntroduce( String introduction,String specialty,String autograph,String match,Long designerId) {
		DesignerParticularExample example = new DesignerParticularExample();
		mf.pojo.DesignerParticularExample.Criteria criteria = example.createCriteria();
		criteria.andDesignerIdEqualTo(designerId);
		 DesignerParticular designerParticular = introduceMapper.selectByPrimaryKey(designerId);
	
		if(designerParticular!=null){
			designerParticular.setDesignerId(designerId);
			designerParticular.setAutograph(autograph);
			designerParticular.setIntroduction(introduction);
			designerParticular.setMatchgame(match);
			designerParticular.setSpecialty(specialty);
		
			introduceMapper.updateByPrimaryKeySelective(designerParticular);
			
		}
		
		return Result.ok(1);
	}
	
	
	
	//点击我的发布 查看作品
	@Override
	public Result goToWork(long designerId,int page) {
		List<Designwork> list = designerPageMapper.selectBypageDesigner(page, designerId);
		/* DesignworkExample example = new DesignworkExample();
		 mf.pojo.DesignworkExample.Criteria criteria = example.createCriteria();
		 criteria.andDesignerIdEqualTo(designerId);
		List<Designwork> list = designworkMapper.selectByExample(example);*/
		 List<Map<String,Object>> ImgList=new ArrayList<>();
		for (Designwork designwork : list) {
			String coverImage = designwork.getCoverImage();
			Map<String,Object> map = new HashMap();
			map.put("workId",designwork.getWorkId());
			System.out.println(designwork.getWorkId());
			map.put("img", coverImage);
			map.put("name", designwork.getTitle());//标题
			System.out.println(coverImage);
			ImgList.add(map);
		}
		return Result.ok(ImgList);
	}
	@Override
	public Result publishWorkList(MultipartFile[] uploadFile, long desigerId,String name) throws Exception {
		 /* // endpoint以杭州为例，其它region请按实际情况填写
		 String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
		// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建
		String accessKeyId = "LTAIjb6mQH7kdlhp";
		String accessKeySecret = "IelMKDdDjME1BAKjxKhOpKfD5nKTyL";
		// 创建OSSClient实例
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		// 获取 bucketName的名字
		//String bucketName = ossUtils.getBucketName();
*/		List<String> urlLists =new ArrayList();
		WorksList worksList = new WorksList();
		long worksId = IDUtils.getUserId();
		worksList.setWorksId(worksId);
		worksListMapper.insertSelective(worksList);
		for (MultipartFile multipartFile : uploadFile) {
			
			 String remoteFilePath="work";
				String fileName="work"+multipartFile.getOriginalFilename();
			
	  			boolean uploadFileByInputStream = FileUpDownloadAndProgress.uploadFileByInputStream(multipartFile.getInputStream(), remoteFilePath, fileName);
	            if(uploadFileByInputStream){
	            	//拼接url
	            	String url=baseUrl+remoteFilePath+"/"+fileName;
	            	//urlLists.add(url);
	            	 //保存作品
	   	         WorksCollection worksCollection = new WorksCollection();
	   	           Designwork designwork = new  Designwork();
	   	           long workId= IDUtils.getUserId();
	   	           designwork.setWorkId(workId);
	   	           designwork.setContentPicture(url);
	   	        //作品集和作品关系
	  	         worksCollection.setWorksCollectionId(IDUtils.getUserId());
	  	         worksCollection.setWorkId(workId);
	  	         worksCollection.setWorksId(worksId);     
	  	         //保存图片
	  	         urlLists.add(url);
	  	         designworkMapper.insertSelective(designwork);
	  	         worksCollectionMapper.insertSelective(worksCollection);
	  	         
	            	
	            }
	
	}
		
		//设置作品集
		
		worksList.setDesignerId(desigerId);
		worksList.setCreatTime(new Date());	
		worksList.setImgurl(urlLists.get(0));
		worksList.setName(name);
		worksListMapper.updateByPrimaryKey(worksList);
		Map<String,Integer> map =new HashMap();
		map.put("status",1);
		 return Result.ok(map);
}
	//
	@Override
	public Result getWorkList(long worksId) {
		WorksCollectionExample example = new WorksCollectionExample();
		mf.pojo.WorksCollectionExample.Criteria criteria = example.createCriteria();
		criteria.andWorksIdEqualTo(worksId);
		WorksList workList = worksListMapper.selectByPrimaryKey(worksId);
		List<WorksCollection> lists = worksCollectionMapper.selectByExample(example);
		  List<Map<String,Object>> imgStr= new ArrayList<>();
		for (WorksCollection worksCollection : lists) {
			Designwork selectByPrimaryKey = designworkMapper.selectByPrimaryKey(worksCollection.getWorkId());
			Map<String,Object> map=new HashMap();
			map.put("workId", selectByPrimaryKey.getWorkId());
			map.put("workImgUrl", selectByPrimaryKey.getCoverImage());
		    map.put("workName", workList.getName());//设计师吗，
		    map.put("worktime",workList.getCreatTime());    
			imgStr.add(map);
		}
	return Result.ok(imgStr);
	}





	@Override
	public Result getDesigerInfor(long desigerId) {
		//
		Designer designer = designerMapper.selectByPrimaryKey(desigerId);
		DesignerParticular designerParticular = introduceMapper.selectByPrimaryKey(desigerId);
		
		UserCenter user = userCenterMapper.selectByPrimaryKey(designer.getUserId());
		DesignerInfo designerInfo = new DesignerInfo();
		designerInfo.setAutograph(designerParticular.getAutograph());
		designerInfo.setCompanyName(designer.getJob());
		designerInfo.setDesigerHeadPath(designer.getHeadPath());
		designerInfo.setDesigerName(designer.getDesigerName());
		designerInfo.setDesigerPosition(designer.getPosition());
		designerInfo.setIntroduction(designerParticular.getIntroduction());
		designerInfo.setMatch(designerParticular.getMatchgame());
		designerInfo.setSpecialty(designerParticular.getSpecialty());
		designerInfo.setTelephone(user.getPhoneNum());
		//设置经验
		Integer jobYear = designer.getJobYear();
		Date date = new Date();
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		  String dateNowStr = sdf.format(date); 
		  int i = Integer.parseInt(dateNowStr); 
		  System.out.println("格式化后的日期：" + dateNowStr);
		  System.out.println(i-jobYear);
		  designerInfo.setJobyears(i-jobYear+"");
		
		return Result.ok(designerInfo);
	}



//个人信息的修改

	@Override
	public Result updateDesigerInfor(long desigerId) {
		// TODO Auto-generated method stub
		return null;
	}




//查看设计师的作品集
	@Override
	public Result goToWorkList(long designerId) {
		WorksListExample example = new WorksListExample();
		Criteria criteria = example.createCriteria();
		criteria.andDesignerIdEqualTo(designerId);
		List<WorksList> workLists = worksListMapper.selectByExample(example);
		List<Map<String,Object>> lists=new ArrayList();
		if(workLists.size()>0){
			for (WorksList worksList : workLists) {
				Map<String,Object> map =new HashMap();
				map.put("id", worksList.getWorksId());
				map.put("img", worksList.getImgurl());
				map.put("creaTime",worksList.getCreatTime());
		        map.put("name", worksList.getName());
				lists.add(map);
			}
			
		}
		Map<String,Object> map= new HashMap();
		map.put("status",1);
		map.put("data", lists);
		return Result.ok(map);
	}
	

}
