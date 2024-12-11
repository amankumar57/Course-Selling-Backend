package com.scm.Service;

import java.util.List;

import com.scm.entity.Payment;

public interface PaymentService {
	
	 List<Payment> getAllPayments();

	    Payment getPaymentById(Integer paymentId);

	    Payment getPaymentByOrderId(Integer orderId);

	    Payment createPayment(Payment payment);

	    Payment updatePaymentStatus(Integer paymentId, String status);

	    void deletePayment(Integer paymentId);

}
