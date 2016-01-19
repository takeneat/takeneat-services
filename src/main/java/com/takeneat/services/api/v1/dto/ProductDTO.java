package com.takeneat.services.api.v1.dto;

import com.takeneat.services.model.Product;
import java.util.Date;

/**
 * @author paoesco
 */
public class ProductDTO {

    private Long id;
    private String name;
    private Double price;
    private String cookName;
    private Long cookId;
    private Date creationDate;
    private String distance;

    protected ProductDTO() {
    }

    public ProductDTO(Product p) {
        this.id = p.getId();
        this.cookName = p.getCook().getFirstname() + " " + p.getCook().getLastname();
        this.cookId = p.getCook().getId();
        this.name = p.getName();
        this.price = p.getPrice();
        this.creationDate = p.getCreationDate();
        this.distance = String.valueOf(Math.random() * 300);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getCookName() {
        return cookName;
    }

    public void setCookName(String cookName) {
        this.cookName = cookName;
    }

    public Long getCookId() {
        return cookId;
    }

    public void setCookId(Long cookId) {
        this.cookId = cookId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

}
