package com.example.orderservice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")

public class HelloController {
    @GetMapping("/")
    public String Order() {
        return "hello";
    }


}
