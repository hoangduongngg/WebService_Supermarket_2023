package com.example.orderdetailservice.service;

import com.example.orderdetailservice.model.DTO.Order;
import com.example.orderdetailservice.model.DTO.OrderDetail;
import com.example.orderdetailservice.model.entity.OrderDetailEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDetailService {
    List<OrderDetailEntity> addtoCart (Integer productID, Integer orderId, Integer customerId, Integer price);
    List<OrderDetailEntity> setQuantityProductInCart (Integer productId, Integer orderId, String action);

    List<OrderDetail> getListDetailsByOrder (Integer orderId);
}
