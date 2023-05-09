package com.example.orderservice.service;

import com.example.orderservice.model.entity.Customer;
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
    public List<OrderDetail> addtoCart(Integer productID, Customer customer) {
        Order order = orderService.getCartByCustomer(customer);
//        Neu chua ton tai Cart thi tao moi
        if (order == null) {
            order = new Order();
            order.setStatusOrder("cart");
            order.setTblCustomer(customer);
            orderRepository.save(order);
            order = orderService.getCartByCustomer(customer);
        }

        Optional<OrderDetail> list_od = orderDetailRepository.
                findByTblOrderAndTblProductid(order, productID);
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
            od.setTblOrder(order);
        }
        orderDetailRepository.save(od);

        return orderDetailRepository.findByTblOrder(order);
    }

    @Override
    public Boolean SetQuantityProductInCart(Integer productID, Customer customer, String action) {
        Order order = orderService.getCartByCustomer(customer);
        Optional<OrderDetail> list_od = orderDetailRepository.
                findByTblOrderAndTblProductid(order, productID);

        try {
            OrderDetail od = list_od.get();
            switch (action){
                case "inc": od.setQuantity(od.getQuantity() +1);
                    break;
                case "red": od.setQuantity(od.getQuantity() -1 );
                    break;
                case "delete": od.setQuantity(0);
                    break;
            }
            return true;
        }
        catch (Exception e) {
            return false;
        }

    }

//    @Override
//    public Float statiticCustomer(Integer customerID) {
//        List<Order> list_Order = orderRepository.findByTblCustomerid(customerID);
//
//        Float res = 0f;
//        for (int i=0; i<list_Order.size(); i++) {
//            res += list_Order.get(i).getTotalAmount();
//        }
//
//        return res;
//    }


}
