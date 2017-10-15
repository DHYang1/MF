package mf.service.wx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mf.mapper.PayInOrderDetailMapper;
import mf.mapper.PayInOrderMapper;
import mf.pojo.PayInOrder;

@Service
public class GoodsTradeServiceImpl implements GoodsTradeService {
	@Autowired PayInOrderDetailMapper detailMapper;
	@Autowired PayInOrderMapper payInOrderMapper;
	@Override
	public GoodsTrade queryGoodsTradeById(String tradeId) {
		long tradeId1= new Long(tradeId);
		  GoodsTrade goodsTrade = new GoodsTrade();
		  PayInOrder order = payInOrderMapper.selectByPrimaryKey(tradeId1);
		   
		return null;
	}

}
