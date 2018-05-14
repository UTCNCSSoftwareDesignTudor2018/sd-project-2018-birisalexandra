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
        return cartJpaRepository.findAllByUserId(user.getUserId());
    }

    public void addToCart(Product product, User user) {
        List<Product> newList = findProducts(user);
        ShoppingCart newCart = new ShoppingCart(0, user, newList);
        cartJpaRepository.save(newCart);
    }
}
