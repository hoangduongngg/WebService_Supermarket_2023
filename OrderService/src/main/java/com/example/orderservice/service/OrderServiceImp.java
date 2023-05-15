package com.example.orderservice.service;

import com.example.orderservice.model.DTO.Order;
import com.example.orderservice.model.entity.OrderEntity;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class OrderServiceImp implements OrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order getCartByCustomerId (Integer id) {
        Optional<OrderEntity> order_entity = orderRepository.findByTblCustomeridAndStatusOrder(id, "cart");
        if (order_entity.isPresent()) {
            Order order = new Order(order_entity.get());
            return order;
        }
        else return null;

    }


}
