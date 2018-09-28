package com.zl.order.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: le
 * @Date: 2018/7/23 15:31
 * @Description:
 */
public class OrderDetail {

    private String detailId;
    // 订单ID
    private String orderId;
    // 商品id
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productQuantity;

    private String prdocuIcon;

    private Date createTime;

    private Date updateTime;

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getPrdocuIcon() {
        return prdocuIcon;
    }

    public void setPrdocuIcon(String prdocuIcon) {
        this.prdocuIcon = prdocuIcon;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
