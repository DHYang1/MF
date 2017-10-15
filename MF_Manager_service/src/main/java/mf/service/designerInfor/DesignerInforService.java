package mf.service.designerInfor;

import org.springframework.web.multipart.MultipartFile;

import MF_Utils.Result;

public interface DesignerInforService {
	  public Result updateTouxiang(long designerId,MultipartFile uploadFile)throws Exception ;
}
