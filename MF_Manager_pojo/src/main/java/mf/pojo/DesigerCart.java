package mf.pojo;

import java.util.List;
import java.util.Map;

public class DesigerCart {
  
    private Long designerId;
   private String desigerName;
   private String  desigerImg;
   private String dateTime;//时间
   private int  periodtime;//时间段
   private List<Map<String, Object>> servicesId;
public Long getDesignerId() {
	return designerId;
}
public void setDesignerId(Long designerId) {
	this.designerId = designerId;
}
public String getDesigerName() {
	return desigerName;
}
public void setDesigerName(String desigerName) {
	this.desigerName = desigerName;
}
public String getDesigerImg() {
	return desigerImg;
}
public void setDesigerImg(String desigerImg) {
	this.desigerImg = desigerImg;
}
public String getDateTime() {
	return dateTime;
}
public void setDateTime(String dateTime) {
	this.dateTime = dateTime;
}
public int getPeriodtime() {
	return periodtime;
}
public void setPeriodtime(int periodtime) {
	this.periodtime = periodtime;
}
public List<Map<String, Object>> getServicesId() {
	return servicesId;
}
public void setServicesId(List<Map<String, Object>> servicesId) {
	this.servicesId = servicesId;
}

   
    
    
   
}