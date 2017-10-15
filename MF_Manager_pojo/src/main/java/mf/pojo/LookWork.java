package mf.pojo;

import org.joda.time.DateTime;

public class LookWork {
	//设计师头像  设计师名字 访问量  作品发布时间 适合年龄段
	private String contentImg;
	private long desigerId;
	private String headPath;
	private String designerName;
	private Integer pageView;//浏览量
	private String publishTime;//发布时间 
	private byte ageType;//年龄段
	public String getHeadPath() {
		return headPath;
	}
	public void setHeadPath(String headPath) {
		this.headPath = headPath;
	}
	public String getDesignerName() {
		return designerName;
	}
	public void setDesignerName(String designerName) {
		this.designerName = designerName;
	}
	public Integer getPageView() {
		return pageView;
	}
	public void setPageView(Integer pageView) {
		this.pageView = pageView;
	}


	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	public byte getAgeType() {
		return ageType;
	}
	public void setAgeType(byte ageType) {
		this.ageType = ageType;
	}
	public String getContentImg() {
		return contentImg;
	}
	public void setContentImg(String contentImg) {
		this.contentImg = contentImg;
	}

	public long getDesigerId() {
		return desigerId;
	}
	public void setDesigerId(long desigerId) {
		this.desigerId = desigerId;
	}

}
