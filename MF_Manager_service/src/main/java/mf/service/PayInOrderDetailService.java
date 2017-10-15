package mf.service;

import MF_Utils.Result;
import mf.pojo.PayInOrderDetail;
import mf.pojo.PayInOrderDetailExample;

public interface PayInOrderDetailService {
    /**
     * 新增订单条目
     * @param record
     * @return
     */
    public Result insertSelective(PayInOrderDetail record);

    /**
     * 根据条件查询订单条目
     * @param example
     * @return
     */
    public Result selectByExample(PayInOrderDetailExample example);
}
