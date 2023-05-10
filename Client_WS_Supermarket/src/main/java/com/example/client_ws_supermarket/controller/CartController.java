package com.example.client_ws_supermarket.controller;

import com.example.client_ws_supermarket.model.Customer;
import com.example.client_ws_supermarket.model.Order;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("cart")
public class CartController {
    protected RestTemplate rest = new RestTemplate();


    @GetMapping("")
    public String cartView(HttpSession session, Model model) {
//        Customer customer = (Customer) session.getAttribute("customer");
//
        Customer customer = new Customer();
        customer.setId(29);
        try {
            Order cart = rest.getForObject("http://localhost:8089/api/cart/{customerID}",Order.class, customer.getId());
            System.out.println(cart);
            System.out.println(cart.getStatusOrder());
        }
        catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(customer);

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
