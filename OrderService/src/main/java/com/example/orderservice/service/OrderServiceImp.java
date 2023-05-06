package com.example.orderservice.service;

import com.example.orderservice.model.entity.Order;
import com.example.orderservice.model.entity.OrderDetail;
import com.example.orderservice.repository.OrderDetailRepository;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class OrderServiceImp implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    private OrderDetailRepository orderDetailRepository;

    @Override
    public Order getCartByCustomerId (Integer id) {
        Optional<Order> order = orderRepository.findByTblCustomeridAndStatusOrder(id, "cart");
        if (order.isPresent()) {
//            return SetTotalAmount(order.get());
            return order.get();
        }
        else return null;

    }

//    @Override
//    public Order SetTotalAmount(Order order) {
//        List<OrderDetail> details = orderDetailRepository.findByTblOrderid(order.getId());
//        order.setDetails(details);
//        order.setTotalAmount(totalAmount(order));
//        return order;
//    }
//
//    private Float totalAmount (Order order) {
//        float totalAmount = 0f;
//        List<OrderDetail> details = order.getDetails();
//        for (int i=0; i<details.size(); i++) {
//            totalAmount += (float) details.get(i).getPrice() * details.get(i).getQuantity();
//        }
//        return totalAmount;
//    }


}
