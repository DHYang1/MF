package mf.controller.picUpload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import MF_Utils.Result;
import mf.service.PicUpload.PicService;
@Controller
public class PicController {
	@Autowired  PicService  picService;
	
	//发布作品的时候上传图片
	@RequestMapping("/uploadPublishWork")
	@ResponseBody
	public  Result uploadPublishWork(@RequestParam MultipartFile[] uploadFile){
		try {
			Result result = picService.uploadPublishWork(uploadFile);
			return result;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}
}
