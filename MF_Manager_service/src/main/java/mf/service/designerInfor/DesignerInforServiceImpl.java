package mf.service.designerInfor;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import MF_Utils.Result;
import OssUtils.FileUpDownloadAndProgress;
import mf.mapper.DesignerMapper;
import mf.pojo.Designer;

@Service
public class DesignerInforServiceImpl implements DesignerInforService {
	String baseUrl="http://jykj666.oss-cn-shenzhen.aliyuncs.com/";
	@Autowired  DesignerMapper  designerMapper;
	@Override
	public Result updateTouxiang(long designerId,MultipartFile uploadFile) throws Exception {
		
		    String remoteFilePath="touxiang";
			String fileName="work"+uploadFile.getOriginalFilename();
			boolean uploadFileByInputStream = FileUpDownloadAndProgress.uploadFileByInputStream(uploadFile.getInputStream(), remoteFilePath, fileName);
		if(uploadFileByInputStream){
			//拼接url
        	String headPath=baseUrl+remoteFilePath+"/"+fileName;
			Designer designer = designerMapper.selectByPrimaryKey(designerId);
			designer.setHeadPath(headPath);
			designerMapper.updateByPrimaryKeySelective(designer);
			
			
		}
		return Result.ok(1);
	}

}
