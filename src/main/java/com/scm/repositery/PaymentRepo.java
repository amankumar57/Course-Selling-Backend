package com.scm.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer>{
	
	// Custom query to find payments by order ID
    Payment findByOrderId(Integer orderId);

    // Custom query to find payments by transaction ID
    Payment findByTransactionId(String transactionId);

}
