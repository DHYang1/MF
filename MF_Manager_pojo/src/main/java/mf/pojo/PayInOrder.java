package mf.pojo;

import java.util.Date;
import java.util.List;

public class PayInOrder {
    private Long payInOrderId;

    private Long userId;

    private Long payVendorId;

    private Integer timeSlot;

    private Double amount;

    private Byte status;

    private Date ctime;

    private String rmake;

    private String ordertime;

    private String shopImage;

    private String designerImage;

    private List<PayInOrderDetail> payInOrderDetailList;
    
    private List<PayLog> payLogs;
    
    

    public List<PayLog> getPayLogs() {
		return payLogs;
	}

	public void setPayLogs(List<PayLog> payLogs) {
		this.payLogs = payLogs;
	}

	public List<PayInOrderDetail> getPayInOrderDetailList() {
        return payInOrderDetailList;
    }

    public void setPayInOrderDetailList(List<PayInOrderDetail> payInOrderDetailList) {
        this.payInOrderDetailList = payInOrderDetailList;
    }

    public String getShopImage() {
        return shopImage;
    }

    public void setShopImage(String shopImage) {
        this.shopImage = shopImage;
    }

    public String getDesignerImage() {
        return designerImage;
    }

    public void setDesignerImage(String designerImage) {
        this.designerImage = designerImage;
    }

    public Long getPayInOrderId() {
        return payInOrderId;
    }

    public void setPayInOrderId(Long payInOrderId) {
        this.payInOrderId = payInOrderId;
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

    public Integer getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(Integer timeSlot) {
        this.timeSlot = timeSlot;
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

    public String getRmake() {
        return rmake;
    }

    public void setRmake(String rmake) {
        this.rmake = rmake == null ? null : rmake.trim();
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime == null ? null : ordertime.trim();
    }
}