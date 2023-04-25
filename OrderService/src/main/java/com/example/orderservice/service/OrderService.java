package com.example.orderservice.service;

import com.example.orderservice.model.entity.Order;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface OrderService {
    Order getCartByCustomerId (Integer id);
}
