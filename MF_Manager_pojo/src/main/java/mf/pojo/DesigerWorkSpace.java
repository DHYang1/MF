package mf.pojo;

import java.util.List;
import java.util.Map;

public class DesigerWorkSpace {
	private String position;//职位
	private String job;//工作室
	private Integer jobYear;//工作年限
	private List<MyWorkList> myWorkList;
	private  List<Work> workList;//作品
	private  String  desigerHeadImg;
	private  String  desigerName;//设计师名字
	private  String  desigerPhone;//设计师电话
	
	

	public String getDesigerName() {
		return desigerName;
	}
	public void setDesigerName(String desigerName) {
		this.desigerName = desigerName;
	}
	public String getDesigerPhone() {
		return desigerPhone;
	}
	public void setDesigerPhone(String desigerPhone) {
		this.desigerPhone = desigerPhone;
	}
	public List<Work> getWorkList() {
		return workList;
	}
	public void setWorkList(List<Work> workList) {
		this.workList = workList;
	}
	public String getDesigerHeadImg() {
		return desigerHeadImg;
	}
	public void setDesigerHeadImg(String desigerHeadImg) {
		this.desigerHeadImg = desigerHeadImg;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Integer getJobYear() {
		return jobYear;
	}
	public void setJobYear(Integer jobYear) {
		this.jobYear = jobYear;
	}
	public List<MyWorkList> getMyWorkList() {
		return myWorkList;
	}
	public void setMyWorkList(List<MyWorkList> myWorkList) {
		this.myWorkList = myWorkList;
	}
	
	
	
}
