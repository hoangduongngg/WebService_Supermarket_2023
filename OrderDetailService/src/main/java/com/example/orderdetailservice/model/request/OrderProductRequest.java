package com.example.orderdetailservice.model.request;

import com.example.orderdetailservice.model.DTO.Order;
import com.example.orderdetailservice.model.DTO.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderProductRequest {
    private Order order;
    private Product product;
}
