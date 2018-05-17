package com.FinalProject.BookStore.business.validator;

import com.FinalProject.BookStore.data.entity.ShippingInfo;

public class AgeValidator implements Validator<ShippingInfo> {

    private static final int MIN_AGE = 12;
    private static final int MAX_AGE = 90;

    @Override
    public boolean validate(ShippingInfo info) {
        if (info.getAge() >= MIN_AGE && info.getAge() <= MAX_AGE)
            return true;
        else
            return false;
    }
}
