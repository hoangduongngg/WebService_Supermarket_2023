package com.example.orderdetailservice.model.DTO;

import lombok.*;

@Data
@RequiredArgsConstructor
public class OrderDetail {
    private Integer id;
    private Integer quantity;
    private Integer price;
    private Product product;
    private Order order;
}
