package com.tejait.batch15.service;

import org.springframework.stereotype.Service;

import com.tejait.batch15.model.Payment;

@Service
public interface PaymentService {

	Payment savePayment(Payment payment);

	Payment getByPaymentId(Integer paymentId);

	Payment getRefundByPaymentId(Integer paymentId);

}
