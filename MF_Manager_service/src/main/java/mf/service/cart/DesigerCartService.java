package mf.service.cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MF_Utils.Result;
import mf.pojo.DesigerCart;
import mf.pojo.DesigerCartOrder;

public interface DesigerCartService {
	public  Result getdesiger(long desigerId);
	  public  Result addCart(long userId,String dateTime ,Integer num,Integer[] servicesId ,long desigerId,HttpServletRequest request,HttpServletResponse response);
	  public  Result addShopCart(long userId,long shopId,long[] commodityIds,HttpServletRequest request,HttpServletResponse response);
	  
}
