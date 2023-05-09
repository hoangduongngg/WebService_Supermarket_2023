package com.example.orderservice.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "tblcustomer")
public class Customer {

    @Id
    private Integer id;

    @OneToOne
    @JoinColumn(name = "tbl_memberid")
    private Member tblMemberid;

    @Column(name = "tblPaymentCardid")
    private Integer tblPaymentCardid;

    public Member getTblMemberid() {
        return this.tblMemberid;
    }

    public void setTblMemberid(Member tblMemberid) {
        this.tblMemberid = tblMemberid;
    }

    public Integer getTblPaymentCardid() {
        return this.tblPaymentCardid;
    }

    public void setTblPaymentCardid(Integer tblPaymentCardid) {
        this.tblPaymentCardid = tblPaymentCardid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}