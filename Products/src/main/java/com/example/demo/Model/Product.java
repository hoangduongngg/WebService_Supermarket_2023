/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Model;

import java.io.Serializable;
import jakarta.persistence.*;
/**
 *
 * @author ben
 */
@Entity
@Table(name = "product")
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id"),
    @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name"),
    @NamedQuery(name = "Product.findByImg", query = "SELECT p FROM Product p WHERE p.img = :img"),
    @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price"),
    @NamedQuery(name = "Product.findByUnits", query = "SELECT p FROM Product p WHERE p.units = :units"),
    @NamedQuery(name = "Product.findByDescription", query = "SELECT p FROM Product p WHERE p.description = :description"),
    @NamedQuery(name = "Product.findByExpirationDate", query = "SELECT p FROM Product p WHERE p.expirationDate = :expirationDate"),
    @NamedQuery(name = "Product.findByIdSupplier", query = "SELECT p FROM Product p WHERE p.idSupplier = :idSupplier")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "img")
    private String img;
    @Basic(optional = false)
    @Column(name = "price")
    private int price;
    @Basic(optional = false)
    @Column(name = "units")
    private int units;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "expiration_date")
    private String expirationDate;
    @Basic(optional = false)
    @Column(name = "id_supplier")
    private int idSupplier;

    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Product(Integer id, String name, String img, int price, int units, String expirationDate, int idSupplier) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
        this.units = units;
        this.expirationDate = expirationDate;
        this.idSupplier = idSupplier;
    }

    public Product(ProductRequest productRequest) {
        this.name = productRequest.name;
        this.img = productRequest.img;
        this.price = productRequest.price;
        this.units = productRequest.units;
        this.expirationDate = productRequest.expirationDate;
        this.description=productRequest.description;
        this.idSupplier = productRequest.idSupplier;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.Model.Product[ id=" + id + " ]";
    }
    
}
