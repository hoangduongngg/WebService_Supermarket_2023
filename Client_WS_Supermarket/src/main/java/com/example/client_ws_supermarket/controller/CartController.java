package com.example.client_ws_supermarket.controller;

import com.example.client_ws_supermarket.model.Customer;
import com.example.client_ws_supermarket.model.Order;
import com.example.client_ws_supermarket.model.OrderDetail;
import com.example.client_ws_supermarket.model.Product;
import com.example.client_ws_supermarket.model.request.OrderProductRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpHeaders;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("cart")
public class CartController {
    protected RestTemplate rest = new RestTemplate();


    @GetMapping("")
    public String cartView(HttpSession session,
//                           @SessionAttribute Customer customer,
                           Model model) {
        Customer customer = (Customer) session.getAttribute("customer");
        System.out.println(customer);


//        Customer customer = new Customer();
//        customer.setId(29);
        try {
            Order cart = rest.getForObject("http://localhost:8089/api/cart/{customerID}",Order.class, customer.getId());
            List<OrderDetail> list_od = cart.getDetails();
            model.addAttribute("list_od", list_od);
            session.setAttribute("order", cart);

            System.out.println(cart.getStatusOrder());
            System.out.println(list_od);
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return "customer/cart";
    }

    @GetMapping ("addtocart/{productId}")
    public String addtocart(HttpSession session,
                            Model model,
                            @PathVariable Integer productId) {
        System.out.println(productId);
        Customer customer = (Customer) session.getAttribute("customer");
        Product product = rest.getForObject("http://localhost:8081/product?id=" + productId ,Product.class);

        Order cart = rest.getForObject("http://localhost:8089/api/cart/{customerID}",Order.class, customer.getId());
        try {
            OrderProductRequest request = new OrderProductRequest(cart, product);
            cart = rest.postForObject("http://localhost:8088/api/details/addtocart", request, Order.class );
            session.setAttribute("order", cart);

            List<OrderDetail> list_od = cart.getDetails();
            model.addAttribute("list_od", list_od);

            System.out.println(cart.getStatusOrder());
            System.out.println(list_od);
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return "customer/cart";
    }

    @GetMapping ("setQuantity/{action}/{productId}")
    public String setQuantity (HttpSession session,
                            Model model,
//                            @RequestBody Product product,
                               @PathVariable Integer productId,
                            @PathVariable String action) {
        System.out.println("Run set Quan");

        Customer customer = (Customer) session.getAttribute("customer");
        Product product = rest.getForObject("http://localhost:8081/product?id=" + productId ,Product.class);
        Order order = (Order) session.getAttribute("order");
        try {
            OrderProductRequest request = new OrderProductRequest(order, product);
            Order cart = rest.postForObject("http://localhost:8088/api/details/setQuantity", request + action, Order.class );
            session.setAttribute("order", cart);

            List<OrderDetail> list_od = cart.getDetails();
            model.addAttribute("list_od", list_od);

            System.out.println(cart.getStatusOrder());
            System.out.println(list_od);
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return "customer/cart";
    }

    @GetMapping("checkout")
    public String checkout (Model model) {
        return "customer/checkout";
    }
}
