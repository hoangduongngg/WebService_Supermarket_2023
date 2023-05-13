package com.example.orderdetailservice.service;

import com.example.orderdetailservice.model.entity.OrderDetailEntity;
import com.example.orderdetailservice.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderDetailServiceImp implements OrderDetailService{
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Override
    public List<OrderDetailEntity> addtoCart(Integer productId, Integer orderId, Integer customerId, Integer price) {
        // Coi nhu da ton tai Order, neu chua thi tao o ben OrderSer
        try {
            Optional<OrderDetailEntity> list_od = orderDetailRepository.findByTblOrderidAndTblProductid(orderId, productId);
            OrderDetailEntity od = new OrderDetailEntity();
            // Da ton tai san pham trong gio hang
            if (list_od.isPresent()) {
                od = list_od.get();
                od.setQuantity(od.getQuantity() +1);
            }
            else { //Chua ton tai
                od.setQuantity(1);
                od.setPrice(price);
                od.setTblProductid(productId);
                od.setTblOrderid(orderId);
            }
            orderDetailRepository.save(od);

            return orderDetailRepository.findByTblOrderid(orderId);
        }
        catch (Exception e) {
            System.out.println("null" + e);
            return null;
        }

    }

    @Override
    public List<OrderDetailEntity> setQuantityProductInCart(Integer productId, Integer orderId, String action) {
        try {
            Optional<OrderDetailEntity> list_od = orderDetailRepository.
                    findByTblOrderidAndTblProductid(orderId, productId);
            try {
                OrderDetailEntity od = list_od.get();
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
