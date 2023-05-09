package com.example.orderservice.repository;

import com.example.orderservice.model.entity.Customer;
import com.example.orderservice.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository <Order, Long> {
    Optional<Order> findByTblCustomerAndStatusOrder (Customer customer, String status);
    List <Order> findByTblCustomer (Customer customer);
}
