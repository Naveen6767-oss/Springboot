package com.tejait.batch15.serviceimpl;

import org.springframework.stereotype.Service;


import com.tejait.batch15.service.CustomerService;
@Service("business")
public class BusinessServiceImpl implements CustomerService{

	@Override
	public String getCustomerType() {
		
		return "Business Service";
	}

}
