package com.example.productservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "tblproduct")
public class Product {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "img")
    private String img;

    @Column(name = "price")
    private Float price;

    @Column(name = "description")
    private String description;

    @Column(name = "color")
    private String color;

    @Column(name = "mfgDate")
    private LocalDate mfgDate;

    @Column(name = "expDate")
    private LocalDate expDate;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "tblWareHouseid")
    private Integer tblWareHouseid;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDate getMfgDate() {
        return this.mfgDate;
    }

    public void setMfgDate(LocalDate mfgDate) {
        this.mfgDate = mfgDate;
    }

    public LocalDate getExpDate() {
        return this.expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTblWareHouseid() {
        return this.tblWareHouseid;
    }

    public void setTblWareHouseid(Integer tblWareHouseid) {
        this.tblWareHouseid = tblWareHouseid;
    }
}
