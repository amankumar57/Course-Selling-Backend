package com.scm.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.entity.OnlinePayment;



public interface OnlinePaymentRepo extends JpaRepository<OnlinePayment, Long> {

	public OnlinePayment findByRazorPayOrderId(String razorPayOrderId);

}

