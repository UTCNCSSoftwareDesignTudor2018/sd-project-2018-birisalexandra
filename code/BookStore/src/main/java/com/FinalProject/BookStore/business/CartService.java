package com.FinalProject.BookStore.business;

import com.FinalProject.BookStore.data.entity.Product;
import com.FinalProject.BookStore.data.entity.ShoppingCart;
import com.FinalProject.BookStore.data.entity.User;
import com.FinalProject.BookStore.data.repository.CartJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    CartJpaRepository cartJpaRepository;

    public void insertCart(ShoppingCart cart) {
        cartJpaRepository.save(cart);
    }

    public ShoppingCart findCartByUser(User user) {
        return cartJpaRepository.findByUser(user);
    }

    public void addToCart(ShoppingCart cart, Product product) {
        List<Product> newList = cart.getProducts();
        newList.add(product);
        cart.setProducts(newList);
        cartJpaRepository.save(cart);
    }

    public void emptyCart(ShoppingCart cart) {
        cart.getProducts().removeAll(cart.getProducts());
        cartJpaRepository.save(cart);
    }

}
