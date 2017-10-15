package mf.mapper;

import java.util.List;
import mf.pojo.DesignerParticular;
import mf.pojo.DesignerParticularExample;
import org.apache.ibatis.annotations.Param;

public interface DesignerParticularMapper {
    int countByExample(DesignerParticularExample example);

    int deleteByExample(DesignerParticularExample example);

    int deleteByPrimaryKey(Long designerId);

    int insert(DesignerParticular record);

    int insertSelective(DesignerParticular record);

    List<DesignerParticular> selectByExample(DesignerParticularExample example);

    DesignerParticular selectByPrimaryKey(Long designerId);

    int updateByExampleSelective(@Param("record") DesignerParticular record, @Param("example") DesignerParticularExample example);

    int updateByExample(@Param("record") DesignerParticular record, @Param("example") DesignerParticularExample example);

    int updateByPrimaryKeySelective(DesignerParticular record);

    int updateByPrimaryKey(DesignerParticular record);
}