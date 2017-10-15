package mf.service.user;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSSClient;

import MF_Utils.Result;
import OssUtils.FileUpDownloadAndProgress;
import mf.mapper.UserCenterMapper;
import mf.pojo.UserCenter;

@Service
public class UserCenterServiceImpl implements UserCenterService {
@Autowired UserCenterMapper  userMapper;
String baseUrl="http://jykj666.oss-cn-shenzhen.aliyuncs.com/";
	@Override
	public Result getUserInformation(long userId) {
		UserCenter user = userMapper.selectByPrimaryKey(userId);
		Map<String,String> map = new HashMap();
		//设置头像
		map.put("headImg", user.getHeadImg());
		//昵称
		map.put("userName", user.getNickname());
		//电话号码
		map.put("telephone",user.getPhoneNum());
		return Result.ok(map);
	}

	@Override
	public Result updateUserTouXiang(long userId,MultipartFile uploadFile) throws Exception {
		
		
		UserCenter user = userMapper.selectByPrimaryKey(userId);
		
		 String remoteFilePath="work";
			String fileName="work"+uploadFile.getOriginalFilename();
		
			boolean uploadFileByInputStream = FileUpDownloadAndProgress.uploadFileByInputStream(uploadFile.getInputStream(), remoteFilePath, fileName);
         if(uploadFileByInputStream){
         	//拼接url
         	String url=baseUrl+remoteFilePath+"/"+fileName;
         
		
		user.setHeadImg(url);
		
		user.setCreateTime(new Date());
		userMapper.updateByPrimaryKey(user);
		
	}
         return Result.ok(1);     
	}

	@Override
	public Result updateName(long userId, String userName) {
		UserCenter user = userMapper.selectByPrimaryKey(userId);
		user.setNickname(userName);
		userMapper.updateByPrimaryKey(user);

		return Result.ok(1);
	}

}
