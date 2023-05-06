package com.example.client_ws_supermarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("")
public class TestController {
    @GetMapping("/test")
    public String test_home () {
        return "test";
    }
}
