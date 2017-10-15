package mf.controller;
import MF_Utils.Result;
import mf.pojo.*;
import mf.service.ShopService;
import mf.service.ShopcategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class ShopController {
    @Autowired
    ShopService shopService;
    @Autowired
    ShopcategoriesService shopcategoriesService;

    /**
     * 根据商店ID查询店铺详情
     * @param shop_id
     * @return
     */
    @RequestMapping("/shop/select")
    @ResponseBody
    public Result select(long shop_id){
        Result result=shopService.selectByPrimaryKey(shop_id);
        return result;
    }

    /**
     * 查询符合条件的商店
     * @param shop
     * @return
     */
    @RequestMapping("/shop/list")
    @ResponseBody
    public String list(Shop shop){
        ShopExample shopExample=new ShopExample();
        return null;
    }

    /**
     * 根据商店ID查询分类
     * @param shop_id
     * @return
     */
    @RequestMapping("/shop/category")
    @ResponseBody
    public Result category(long shop_id){
        ShopcategoriesExample shopcategoriesExample=new ShopcategoriesExample();
        shopcategoriesExample.or().andShopIdEqualTo(shop_id);
        Result result=shopcategoriesService.selectByExample(shopcategoriesExample);
        return result;
    }
}
