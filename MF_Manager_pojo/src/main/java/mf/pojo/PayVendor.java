package mf.pojo;

public class PayVendor {
    private Long payVendorId;

    private String name;

    public Long getPayVendorId() {
        return payVendorId;
    }

    public void setPayVendorId(Long payVendorId) {
        this.payVendorId = payVendorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}