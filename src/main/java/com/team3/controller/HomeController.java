package com.team3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String home() {
        return "user/index";
    }

    @GetMapping("/shop")
    public String shop() {
        return "user/shop";
    }

    @GetMapping("/product-details")
    public String productDetails() {
        return "user/product-details";
    }

    @GetMapping("/cart")
    public String cart() {
        return "user/shop-cart";
    }

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @GetMapping("/checkout")
    public String checkOut() {
        return "user/cart-checkout";
    }
}
