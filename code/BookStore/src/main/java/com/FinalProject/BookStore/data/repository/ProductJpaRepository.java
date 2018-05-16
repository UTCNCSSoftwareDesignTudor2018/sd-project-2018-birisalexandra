package com.FinalProject.BookStore.data.repository;

import com.FinalProject.BookStore.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductJpaRepository extends JpaRepository<Product, Integer> {

    public List<Product> findAll();
}
