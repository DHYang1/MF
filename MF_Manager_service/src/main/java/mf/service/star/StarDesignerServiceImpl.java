package mf.service.star;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MF_Utils.Result;
import mf.mapper.DesignerMapper;
import mf.pojo.Designer;
import mf.pojo.StarDesigner;
@Service
public class StarDesignerServiceImpl implements StarDesignerService {

	@Autowired DesignerMapper  designerMapper;
	//默认查看
	@Override
	public Result getStarDesigner() {
		List<StarDesigner> lists=new ArrayList<>();
		List<Designer> designer = designerMapper.selectByExample(null);
		for (Designer designer2 : designer) {
			StarDesigner starDesigner = new StarDesigner();
			starDesigner.setDesignerId(designer2.getDesignerId());
			starDesigner.setDesignerName(designer2.getDesigerName());
			starDesigner.setHeadPath(designer2.getHeadPath());
			Integer jobYear = designer2.getJobYear();
			Date date = new Date();
			  SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			  String dateNowStr = sdf.format(date); 
			  int i = Integer.parseInt(dateNowStr); 
			  System.out.println("格式化后的日期：" + dateNowStr);
			  System.out.println(i-jobYear);
			starDesigner.setJobYear(i-jobYear);
			starDesigner.setPosition(designer2.getPosition());
			lists.add(starDesigner);
		}
		
		return Result.ok(lists);
	}
	//根据时间排名
	@Override
	public Result getStarDesignerByTime() {
		List<Designer> designerByTime = designerMapper.getDesignerByTime();
		List<StarDesigner> lists=new ArrayList<>();
		for (Designer designer2 : designerByTime) {
			StarDesigner starDesigner = new StarDesigner();
			starDesigner.setDesignerId(designer2.getDesignerId());
			starDesigner.setDesignerName(designer2.getDesigerName());
			starDesigner.setHeadPath(designer2.getHeadPath());
			Integer jobYear = designer2.getJobYear();
			Date date = new Date();
			  SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			  String dateNowStr = sdf.format(date); 
			  int i = Integer.parseInt(dateNowStr); 
			  System.out.println("格式化后的日期：" + dateNowStr);
			  System.out.println(i-jobYear);
			starDesigner.setJobYear(i-jobYear);
			starDesigner.setPosition(designer2.getPosition());
			lists.add(starDesigner);
		}
		
		return Result.ok(lists);
	
	}

}
