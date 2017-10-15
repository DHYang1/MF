package mf.mapper;

import java.util.List;
import mf.pojo.DesignerCertification;
import mf.pojo.DesignerCertificationExample;
import org.apache.ibatis.annotations.Param;

public interface DesignerCertificationMapper {
    int countByExample(DesignerCertificationExample example);

    int deleteByExample(DesignerCertificationExample example);

    int insert(DesignerCertification record);

    int insertSelective(DesignerCertification record);

    List<DesignerCertification> selectByExample(DesignerCertificationExample example);

    int updateByExampleSelective(@Param("record") DesignerCertification record, @Param("example") DesignerCertificationExample example);

    int updateByExample(@Param("record") DesignerCertification record, @Param("example") DesignerCertificationExample example);
}