package com.example.orderservice.service;

import com.example.orderservice.model.entity.Order;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class OrderServiceImp implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    public Order getCartByCustomerId (Integer id) {
        Optional<Order> order = orderRepository.findByTblCustomeridAndStatusOrder(id, "cart");
        if (order.isPresent()) {
            return order.get();
        }
        else return null;

    }
}
