package mf.service.user;

import org.springframework.web.multipart.MultipartFile;

import MF_Utils.Result;

public interface UserCenterService {
	 public Result  getUserInformation(long userId);
	 public Result  updateUserTouXiang(long userId,MultipartFile uploadFile) throws Exception;
		public Result updateName(long userId,String userName);
}
