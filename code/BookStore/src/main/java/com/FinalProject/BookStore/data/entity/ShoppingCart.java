package com.FinalProject.BookStore.data.entity;

import javax.persistence.*;

@Entity
@Table(name="shopping_info")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Integer cartId;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToOne
    @JoinColumn(name="product_id")
    private Product product;

    public ShoppingCart() {
    }

    public ShoppingCart(Integer cartId, User user, Product products) {
        this.cartId = cartId;
        this.user = user;
        this.product = products;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
