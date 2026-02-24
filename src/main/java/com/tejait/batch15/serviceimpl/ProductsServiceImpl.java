package com.tejait.batch15.serviceimpl;


import org.springframework.stereotype.Service;

import com.tejait.batch15.model.Products;
import com.tejait.batch15.repository.ProducstsRepository;
import com.tejait.batch15.service.ProductsService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ProductsServiceImpl implements ProductsService{
	
	ProducstsRepository repository;

	
	
	
	@Override
	public Products savedProducts(Products products) {
		
		
		
		return repository.save(products);
	}

}
