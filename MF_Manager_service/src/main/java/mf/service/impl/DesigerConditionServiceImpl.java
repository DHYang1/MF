package mf.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import MF_Utils.EUDataGridResult;
import MF_Utils.Result;
import mf.mapper.DesignerMapper;
import mf.mapper.GoodaspectMapper;
import mf.pojo.Designer;
import mf.pojo.Goodaspect;
import mf.pojo.GoodaspectExample;
import mf.pojo.GoodaspectExample.Criteria;
import mf.pojo.IndexDesiger;
import mf.pojo.indexDesigerAdd;
import mf.service.DesigerConditionService;
@Service
public class DesigerConditionServiceImpl implements DesigerConditionService {

	 
	@Autowired  GoodaspectMapper goodaspectMapper;
	@Autowired   DesignerMapper  designerMapper;
	@Override
	public Result getDesigerCondition(Integer condition) {
		
		   //烫染 为1    理发2   美妆3 设计4
		if(condition==1){
			String str="烫染";
			
		 List<IndexDesiger> desigerByCondition = getDesigerByCondition(str);
		 return Result.ok(desigerByCondition);
			
		}
		if(condition==2){
			String str="理发";
			 List<IndexDesiger> desigerByCondition = getDesigerByCondition(str);
			 return Result.ok(desigerByCondition);
			
		}
		if(condition==3){
			String str="美妆";
			
			 List<IndexDesiger> desigerByCondition = getDesigerByCondition(str);
			 return Result.ok(desigerByCondition);
			
		}
		
		if(condition==4){
			String str="设计";
			
			 List<IndexDesiger> desigerByCondition = getDesigerByCondition(str);
			 return Result.ok(desigerByCondition);
			
		}
		
	
		return null;
	
	}
		

	
	public  List<IndexDesiger> getDesigerByCondition(String condition){
		GoodaspectExample example1 = new   GoodaspectExample();
		 Criteria createCriteria = example1.createCriteria();
		 createCriteria.andGoodNameEqualTo(condition);
			List<Goodaspect> selectByExample = goodaspectMapper.selectByExample(example1);	
			List<IndexDesiger>  indexDesigers =new ArrayList();
			if(!selectByExample.isEmpty()&&selectByExample.size()>0){
				  for (Goodaspect goodaspect : selectByExample) {
					  if(goodaspect.getStatus()==null){
					  Long desigerid = goodaspect.getDesigerid();
					  Designer desi = designerMapper.selectByPrimaryKey(desigerid);
					  IndexDesiger indexDesiger = new  IndexDesiger();
					  indexDesiger.setDesignerId(desi.getDesignerId());
						indexDesiger.setDesigername(desi.getDesigerName());
						indexDesiger.setImgUrl(desi.getHeadPath());
						indexDesigers.add(indexDesiger);			  
				}
				  }
				return  indexDesigers;
		
	}
			
			
			return null;
	
	}
	
	
	
	
	
