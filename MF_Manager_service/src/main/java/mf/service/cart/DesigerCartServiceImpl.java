package mf.service.cart;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.ctc.wstx.util.StringUtil;

import MF_Utils.IDUtils;
import MF_Utils.Result;
import mf.mapper.CommodityMapper;
import mf.mapper.DesignerMapper;
import mf.mapper.DesignerorderMapper;
import mf.mapper.GoodaspectMapper;
import mf.mapper.ShopImageMapper;
import mf.mapper.ShopMapper;
import mf.pojo.CartItem;
import mf.pojo.Commodity;
import mf.pojo.DesigerCart;
import mf.pojo.DesigerCartOrder;
import mf.pojo.Designer;
import mf.pojo.Designerorder;
import mf.pojo.DesignerorderExample;
import mf.pojo.Goodaspect;
import mf.pojo.GoodaspectExample;
import mf.pojo.GoodaspectExample.Criteria;
import mf.pojo.Shop;
import mf.pojo.ShopCart;
import mf.pojo.ShopImage;
import mf.pojo.ShopImageExample;
@Service
public class DesigerCartServiceImpl implements DesigerCartService {
@Autowired   DesignerMapper  designerMapper;
@Autowired   GoodaspectMapper  goodaspectMapper;
@Autowired   CommodityMapper  commodityMapper;
	
@Autowired    DesignerorderMapper designerorderMapper;

@Autowired   ShopMapper  shopMapper;
 
@Autowired    ShopImageMapper shopImageMapper;
 


      

//获取时间
public static String getFetureDate(int past) {  
       Calendar calendar = Calendar.getInstance();  
       calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);  
       Date today = calendar.getTime();  
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
       String result = format.format(today);  
      // Log.e(null, result);  
       return result;  
   }  




	//预约设计师
	@Override
	public Result getdesiger(long desigerId) {
		//,String dateTime
		//String[] dateTime1 = dateTime.split(",");
		  Map<String,Object> retMap =new HashMap();
		  List<Map<String,Object>> datelist=new ArrayList<>();
		    List<String> dateTime =new ArrayList();
		    Date date = new Date();
			SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd");
			String   dayNow=sf2.format(date);
			String fetureDate0 = getFetureDate(0);
			String fetureDate1 = getFetureDate(1);
			System.out.println(fetureDate1);
			String fetureDate2 = getFetureDate(2);
			System.out.println(fetureDate2);
			String fetureDate3 = getFetureDate(3);
			String fetureDate4 = getFetureDate(4);
			String fetureDate5 = getFetureDate(5);
			String fetureDate6 = getFetureDate(6);
			System.out.println(fetureDate0);
			dateTime.add(fetureDate0);
			dateTime.add(fetureDate1);
			dateTime.add(fetureDate2);
			dateTime.add(fetureDate3);
			dateTime.add(fetureDate4);
			dateTime.add(fetureDate5);
			dateTime.add(fetureDate6);
			
	  
	     //返回时间是否被选中
		if(dateTime!=null){
			//获取当前时间 以及未来
			for (String string : dateTime) {	
				Map<String,Object> map =new HashMap();
 	      DesignerorderExample example = new DesignerorderExample();
 	     mf.pojo.DesignerorderExample.Criteria criteria = example.createCriteria();
 	  criteria.andDateTimeEqualTo(string);
 	     List<Designerorder> selectByExample = designerorderMapper.selectByExample(example);
 	 
 	    Integer[] ints =new Integer[3];
 	  if(selectByExample.size()>0){
 		//Designerorder designerorder = selectByExample.get(0);
 		//循环
 			int i1=0;
 	   for (Designerorder designerorder : selectByExample) {
		
			System.out.println(i1);
 		  String timeQuantum = designerorder.getTimeQuantum();
 		  if(!StringUtils.isEmpty(timeQuantum)){
 			 Integer int1=new Integer(timeQuantum);
 			ints[i1]=int1; 
 			  i1++;
 			  
 		  }
   
 			}
 
 	  }
 	
 	  map.put("periodtime;",ints);
 	 map.put("time", string);
 	datelist.add(map); 
 	 }
			
		}
 	     //添加时间
		retMap.put("timelist", datelist);
		
		
 	 //返回设计师服务价格
 	   
 	//  1  haircut   2  HotDyeds  3  makeups
 	   
 		Designer designer = designerMapper.selectByPrimaryKey(desigerId);
		List<Map<String,Object>> lists=new ArrayList<>();
		 
		Map<String,Object> map = new HashMap();
		map.put("id",1);
		map.put("price", designer.getHaircut());
		
		Map<String,Object> map1 = new HashMap();
		map1.put("id",2);
		map1.put("price",designer.getHotDyed());
		Map<String,Object> map2= new HashMap();

	
		map2.put("id",3);
		map2.put("price",designer.getMakeups());
		
		lists.add(map);
		lists.add(map1);
		lists.add(map2);
	//获取设计师头像和名字

		 retMap.put("status", 1);
		
		 retMap.put("serviceprice", lists);
		 retMap.put("headImg", designer.getHeadPath());
		 retMap.put("desiName", designer.getDesigerName());
		 
		 
		 return Result.ok(retMap);
		 
	
		
	

	
}
	
	
	
	
	
	//预约设计师的时间
	
	
	
	
