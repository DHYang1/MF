package mf.mapper;

import java.util.List;
import mf.pojo.PayOutOrder;
import mf.pojo.PayOutOrderExample;
import org.apache.ibatis.annotations.Param;

public interface PayOutOrderMapper {
    int countByExample(PayOutOrderExample example);

    int deleteByExample(PayOutOrderExample example);

    int deleteByPrimaryKey(Long payOutOrderId);

    int insert(PayOutOrder record);

    int insertSelective(PayOutOrder record);

    List<PayOutOrder> selectByExample(PayOutOrderExample example);

    PayOutOrder selectByPrimaryKey(Long payOutOrderId);

    int updateByExampleSelective(@Param("record") PayOutOrder record, @Param("example") PayOutOrderExample example);

    int updateByExample(@Param("record") PayOutOrder record, @Param("example") PayOutOrderExample example);

    int updateByPrimaryKeySelective(PayOutOrder record);

    int updateByPrimaryKey(PayOutOrder record);
}