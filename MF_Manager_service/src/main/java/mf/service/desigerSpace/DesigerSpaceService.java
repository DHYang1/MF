package mf.service.desigerSpace;


import org.springframework.web.multipart.MultipartFile;

import MF_Utils.Result;

public interface DesigerSpaceService {
	 public Result goToWorkSpace(long designerId);
	  public Result  getIntroduce(long designerId);
	  public Result  updateIntroduce( String introduction,String specialty,String autograph,String match,Long designerId);
	  public Result goToWork(long designerId,int page);
	  
	  public Result publishWorkList(MultipartFile[] uploadFile,long desigerId,String name)  throws Exception;
	  
	  public Result getWorkList(long  worksId);
	  public Result  getDesigerInfor(long desigerId);
	 public Result  updateDesigerInfor(long desigerId);
	 public Result goToWorkList(long designerId);
}
