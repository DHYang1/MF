package mf.mapper;

import java.util.List;
import mf.pojo.PayOutOrderDetail;
import mf.pojo.PayOutOrderDetailExample;
import org.apache.ibatis.annotations.Param;

public interface PayOutOrderDetailMapper {
    int countByExample(PayOutOrderDetailExample example);

    int deleteByExample(PayOutOrderDetailExample example);

    int deleteByPrimaryKey(Long payOutOrderDetailId);

    int insert(PayOutOrderDetail record);

    int insertSelective(PayOutOrderDetail record);

    List<PayOutOrderDetail> selectByExample(PayOutOrderDetailExample example);

    PayOutOrderDetail selectByPrimaryKey(Long payOutOrderDetailId);

    int updateByExampleSelective(@Param("record") PayOutOrderDetail record, @Param("example") PayOutOrderDetailExample example);

    int updateByExample(@Param("record") PayOutOrderDetail record, @Param("example") PayOutOrderDetailExample example);

    int updateByPrimaryKeySelective(PayOutOrderDetail record);

    int updateByPrimaryKey(PayOutOrderDetail record);
}