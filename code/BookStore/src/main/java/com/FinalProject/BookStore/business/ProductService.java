package com.FinalProject.BookStore.business;

import com.FinalProject.BookStore.data.entity.Product;
import com.FinalProject.BookStore.data.repository.ProductJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductJpaRepository productJpaRepository;

    public void insertProduct(Product product) {
        productJpaRepository.save(product);
    }

    public List<Product> findAllProducts() {
        return productJpaRepository.findAll();
    }
}
