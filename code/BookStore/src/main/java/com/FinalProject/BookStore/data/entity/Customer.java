package com.FinalProject.BookStore.data.entity;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer extends User{

    @Column
    private String name;

    @OneToOne
    @JoinColumn(name="shipping_id")
    private ShippingInfo info;

    public Customer() {}

    public Customer(Integer userId, String username, String password, Integer type, ShippingInfo info) {
        super(userId, username, password, type);
        this.info = info;
    }

    public ShippingInfo getInfo() {
        return info;
    }

    public void setInfo(ShippingInfo info) {
        this.info = info;
    }
}