	//分页查询
	@Override
	public Result getDesiger(Integer page,Integer condition){
		//烫染 为1    理发2   美妆3 设计4
		List<Designer> selectByExample=designerMapper.getDesignerByPage(page);
		List<indexDesigerAdd> lists =new ArrayList<>();
		// = designerMapper.selectByExample(null);
	//判断是哪一类的
			if(condition==1){
				for (Designer designer : selectByExample) {
				String str="烫染";	
				
				GoodaspectExample example = new  GoodaspectExample();
				Criteria criteria = example.createCriteria();
				criteria.andDesigeridEqualTo(designer.getDesignerId());
				List<Goodaspect> selectByExample2 = goodaspectMapper.selectByExample(example);
				for (Goodaspect goodaspect : selectByExample2){
					if(str.equals(goodaspect.getGoodName())){
						  indexDesigerAdd indexDesigerAdd = new  indexDesigerAdd();
						  indexDesigerAdd.setDesigerName(designer.getDesigerName());
						  indexDesigerAdd.setDesignerId(designer.getDesignerId());
						  indexDesigerAdd.setHeadPath(designer.getHeadPath());
						  indexDesigerAdd.setPosition(designer.getPosition());
						  Integer jobYear = designer.getJobYear();
							Date date = new Date();
							  SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
							  String dateNowStr = sdf.format(date); 
						  int i = Integer.parseInt(dateNowStr);	
					  indexDesigerAdd.setYears(i-jobYear+"");	
					  lists.add(indexDesigerAdd);
					}
					
					
					
				}
				
				
			}
			}
	

			//烫染 为1    理发2   美妆3 设计4
		
			if(condition==2){
				for (Designer designer : selectByExample) {
					String str="理发";
					
					GoodaspectExample example = new  GoodaspectExample();
					Criteria criteria = example.createCriteria();
					criteria.andDesigeridEqualTo(designer.getDesignerId());
					List<Goodaspect> selectByExample2 = goodaspectMapper.selectByExample(example);
					for (Goodaspect goodaspect : selectByExample2){
						if(str.equals(goodaspect.getGoodName())){
							  indexDesigerAdd indexDesigerAdd = new  indexDesigerAdd();
							  indexDesigerAdd.setDesigerName(designer.getDesigerName());
							  indexDesigerAdd.setDesignerId(designer.getDesignerId());
							  indexDesigerAdd.setHeadPath(designer.getHeadPath());
							  indexDesigerAdd.setPosition(designer.getPosition());
							  Integer jobYear = designer.getJobYear();
								Date date = new Date();
								  SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
								  String dateNowStr = sdf.format(date); 
							  int i = Integer.parseInt(dateNowStr);	
						  indexDesigerAdd.setYears(i-jobYear+"");	
						  lists.add(indexDesigerAdd);
						}
						
						
						
					}
					
					
				}
				
				
			}
			if(condition==3){
				for (Designer designer : selectByExample) {
					String str="美妆";	
					
					GoodaspectExample example = new  GoodaspectExample();
					Criteria criteria = example.createCriteria();
					criteria.andDesigeridEqualTo(designer.getDesignerId());
					List<Goodaspect> selectByExample2 = goodaspectMapper.selectByExample(example);
					for (Goodaspect goodaspect : selectByExample2){
						if(str.equals(goodaspect.getGoodName())){
							  indexDesigerAdd indexDesigerAdd = new  indexDesigerAdd();
							  indexDesigerAdd.setDesigerName(designer.getDesigerName());
							  indexDesigerAdd.setDesignerId(designer.getDesignerId());
							  indexDesigerAdd.setHeadPath(designer.getHeadPath());
							  indexDesigerAdd.setPosition(designer.getPosition());
							  Integer jobYear = designer.getJobYear();
								Date date = new Date();
								  SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
								  String dateNowStr = sdf.format(date); 
							  int i = Integer.parseInt(dateNowStr);	
						  indexDesigerAdd.setYears(i-jobYear+"");	
						  lists.add(indexDesigerAdd);
						}
						
						
						
					}
					
					
				}
				
				
				
				
				
			}
			if(condition==4){
				for (Designer designer : selectByExample) {
					String str="设计";
					
					GoodaspectExample example = new  GoodaspectExample();
					Criteria criteria = example.createCriteria();
					criteria.andDesigeridEqualTo(designer.getDesignerId());
					List<Goodaspect> selectByExample2 = goodaspectMapper.selectByExample(example);
					for (Goodaspect goodaspect : selectByExample2){
						if(str.equals(goodaspect.getGoodName())){
							  indexDesigerAdd indexDesigerAdd = new  indexDesigerAdd();
							  indexDesigerAdd.setDesigerName(designer.getDesigerName());
							  indexDesigerAdd.setDesignerId(designer.getDesignerId());
							  indexDesigerAdd.setHeadPath(designer.getHeadPath());
							  indexDesigerAdd.setPosition(designer.getPosition());
							  Integer jobYear = designer.getJobYear();
								Date date = new Date();
								  SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
								  String dateNowStr = sdf.format(date); 
							  int i = Integer.parseInt(dateNowStr);	
						  indexDesigerAdd.setYears(i-jobYear+"");	
						  lists.add(indexDesigerAdd);
						}
						
						
						
					}
					
					
				} 
				
				
				
				
			}

			  Map<String,Object> map =new HashMap();
			  map.put("status", 1);
			  map.put("data", lists);
	
			return 	 Result.ok(map);
		}
		
