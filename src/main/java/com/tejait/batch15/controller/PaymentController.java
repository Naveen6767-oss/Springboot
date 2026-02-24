package com.tejait.batch15.controller;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejait.batch15.model.Payment;
import com.tejait.batch15.service.PaymentService;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("payment")
public class PaymentController {
	
	
	PaymentService service;
	
	private static final Logger logger= LogManager.getLogger(PaymentController.class);
	
	@PostMapping("makePayment")
	public ResponseEntity<Payment> makePayment(@RequestBody Payment payment){
		
		logger.debug("Entered into Payment Controller");
		
		logger.info("Payment Data :{}", payment);
		
		 Payment  SavedPayment=service.savePayment(payment);
		 
		 logger.info("Saved Payment Data:{}", SavedPayment);
		        
		        return new ResponseEntity<> (SavedPayment, HttpStatus.OK);
		
	}

	@GetMapping("byPaymentId/{paymentId}")
	
	public ResponseEntity<Payment> getPaymentBypaymentId(@PathVariable Integer paymentId){
		
		logger.debug("Enter Into getPaymentBypaymentId ");
		logger.info("paymentId:{}", paymentId);
		
		    Payment payment=service.getByPaymentId(paymentId);
		    
		    return new ResponseEntity<>  (payment, HttpStatus.OK);
	}
	
	
	@GetMapping("refundByPaymentId/{paymentId}")
	
	public ResponseEntity<Payment> getRefundByPaymentId(@PathVariable Integer paymentId){
		
		logger.debug("Entered Into getByRefundPaymentId");
		logger.info("Paymentid:{}", paymentId);
		
		 Payment payment =service.getRefundByPaymentId(paymentId);
		         
		   return new ResponseEntity<> (payment, HttpStatus.OK);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
