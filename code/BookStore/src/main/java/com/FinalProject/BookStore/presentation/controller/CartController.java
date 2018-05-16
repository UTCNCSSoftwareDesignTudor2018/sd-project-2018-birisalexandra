package com.FinalProject.BookStore.presentation.controller;

import com.FinalProject.BookStore.business.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartController {

    @Autowired
    CartService cartService;


}
