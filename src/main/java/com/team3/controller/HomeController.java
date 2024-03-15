package com.team3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("home")
    public String home() {
        return "user/index";
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

    @GetMapping("/admin")
    public String adminHome() {
        return "admin/index";
    }
}
