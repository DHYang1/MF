package mf.service;

import MF_Utils.Result;

public interface SearchService {
	 public Result search(String condition,Integer type);
	 public Result likeSearch(String condition,Integer type);
	 public Result getDesigers(String condition);
		public Result getDesignworks(String condition);
		public Result getShops(String condition);
		//热门搜索
		 public Result hotsearch(Integer type);
}
