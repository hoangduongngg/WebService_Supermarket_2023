package com.example.thongkekh.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "tblorder")
public class Order {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "order_date")
    private Date orderDate;

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

    @ManyToOne
    @JoinColumn(name = "tbl_customerid")
    private Customer tblCustomerid;

    @Column(name = "tbl_shipperid")
    private Integer tblShipperid;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Date getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getPaymentDate() {
        return this.paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public LocalDate getCancelDate() {
        return this.cancelDate;
    }

    public void setCancelDate(LocalDate cancelDate) {
        this.cancelDate = cancelDate;
    }

    public LocalDate getDeliveryDate() {
        return this.deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getReasonCancel() {
        return this.reasonCancel;
    }

    public void setReasonCancel(String reasonCancel) {
        this.reasonCancel = reasonCancel;
    }

    public String getStatusDelivery() {
        return this.statusDelivery;
    }

    public void setStatusDelivery(String statusDelivery) {
        this.statusDelivery = statusDelivery;
    }

    public String getStatusOrder() {
        return this.statusOrder;
    }

    public void setStatusOrder(String statusOrder) {
        this.statusOrder = statusOrder;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Customer getTblCustomerid() {
        return this.tblCustomerid;
    }

    public void setTblCustomerid(Customer tblCustomerid) {
        this.tblCustomerid = tblCustomerid;
    }

    public Integer getTblShipperid() {
        return this.tblShipperid;
    }

    public void setTblShipperid(Integer tblShipperid) {
        this.tblShipperid = tblShipperid;
    }
}
