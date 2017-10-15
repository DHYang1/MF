package mf.mapper;

import java.util.List;
import mf.pojo.WorksList;
import mf.pojo.WorksListExample;
import org.apache.ibatis.annotations.Param;

public interface WorksListMapper {
    int countByExample(WorksListExample example);

    int deleteByExample(WorksListExample example);

    int deleteByPrimaryKey(Long worksId);

    int insert(WorksList record);

    int insertSelective(WorksList record);

    List<WorksList> selectByExample(WorksListExample example);

    WorksList selectByPrimaryKey(Long worksId);

    int updateByExampleSelective(@Param("record") WorksList record, @Param("example") WorksListExample example);

    int updateByExample(@Param("record") WorksList record, @Param("example") WorksListExample example);

    int updateByPrimaryKeySelective(WorksList record);

    int updateByPrimaryKey(WorksList record);
}