package mf.service.work;

import org.springframework.web.multipart.MultipartFile;

import MF_Utils.Result;

public interface DesigerWorkService {
	 public Result publishWork(long desigerId,int ageType,String title, String introduction, Integer gender, Integer face,Long[] labelId ,
				MultipartFile uploadFile1, MultipartFile uploadFile2);
	 public Result getDesigerWork(long workId);
	 public Result getWorkLable();
	 public Result deleteDesigerWork(String workIds);
	 public Result deleteDesigerWorks(String workIdlists);
}
