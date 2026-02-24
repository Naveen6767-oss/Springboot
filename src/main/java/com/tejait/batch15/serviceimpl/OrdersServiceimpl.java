package com.tejait.batch15.serviceimpl;


import java.util.List;

import org.springframework.stereotype.Service;

import com.tejait.batch15.Exceptions.DataNotFoundException;
import com.tejait.batch15.dto.OrdersRequestDto;
import com.tejait.batch15.model.Customer;
import com.tejait.batch15.model.Orders;
import com.tejait.batch15.repository.CustomerRepository;
import com.tejait.batch15.repository.OrdersRepository;
import com.tejait.batch15.service.OrdersService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class OrdersServiceimpl implements OrdersService{
	
	OrdersRepository repository;
	CustomerRepository customerRepository;

	@Override
	public OrdersRequestDto saveOrders(OrdersRequestDto dto) {
		
		                 Customer customer  = customerRepository.findById(dto.getCustomerId())
		                		 .orElseThrow(()->new DataNotFoundException("customer not found"));
		                 
		         List<Orders>   orderslist =dto.getOrders();
		         
		         for(Orders orders:orderslist) {
		        	 orders.setCustom(customer);
		         }
		     List<Orders>  savedOrdersList = repository.saveAll(orderslist);
		     
		     OrdersRequestDto responceDto=new OrdersRequestDto();
		     responceDto.setOrders(savedOrdersList);
		     responceDto.setCustomerId(dto.getCustomerId());
		     return responceDto;
		         
		
		
	}

}
	

