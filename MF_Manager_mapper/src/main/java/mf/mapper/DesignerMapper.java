package mf.mapper;

import java.util.List;
import mf.pojo.Designer;
import mf.pojo.DesignerExample;
import mf.pojo.HotDesigner;

import org.apache.ibatis.annotations.Param;

public interface DesignerMapper {
    int countByExample(DesignerExample example);

    int deleteByExample(DesignerExample example);

    int deleteByPrimaryKey(Long designerId);

    int insert(Designer record);

    int insertSelective(Designer record);

    List<Designer> selectByExample(DesignerExample example);

    Designer selectByPrimaryKey(Long designerId);

    int updateByExampleSelective(@Param("record") Designer record, @Param("example") DesignerExample example);

    int updateByExample(@Param("record") Designer record, @Param("example") DesignerExample example);

    int updateByPrimaryKeySelective(Designer record);

    int updateByPrimaryKey(Designer record);
    //查询热门设计师
    List<Designer> getHotDesigers();
    //分页查询设计师
    List<Designer> getDesignerByPage(Integer page);
    //根据时间排名
    List<Designer> getDesignerByTime();

    
    
    
  
}