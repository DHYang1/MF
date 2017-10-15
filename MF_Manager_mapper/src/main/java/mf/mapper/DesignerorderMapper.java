package mf.mapper;

import java.util.List;
import mf.pojo.Designerorder;
import mf.pojo.DesignerorderExample;
import org.apache.ibatis.annotations.Param;

public interface DesignerorderMapper {
    int countByExample(DesignerorderExample example);

    int deleteByExample(DesignerorderExample example);

    int deleteByPrimaryKey(Long yuid);

    int insert(Designerorder record);

    int insertSelective(Designerorder record);

    List<Designerorder> selectByExample(DesignerorderExample example);

    Designerorder selectByPrimaryKey(Long yuid);

    int updateByExampleSelective(@Param("record") Designerorder record, @Param("example") DesignerorderExample example);

    int updateByExample(@Param("record") Designerorder record, @Param("example") DesignerorderExample example);

    int updateByPrimaryKeySelective(Designerorder record);

    int updateByPrimaryKey(Designerorder record);
}