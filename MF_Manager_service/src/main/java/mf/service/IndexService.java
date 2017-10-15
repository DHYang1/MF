package mf.service;

import java.util.List;

import MF_Utils.Result;
import mf.pojo.Designer;
import mf.pojo.Designwork;
import mf.pojo.HotDesigerWork;
import mf.pojo.IndexWorkAd;

public interface IndexService {
	List<Designer> getHotDesigers();
	List<HotDesigerWork> getHotDesigersWork();
	
	Result getAdvertisement();
	
	 List<IndexWorkAd>  getadverWork(Integer page);
}
