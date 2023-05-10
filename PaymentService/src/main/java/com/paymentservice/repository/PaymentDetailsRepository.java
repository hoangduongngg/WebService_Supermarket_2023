package com.paymentservice.repository;

import com.paymentservice.model.PaymentDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDetailsRepository extends JpaRepository<PaymentDetailsEntity, Integer> {
    PaymentDetailsEntity findPaymentDetailsEntityByOrderId(Integer id);
    PaymentDetailsEntity getByToken(String token);
}
