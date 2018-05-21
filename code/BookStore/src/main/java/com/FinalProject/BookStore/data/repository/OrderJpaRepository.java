package com.FinalProject.BookStore.data.repository;

import com.FinalProject.BookStore.data.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderJpaRepository extends JpaRepository<Order, Integer> {
}
