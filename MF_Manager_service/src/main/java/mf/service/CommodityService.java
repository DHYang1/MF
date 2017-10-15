package mf.service;

import MF_Utils.Result;
import mf.pojo.Commodity;
import mf.pojo.CommodityExample;

import java.util.List;
/**
 * CommodityService接口
 * created by 程建达 on 2017/9/11.
 */
public interface CommodityService {
    /**
     * 查询该分类下所有的商品
     */
    public Result selectByExample(CommodityExample example);

    /**
     * 根据ID查询商品
     * @param commodityId
     * @return
     */
    public Commodity selectByPrimaryKey(Long commodityId);
}
