package com.tejait.batch15.serviceimpl;

import java.time.LocalDateTime;


import org.aspectj.apache.bcel.util.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.tejait.batch15.dto.AccountCustomerdto;
import com.tejait.batch15.dto.AccountResponcedto;
import com.tejait.batch15.model.Account;
import com.tejait.batch15.repository.AccountRespository;
import com.tejait.batch15.service.AccountService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
//@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
	AccountRespository respository;
	
	@Override
	public Account saveAccount(Account acc) {
		
	  acc.setCreatedDate(LocalDateTime.now());
	  acc.setUpdatedDate(LocalDateTime.now());
	  return respository.save(acc);
		
	}

	@Override
	public Account getByAccountId(long id) {
		
		return respository.findById(id).get();
	}

	@Override
	public AccountResponcedto getByCustomerinfoByacountId(long id) {
		
		                Account account= respository.findById(id).get();
		                
		                System.out.println("Account info:"+account);
		                
		    AccountResponcedto dto=new AccountResponcedto();
		                       dto.setAccountId(account.getAccountId());
		                       dto.setAccountType(account.getAccountType());
		                       dto.setHolderName(account.getHolderName());
		                       dto.setIfsc(account.getIfsc());

		return dto;
	}

	@Override
	public AccountCustomerdto getbycutsomerdetails(long id) {
		
		Account accdto1=respository.findById(id).get();
		
		System.out.println("customer info:"+accdto1);
		
		AccountCustomerdto acdtos=new AccountCustomerdto();
		
		acdtos.setAccountId(accdto1.getAccountId());
		acdtos.setAccountNum(accdto1.getAccountNum());
		acdtos.setBalance(accdto1.getBalance());
	
		return acdtos;
		
		
		
		
		
		
		
		
		
		
				     
		
		
	}

	
		
		
	
	

}
