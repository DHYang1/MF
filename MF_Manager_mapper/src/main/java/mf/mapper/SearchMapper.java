package mf.mapper;

import java.util.List;

import mf.pojo.Designer;
import mf.pojo.Designwork;
import mf.pojo.Shop;

public interface SearchMapper {

	public List<Designer> getDesigers(String condition);
	public List<Designwork> getDesignworks(String condition);
	public List<Shop> getShops(String condition);
	 //List<Designer> getDesignerByLike(String condition);
	//热门搜索
	 public  List<Designer> hotSearchDesigners();
	 public  List<Designwork> hotSearchDesignerWorks();
	 public  List<Shop> hotSearchShops();
	 
 
}
