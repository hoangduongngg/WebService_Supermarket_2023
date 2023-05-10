package com.example.orderdetailservice.controller;

import com.example.orderdetailservice.model.entity.OrderDetail;
import com.example.orderdetailservice.repository.OrderDetailRepository;
import com.example.orderdetailservice.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/details", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin("*")

public class OrderDetailRestController {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/{orderID}")
    public ResponseEntity<List<OrderDetail>> listOrderDetail (@PathVariable Integer orderID) {
        List <OrderDetail> list_od = orderDetailRepository.findByTblOrderid(orderID);
        if (list_od == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(list_od);
        }
    }

    //    localhost:8088/api/details/addtocart?productId=1&orderId=29
    @PostMapping("/addtocart")
    public ResponseEntity<List<OrderDetail>> addtoCart (@RequestParam("productId") Integer productId,
                                                        @RequestParam("orderId") Integer orderId,
                                                        @RequestParam("customerId") Integer customerId,
                                                        @RequestParam("price") Integer price
                                                        ) {

        List<OrderDetail> list_od = orderDetailService.addtoCart(productId, orderId, customerId, price);
        return ResponseEntity.status(HttpStatus.OK).body(list_od);
    }

    @PostMapping("/setQuantity")
    public ResponseEntity<List<OrderDetail>> SetQuantityProductInCart (
            @RequestParam("productId") Integer productId,
            @RequestParam("orderId") Integer orderId,
            @RequestParam ("action") String action) {

        List<OrderDetail> list_od = orderDetailService.setQuantityProductInCart(productId, orderId, action);
        return ResponseEntity.status(HttpStatus.OK).body(list_od);
    }
}
