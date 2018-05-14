package com.FinalProject.BookStore.data.repository;

import com.FinalProject.BookStore.data.entity.Product;
import com.FinalProject.BookStore.data.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartJpaRepository extends JpaRepository<ShoppingCart, Integer> {

    public List<Product> findAllByUserId(Integer userId);
}
