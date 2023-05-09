package com.example.client_ws_supermarket.controller;

import com.example.client_ws_supermarket.model.CustomerStatitic;
import com.example.client_ws_supermarket.model.DateTotal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.web.client.HttpClientErrorException;

import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class TKcontroller {
    protected RestTemplate restTemplate=new RestTemplate();

    @GetMapping("/thongke_customer")
    public String thongKe_customer(Model model) {
        String url = "http://localhost:8080/thongke/customer";

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String response = restTemplate.getForObject(url, String.class);
            CustomerStatitic[] customerDataArray = objectMapper.readValue(response, CustomerStatitic[].class);

            model.addAttribute("customers", Arrays.asList(customerDataArray));
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "thongkekh";
    }
    @GetMapping("/thongke_date")
    public String thongKe_date(Model model) {
        String url = "http://localhost:8080/thongke/dateList";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String response = restTemplate.getForObject(url, String.class);
            DateTotal[] customerDataArray = objectMapper.readValue(response, DateTotal[].class);

            if (customerDataArray != null) {
                model.addAttribute("date", Arrays.asList(customerDataArray));
            }
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "thongkedate";
    }


}
