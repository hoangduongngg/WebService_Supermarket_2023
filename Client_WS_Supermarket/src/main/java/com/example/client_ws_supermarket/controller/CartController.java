package com.example.client_ws_supermarket.controller;

import com.example.client_ws_supermarket.model.Customer;
import com.example.client_ws_supermarket.model.Order;
import com.example.client_ws_supermarket.model.OrderDetail;
import com.example.client_ws_supermarket.model.Product;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("cart")
public class CartController {
    protected RestTemplate rest = new RestTemplate();


    @GetMapping("")
    public String cartView(@SessionAttribute Customer customer, Model model) {
//
//        Customer customer = new Customer();
//        customer.setId(29);
        try {
            Order cart = rest.getForObject("http://localhost:8089/api/cart/{customerID}",Order.class, customer.getId());
            System.out.println(cart);
            System.out.println(cart.getStatusOrder());

            String url_detail = "http://localhost:8088/api/details/{orderId}";
            List<OrderDetail> list_od = Arrays.asList(rest.getForObject(url_detail, OrderDetail[].class, cart.getId()));

            model.addAttribute("list_od", list_od);
            System.out.println(list_od);
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return "customer/cart";
    }

    @GetMapping("addtocart/{productId}")
    public String addtocart(Model model, @PathVariable Long productId) {
        System.out.println("productId + " + productId);

        return "customer/cart";
    }

    @GetMapping("checkout")
    public String checkout (Model model) {
        return "customer/checkout";
    }
}
