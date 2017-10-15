package mf.mapper;

import java.util.List;
import mf.pojo.RegistrationProtocol;
import mf.pojo.RegistrationProtocolExample;
import org.apache.ibatis.annotations.Param;

public interface RegistrationProtocolMapper {
    int countByExample(RegistrationProtocolExample example);

    int deleteByExample(RegistrationProtocolExample example);

    int deleteByPrimaryKey(Integer registerId);

    int insert(RegistrationProtocol record);

    int insertSelective(RegistrationProtocol record);

    List<RegistrationProtocol> selectByExampleWithBLOBs(RegistrationProtocolExample example);

    List<RegistrationProtocol> selectByExample(RegistrationProtocolExample example);

    RegistrationProtocol selectByPrimaryKey(Integer registerId);

    int updateByExampleSelective(@Param("record") RegistrationProtocol record, @Param("example") RegistrationProtocolExample example);

    int updateByExampleWithBLOBs(@Param("record") RegistrationProtocol record, @Param("example") RegistrationProtocolExample example);

    int updateByExample(@Param("record") RegistrationProtocol record, @Param("example") RegistrationProtocolExample example);

    int updateByPrimaryKeySelective(RegistrationProtocol record);

    int updateByPrimaryKeyWithBLOBs(RegistrationProtocol record);

    int updateByPrimaryKey(RegistrationProtocol record);
}