//添加到购物车
	@Override
	  public  Result addCart(long userId,String dateTime ,Integer num,Integer[] servicesId,long desigerId,HttpServletRequest request,HttpServletResponse response){
		
		HttpSession session = request.getSession();
		//取出用户的购物车
		Map<Long,Object> map10 =(Map<Long, Object>) session.getAttribute("cart");
		if(map10!=null){
		CartItem cartItem = (CartItem) map10.get(userId);
		//判断有无购物车
		//Object attribute = session.getAttribute("cart");
		//CartItem cartItem= (CartItem) attribute;
		if(cartItem!=null){
			//购物车里面是否有设计师
			 if(cartItem.getDesigerCart()!=null){
				 //返回3为不能再添加设计师
				 return Result.ok(3);
				 
			 }
			 
			 Designer designer = designerMapper.selectByPrimaryKey(desigerId);
				DesigerCart desigerCart = new DesigerCart();
				desigerCart.setDesignerId(desigerId);//id
				desigerCart.setDesigerImg(designer.getHeadPath());//头像
				desigerCart.setDesigerName(designer.getDesigerName());//名字
				desigerCart.setPeriodtime(num);//时间段
				desigerCart.setDateTime(dateTime);//时间
				List<Map<String, Object>> lists = new ArrayList<>();
				
			

				for (Integer integer : servicesId) {
					if (integer == 1) {
						String str = "剪发";
						GoodaspectExample example = new GoodaspectExample();
						Criteria criteria = example.createCriteria();
						criteria.andDesigeridEqualTo(desigerId);
						List<Goodaspect> selectByExample = goodaspectMapper.selectByExample(example);
						if (selectByExample.size() > 0) {
							for (Goodaspect goodaspect : selectByExample) {
								if (str.equals(goodaspect.getGoodName())) {
									Map<String, Object> map = new HashMap();
									map.put("serviceId", 1);
									map.put("price", goodaspect.getGoodPrice());
									lists.add(map);
								}

							}

						}
						
					
						
						
						
						
					}
					if (integer == 2) {
						String str = "烫染";
						GoodaspectExample example = new GoodaspectExample();
						Criteria criteria = example.createCriteria();
						criteria.andDesigeridEqualTo(desigerId);
						List<Goodaspect> selectByExample = goodaspectMapper.selectByExample(example);
						if (selectByExample.size() > 0) {
							for (Goodaspect goodaspect : selectByExample) {
								if (str.equals(goodaspect.getGoodName())) {
									Map<String, Object> map1 = new HashMap();
									map1.put("serviceId", 2);
									map1.put("price", goodaspect.getGoodPrice());
									lists.add(map1);
								}

							}

						}

					}
					if (integer == 3) {
						String str = "美妆";
						GoodaspectExample example = new GoodaspectExample();
						Criteria criteria = example.createCriteria();
						criteria.andDesigeridEqualTo(desigerId);
						List<Goodaspect> selectByExample = goodaspectMapper.selectByExample(example);
						if (selectByExample.size() > 0) {
							for (Goodaspect goodaspect : selectByExample) {
								if (str.equals(goodaspect.getGoodName())) {
									Map<String, Object> map2 = new HashMap();
									map2.put("serviceId", 3);
									map2.put("price", goodaspect.getGoodPrice());
									lists.add(map2);
								}

							}

						}

					}

				}
				
				
				desigerCart.setServicesId(lists);//服务添加到购物车
				cartItem.setDesigerCart(desigerCart);
				session.setAttribute("cart", cartItem);
			
				 //添加购物车订单号
				 Designerorder designerorder = new  Designerorder();
					designerorder.setDesignerid(desigerId);
					designerorder.setDateTime(dateTime);
					designerorder.setYuid(IDUtils.getUserId());
					//String timeQuantum = designerorder.getTimeQuantum();
					/*StringBuffer  sb=new StringBuffer(timeQuantum);
					sb.append(",").append(num+"");*/
					designerorder.setTimeQuantum(num+"");
				designerorderMapper.insert(designerorder);
			
				System.out.println("-------------------------------");
				CartItem cartItem2 =(CartItem) session.getAttribute("cart");
				System.out.println(cartItem2);
				Map<String,Object> map =new HashMap();
				map.put("status",1);
			  return Result.ok(map);
			 
			 
		
		}
		}
		else{
		//创建购物车
		CartItem cartItem1 = new CartItem();
		Designer designer = designerMapper.selectByPrimaryKey(desigerId);
		DesigerCart desigerCart = new DesigerCart();
		desigerCart.setDesignerId(desigerId);//id
		desigerCart.setDesigerImg(designer.getHeadPath());//头像
		desigerCart.setDesigerName(designer.getDesigerName());//名字
		desigerCart.setPeriodtime(num);//时间段
		desigerCart.setDateTime(dateTime);//时间
		List<Map<String, Object>> lists = new ArrayList<>();
		
	

		for (Integer integer : servicesId) {
			if (integer == 1) {
				String str = "剪发";
				GoodaspectExample example = new GoodaspectExample();
				Criteria criteria = example.createCriteria();
				criteria.andDesigeridEqualTo(desigerId);
				List<Goodaspect> selectByExample = goodaspectMapper.selectByExample(example);
				if (selectByExample.size() > 0) {
					for (Goodaspect goodaspect : selectByExample) {
						if (str.equals(goodaspect.getGoodName())) {
							Map<String, Object> map = new HashMap();
							map.put("serviceId", 1);
							map.put("price", goodaspect.getGoodPrice());
							lists.add(map);
						}

					}

				}
				
			
				
				
				
				
			}
			if (integer == 2) {
				String str = "烫染";
				GoodaspectExample example = new GoodaspectExample();
				Criteria criteria = example.createCriteria();
				criteria.andDesigeridEqualTo(desigerId);
				List<Goodaspect> selectByExample = goodaspectMapper.selectByExample(example);
				if (selectByExample.size() > 0) {
					for (Goodaspect goodaspect : selectByExample) {
						if (str.equals(goodaspect.getGoodName())) {
							Map<String, Object> map1 = new HashMap();
							map1.put("serviceId", 2);
							map1.put("price", goodaspect.getGoodPrice());
							lists.add(map1);
						}

					}

				}

			}
			if (integer == 3) {
				String str = "美妆";
				GoodaspectExample example = new GoodaspectExample();
				Criteria criteria = example.createCriteria();
				criteria.andDesigeridEqualTo(desigerId);
				List<Goodaspect> selectByExample = goodaspectMapper.selectByExample(example);
				if (selectByExample.size() > 0) {
					for (Goodaspect goodaspect : selectByExample) {
						if (str.equals(goodaspect.getGoodName())) {
							Map<String, Object> map2 = new HashMap();
							map2.put("serviceId", 3);
							map2.put("price", goodaspect.getGoodPrice());
							lists.add(map2);
						}

					}

				}

			}

		}
		
		
		desigerCart.setServicesId(lists);//服务添加到购物车
		cartItem1.setDesigerCart(desigerCart);
		//存放购物车
		Map<Long,Object> map= new HashMap();
		map.put(userId, cartItem1);
		session.setAttribute("cart", map);
	
		 //添加购物车订单号
		 Designerorder designerorder = new  Designerorder();
			designerorder.setDesignerid(desigerId);
			designerorder.setDateTime(dateTime);
			designerorder.setYuid(IDUtils.getUserId());
			//String timeQuantum = designerorder.getTimeQuantum();
			/*StringBuffer  sb=new StringBuffer(timeQuantum);
			sb.append(",").append(num+"");*/
			designerorder.setTimeQuantum(num+"");
		designerorderMapper.insert(designerorder);
	
		System.out.println("-------------------------------");
		Map<Long,Object> map1 =(Map<Long, Object>) session.getAttribute("cart");
		System.out.println(map1.get("userId"));
		
		Map<String,Object> map2 =new HashMap();
		map2.put("status",1);
		//map.put("data", cartItem1);
		return Result.ok(map2);
	}
		Map<String,Object> map =new HashMap();
		map.put("status",2);
		return Result.ok(map);

	
	}
	@Override
	public Result addShopCart(long userId,long shopId, long[] commodityIds,HttpServletRequest request,HttpServletResponse response) {
	
		HttpSession session = request.getSession();
		
		//判断有无购物车
		//Object attribute = session.getAttribute("cart");
		
		//取出用户的购物车
			Map<Long,Object> map10 =(Map<Long, Object>) session.getAttribute("cart");
			if(map10!=null){
			CartItem cartItem = (CartItem) map10.get(userId);
		
		//CartItem cartItem= (CartItem) attribute;
		if(cartItem!=null){
			//购物车里面是否有设计师
			 if(cartItem.getShopCart()!=null){
				 //返回3为不能再添加店铺
				 return Result.ok(3);
				 
			 }
			    Shop shop = shopMapper.selectByPrimaryKey(shopId);	
				ShopCart shopCart=new ShopCart();
				shopCart.setShopName(shop.getName());
				shopCart.setShopNo(shop.getAddress());//地址
				
				//获取头像
				ShopImageExample example = new  ShopImageExample();
				mf.pojo.ShopImageExample.Criteria criteria = example.createCriteria();
				criteria.andShopIdEqualTo(shopId);
				List<ShopImage> selectByExample = shopImageMapper.selectByExample(example);
				if(selectByExample.size()>0){
					String imagepath = selectByExample.get(0).getImagepath();
					shopCart.setShopImg(imagepath);
					
				}
				shopCart.setShopId(shopId);
		
				List<Map<String,Object>>  serviceList =new ArrayList<>();
				Map<String,Object> map=new HashMap();
				for (long l : commodityIds) {
					Commodity selectByPrimaryKey = commodityMapper.selectByPrimaryKey(l);
					
					map.put("name", selectByPrimaryKey.getCommodityName());
					map.put("price", selectByPrimaryKey.getPrice());
					serviceList.add(map);	
				} 
				shopCart.setServiceList(serviceList);
				
				cartItem.setShopCart(shopCart);
			
				//session.setAttribute("cart", cartItem);
				//存放购物车
				Map<Long,Object> mapcart= new HashMap();
				mapcart.put(userId, cartItem);
				session.setAttribute("cart", mapcart);
			
				
				
				Map<String,Object> map1=new HashMap();
				map.put("status",1);
				return Result.ok(map1);
			 
		
			 
		}
	}
			else{
			CartItem cartItem1 = new CartItem();
		Shop shop = shopMapper.selectByPrimaryKey(shopId);	
		ShopCart shopCart=new ShopCart();
	
		shopCart.setShopName(shop.getName());
		shopCart.setShopNo(shop.getAddress());//地址
		
		//获取头像
		ShopImageExample example = new  ShopImageExample();
		mf.pojo.ShopImageExample.Criteria criteria = example.createCriteria();
		criteria.andShopIdEqualTo(shopId);
		List<ShopImage> selectByExample = shopImageMapper.selectByExample(example);
		if(selectByExample.size()>0){
			String imagepath = selectByExample.get(0).getImagepath();
			shopCart.setShopImg(imagepath);
			
		}
		shopCart.setShopId(shopId);
		
		cartItem1.setShopCart(shopCart);

		
		
		//存放购物车
		Map<Long,Object> mapcart= new HashMap();
		mapcart.put(userId, cartItem1);
		session.setAttribute("cart", mapcart);
		
		//session.setAttribute("cart", cartItem1);
		
		
		
		Map<String,Object> map =new HashMap();
		map.put("status",1);
		return Result.ok(map);
		
		}
		// 
		Map<String,Object> map =new HashMap();
		map.put("status",2);
		return Result.ok(map);
	}

	
	
}
