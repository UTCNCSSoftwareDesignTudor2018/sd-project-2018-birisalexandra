package com.FinalProject.BookStore.data.entity;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @Column
    private String name;

    @OneToOne
    @JoinColumn(name="shipping_id")
    private ShippingInfo info;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    public Customer() {}

    public Customer(Integer customerId, String name, ShippingInfo info, User user) {
        this.customerId = customerId;
        this.name = name;
        this.info = info;
        this.user = user;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShippingInfo getInfo() {
        return info;
    }

    public void setInfo(ShippingInfo info) {
        this.info = info;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
