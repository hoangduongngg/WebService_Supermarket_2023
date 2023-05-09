package com.example.orderservice.service;

import com.example.orderservice.model.entity.Customer;
import com.example.orderservice.model.entity.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDetailService {
    List<OrderDetail> addtoCart (Integer productID, Customer customer);
    Boolean SetQuantityProductInCart (Integer productID, Customer customer, String action);

//    Float statiticCustomer (Integer customerID);

}
