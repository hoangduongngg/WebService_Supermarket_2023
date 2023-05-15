package com.example.thongkekh.model;


import jakarta.persistence.*;

@Entity
@Table(name = "tblorderdetail")
public class OrderDetail {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "price")
    private Long price;

    @Column(name = "tbl_productid")
    private Integer tblProductid;

    @ManyToOne()
    @JoinColumn(name = "tbl_orderid")
    private Order tblOrderid;

    public void setTblOrderid(Order tblOrderid) {
        this.tblOrderid = tblOrderid;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getPrice() {
        return this.price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getTblProductid() {
        return this.tblProductid;
    }

    public void setTblProductid(Integer tblProductid) {
        this.tblProductid = tblProductid;
    }

    public Order getTblOrderid() {
        return tblOrderid;
    }
}
