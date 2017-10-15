package mf.service.impl;

import MF_Utils.Result;
import mf.mapper.PayInOrderDetailMapper;
import mf.pojo.PayInOrderDetail;
import mf.pojo.PayInOrderDetailExample;
import mf.service.PayInOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayInOrderDetailServiceImpl implements PayInOrderDetailService{
    @Autowired
    PayInOrderDetailMapper payInOrderDetailMapper;
    @Override
    public Result insertSelective(PayInOrderDetail record) {
        payInOrderDetailMapper.insertSelective(record);
        return Result.ok();
    }

    @Override
    public Result selectByExample(PayInOrderDetailExample example) {
        List<PayInOrderDetail> payInOrderDetailList=payInOrderDetailMapper.selectByExample(example);
        return Result.ok(payInOrderDetailList);
    }
}
