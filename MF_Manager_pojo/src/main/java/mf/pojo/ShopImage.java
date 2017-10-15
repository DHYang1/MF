package mf.pojo;

import java.util.Date;

public class ShopImage {
    private Long imageId;

    private Long shopId;

    private String imagepath;

    private Date creat;

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath == null ? null : imagepath.trim();
    }

    public Date getCreat() {
        return creat;
    }

    public void setCreat(Date creat) {
        this.creat = creat;
    }
}