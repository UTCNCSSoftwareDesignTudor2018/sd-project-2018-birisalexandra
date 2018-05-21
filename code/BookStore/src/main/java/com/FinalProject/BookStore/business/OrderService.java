package com.FinalProject.BookStore.business;

import com.FinalProject.BookStore.data.entity.Customer;
import com.FinalProject.BookStore.data.entity.Order;
import com.FinalProject.BookStore.data.repository.OrderJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderJpaRepository orderJpaRepository;

    public void insertOrder(Order order) {
        orderJpaRepository.save(order);
    }

    public List<Order> findAll() {
        return orderJpaRepository.findAll();
    }
}
