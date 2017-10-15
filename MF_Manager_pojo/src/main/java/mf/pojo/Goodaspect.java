package mf.pojo;

public class Goodaspect {
    private Long goodId;

    private String goodName;

    private Double goodPrice;

    private Long desigerid;

    private Byte status;

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName == null ? null : goodName.trim();
    }

    public Double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(Double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public Long getDesigerid() {
        return desigerid;
    }

    public void setDesigerid(Long desigerid) {
        this.desigerid = desigerid;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}