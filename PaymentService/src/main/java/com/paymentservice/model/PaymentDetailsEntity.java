package com.paymentservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "payment")
public class PaymentDetailsEntity {
    @Id
    @Column(name = "id")
    private Integer orderId;
    private double amount;
    private String token;
    private String paymentMode = "paypal";
    private LocalDateTime paymentDate;
    private String currency = "USD";
    private String paymentStatus;
}
