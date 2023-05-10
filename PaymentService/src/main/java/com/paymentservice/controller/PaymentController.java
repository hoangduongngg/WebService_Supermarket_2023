package com.paymentservice.controller;

import com.paymentservice.model.OrderEntity;
import com.paymentservice.model.PaymentDetailsEntity;
import com.paymentservice.repository.OrderRepository;
import com.paymentservice.repository.PaymentDetailsRepository;
import com.paymentservice.service.PayWithPaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;


@RestController
@RequestMapping("/")
public class PaymentController {
    public static final String PAYPAL_SUCCESS_URL = "pay/success";
    public static final String PAYPAL_CANCEL_URL = "pay/cancel";

    @Autowired
    private PaymentDetailsRepository paymentDetailsRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PayWithPaypalService payWithPaypalService;

    // http://localhost:9090/pay?orderId=1
    @PostMapping("/pay")
    public String payment(@RequestParam int orderId) {
        String token = "";
        try {
            OrderEntity order = orderRepository.findOrderEntityById(orderId);
            Payment payment = payWithPaypalService.createPayment(order.getAmount() / 23447, "USD", "paypal",
                    "order", "thanh toan hoa don"
                    , "http://localhost:9090/" + PAYPAL_CANCEL_URL,
                    "http://localhost:9090/" + PAYPAL_SUCCESS_URL);
            System.out.println(payment);

            PaymentDetailsEntity paymentDetails = new PaymentDetailsEntity();
            paymentDetails.setOrderId(orderId);
            paymentDetails.setAmount(order.getAmount());
            paymentDetails.setPaymentStatus("PENDING");

            for(Links link:payment.getLinks()) {
                if(link.getRel().equals("approval_url")) {
                    String[] s = link.getHref().split("=");
                    token = s[2];
                    paymentDetails.setToken(token);
                    paymentDetailsRepository.save(paymentDetails);
                    return link.getHref();
                }
            }

        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }
        return "payment pending";
    }

    @GetMapping(value = PAYPAL_CANCEL_URL)
    public String cancelPay(
            @RequestParam("token") String token
    ) {
        PaymentDetailsEntity paymentDetails = paymentDetailsRepository.getByToken(token);
        paymentDetails.setPaymentDate(LocalDateTime.now());
        paymentDetails.setPaymentStatus("PAYMENT CANCELLED");
        paymentDetailsRepository.save(paymentDetails);

        OrderEntity order = orderRepository.findOrderEntityById(paymentDetails.getOrderId());
        order.setPaymentType("PAYPAL");
        order.setPaymentStatus("PAYMENT CANCELLED");
        order.setPaymentDate(Date.from(Instant.now()));
        orderRepository.save(order);
        return "payment failed";
    }
    @GetMapping(value = PAYPAL_SUCCESS_URL)
    public String successPay(
            @RequestParam("paymentId") String paymentId,
            @RequestParam("token") String token,
            @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = payWithPaypalService.executePayment(paymentId, payerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
                PaymentDetailsEntity paymentDetails = paymentDetailsRepository.getByToken(token);
                paymentDetails.setPaymentDate(LocalDateTime.now());
                paymentDetails.setPaymentStatus("PAYMENT SUCCESS");
                paymentDetailsRepository.save(paymentDetails);

                OrderEntity order = orderRepository.findOrderEntityById(paymentDetails.getOrderId());
                order.setPaymentType("PAYPAL");
                order.setPaymentStatus("PAYMENT SUCCESS");
                order.setPaymentDate(Date.from(Instant.now()));
                orderRepository.save(order);
                return "payment success";
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return "payment success";
    }

}
