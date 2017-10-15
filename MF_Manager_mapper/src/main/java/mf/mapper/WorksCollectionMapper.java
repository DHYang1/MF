package mf.mapper;

import java.util.List;
import mf.pojo.WorksCollection;
import mf.pojo.WorksCollectionExample;
import org.apache.ibatis.annotations.Param;

public interface WorksCollectionMapper {
    int countByExample(WorksCollectionExample example);

    int deleteByExample(WorksCollectionExample example);

    int deleteByPrimaryKey(Long worksCollectionId);

    int insert(WorksCollection record);

    int insertSelective(WorksCollection record);

    List<WorksCollection> selectByExample(WorksCollectionExample example);

    WorksCollection selectByPrimaryKey(Long worksCollectionId);

    int updateByExampleSelective(@Param("record") WorksCollection record, @Param("example") WorksCollectionExample example);

    int updateByExample(@Param("record") WorksCollection record, @Param("example") WorksCollectionExample example);

    int updateByPrimaryKeySelective(WorksCollection record);

    int updateByPrimaryKey(WorksCollection record);
}