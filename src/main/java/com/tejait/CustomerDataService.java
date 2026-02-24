package com.tejait;

import org.springframework.stereotype.Service;

import com.tejait.batch15.model.Customer;
@Service
public interface CustomerDataService {


	

	Customer saveCustomer(Customer customer);

}
