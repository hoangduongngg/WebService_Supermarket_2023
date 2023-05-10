package com.example.client_ws_supermarket.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblorderdetail")
public class OrderDetail {
    private static final long serialVersionUID = 100000000000002L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Integer price;

    @Column(name = "tbl_productid")
    private Integer tblProductid;

    @Column(name = "tbl_orderid")
    private Integer tblOrderid;

}
