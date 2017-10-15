package mf.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MF_Utils.Result;
import mf.mapper.DesignerMapper;
import mf.mapper.DesignerParticularMapper;
import mf.mapper.LabelMapper;
import mf.mapper.SearchMapper;
import mf.mapper.ShopImageMapper;
import mf.mapper.WorkLabelMapper;
import mf.pojo.Designer;
import mf.pojo.Designwork;
import mf.pojo.Label;
import mf.pojo.SearchDesiger;
import mf.pojo.SearchDesigerWork;
import mf.pojo.SearchShop;
import mf.pojo.Shop;
import mf.pojo.ShopImage;
import mf.pojo.ShopImageExample;
import mf.pojo.ShopImageExample.Criteria;
import mf.pojo.WorkLabel;
import mf.pojo.WorkLabelExample;
import mf.service.SearchService;
@Service
public class SearchServiceImpl implements SearchService {
@Autowired  SearchMapper searchMapper;

@Autowired  ShopImageMapper  shopImageMapper;

@Autowired  WorkLabelMapper  workLabelMapper;
@Autowired   LabelMapper  labelMapper;
/*@Autowired   DesignerMapper designerMapper;*/
	@Override
	public Result search(String condition,Integer type) {
		//查询设计师  设计师头像 职位 办公司 名字 
		if(!condition.isEmpty()){
	   if(type==1){
		List<Designer> desigers = searchMapper.getDesigers(condition);
	   List<SearchDesiger> searchDesigers =new ArrayList<>();
		for (Designer designer : desigers) {
			SearchDesiger searchDesiger = new SearchDesiger();
			searchDesiger.setDesigerId(designer.getDesignerId());
			searchDesiger.setDesigerName(designer.getDesigerName());
			searchDesiger.setPosition(designer.getPosition());
			searchDesiger.setHeadPath(designer.getHeadPath());
			 Integer jobYear = designer.getJobYear();
				Date date = new Date();
				  SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
				  String dateNowStr = sdf.format(date); 
			  int i = Integer.parseInt(dateNowStr);	
			  searchDesiger.setJobYear(i-jobYear);	
			
			
			searchDesigers.add(searchDesiger);
			
		}
		Map<String,Object> map =new HashMap();
		 map.put("data", searchDesigers);
		 return Result.ok(map);
		
		}
		//查询作品
	   if(type==2){
		List<Designwork> designworks = searchMapper.getDesignworks(condition);
		  List<SearchDesigerWork> searchDesigerWorks =new ArrayList<>();
		for (Designwork designwork : designworks) {
			WorkLabelExample example = new WorkLabelExample();
			mf.pojo.WorkLabelExample.Criteria criteria = example.createCriteria();
			System.out.println(designwork.getWorkId());
			criteria.andWorkIdEqualTo(designwork.getWorkId());
			List<WorkLabel> workLabels = workLabelMapper.selectByExample(example);
			
			  SearchDesigerWork searchDesigerWork = new  SearchDesigerWork();
			  searchDesigerWork.setCover_image(designwork.getCoverImage());
			  searchDesigerWork.setDesigerWorkName(designwork.getTitle());
			  searchDesigerWork.setIntroduction(designwork.getIntroduction());
			  System.out.println(designwork.getAgeType());
			if(designwork.getAgeType()==3){
				String str="老年";
				 searchDesigerWork.setAge_type(str);
			}
			if(designwork.getAgeType()==2){
				String str="中年";
				 searchDesigerWork.setAge_type(str);
			}
			if(designwork.getAgeType()==1){
				String str="青年";
				 searchDesigerWork.setAge_type(str);
			}
		
			  StringBuilder sb = new StringBuilder();
			if(workLabels.size()>0){
				for (WorkLabel workLabel : workLabels) {
					Label lable = labelMapper.selectByPrimaryKey(workLabel.getLabelId());
					String name = lable.getName();
					sb.append(name).append(",");
				}
				
			}
			
			
			searchDesigerWork.setLabelName(sb.substring(0,sb.length()-1));
			  searchDesigerWork.setDesigerWorkId(designwork.getWorkId());
			  searchDesigerWork.setDesigerId(designwork.getDesignerId());
			  searchDesigerWorks.add(searchDesigerWork);
			
		}
		Map<String,Object> map =new HashMap();
		 map.put("data", searchDesigerWorks);
		 return Result.ok(map);
	   }
		//查询商品
	   if(type==3){
		List<Shop> shops = searchMapper.getShops(condition);
		List<SearchShop> searchShops =new ArrayList<>();
		for (Shop shop : shops) {
			SearchShop searchShop = new SearchShop();
			searchShop.setShopId(shop.getShopId());
			searchShop.setAddress(shop.getAddress());
			searchShop.setShopName(shop.getName());
		//设置店铺的头像
			ShopImageExample example = new ShopImageExample();
			Criteria criteria = example.createCriteria();
			criteria.andShopIdEqualTo(shop.getShopId());
			List<ShopImage> selectByExample = shopImageMapper.selectByExample(example);
			if(selectByExample.size()>0){
				searchShop.setShopImg(selectByExample.get(0).getImagepath());
				
			}
			
			searchShops.add(searchShop);
		}
		
		Map<String,Object> map =new HashMap();
		 map.put("data", searchShops);
		 return Result.ok(map);
		
	   }
	}
		 Map<String,Object> map =new HashMap();
		 map.put("data", null);
		
		return Result.ok(map);
	}
	
	
	
	
	
