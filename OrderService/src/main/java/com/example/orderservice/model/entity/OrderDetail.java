package com.example.orderservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblorderdetail")
public class OrderDetail {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Float price;

    @Column(name = "tbl_productid")
    private Integer tblProductid;

    @Column(name = "tbl_orderid")
    private Integer tblOrderid;

}
