package com.example.orderservice.controller;

import com.example.orderservice.dto.CustomerStatitic;
import com.example.orderservice.dto.DateTotalDTO;
import com.example.orderservice.repository.CustomerRespon;
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
