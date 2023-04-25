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
public class OrderDetailServiceImp implements OrderDetailService{
    @Autowired
    private OrderService orderService;
    private OrderRepository orderRepository;

    private OrderDetailRepository orderDetailRepository;
    @Override
    public List<OrderDetail> addtoCart(Integer productID, Integer customerID) {
        Order order = orderService.getCartByCustomerId(customerID);
//        Neu chua ton tai Cart thi tao moi
        if (order == null) {
            order = new Order();
            order.setStatusOrder("cart");
            order.setTblCustomerid(customerID);
            orderRepository.save(order);
            order = orderService.getCartByCustomerId(customerID);
        }

        Optional<OrderDetail> list_od = orderDetailRepository.
                findByTblOrderidAndTblProductid(order.getId(), productID);
        OrderDetail od = new OrderDetail();
        // Da ton tai san pham trong gio hang
        if (list_od.isPresent()) {
            od = list_od.get();
            od.setQuantity(od.getQuantity() +1);
        }
        else {
            od.setQuantity(1);
//            od.setPrice(100); =product.getPrice();
            od.setTblProductid(productID);
            od.setTblOrderid(order.getId());
        }
        orderDetailRepository.save(od);

        return orderDetailRepository.findByTblOrderid(order.getId());
    }
}
