package com.FinalProject.BookStore.data.repository;

import com.FinalProject.BookStore.data.entity.ShippingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingJpaRepository extends JpaRepository<ShippingInfo, Integer> {

    public ShippingInfo findByPhone(String phone);
}
