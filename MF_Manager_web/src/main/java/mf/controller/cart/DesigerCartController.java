package mf.controller.cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import MF_Utils.Result;
import mf.mapper.DesigerorderMapper;
import mf.pojo.CartItem;
import mf.pojo.DesigerCart;
import mf.pojo.DesigerCartOrder;
import mf.pojo.Desigerorder;
import mf.pojo.DesigerorderExample;
import mf.pojo.DesigerorderExample.Criteria;
import mf.pojo.ShopCart;
import mf.service.cart.DesigerCartService;

@Controller
public class DesigerCartController {
@Autowired   DesigerCartService  desigerCartService;
@Autowired     DesigerorderMapper 	 desigerorderMapper;
	//点击设计师 预约页面
	@RequestMapping("/desiger/cart")
    @ResponseBody
    public  Result getdesiger(long desigerId){
	try {
		//dateTime = new String(dateTime.getBytes("iso8859-1"),"utf-8");
		 Result getdesiger = desigerCartService.getdesiger(desigerId);
		 return Result.ok(getdesiger);
	} catch (Exception e) {
		e.printStackTrace();
		return Result.ok(null);
	}
	
		
	
		
	}
	
	
	
//添加设计师到购物车
	@RequestMapping("/addDesiger/cart")
    @ResponseBody
    public  Result addDesigerCart(long userId,String dateTime ,Integer num, Integer[] servicesId,long desigerId,HttpServletRequest request,HttpServletResponse response){
	
	//购物车放在session
		
	//购物车对象里面  设计师为 1 店铺为 2 
	                 	              
	// 参数  String dateTime 时间段Intger num, 项目 Integer[] servicesId,设计师long desigerId

	//店铺添加
		

		
		  try {
			  return desigerCartService.addCart(userId,dateTime, num, servicesId, desigerId, request, response);
		} catch (Exception e) {

			Map<String,Object> map =new HashMap();
			map.put("status",2);
			return Result.ok(map);
		}
		
		
		
		
		//return desigerCartService.addCart(desigerCart, shopId, serviceId, request, response);
		//return null;
	} 
	
	
	
	
	//添加店铺到购物车
	@RequestMapping("/add/shop/cart")
    @ResponseBody
    public  Result addShopCart(long userId,long shopId,long[] commodityIds,HttpServletRequest request,HttpServletResponse response){
		
		//店铺的id，long shopId,  服务的ID  商品的价格
		
		return desigerCartService.addShopCart(userId,shopId, commodityIds, request, response);
	}
	
	
	//查看购物车
	
	@RequestMapping("/get/cart")
    @ResponseBody
    public  Result getCart(long userId,HttpServletRequest request,HttpServletResponse response){	
		HttpSession session = request.getSession();
		Map<Long,Object> map10= (Map<Long, Object>) session.getAttribute("cart");
		if(map10==null){
			return Result.ok();
			
		}
		CartItem cartItem = (CartItem) map10.get(userId);
		return Result.ok(cartItem);
	}
	

	
//删除设计师
	@RequestMapping("/delete/cart/designer")
    @ResponseBody
    public  Result deleteCart(long userId,long designerId,String dateTime,Integer num,HttpServletRequest request,HttpServletResponse response){
		try {
		//删除购物车订单
			//String dateTime为时间，Integer num为时间段
			HttpSession session = request.getSession();
			Map<Long,Object> map10= (Map<Long, Object>) session.getAttribute("cart");
			if(map10!=null){
				CartItem cartItem = (CartItem) map10.get(userId);
				if(cartItem!=null){
					DesigerCart desigerCart = cartItem.getDesigerCart();
						DesigerorderExample example = new  DesigerorderExample();
						Criteria criteria = example.createCriteria();
						criteria.andDesignerIdEqualTo(designerId);
						desigerorderMapper.deleteByExample(example);
						cartItem.setDesigerCart(null);
					
	
				}

				map10.put(userId, cartItem);
				
			}
		
			session.setAttribute("cart", map10);
		
			return Result.ok(1);
		} catch (Exception e) {
			return Result.ok(2);
		}
		
	}
	
	//删除店铺
	
	@RequestMapping("/delete/cart/shop")
    @ResponseBody
    public  Result deleteShop(long userId,String shopId,HttpServletRequest request,HttpServletResponse response){
		try {
		
			HttpSession session = request.getSession();
			Map<Long,Object> map10= (Map<Long, Object>) session.getAttribute("cart");
			if(map10!=null){
				CartItem cartItem = (CartItem) map10.get(userId);
				if(cartItem!=null){
					cartItem.setShopCart(null);
						
					
	
				}

				map10.put(userId, cartItem);
				
			}
		
			session.setAttribute("cart", map10);
		
			return Result.ok(1);
		} catch (Exception e) {
			return Result.ok(2);
		}
		
	}
	
	
	
}
