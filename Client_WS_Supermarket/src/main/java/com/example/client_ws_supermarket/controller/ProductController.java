package com.example.client_ws_supermarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("product")
public class ProductController {
    @GetMapping("{id}")
    public String cartView(@PathVariable String id) {
        System.out.println(id);
        return "customer/product";
    }
}
