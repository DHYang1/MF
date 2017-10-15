package mf.service.impl;

import MF_Utils.Result;
import mf.mapper.ShopImageMapper;
import mf.mapper.ShopMapper;
import mf.pojo.Shop;
import mf.pojo.ShopExample;
import mf.pojo.ShopImage;
import mf.pojo.ShopImageExample;
import mf.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ShopServiceImpl implements ShopService{
    @Autowired
    ShopMapper shopMapper;
    @Autowired
    ShopImageMapper shopImageMapper;
    @Override
    public Result selectByPrimaryKey(Long shopId) {
    	ShopImageExample shopImageExample=new ShopImageExample();
    	shopImageExample.or().andShopIdEqualTo(shopId);
    	List<ShopImage> images=shopImageMapper.selectByExample(shopImageExample);
        Shop shop = shopMapper.selectByPrimaryKey(shopId);
        shop.setImages(images);
        return Result.ok(shop);
    }

    @Override
    public Result selectByExample(ShopExample example) {
        List<Shop> shops=shopMapper.selectByExample(example);
        return Result.ok(shops);
    }

    @Override
    public List<Shop> selectAll(ShopExample example) {
        List<Shop> shops=shopMapper.selectByExample(example);
        return shops;
    }
}
