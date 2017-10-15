package mf.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class DesigerCartOrder extends HotDesigner implements  Serializable{
  private List<Map<String,Double>> productList;

public List<Map<String, Double>> getProductList() {
	return productList;
}

public void setProductList(List<Map<String, Double>> productList) {
	this.productList = productList;
}
  
  
	
}
