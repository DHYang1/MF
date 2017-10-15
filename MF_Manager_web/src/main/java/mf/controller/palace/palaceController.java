package mf.controller.palace;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import MF_Utils.Result;
import mf.pojo.Designer;
import mf.service.palace.PalaceService;


@Controller
public class palaceController {

	@Autowired   PalaceService palaceService;
	
	@RequestMapping("/getPalace")
    @ResponseBody
    public Result getPalace(Integer page){
		try {
			page=page-1;
			return palaceService.getPalace(page);
		} catch (Exception e) {
			Map<String,Object> map =new HashMap();
			map.put("status", 2);
			map.put("data", null);
			return Result.ok(map);

		}
		
		
	
		
		

		
	
	}
	
}
