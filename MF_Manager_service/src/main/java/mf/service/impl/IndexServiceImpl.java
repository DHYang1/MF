package mf.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MF_Utils.Result;
import mf.mapper.AdvertisementMapper;
import mf.mapper.DesignerMapper;
import mf.mapper.DesignworkMapper;
import mf.pojo.Advertisement;
import mf.pojo.Designer;
import mf.pojo.Designwork;
import mf.pojo.DesignworkExample;
import mf.pojo.DesignworkExample.Criteria;
import mf.pojo.HotDesigerWork;
import mf.pojo.IndexWorkAd;
import mf.service.IndexService;
@Service
public class IndexServiceImpl implements IndexService {
@Autowired  DesignerMapper designerMapper;
@Autowired     AdvertisementMapper advertisementMapper;
@Autowired   DesignworkMapper  workMapper;
	@Override
	public List<Designer> getHotDesigers() {
		List<Designer> hotDesigers = designerMapper.getHotDesigers();
		System.out.println(hotDesigers);
		return hotDesigers;
	}
	@Override
	public List<HotDesigerWork> getHotDesigersWork() {
		DesignworkExample example = new   DesignworkExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo((byte)1);
		List<Designwork> selectByExample = workMapper.selectByExample(example);
	
		List<HotDesigerWork> lists =new ArrayList<>();
		if(selectByExample.size()>0){
			for (Designwork designwork : selectByExample) {
				Designer designer = designerMapper.selectByPrimaryKey(designwork.getDesignerId());
				HotDesigerWork hotDesigerWork =new HotDesigerWork();
				hotDesigerWork.setAutograph(designer.getAutograph());
				hotDesigerWork.setCoverImage(designwork.getCoverImage());
				hotDesigerWork.setDesigerName(designer.getDesigerName());
				hotDesigerWork.setHeadPath(designer.getHeadPath());
				lists.add(hotDesigerWork);
			}
	
		}
		
		return lists;
		
	}
	@Override
	public Result getAdvertisement() {
		List<Advertisement> ads = advertisementMapper.selectByExample(null);
		return Result.ok(ads);
	}
	@Override
	public List<IndexWorkAd> getadverWork(Integer page) {
		 List<Designwork> works = workMapper.selectBypage(page);
		//List<Designwork> works = workMapper.selectByExample(null);
		 List<IndexWorkAd> ads =new ArrayList<>();
		for (Designwork designwork : works) {
			Long designerId = designwork.getDesignerId();
			Designer desiger = designerMapper.selectByPrimaryKey(designerId);
			IndexWorkAd indexWorkAd = new IndexWorkAd();
			 indexWorkAd.setCoverImage(designwork.getCoverImage());
			 indexWorkAd.setDesignerId(designwork.getDesignerId());
			 indexWorkAd.setWorkId(designwork.getWorkId());
			 indexWorkAd.setDesigerName(desiger.getDesigerName());
			 indexWorkAd.setHeadImg(desiger.getHeadPath());
			 indexWorkAd.setIntroduction(designwork.getIntroduction());
			 ads.add(indexWorkAd);
		}
		return ads;
	}

	
	
}
