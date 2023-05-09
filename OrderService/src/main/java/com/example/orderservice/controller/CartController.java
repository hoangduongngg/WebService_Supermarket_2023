package com.example.orderservice.controller;

import com.example.orderservice.model.entity.Customer;
import com.example.orderservice.model.entity.Order;
import com.example.orderservice.model.entity.OrderDetail;
import com.example.orderservice.repository.OrderDetailRepository;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.service.OrderDetailService;
import com.example.orderservice.service.OrderService;
import com.example.orderservice.service.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/cart", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin("*")

public class CartController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderDetailService orderDetailService;

    //Get Cart -> Load trang Gio hang
    @GetMapping("/{customerId}")
    public ResponseEntity<Order> cartView (@RequestBody Customer customer) {
        Order cart = orderService.getCartByCustomer(customer);
        if (cart == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(cart);
        }
    }
//    localhost:8080/addtocart?productID=1&customerID=29
//    @PostMapping("/addtocart")
//    public ResponseEntity<List<OrderDetail>> addtoCart (@RequestParam("productID") Integer productID,
//                                            @RequestParam("customerID") Integer customerID) {
//
//        //Test
//        Customer customer = new Customer();
//        List<OrderDetail> list_od = orderDetailService.addtoCart(productID, customer);
//        return ResponseEntity.status(HttpStatus.OK).body(list_od);
//    }
//    Get List Order Detail
    @GetMapping("/details/{orderID}")
    public ResponseEntity<List<OrderDetail>> listOrderDetail (@RequestBody Order order) {
        List <OrderDetail> list_od = orderDetailRepository.findByTblOrder(order);
        if (list_od == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(list_od);
        }
    }

//    @GetMapping ("/setQuantity")
//    public ResponseEntity<Boolean> SetQuantityProductInCart (
//            @RequestParam("productID") Integer productID,
//            @RequestParam ("action") String action),
//            @RequestBody Customer customer)
//
//    {
//
//        ;
//        if (orderDetailService.SetQuantityProductInCart(productID, customer, action) == false) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        } else {
//            return ResponseEntity.status(HttpStatus.OK).body(true);
//        }
//    }
}
