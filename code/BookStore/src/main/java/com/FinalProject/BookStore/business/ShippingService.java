package com.FinalProject.BookStore.business;

import com.FinalProject.BookStore.business.validator.AgeValidator;
import com.FinalProject.BookStore.business.validator.PhoneValidator;
import com.FinalProject.BookStore.data.entity.ShippingInfo;
import com.FinalProject.BookStore.data.repository.ShippingJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    @Autowired
    ShippingJpaRepository shippingJpaRepository;

    public void addNewShipping(ShippingInfo info) {
        shippingJpaRepository.save(info);
    }

    public boolean checkAge(ShippingInfo info) {
        AgeValidator validator = new AgeValidator();
        return validator.validate(info);
    }

    public boolean checkPhone(ShippingInfo info) {
        PhoneValidator validator = new PhoneValidator();
        return validator.validate(info);
    }
}
