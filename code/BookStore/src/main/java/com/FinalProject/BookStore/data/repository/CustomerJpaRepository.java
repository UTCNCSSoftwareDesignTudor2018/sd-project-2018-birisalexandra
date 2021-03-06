package com.FinalProject.BookStore.data.repository;

import com.FinalProject.BookStore.data.entity.Customer;
import com.FinalProject.BookStore.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerJpaRepository extends JpaRepository<Customer, Integer> {

    public List<Customer> findAll();
    public Customer findByUser(User user);
}
