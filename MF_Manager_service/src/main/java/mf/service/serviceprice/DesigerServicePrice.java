package mf.service.serviceprice;

import java.util.List;
import java.util.Map;

import MF_Utils.Result;
import mf.pojo.Goodaspect;


public interface DesigerServicePrice {
	 public  Result getDesigerPrice(long desigerId);
	 
	 public  Result updateDesigerPrice(long desigerId,int id,double price);
}
