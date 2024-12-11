package com.scm.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.entity.Payment;
import com.scm.repositery.PaymentRepo;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepo.findAll();
    }

    @Override
    public Payment getPaymentById(Integer paymentId) {
        Optional<Payment> payment = paymentRepo.findById(paymentId);
        return payment.orElse(null);
    }

    @Override
    public Payment getPaymentByOrderId(Integer orderId) {
        return paymentRepo.findByOrderId(orderId);
    }

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepo.save(payment);
    }

    @Override
    public Payment updatePaymentStatus(Integer paymentId, String status) {
        Optional<Payment> paymentOpt = paymentRepo.findById(paymentId);
        if (paymentOpt.isPresent()) {
            Payment payment = paymentOpt.get();
            payment.setPaymentStatus(status);
            return paymentRepo.save(payment);
        }
        return null;
    }

    @Override
    public void deletePayment(Integer paymentId) {
        paymentRepo.deleteById(paymentId);
    }
}
