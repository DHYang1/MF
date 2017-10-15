package mf.mapper;

import java.util.List;
import mf.pojo.PayInOrder;
import mf.pojo.PayInOrderExample;
import org.apache.ibatis.annotations.Param;

public interface PayInOrderMapper {
    int countByExample(PayInOrderExample example);

    int deleteByExample(PayInOrderExample example);

    int deleteByPrimaryKey(Long payInOrderId);

    int insert(PayInOrder record);

    int insertSelective(PayInOrder record);

    List<PayInOrder> selectByExample(PayInOrderExample example);

    PayInOrder selectByPrimaryKey(Long payInOrderId);

    int updateByExampleSelective(@Param("record") PayInOrder record, @Param("example") PayInOrderExample example);

    int updateByExample(@Param("record") PayInOrder record, @Param("example") PayInOrderExample example);

    int updateByPrimaryKeySelective(PayInOrder record);

    int updateByPrimaryKey(PayInOrder record);
}