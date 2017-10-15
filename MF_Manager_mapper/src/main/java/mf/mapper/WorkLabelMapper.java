package mf.mapper;

import java.util.List;
import mf.pojo.WorkLabel;
import mf.pojo.WorkLabelExample;
import org.apache.ibatis.annotations.Param;

public interface WorkLabelMapper {
    int countByExample(WorkLabelExample example);

    int deleteByExample(WorkLabelExample example);

    int deleteByPrimaryKey(Long workLabelId);

    int insert(WorkLabel record);

    int insertSelective(WorkLabel record);

    List<WorkLabel> selectByExample(WorkLabelExample example);

    WorkLabel selectByPrimaryKey(Long workLabelId);

    int updateByExampleSelective(@Param("record") WorkLabel record, @Param("example") WorkLabelExample example);

    int updateByExample(@Param("record") WorkLabel record, @Param("example") WorkLabelExample example);

    int updateByPrimaryKeySelective(WorkLabel record);

    int updateByPrimaryKey(WorkLabel record);
}