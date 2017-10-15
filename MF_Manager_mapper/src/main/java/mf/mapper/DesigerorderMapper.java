package mf.mapper;

import java.util.List;
import mf.pojo.Desigerorder;
import mf.pojo.DesigerorderExample;
import org.apache.ibatis.annotations.Param;

public interface DesigerorderMapper {
    int countByExample(DesigerorderExample example);

    int deleteByExample(DesigerorderExample example);

    int deleteByPrimaryKey(Long cartId);

    int insert(Desigerorder record);

    int insertSelective(Desigerorder record);

    List<Desigerorder> selectByExample(DesigerorderExample example);

    Desigerorder selectByPrimaryKey(Long cartId);

    int updateByExampleSelective(@Param("record") Desigerorder record, @Param("example") DesigerorderExample example);

    int updateByExample(@Param("record") Desigerorder record, @Param("example") DesigerorderExample example);

    int updateByPrimaryKeySelective(Desigerorder record);

    int updateByPrimaryKey(Desigerorder record);
}