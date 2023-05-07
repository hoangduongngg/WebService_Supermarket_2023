package com.example.client_ws_supermarket.controller;

import com.example.client_ws_supermarket.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("")
public class HomeController {
    private RestTemplate rest = new RestTemplate();


    @GetMapping("/")
    public String home (Model model) {
        // Kiem tra neu la Admin thi chuyen den trang admin
        if (1==0) {
            return "admin/home";
        }
        else {
            return home_customer(model);
        }



    }

    private String home_customer (Model model) {
//        List<Product> listP = Arrays.asList(
//                rest.getForObject("http://localhost:8081//api/product",Product[].class));

        //Add fix cung du lieu -> Test FE
        List<Product> listP = new ArrayList<>();
        if (listP.size() == 0) {
            Product p = new Product();
            p.setId(1L);
            p.setName("Nike 1 '071");
            p.setImg("https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/aee23c65-5ed1-4a07-aeff-180b2ad74c00/air-force-1-07-shoe-NMmm1B.png");
            p.setPrice(100);
            p.setDescription("The radiance lives on in the Nike Air Force 1 '07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold colours and the perfect amount of flash to make you shine.");

            for (int i=0; i<10; i++)
                listP.add(p);
        }



        model.addAttribute("listP", listP);
        return "customer/home";
    }


}
