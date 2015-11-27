package com.takeneat.services.api.v1.dto;

import com.takeneat.services.api.utils.WebServiceUtils;
import com.takeneat.services.model.Order;

/**
 * @author paoesco
 */
public class OrderDTO {

    private Long orderId;
    private Long productId;
    private String productName;
    private Double productPrice;
    private Long cookId;
    private String cookName;
    private Long consumerId;
    private String consumerName;
    private String creationDate;

    private OrderDTO() {
    }

    public OrderDTO(Order order) {
        this.orderId = order.getId();
        this.productId = order.getProduct().getId();
        this.productName = order.getProduct().getName();
        this.productPrice = order.getProduct().getPrice();
        this.cookId = order.getProduct().getCook().getId();
        this.cookName = order.getProduct().getCook().getFullname();
        this.consumerId = order.getConsumer().getId();
        this.consumerName = order.getConsumer().getFullname();
        this.creationDate = WebServiceUtils.formatDate(order.getCreationDate());
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Long getCookId() {
        return cookId;
    }

    public void setCookId(Long cookId) {
        this.cookId = cookId;
    }

    public String getCookName() {
        return cookName;
    }

    public void setCookName(String cookName) {
        this.cookName = cookName;
    }

    public Long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

}
