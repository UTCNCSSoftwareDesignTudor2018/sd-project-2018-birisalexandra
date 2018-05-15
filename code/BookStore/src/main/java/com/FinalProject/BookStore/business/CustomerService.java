package com.FinalProject.BookStore.business;

import com.FinalProject.BookStore.data.entity.Customer;
import com.FinalProject.BookStore.data.repository.CustomerJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerJpaRepository customerJpaRepository;

    public void insertCustomer(Customer customer) {
        customerJpaRepository.save(customer);
    }
}
