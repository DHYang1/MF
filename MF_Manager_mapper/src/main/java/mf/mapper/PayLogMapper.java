package mf.mapper;

import java.util.List;
import mf.pojo.PayLog;
import mf.pojo.PayLogExample;
import org.apache.ibatis.annotations.Param;

public interface PayLogMapper {
    int countByExample(PayLogExample example);

    int deleteByExample(PayLogExample example);

    int deleteByPrimaryKey(Long logId);

    int insert(PayLog record);

    int insertSelective(PayLog record);

    List<PayLog> selectByExample(PayLogExample example);

    PayLog selectByPrimaryKey(Long logId);

    int updateByExampleSelective(@Param("record") PayLog record, @Param("example") PayLogExample example);

    int updateByExample(@Param("record") PayLog record, @Param("example") PayLogExample example);

    int updateByPrimaryKeySelective(PayLog record);

    int updateByPrimaryKey(PayLog record);
}