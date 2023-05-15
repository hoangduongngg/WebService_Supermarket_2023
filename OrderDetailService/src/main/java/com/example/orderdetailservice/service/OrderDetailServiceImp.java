package com.example.orderdetailservice.service;

import com.example.orderdetailservice.model.DTO.Order;
import com.example.orderdetailservice.model.DTO.OrderDetail;
import com.example.orderdetailservice.model.DTO.Product;
import com.example.orderdetailservice.model.entity.OrderDetailEntity;
import com.example.orderdetailservice.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class OrderDetailServiceImp implements OrderDetailService{
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Override
    public Order addtoCart(Product product, Order cart) {
        // Coi nhu da ton tai Gio hang - Order, neu chua thi tao o ben Client




        try { // Da ton tai san pham trong gio hang
            OrderDetailEntity od_entity = orderDetailRepository.findByTblOrderidAndTblProductid(cart.getId(), product.getId());
            if (od_entity != null) {
                od_entity.setQuantity(od_entity.getQuantity() +1);
            }
            orderDetailRepository.save(od_entity);
            System.out.println("Da ton tai trong gio hang");
        }
        catch (Exception e) { //Chua ton tai
            System.out.println("Chua ton tai" + e);
            OrderDetailEntity od_entity = new OrderDetailEntity();
            od_entity.setQuantity(1);
            od_entity.setPrice(product.getPrice());
            od_entity.setTblProductid(product.getId());
            od_entity.setTblOrderid(cart.getId());
            orderDetailRepository.save(od_entity);
        }
        cart.setDetails(getListDetailsByOrder(cart.getId()));
        return cart;
    }

    @Override
    public List<OrderDetailEntity> setQuantityProductInCart(Integer productId, Integer orderId, String action) {
        try {
            OrderDetailEntity list_od = orderDetailRepository.
                    findByTblOrderidAndTblProductid(orderId, productId);
            try {
                OrderDetailEntity od = list_od;
                switch (action){
                    case "inc": od.setQuantity(od.getQuantity() +1);
                        break;
                    case "red": od.setQuantity(od.getQuantity() -1 );
                        break;
                    case "delete": od.setQuantity(0);
                        break;
                }
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return orderDetailRepository.findByTblOrderid(orderId);
    }

    @Override
    public List<OrderDetail> getListDetailsByOrder(Integer orderId) {
        List <OrderDetailEntity> list_od_entity = orderDetailRepository.findByTblOrderid(orderId);
        List<OrderDetail> list_details = new ArrayList<>();
        for (OrderDetailEntity od_entity:list_od_entity) {
            list_details.add(new OrderDetail(od_entity));
        }
        return list_details;
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
