package mf.service.impl;

import MF_Utils.Result;
import mf.mapper.CommodityMapper;
import mf.pojo.Commodity;
import mf.pojo.CommodityExample;
import mf.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommodityServiceImpl implements CommodityService{
    @Autowired
    CommodityMapper commodityMapper;
    @Override
    public Result selectByExample(CommodityExample example) {
        List<Commodity> commodities=commodityMapper.selectByExample(example);
        return Result.ok(commodities);
    }

    @Override
    public Commodity selectByPrimaryKey(Long commodityId) {
        Commodity commodity=commodityMapper.selectByPrimaryKey(commodityId);
        return commodity;
    }
}
