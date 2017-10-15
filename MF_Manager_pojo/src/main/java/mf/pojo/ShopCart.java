package mf.pojo;

import java.util.List;
import java.util.Map;

public class ShopCart {
  //店铺的ID
	private  long shopId;
//店铺的名称
	private  String shopName;
//服务的选择	
	private List<Map<String,Object>>  serviceList;
//店铺的头像
	private  String shopImg;
	private String shopNo;
	
	public String getShopNo() {
		return shopNo;
	}
	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
	public List<Map<String, Object>> getServiceList() {
		return serviceList;
	}
	public void setServiceList(List<Map<String, Object>> serviceList) {
		this.serviceList = serviceList;
	}
	public String getShopImg() {
		return shopImg;
	}
	public void setShopImg(String shopImg) {
		this.shopImg = shopImg;
	}
	public long getShopId() {
		return shopId;
	}
	public void setShopId(long shopId) {
		this.shopId = shopId;
	}
	
	
	
	
	
	

}
