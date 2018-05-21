package com.FinalProject.BookStore.business;

import com.FinalProject.BookStore.data.entity.Customer;
import com.FinalProject.BookStore.data.entity.ShippingInfo;
import com.FinalProject.BookStore.data.entity.User;
import com.FinalProject.BookStore.data.repository.CustomerJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerJpaRepository customerJpaRepository;

    public void insertCustomer(Customer customer) {
        customerJpaRepository.save(customer);
    }

    public List<Customer> findAll() {
        return customerJpaRepository.findAll();
    }

    public Customer findByUser(User user) {
        return  customerJpaRepository.findByUser(user);
    }
}
