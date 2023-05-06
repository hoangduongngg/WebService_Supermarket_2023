package com.example.orderservice.repository;

import com.example.orderservice.model.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDetailRepository extends JpaRepository <OrderDetail, Long> {
    Optional<OrderDetail> findByTblOrderidAndTblProductid (Integer orderID, Integer productID);
    List<OrderDetail> findByTblOrderid (Integer orderID);

}
