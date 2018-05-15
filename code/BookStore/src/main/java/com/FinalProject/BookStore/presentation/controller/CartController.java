package com.FinalProject.BookStore.presentation.controller;

import com.FinalProject.BookStore.business.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CartController {

    @Autowired
    CartService cartService;


}
