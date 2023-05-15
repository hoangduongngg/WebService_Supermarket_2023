package com.example.thongkekh.controller;

import com.example.thongkekh.dto.CustomerStatitic;
import com.example.thongkekh.dto.DateTotalDTO;
import com.example.thongkekh.respon.CustomerRespon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("thongke")
public class ThongKeKHController {
    @Autowired
    public CustomerRespon customerRepo;

    @RequestMapping("/customer")
    public List<CustomerStatitic> customerList() {
        return customerRepo.thongkeCustomer();
    }

    @RequestMapping("/dateList")
    public List<DateTotalDTO> dateList() {

        return customerRepo.dateTotal();
    }
}
