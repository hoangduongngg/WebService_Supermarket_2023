package com.paymentservice.repository;

import com.paymentservice.model.OrderEntity;
import com.paypal.api.payments.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    OrderEntity findOrderEntityById(Integer id);

}
