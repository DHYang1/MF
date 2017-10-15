package mf.pojo;

import java.util.Date;

public class PayOutOrder {
    private Long payOutOrderId;

    private Long userId;

    private Long payVendorId;

    private Double amount;

    private Byte status;

    private Date ctime;

    public Long getPayOutOrderId() {
        return payOutOrderId;
    }

    public void setPayOutOrderId(Long payOutOrderId) {
        this.payOutOrderId = payOutOrderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPayVendorId() {
        return payVendorId;
    }

    public void setPayVendorId(Long payVendorId) {
        this.payVendorId = payVendorId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}