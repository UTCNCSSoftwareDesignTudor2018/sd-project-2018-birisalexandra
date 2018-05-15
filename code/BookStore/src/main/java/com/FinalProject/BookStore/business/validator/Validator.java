package com.FinalProject.BookStore.business.validator;

public interface Validator<T> {

    public boolean validate(T t);
}
