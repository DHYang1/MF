package mf.service.Auth;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import MF_Utils.Result;
import mf.pojo.Designer;
import mf.pojo.Goodaspect;

public interface DesigerAuthService {
	
	  public Result getDesigerAuth();
	  public  Result desigerAuth(long userId,long[] goodIds,MultipartFile[] uploadFile,Integer startworkDate);
}
