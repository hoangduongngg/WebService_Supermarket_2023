package com.example.orderservice.controller;

import com.example.orderservice.model.entity.Order;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.service.OrderService;
import com.example.orderservice.service.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cart")
@CrossOrigin("*")

public class CartController {
    @Autowired
    private OrderServiceImp orderServiceImp;

    //Get Cart -> Load trang Gio hang
    @GetMapping("/{customerID}")
    public ResponseEntity<Order> cartView (@PathVariable Integer customerID) {
        Order cart = orderServiceImp.getCartByCustomerId(customerID);
        if (cart == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(cart);
        }
    }


}
