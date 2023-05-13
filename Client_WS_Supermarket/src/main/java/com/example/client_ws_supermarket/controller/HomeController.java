package com.example.client_ws_supermarket.controller;

import com.example.client_ws_supermarket.model.Customer;
import com.example.client_ws_supermarket.model.Product;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("")
public class HomeController {
    protected RestTemplate rest = new RestTemplate();


    @GetMapping("/")
    public String home (HttpSession session, Model model) {
        // Kiem tra neu la Admin thi chuyen den trang admin
        if (1==0) {
            return "admin/home";
        }
        else {
            return home_customer(session, model);
        }
    }

    @PostMapping ("/")
    public String search_home (HttpSession session, Model model, @RequestParam String txtSearch) {
        System.out.println(txtSearch);
        model.addAttribute("txtSearch", txtSearch);
        return home_customer(session, model);
    }

    private String home_customer (HttpSession session, Model model) {
        String url = "http://localhost:8081/products";
        List<Product> listP = new ArrayList<>();
        try {
            listP = Arrays.asList(rest.getForObject(url,Product[].class));
        }
        catch (Exception e) {
            System.out.println(e);
            Product p = new Product();
            p.setId(1L);
            p.setName("Nike 1 '071");
            p.setImg("https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/aee23c65-5ed1-4a07-aeff-180b2ad74c00/air-force-1-07-shoe-NMmm1B.png");
            p.setPrice(100);
            p.setDescription("The radiance lives on in the Nike Air Force 1 '07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold colours and the perfect amount of flash to make you shine.");

            for (int i=0; i<10; i++)
                listP.add(p);
        }
        System.out.println(listP);
        //Add fix cung du lieu -> Test FE

        //Add fix cung du lieu -> Test FE
        Customer customer = new Customer();
        customer.setId(29);

        
        session.setAttribute("customer", customer);
        model.addAttribute("listP", listP);
        return "customer/home";
    }


}
