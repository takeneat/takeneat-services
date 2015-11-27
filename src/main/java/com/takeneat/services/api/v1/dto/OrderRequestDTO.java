package com.takeneat.services.api.v1.dto;

import javax.validation.constraints.NotNull;

/**
 * @author paoesco
 */
public class OrderRequestDTO {

    @NotNull
    private Long productId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

}
