package com.example.orderdetailservice.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Product {
    private static final long serialVersionUID = 100000000000001L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String img;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String expirationDate;
    @Column(nullable = true)
    private int idSupplier;
}