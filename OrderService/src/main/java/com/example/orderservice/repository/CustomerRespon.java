package com.example.orderservice.repository;

import com.example.orderservice.dto.CustomerStatitic;
import com.example.orderservice.dto.DateTotalDTO;
import com.example.orderservice.model.entity.Customer;
import com.example.orderservice.model.entity.OrderDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRespon extends JpaRepository<Customer,Integer> {
    @Query(value = "select new com.example.orderservice.dto.CustomerStatitic( " +
            "od.tblOrder.tblCustomer.tblMember.name, " +
            "sum(od.price * od.quantity)) from OrderDetail od  " +
            "group by od.tblOrder.tblCustomer.tblMember.id, od.tblOrder.tblCustomer.tblMember.name")
    List<CustomerStatitic> thongkeCustomer();

    @Query(value = "select new com.example.orderservice.dto.DateTotalDTO(  " +
            "month(od.tblOrder.orderDate), " +
            "sum(od.price * od.quantity)) from  OrderDetail od  " +
            "group by month(od.tblOrder.orderDate) ")
    List<DateTotalDTO> dateTotal();
}

