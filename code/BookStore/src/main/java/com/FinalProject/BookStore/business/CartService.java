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

    public List<Product> findProducts(User user) {
        return cartJpaRepository.findAllByUser(user);
    }

    public void addToCart(ShoppingCart cart, Product product) {
        List<Product> newList = findProducts(cart.getUser());
        newList.add(product);
        cart.setProducts(newList);
        cartJpaRepository.save(cart);
    }

    public void removeFromCart(ShoppingCart cart, Product product) {
        List<Product> newList = findProducts(cart.getUser());
        newList.remove(product);
        cart.setProducts(newList);
        cartJpaRepository.save(cart);
    }
}
