package mf.mapper;

import java.util.List;

import mf.pojo.Designer;
import mf.pojo.Palace;
import mf.pojo.PalaceExample;
import org.apache.ibatis.annotations.Param;

public interface PalaceMapper {
    int countByExample(PalaceExample example);

    int deleteByExample(PalaceExample example);

    int insert(Palace record);

    int insertSelective(Palace record);

    List<Palace> selectByExample(PalaceExample example);

    int updateByExampleSelective(@Param("record") Palace record, @Param("example") PalaceExample example);

    int updateByExample(@Param("record") Palace record, @Param("example") PalaceExample example);
    //分页查询殿堂级设计师
    
    List<Palace> getPalaceByPage(Integer page);
}