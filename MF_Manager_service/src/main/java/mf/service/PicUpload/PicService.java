package mf.service.PicUpload;

import org.springframework.web.multipart.MultipartFile;

import MF_Utils.Result;

public interface PicService {
	public  Result uploadPublishWork(MultipartFile[] uploadFile) throws Exception;
}
