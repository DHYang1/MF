package mf.pojo;

public class Palace {
    private Long palaceId;

    private String headpath;

    private String place;

    private String name;

    private Byte status;

    private Byte degree;

    public Long getPalaceId() {
        return palaceId;
    }

    public void setPalaceId(Long palaceId) {
        this.palaceId = palaceId;
    }

    public String getHeadpath() {
        return headpath;
    }

    public void setHeadpath(String headpath) {
        this.headpath = headpath == null ? null : headpath.trim();
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getDegree() {
        return degree;
    }

    public void setDegree(Byte degree) {
        this.degree = degree;
    }
}