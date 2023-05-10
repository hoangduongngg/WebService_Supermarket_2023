package com.paymentservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Entity
@Data
@Table(name = "tblorder")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String paymentType;
    private String paymentStatus;
    private Date orderDate;
    private Date paymentDate;
    private Date cancelDate;
    private Date deliveryDate;
    private String reasonCancel;
    private String statusDelivery;
    private String statusOrder;
    private String note;
    private Integer customerId;
    private Integer shipperId;
    private Double amount;
}
