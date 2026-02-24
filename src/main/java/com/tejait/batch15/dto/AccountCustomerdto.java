package com.tejait.batch15.dto;

public class AccountCustomerdto {
	
	private Long accountId;
	private Long accountNum;
	private Long balance;
	
	
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public Long getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(Long accountNum) {
		this.accountNum = accountNum;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "AccountCustomerdto [accountId=" + accountId + ", accountNum=" + accountNum + ", balance=" + balance
				+ "]";
	}
	
	
	
	

}
