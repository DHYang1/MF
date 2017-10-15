package mf.pojo;

import java.util.List;

public class PayInOrderDetail {
    private Long payInOrderDetailId;

    private Long payInOrderId;

    private Long productId;

    private String productName;

    private Double productPrice;

    private Integer productCount;

    private Double productSubtotal;

    private Byte type;



	public Long getPayInOrderDetailId() {
        return payInOrderDetailId;
    }

    public void setPayInOrderDetailId(Long payInOrderDetailId) {
        this.payInOrderDetailId = payInOrderDetailId;
    }

    public Long getPayInOrderId() {
        return payInOrderId;
    }

    public void setPayInOrderId(Long payInOrderId) {
        this.payInOrderId = payInOrderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Double getProductSubtotal() {
        return productSubtotal;
    }

    public void setProductSubtotal(Double productSubtotal) {
        this.productSubtotal = productSubtotal;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }
}