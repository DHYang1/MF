package mf.mapper;

import java.util.List;

import mf.pojo.Designer;
import mf.pojo.Designwork;
import mf.pojo.DesignworkExample;
import org.apache.ibatis.annotations.Param;

public interface DesignworkMapper {
    int countByExample(DesignworkExample example);

    int deleteByExample(DesignworkExample example);

    int deleteByPrimaryKey(Long workId);

    int insert(Designwork record);

    int insertSelective(Designwork record);

    List<Designwork> selectByExample(DesignworkExample example);

    Designwork selectByPrimaryKey(Long workId);

    int updateByExampleSelective(@Param("record") Designwork record, @Param("example") DesignworkExample example);

    int updateByExample(@Param("record") Designwork record, @Param("example") DesignworkExample example);

    int updateByPrimaryKeySelective(Designwork record);

    int updateByPrimaryKey(Designwork record);
    
  
    List<Designer> getDesignerByPage(Integer  page);
    
    //查询殿堂设计师作品
    List<Designwork> selectByPalaceId(long palaceId);
    //分页查询作品
    List<Designwork> selectBypage(Integer page);
    //模糊查询
    List<Designwork> selectBycondition(String condition);
    //分页根据设计师查询作品
    List<Designwork> selectBypageDesigner(Integer page,long designerId);
    
    
    
}