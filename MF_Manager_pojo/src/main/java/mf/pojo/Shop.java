package mf.pojo;

import java.util.Date;
import java.util.List;

public class Shop {
    private Long shopId;

    private String thumbnails;

    private String name;

    private Double x;

    private Double y;

    private String address;

    private Integer phone;

    private String beginEnd;

    private Date createTime;

    private Date lastUpdated;

    private Integer state;
    
    private List<ShopImage> images;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(String thumbnails) {
        this.thumbnails = thumbnails == null ? null : thumbnails.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getBeginEnd() {
        return beginEnd;
    }

    public void setBeginEnd(String beginEnd) {
        this.beginEnd = beginEnd == null ? null : beginEnd.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

	public List<ShopImage> getImages() {
		return images;
	}

	public void setImages(List<ShopImage> images) {
		this.images = images;
	}
    
    
    
}