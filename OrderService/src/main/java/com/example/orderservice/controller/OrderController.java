package com.example.orderservice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")

public class OrderController {
    @GetMapping("/")
    public String Order() {
        return "hello";
    }


}
