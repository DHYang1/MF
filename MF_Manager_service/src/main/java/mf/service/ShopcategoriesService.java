package mf.service;

import MF_Utils.Result;
import mf.pojo.Shopcategories;
import mf.pojo.ShopcategoriesExample;

import java.util.List;
/**
 * ShopcategoriesService接口
 * created by 程建达 on 2017/9/11.
 */
public interface ShopcategoriesService {
    /*
    * 根据商店ID查询所有分类
    * */
    public Result selectByExample(ShopcategoriesExample example);
}
