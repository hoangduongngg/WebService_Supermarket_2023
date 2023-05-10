package com.example.orderdetailservice.repository;

import com.example.orderdetailservice.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository <Order, Long> {
    Optional<Order> findByTblCustomeridAndStatusOrder (Integer id, String status);
    List <Order> findByTblCustomerid (Integer id);
}
