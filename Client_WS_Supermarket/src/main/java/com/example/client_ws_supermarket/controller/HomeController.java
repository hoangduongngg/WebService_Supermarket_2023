package com.example.client_ws_supermarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

    @GetMapping("/")
    public String home () {
        // Kiem tra neu la Admin thi chuyen den trang admin
//        if () {
//            return "admin/home";
//        }

        return "customer/home";
    }


}
