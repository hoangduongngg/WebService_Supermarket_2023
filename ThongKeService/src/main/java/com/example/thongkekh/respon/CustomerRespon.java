package com.example.thongkekh.respon;
import com.example.thongkekh.dto.CustomerStatitic;
import com.example.thongkekh.dto.DateTotalDTO;
import com.example.thongkekh.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRespon extends JpaRepository<Customer,Integer> {
    @Query(value = "select new com.example.thongkekh.dto.CustomerStatitic( " +
            "od.tblOrderid.tblCustomerid.id, od.tblOrderid.tblCustomerid.tblMemberid.name, " +
            "sum(od.price * od.quantity)) from OrderDetail od  " +
            "group by od.tblOrderid.tblCustomerid.id, od.tblOrderid.tblCustomerid.tblMemberid.name")
    List<CustomerStatitic> thongkeCustomer();
//    @Query(value = "select new com.example.thongkekh.dto.DateTotalDTO(  " +
//            "month(od.tblOrderid.orderDate), " +
//            "sum(od.price * od.quantity)) from  OrderDetail od  " +
//            "group by month(od.tblOrderid.orderDate) ")
    @Query(value = "SELECT " +
            "    new com.example.thongkekh.dto.DateTotalDTO(" +
            "        MONTH(od.tblOrderid.paymentDate)," +
            "        SUM(od.price * od.quantity)" +
            "    )" +
            "FROM OrderDetail od WHERE od.tblOrderid.paymentDate IS NOT NULL " +
            "GROUP BY MONTH(od.tblOrderid.paymentDate)")
    List<DateTotalDTO> dateTotal();


}