	@Override
	public Result getDesigers(String condition) {
		List<Map> lists =new ArrayList();
		//查询设计师
		List<Designer> desigers = searchMapper.getDesigers(condition);
		return Result.ok(desigers);
	}

	@Override
	public Result getDesignworks(String condition) {
		List<Designwork> designworks = searchMapper.getDesignworks(condition);
		return Result.ok(designworks);
	}

	@Override
	public Result getShops(String condition) {
		List<Shop> shops = searchMapper.getShops(condition);
		return Result.ok(shops);
	}
	
	
	
	//模糊搜索
	@Override
	public Result likeSearch(String condition,Integer type) {
		Map<String,Object> map =new HashMap();
		if(!condition.isEmpty()){
		//搜索查询 //  1 设计师2 作品3店铺
		if(type==1){
		List<Designer> desigers = searchMapper.getDesigers(condition);
		List<Map<String,String>> list1= new ArrayList<>();
		if(desigers.size()>0){
			for (Designer designer : desigers) {
				String desigerName = designer.getDesigerName();
				Map<String,String> map1=new HashMap();
				map1.put("name", desigerName);
				list1.add(map1);
			}
			
		}
		map.put("data", list1);
		return Result.ok(map);
		
		}
		//设计师作品
		if(type==2){
		List<Designwork> designworks = searchMapper.getDesignworks(condition);
		List<Map<String,String>> list2= new ArrayList<>();
		if(designworks.size()>0){
			for (Designwork designwork : designworks) {
				String title = designwork.getTitle();
				Map<String,String> map1=new HashMap();
				map1.put("name", title);
				list2.add(map1);
			}
		}
		map.put("data", list2);
		return Result.ok(map);
		}
		//店铺
		if(type==3){
		List<Shop> shops = searchMapper.getShops(condition);
		List<Map<String,String>> list3= new ArrayList<>();
		if(shops.size()>0){
			for (Shop shop : shops) {
				String name = shop.getName();
				Map<String,String> map1=new HashMap();
				map1.put("name", name);
				list3.add(map1);
				
			}
			
		}
		
		map.put("data", list3);
		return Result.ok(map);
		}
		}
		map.put("data", null);
		return Result.ok(map);
		
	}





	@Override
	public Result hotsearch(Integer type) {
		Map<String,Object> map =new HashMap();
		int count=0;
	if(type==1){
		List<Designer> desigers = searchMapper.hotSearchDesigners();
		List<Map<String,String>> list1= new ArrayList<>();
		if(desigers.size()>0){
			for (Designer designer : desigers) {
				if(count<10){
					System.out.println(count);
				String desigerName = designer.getDesigerName();
				Map<String,String> map1=new HashMap();
				map1.put("name", desigerName);
				list1.add(map1);
				count++;
				}
			}
			
		}
		map.put("data", list1);
		return Result.ok(map);
		
		
		
	}
    if(type==2){
    	List<Designwork> designworks = searchMapper.hotSearchDesignerWorks();
		List<Map<String,String>> list2= new ArrayList<>();
		if(designworks.size()>0){
			for (Designwork designwork : designworks) {
				if(count<10){
				String title = designwork.getTitle();
				Map<String,String> map1=new HashMap();
				map1.put("name", title);
				list2.add(map1);
				count++;
				}
			}
		}
		map.put("data", list2);
		return Result.ok(map);	
	}
			
   if(type==3){
		List<Shop> shops = searchMapper.hotSearchShops();
		List<Map<String,String>> list3= new ArrayList<>();
		if(shops.size()>0){
			for (Shop shop : shops) {
				if(count<10){
				String name = shop.getName();
				Map<String,String> map1=new HashMap();
				map1.put("name", name);
				list3.add(map1);
				count++;
				}
			}
			
		}
		
		map.put("data", list3);
		return Result.ok(map);
   }
	
   map.put("data", null);
	return Result.ok(map);
	}

}