	/*  PageHelper.startPage(page, rows);
		//PageInfo<indexDesigerAdd> pageInfo=new PageInfo<indexDesigerAdd>(lists);
		PageInfo pageInfo=new PageInfo(lists);
		System.out.println(pageInfo.getTotal());
		EUDataGridResult result=new EUDataGridResult();
		result.setRows(lists);
		result.setTotal(pageInfo.getTotal());*/
		/*Map<String,Object> map =new HashMap();
		map.put("status", 2);
		map.put("data", null);
		return Result.ok(map);*/
	}

	//条件查询
	
/*	
	public List<indexDesigerAdd>  getDesiger(String condition,Designer designer,List<indexDesigerAdd> lists ){
		
		GoodaspectExample example = new  GoodaspectExample();
		Criteria criteria = example.createCriteria();
		criteria.andDesigeridEqualTo(designer.getDesignerId());
		List<Goodaspect> selectByExample2 = goodaspectMapper.selectByExample(example);
		for (Goodaspect goodaspect : selectByExample2) {
			if(condition.equals(goodaspect.getGoodName())){
				  indexDesigerAdd indexDesigerAdd = new  indexDesigerAdd();
				  indexDesigerAdd.setDesigerName(designer.getDesigerName());
				  indexDesigerAdd.setDesignerId(designer.getDesignerId());
				  indexDesigerAdd.setHeadPath(designer.getHeadPath());
				  indexDesigerAdd.setPosition(designer.getPosition());
				  Integer jobYear = designer.getJobYear();
					Date date = new Date();
					  SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
					  String dateNowStr = sdf.format(date); 
				  int i = Integer.parseInt(dateNowStr);	
			  indexDesigerAdd.setYears(i-jobYear+"");	
			  lists.add(indexDesigerAdd);
			}
			
			
		}
		
		
		
		return lists;
	}
 
	*/
	//
	/*public  List<indexDesigerAdd> fenYe(String condition,Designer designer){
		GoodaspectExample example1 = new   GoodaspectExample();
		 Criteria createCriteria = example1.createCriteria();
		 createCriteria.andGoodNameEqualTo(condition);
			List<Goodaspect> selectByExample = goodaspectMapper.selectByExample(example1);	
			List<indexDesigerAdd> lists =new ArrayList<>();
			if(!selectByExample.isEmpty()&&selectByExample.size()>0){
				  for (Goodaspect goodaspect : selectByExample) {
					  if(goodaspect.getStatus()==null){
						  indexDesigerAdd indexDesigerAdd = new  indexDesigerAdd();
						  indexDesigerAdd.setDesigerName(designer.getDesigerName());
						  indexDesigerAdd.setDesignerId(designer.getDesignerId());
						  indexDesigerAdd.setHeadPath(designer.getHeadPath());
						  indexDesigerAdd.setPosition(designer.getPosition());
						  Integer jobYear = designer.getJobYear();
							Date date = new Date();
							  SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
							  String dateNowStr = sdf.format(date); 
						  int i = Integer.parseInt(dateNowStr);	
					  indexDesigerAdd.setYears(i-jobYear+"");	
					  lists.add(indexDesigerAdd);			  
				}
				  }
				  return  lists;	
	}
	
	
		return null;	
	
	
	
	
	
	
}*/
