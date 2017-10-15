package mf.mapper;

import java.util.List;
import mf.pojo.Goodaspect;
import mf.pojo.GoodaspectExample;
import org.apache.ibatis.annotations.Param;

public interface GoodaspectMapper {
    int countByExample(GoodaspectExample example);

    int deleteByExample(GoodaspectExample example);

    int insert(Goodaspect record);

    int insertSelective(Goodaspect record);

    List<Goodaspect> selectByExample(GoodaspectExample example);

    int updateByExampleSelective(@Param("record") Goodaspect record, @Param("example") GoodaspectExample example);

    int updateByExample(@Param("record") Goodaspect record, @Param("example") GoodaspectExample example);
    
 
}