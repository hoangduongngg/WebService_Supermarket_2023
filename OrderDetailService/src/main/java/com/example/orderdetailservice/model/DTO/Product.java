package com.example.orderdetailservice.model.DTO;

import lombok.*;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class Product {
    private Long id;
    private String name;
    private String img;
    private Integer price;
    private Integer quantity;
    private String description;
    private Date expirationDate;
}
