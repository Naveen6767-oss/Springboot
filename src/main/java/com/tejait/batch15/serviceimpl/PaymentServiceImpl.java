package com.tejait.batch15.serviceimpl;


import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.tejait.batch15.Exceptions.InsuffiecientFundsException;
import com.tejait.batch15.model.Payment;
import com.tejait.batch15.repository.PaymentRepositary;
import com.tejait.batch15.service.PaymentService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService{
	
	  PaymentRepositary repositary;
	  
	  public static final Logger logger=LogManager.getLogger(PaymentServiceImpl.class);
	

	@Override
	public Payment savePayment(Payment payment) {
		
		logger.debug("Enter Into payment Service");
		logger.info("Payment Data:{}", payment);
		
		//Failure Scenario
		
		if(payment.getAmount()<1) {
			logger.info("Transaction Amount:{}", payment.getAmount());
			
			payment.setTransactionId(UUID.randomUUID().toString());
			payment.setPaymentStatus("Failed");
			
			logger.warn("Payment Status:{}, Transaction Id:{}", payment.getPaymentStatus(), payment.getTransactionId());
			logger.error("Invalid Amount:{}", payment.getAmount());
			 
			throw new InsuffiecientFundsException("Invalid Amount");
			
			
		}
		
		//Fraud Scenario
		
		if(payment.getAmount()>100000) {
						
			logger.warn("Fraud Alert:{}", payment.getPayerName());
			
			logger.info("Alert Higher Amount Transcatio:{}", payment.getAmount());
			
			
		}
		try {
			payment.setTransactionId(UUID.randomUUID().toString());
			
			payment.setPaymentStatus("Success");
			
	      	return repositary.save(payment);
	      	
		}catch (Exception e) {
			
			logger.error("Error While Making the Payment");	
			
			throw e;
			
		}
		
}


	@Override
	public Payment getByPaymentId(Integer paymentId) {
		
		return repositary.findById(paymentId)
				
				.orElseThrow(()-> new IllegalArgumentException());
		
		 
	}


	@Override
	public Payment getRefundByPaymentId(Integer paymentId) {
	     	
	            Payment payment =repositary.findById(paymentId).orElseThrow(()->{
	            	
	            	logger.error("Payment Id Not Found :{}", paymentId);
	            	
	            	return new IllegalArgumentException("Payment Not Found");
	            });
	            
	            
	            if(!payment.getPaymentStatus().equalsIgnoreCase("Success")) {
	            	
	            	logger.warn("Payment Status:{}", payment.getPaymentStatus());
	            	logger.error("payment Not Allowed For Refund:{}", paymentId);
	            	throw new IllegalArgumentException("Payment Not Allowed For Refund");
	            	
	            }
	            payment.setPaymentStatus("Rufund");
	            payment.setTransactionId(UUID.randomUUID().toString());
	            
	            return repositary.save(payment);
			
		}
		
	}

	
	
		
		
		
	


