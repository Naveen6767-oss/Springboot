package com.tejait.batch15.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejait.batch15.dto.OrdersRequestDto;
import com.tejait.batch15.service.OrdersService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrdersController {
	
	OrdersService Service;
	
	
	@PostMapping("saveorders")
	
	public ResponseEntity<OrdersRequestDto> saveOrders(@RequestBody OrdersRequestDto dto){
		
	   OrdersRequestDto	saved =Service.saveOrders(dto);
	   
	   return new ResponseEntity<> (saved, HttpStatus.OK);
		
		
		
	}
	
	

}
