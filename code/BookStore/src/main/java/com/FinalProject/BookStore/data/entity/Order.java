package com.FinalProject.BookStore.data.entity;

import javax.persistence.*;

@Entity
@Table(name="order")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name="cart_id")
    private ShoppingCart shoppingCart;

    public Order(Integer orderId, Customer customer, ShoppingCart shoppingCart) {
        this.orderId = orderId;
        this.customer = customer;
        this.shoppingCart = shoppingCart;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
