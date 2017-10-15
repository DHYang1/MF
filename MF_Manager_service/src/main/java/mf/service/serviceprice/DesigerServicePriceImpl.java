package mf.service.serviceprice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MF_Utils.Result;
import mf.mapper.DesignerMapper;
import mf.mapper.GoodaspectMapper;
import mf.pojo.Designer;
import mf.pojo.DesignerExample;
import mf.pojo.Goodaspect;
import mf.pojo.GoodaspectExample;
import mf.pojo.GoodaspectExample.Criteria;

@Service
public class DesigerServicePriceImpl implements DesigerServicePrice {
@Autowired     GoodaspectMapper  spectMapper;
@Autowired     DesignerMapper     designerMapper;
	

    //返回设计师的服务价格
	@Override
	public Result getDesigerPrice(long desigerId) {
		
		Designer designer = designerMapper.selectByPrimaryKey(desigerId);
		List<Map<String,Object>> lists=new ArrayList<>();
		 
		Map<String,Object> map = new HashMap();
		map.put("id",1);
		map.put("price", designer.getHaircut());
		
		Map<String,Object> map1 = new HashMap();
		map1.put("id",2);
		map1.put("price",designer.getHotDyed());
		Map<String,Object> map2= new HashMap();

	
		map2.put("id",3);
		map2.put("price",designer.getMakeups());
		
		lists.add(map);
		lists.add(map1);
		lists.add(map2);
	/*	map.put(1,designer.getHaircut());  // 1  haircut
		map.put(2,designer.getHotDyed());   //2  HotDyeds
		map.put(3, designer.getMakeups());  //3    makeups
*/		
		
		return   Result.ok(lists);
		
		
		
		
		
		
		/* List<Map<String, Object>> list =new ArrayList();
		GoodaspectExample example = new GoodaspectExample();
		Criteria criteria = example.createCriteria();
		criteria.andDesigeridEqualTo(desigerId);
		List<Goodaspect> selectByExample = spectMapper.selectByExample(example);
		for (Goodaspect goodaspect : selectByExample) {
			Map<String,Object> map = new HashMap();
			map.put("name",goodaspect.getGoodName());
			map.put("price", goodaspect.getGoodPrice());
			list.add(map);	
		}
	
	
		return list;*/
	}


	@Override
	public Result updateDesigerPrice(long desigerId,int id,double price) {
	
		Designer desiger = designerMapper.selectByPrimaryKey(desigerId);
		
		
		
		if(id==1){
			desiger.setHaircut(price);
			designerMapper.updateByPrimaryKeySelective(desiger);
			return Result.ok(1);
			
		}
		if(id==2){
			desiger.setHotDyed(price);
			designerMapper.updateByPrimaryKeySelective(desiger);
			return Result.ok(1);
			
		}
		if(id==3){
			desiger.setMakeups(price);
			designerMapper.updateByPrimaryKeySelective(desiger);
			return Result.ok(1);
			
		}
		
		
		
		
		
		/*GoodaspectExample example = new GoodaspectExample();
		Criteria criteria = example.createCriteria();
		criteria.andGoodIdEqualTo(goodId);
		
		List<Goodaspect> goodaspect = spectMapper.selectByExample(example);
		if(goodaspect.size()>0){
			Goodaspect goodaspect2 = goodaspect.get(0);
			goodaspect2.setGoodPrice(price);
			spectMapper.updateByExampleSelective(goodaspect2, null);
			 return  Result.ok(1);
			
		}
		*/
		
		
		 return Result.ok(2);
	}

	
	
	
	
}
