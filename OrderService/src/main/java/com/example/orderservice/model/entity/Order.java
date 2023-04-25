package com.example.orderservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tblorder")
public class Order {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @Column(name = "cancel_date")
    private LocalDate cancelDate;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    @Column(name = "reason_cancel")
    private String reasonCancel;

    @Column(name = "status_delivery")
    private String statusDelivery;

    @Column(name = "status_order")
    private String statusOrder;

    @Column(name = "note")
    private String note;

    @Column(name = "tbl_customerid")
    private Integer tblCustomerid;

    @Column(name = "tbl_shipperid")
    private Integer tblShipperid;
}
