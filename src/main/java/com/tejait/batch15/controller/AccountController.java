package com.tejait.batch15.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejait.batch15.dto.AccountCustomerdto;
import com.tejait.batch15.dto.AccountResponcedto;
import com.tejait.batch15.model.Account;
import com.tejait.batch15.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController  {
	@Autowired
	AccountService service;
	
	@PostMapping("/saveAccount")
	public ResponseEntity<Account> SaveAccount(@RequestBody Account acc){
		
	      Account savedacc = service.saveAccount(acc);
		
		return new ResponseEntity<>(savedacc, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Account> getbyAccountdtls(@PathVariable long id){
		
		 Account  acc= service.getByAccountId(id);
		 
		 return new ResponseEntity<>(acc,HttpStatus.OK);
		
	}
	@GetMapping("/getbyAccid/{id}")
	public ResponseEntity<AccountResponcedto>  giveResponceAccountinfo(@PathVariable long id){
		
		 AccountResponcedto dto=service.getByCustomerinfoByacountId(id);
		
		return new ResponseEntity<AccountResponcedto>(dto, HttpStatus.OK);
		
		
		
	}
	@GetMapping("/givecustomerAccountinfo")
	public ResponseEntity<AccountCustomerdto> givecustomerAccountinfo(@PathVariable long id){
		
		AccountCustomerdto acdto= service.getbycutsomerdetails(id);
	
		return new ResponseEntity<AccountCustomerdto>(acdto, HttpStatus.OK);
		
		
		
	}
	
	
	
		
		
		
	}
	

	
	


