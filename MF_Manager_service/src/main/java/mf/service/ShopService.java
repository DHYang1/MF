package mf.service;

import MF_Utils.Result;
import mf.pojo.Shop;
import mf.pojo.ShopExample;

import java.util.List;
/**
 * ShopService接口
 * created by 程建达 on 2017/9/11.
 */
public interface ShopService {
    /**
     * 查询商店信息
     */
    public Result selectByPrimaryKey(Long shopId);
    /**
     * 根据条件查询符合条件的所有店铺
     */
    public Result selectByExample(ShopExample example);
    /**
     * 根据条件查询所有店铺
     */
    public List<Shop> selectAll(ShopExample example);
}
