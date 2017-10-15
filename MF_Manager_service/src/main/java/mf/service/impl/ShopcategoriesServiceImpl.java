package mf.service.impl;

import MF_Utils.Result;
import mf.mapper.CommodityMapper;
import mf.mapper.ShopcategoriesMapper;
import mf.pojo.Commodity;
import mf.pojo.CommodityExample;
import mf.pojo.Shopcategories;
import mf.pojo.ShopcategoriesExample;
import mf.service.ShopcategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShopcategoriesServiceImpl implements ShopcategoriesService{
    @Autowired
    ShopcategoriesMapper shopcategoriesMapper;
    @Autowired
    CommodityMapper commodityMapper;
    @Override
    public Result selectByExample(ShopcategoriesExample example) {
        List<Shopcategories> shopcategoriesList=shopcategoriesMapper.selectByExample(example);
        for (Shopcategories shopcategories : shopcategoriesList) {
        	CommodityExample commodityExample=new CommodityExample();
            commodityExample.or().andCategoriesIdEqualTo(shopcategories.getCategoriesId());
            List<Commodity> commoditys=commodityMapper.selectByExample(commodityExample);
            shopcategories.setCommoditys(commoditys);
		}
        return Result.ok(shopcategoriesList);
    }
}
