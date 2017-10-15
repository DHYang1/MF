package mf.pojo;

import java.util.Date;

public class Designwork {
    private Long workId;

    private Long designerId;

    private String title;

    private String introduction;

    private String coverImage;

    private String contentPicture;

    private Integer sex;

    private Integer face;

    private Byte popularIndex;

    private Byte ageType;

    private Date lastupdateTime;

    private Byte status;

    private Long palaceId;

    public Long getWorkId() {
        return workId;
    }

    public void setWorkId(Long workId) {
        this.workId = workId;
    }

    public Long getDesignerId() {
        return designerId;
    }

    public void setDesignerId(Long designerId) {
        this.designerId = designerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage == null ? null : coverImage.trim();
    }

    public String getContentPicture() {
        return contentPicture;
    }

    public void setContentPicture(String contentPicture) {
        this.contentPicture = contentPicture == null ? null : contentPicture.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getFace() {
        return face;
    }

    public void setFace(Integer face) {
        this.face = face;
    }

    public Byte getPopularIndex() {
        return popularIndex;
    }

    public void setPopularIndex(Byte popularIndex) {
        this.popularIndex = popularIndex;
    }

    public Byte getAgeType() {
        return ageType;
    }

    public void setAgeType(Byte ageType) {
        this.ageType = ageType;
    }

    public Date getLastupdateTime() {
        return lastupdateTime;
    }

    public void setLastupdateTime(Date lastupdateTime) {
        this.lastupdateTime = lastupdateTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getPalaceId() {
        return palaceId;
    }

    public void setPalaceId(Long palaceId) {
        this.palaceId = palaceId;
    }
}