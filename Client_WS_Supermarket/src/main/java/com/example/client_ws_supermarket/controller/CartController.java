package com.example.client_ws_supermarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cart")
public class CartController {

    @GetMapping("")
    public String cartView() {
        return "customer/cart";
    }

    @GetMapping("checkout")
    public String checkout (Model model) {
        return "customer/checkout";
    }
}
