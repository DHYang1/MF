package mf.service.impl;

import MF_Utils.Result;
import mf.mapper.PayInOrderDetailMapper;
import mf.mapper.PayInOrderMapper;
import mf.mapper.PayLogMapper;
import mf.pojo.PayInOrder;
import mf.pojo.PayInOrderDetail;
import mf.pojo.PayInOrderDetailExample;
import mf.pojo.PayInOrderExample;
import mf.pojo.PayLog;
import mf.pojo.PayLogExample;
import mf.service.PayInOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayInOrderServiceImpl implements PayInOrderService{
    @Autowired
    PayInOrderMapper payInOrderMapper;
    @Autowired
    PayInOrderDetailMapper payInOrderDetailMapper;
    @Autowired
    PayLogMapper payLogMapper;

    @Override
    public Result insertSelective(PayInOrder record) {
        payInOrderMapper.insertSelective(record);
        return Result.ok();
    }

    @Override
    public List<PayInOrder> selectByExample(PayInOrderExample example) {
        List<PayInOrder> payInOrderList=payInOrderMapper.selectByExample(example);
        for (int i = 0; i <payInOrderList.size() ; i++) {
            PayInOrder payInOrder=payInOrderList.get(i);
            PayInOrderDetailExample payInOrderDetailExample=new PayInOrderDetailExample();
            payInOrderDetailExample.or().andPayInOrderIdEqualTo(payInOrder.getPayInOrderId());
            List<PayInOrderDetail> payInOrderDetails=payInOrderDetailMapper.selectByExample(payInOrderDetailExample);
            payInOrder.setPayInOrderDetailList(payInOrderDetails);
        }
        return payInOrderList;
    }

    @Override
    public Result updateByPrimaryKeySelective(PayInOrder record) {
        payInOrderMapper.updateByPrimaryKeySelective(record);
        return Result.ok();
    }

    @Override
    public PayInOrder selectByPrimaryKey(Long payInOrderId) {
        PayInOrder payInOrder=payInOrderMapper.selectByPrimaryKey(payInOrderId);
        PayInOrderDetailExample payInOrderDetailExample=new PayInOrderDetailExample();
        payInOrderDetailExample.or().andPayInOrderIdEqualTo(payInOrder.getPayInOrderId());
        List<PayInOrderDetail> payInOrderDetails=payInOrderDetailMapper.selectByExample(payInOrderDetailExample);
        payInOrder.setPayInOrderDetailList(payInOrderDetails);
        PayLogExample payLogExample=new PayLogExample();
        payLogExample.or().andPayInOrderIdEqualTo(payInOrderId);
        List<PayLog> payLogs=payLogMapper.selectByExample(payLogExample);
        
        payInOrder.setPayLogs(payLogs);
        return payInOrder;
    }
}
