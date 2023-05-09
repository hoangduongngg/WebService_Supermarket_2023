package com.example.orderservice.service;

import com.example.orderservice.model.entity.Customer;
import com.example.orderservice.model.entity.Order;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface OrderService {
    Order getCartByCustomer (Customer customer);
//    Order SetTotalAmount (Order order);
}
