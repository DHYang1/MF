package mf.mapper;

import java.util.List;
import mf.pojo.DesigerCart;
import mf.pojo.DesigerCartExample;
import org.apache.ibatis.annotations.Param;

public interface DesigerCartMapper {
    int countByExample(DesigerCartExample example);

    int deleteByExample(DesigerCartExample example);

    int deleteByPrimaryKey(Long cartId);

    int insert(DesigerCart record);

    int insertSelective(DesigerCart record);

    List<DesigerCart> selectByExample(DesigerCartExample example);

    DesigerCart selectByPrimaryKey(Long cartId);

    int updateByExampleSelective(@Param("record") DesigerCart record, @Param("example") DesigerCartExample example);

    int updateByExample(@Param("record") DesigerCart record, @Param("example") DesigerCartExample example);

    int updateByPrimaryKeySelective(DesigerCart record);

    int updateByPrimaryKey(DesigerCart record);
}