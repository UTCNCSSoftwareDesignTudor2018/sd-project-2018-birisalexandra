package com.FinalProject.BookStore.business;

import com.FinalProject.BookStore.data.entity.Order;
import com.FinalProject.BookStore.data.repository.OrderJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderJpaRepository orderJpaRepository;

    public void insertOrder(Order order) {
        orderJpaRepository.save(order);
    }
}
