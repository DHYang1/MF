package mf.controller.designer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import MF_Utils.Result;
import mf.mapper.DesignerMapper;
import mf.mapper.DesignerParticularMapper;
import mf.pojo.Designer;
import mf.pojo.DesignerParticular;
import mf.service.designerInfor.DesignerInforService;

@Controller
public class DesignerInforController {

	@Autowired   DesignerInforService designerInforService;
	@Autowired  DesignerMapper  designerMapper;
	@Autowired   DesignerParticularMapper  particularMapper;
	//设计师 信息修改
	
	@RequestMapping("/designer/touxiang")
    @ResponseBody
    public Result updateTouxiang(long designerId,MultipartFile uploadFile){
		//返回1为成功 2为失败
		 try {
			return designerInforService.updateTouxiang(designerId, uploadFile);
		} catch (Exception e) {
			
			e.printStackTrace();
			return Result.ok(2);
			
		}
		
	
	}
	//名字的修改
	
	
	@RequestMapping("/designer/name")
    @ResponseBody
    public Result updateName(long designerId,String name){
		try {
			
			//name = new String(name.getBytes("iso8859-1"),"utf-8");
			Designer designer = designerMapper.selectByPrimaryKey(designerId);
			designer.setDesigerName(name);
			designerMapper.updateByPrimaryKeySelective(designer);
			return Result.ok(1);
		} catch (Exception e) {
			return Result.ok(2);
		}

		
	
	}
	
	
	//职称的修改
	
	
	@RequestMapping("/designer/position")
    @ResponseBody
    public Result updatePosition(long designerId,String position){
		try {
			//position = new String(position.getBytes("iso8859-1"),"utf-8");
			Designer designer = designerMapper.selectByPrimaryKey(designerId);
			designer.setPosition(position);
			designerMapper.updateByPrimaryKeySelective(designer);
			return Result.ok(1);
		} catch (Exception e) {
			return Result.ok(2);
		}

		
	
	}
	//公司的名字
	@RequestMapping("/designer/companyName")
    @ResponseBody
    public Result updateCompanyName(long designerId,String companyName){
		try {
			//companyName = new String(companyName.getBytes("iso8859-1"),"utf-8");
			Designer selectByPrimaryKey = designerMapper.selectByPrimaryKey(designerId);
			// DesignerParticular part = particularMapper.selectByPrimaryKey(designerId);
			selectByPrimaryKey.setJob(companyName);
			designerMapper.updateByPrimaryKeySelective(selectByPrimaryKey);
			return Result.ok(1);
		} catch (Exception e) {
			return Result.ok(2);
		}

		
	
	}
	
   //自我介绍
	
	@RequestMapping("/designer/introdu")
    @ResponseBody
    public Result updateIntrodu(long designerId,String introdu){
		try {
			//introdu = new String(introdu.getBytes("iso8859-1"),"utf-8");
			 DesignerParticular part = particularMapper.selectByPrimaryKey(designerId);
			 part.setIntroduction(introdu);
			 particularMapper.updateByPrimaryKey(part);
			return Result.ok(1);
		} catch (Exception e) {
			return Result.ok(2);
		}
	}
	//个性签名
		@RequestMapping("/designer/autogra")
	    @ResponseBody
	    public Result updateAutogra(long designerId,String autogra){
			try {
				//autogra = new String(autogra.getBytes("iso8859-1"),"utf-8");
				 DesignerParticular part = particularMapper.selectByPrimaryKey(designerId);
				 part.setAutograph(autogra);
				 particularMapper.updateByPrimaryKey(part);
				return Result.ok(1);
			} catch (Exception e) {
				return Result.ok(2);
			}

		
		

	
	//参加比赛                       
	
	
	
	
}
  // 擅长方面		
		
		@RequestMapping("/designer/specialty")
	    @ResponseBody
	    public Result updateSpecialty(long designerId,String specialty){
			try {
				//specialty = new String(specialty.getBytes("iso8859-1"),"utf-8");
				 DesignerParticular part = particularMapper.selectByPrimaryKey(designerId);
				 part.setSpecialty(specialty);
				 particularMapper.updateByPrimaryKey(part);
				return Result.ok(1);
			} catch (Exception e) {
				return Result.ok(2);
			}

}
		
		//参加比赛    
		@RequestMapping("/designer/match")
	    @ResponseBody
	    public Result updateMatch(long designerId,String match){
			try {
				//match = new String(match.getBytes("iso8859-1"),"utf-8");
				 DesignerParticular part = particularMapper.selectByPrimaryKey(designerId);
				 part.setMatchgame(match);
				 particularMapper.updateByPrimaryKey(part);
				return Result.ok(1);
			} catch (Exception e) {
				return Result.ok(2);
			}

}


}