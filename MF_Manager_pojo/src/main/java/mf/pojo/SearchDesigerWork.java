package mf.pojo;

public class SearchDesigerWork {
	
private long desigerId;	
private long desigerWorkId;
private String desigerWorkName;
private String introduction;
private String  cover_image;
private String age_type;//年龄类型

private String labelName;


public String getLabelName() {
	return labelName;
}
public void setLabelName(String labelName) {
	this.labelName = labelName;
}

public String getAge_type() {
	return age_type;
}
public void setAge_type(String age_type) {
	this.age_type = age_type;
}
public String getDesigerWorkName() {
	return desigerWorkName;
}
public void setDesigerWorkName(String desigerWorkName) {
	this.desigerWorkName = desigerWorkName;
}

public String getIntroduction() {
	return introduction;
}
public void setIntroduction(String introduction) {
	this.introduction = introduction;
}
public String getCover_image() {
	return cover_image;
}
public void setCover_image(String cover_image) {
	this.cover_image = cover_image;
}
public long getDesigerWorkId() {
	return desigerWorkId;
}
public void setDesigerWorkId(long desigerWorkId) {
	this.desigerWorkId = desigerWorkId;
}
public long getDesigerId() {
	return desigerId;
}
public void setDesigerId(long desigerId) {
	this.desigerId = desigerId;
}

}
