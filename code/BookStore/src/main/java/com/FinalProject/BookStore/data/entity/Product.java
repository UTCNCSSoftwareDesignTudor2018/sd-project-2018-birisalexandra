package com.FinalProject.BookStore.data.entity;

import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column
    private String name;

    @Column
    private Float price;

    @Column
    private String image;

    @Column
    private String description;

    public Product() {
    }

    public Product(Integer productId, String name, Float price, String image, String description) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.image = image;
        this.description = description;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
