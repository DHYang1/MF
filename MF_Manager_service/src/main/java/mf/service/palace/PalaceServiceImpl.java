package mf.service.palace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MF_Utils.Result;
import mf.mapper.DesignworkMapper;
import mf.mapper.PalaceMapper;
import mf.pojo.Designwork;
import mf.pojo.DesignworkExample;
import mf.pojo.DesignworkExample.Criteria;
import mf.pojo.Palace;
import mf.pojo.PalaceIndex;
import mf.pojo.PalaceWork;
@Service
public class PalaceServiceImpl implements PalaceService {

	@Autowired PalaceMapper palaceMapper;
	@Autowired    DesignworkMapper designworkMapper;
	@Override 
	public Result getPalace(Integer page) {
		List<PalaceIndex> lists =new ArrayList<>();
		List<Palace> palaceByPage = palaceMapper.getPalaceByPage(page);
		if(palaceByPage.size()>0){
			for (Palace palace : palaceByPage) {
				PalaceIndex palaceIndex = new PalaceIndex();
				palaceIndex.setPalace(palace);
			     //查詢作品
				System.out.println(palace.getPalaceId());
				DesignworkExample example = new DesignworkExample();
				Criteria criteria = example.createCriteria();
				criteria.andPalaceIdEqualTo(palace.getPalaceId());
				List<Designwork> selectByExample = designworkMapper.selectByExample(example);
				List<PalaceWork> works =new ArrayList<>();
				if(selectByExample.size()>0){
					  for (Designwork designwork : selectByExample) {
						if(designwork.getStatus()==2){
							PalaceWork palaceWork = new PalaceWork();
							palaceWork.setImgUrl(designwork.getCoverImage());
							palaceWork.setWorkId(designwork.getWorkId());
							works.add(palaceWork);
							
						}
					}
					
				}
			
				palaceIndex.setWorks(works);
				
				lists.add(palaceIndex);	
			}
			
		}
		Map<String,Object> map =new HashMap();
		map.put("status", 1);
		map.put("data", lists);
		return Result.ok(map);
	}

}
