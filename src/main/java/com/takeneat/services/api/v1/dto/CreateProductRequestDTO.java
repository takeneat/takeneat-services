package com.takeneat.services.api.v1.dto;

import javax.validation.constraints.NotNull;

/**
 * @author paoesco
 */
public class CreateProductRequestDTO {

    @NotNull
    private String name;
    @NotNull
    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
