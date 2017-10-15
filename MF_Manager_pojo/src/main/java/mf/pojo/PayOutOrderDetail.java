package mf.pojo;

public class PayOutOrderDetail {
    private Long payOutOrderDetailId;

    private Long payOutOrderId;

    private String remark;

    public Long getPayOutOrderDetailId() {
        return payOutOrderDetailId;
    }

    public void setPayOutOrderDetailId(Long payOutOrderDetailId) {
        this.payOutOrderDetailId = payOutOrderDetailId;
    }

    public Long getPayOutOrderId() {
        return payOutOrderId;
    }

    public void setPayOutOrderId(Long payOutOrderId) {
        this.payOutOrderId = payOutOrderId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}