package mf.mapper;

import java.util.List;
import mf.pojo.PayInOrderDetail;
import mf.pojo.PayInOrderDetailExample;
import org.apache.ibatis.annotations.Param;

public interface PayInOrderDetailMapper {
    int countByExample(PayInOrderDetailExample example);

    int deleteByExample(PayInOrderDetailExample example);

    int deleteByPrimaryKey(Long payInOrderDetailId);

    int insert(PayInOrderDetail record);

    int insertSelective(PayInOrderDetail record);

    List<PayInOrderDetail> selectByExample(PayInOrderDetailExample example);

    PayInOrderDetail selectByPrimaryKey(Long payInOrderDetailId);

    int updateByExampleSelective(@Param("record") PayInOrderDetail record, @Param("example") PayInOrderDetailExample example);

    int updateByExample(@Param("record") PayInOrderDetail record, @Param("example") PayInOrderDetailExample example);

    int updateByPrimaryKeySelective(PayInOrderDetail record);

    int updateByPrimaryKey(PayInOrderDetail record);
}