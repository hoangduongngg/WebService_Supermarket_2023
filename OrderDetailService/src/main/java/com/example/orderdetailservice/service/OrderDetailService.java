package com.example.orderdetailservice.service;

import com.example.orderdetailservice.model.entity.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDetailService {
    List<OrderDetail> addtoCart (Integer productID, Integer orderId, Integer customerId, Integer price);
    List<OrderDetail> setQuantityProductInCart (Integer productId, Integer orderId, String action);

}
