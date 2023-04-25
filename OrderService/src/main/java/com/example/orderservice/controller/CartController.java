package com.example.orderservice.controller;

import com.example.orderservice.model.entity.Order;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private OrderRepository orderRepository;

    //Get Cart -> Load trang Gio hang
    @GetMapping("/{customerID}")
    public ResponseEntity<Order> cartView (@PathVariable Integer customerID) {
        Order cart = orderRepository.findByTblCustomerid(customerID);
        if (cart == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cart);
        }

    }
}
