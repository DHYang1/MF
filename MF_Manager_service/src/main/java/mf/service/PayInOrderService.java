package mf.service;

import java.util.List;

import MF_Utils.Result;
import mf.pojo.PayInOrder;
import mf.pojo.PayInOrderExample;

public interface PayInOrderService {
    /**
     * 新增订单
     * @param record
     * @return
     */
    public Result insertSelective(PayInOrder record);

    /**
     * 根据条件查询订单
     * @param example
     * @return
     */
    public List<PayInOrder> selectByExample(PayInOrderExample example);

    /**
     * 修改订单状态
     * @param record
     * @return
     */
    public Result updateByPrimaryKeySelective(PayInOrder record);

    public PayInOrder selectByPrimaryKey(Long payInOrderId);
}
