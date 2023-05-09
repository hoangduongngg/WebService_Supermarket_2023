package com.example.orderservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tblcustomer")
public class Customer {

    @Id
    private Integer id;
//    @Id
    @OneToOne
    @JoinColumn(name = "tbl_memberid")
    private Member tblMember;
}