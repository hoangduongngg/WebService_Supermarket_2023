package com.example.orderservice.repository;

import com.example.orderservice.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order, Long> {
    Order findByTblCustomerid (Integer id);
}
