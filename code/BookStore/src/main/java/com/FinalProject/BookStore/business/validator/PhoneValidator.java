package com.FinalProject.BookStore.business.validator;

import com.FinalProject.BookStore.data.entity.ShippingInfo;

public class PhoneValidator implements Validator<ShippingInfo> {

    @Override
    public boolean validate(ShippingInfo shippingInfo) {
        if (shippingInfo.getPhone().matches("\\d{10}"))
            return true;
        else
            return false;
    }
}
