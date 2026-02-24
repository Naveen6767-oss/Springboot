package com.tejait.batch15.service;

import com.tejait.batch15.dto.AccountCustomerdto;
import com.tejait.batch15.dto.AccountResponcedto;
import com.tejait.batch15.model.Account;

public interface AccountService {

	public Account saveAccount(Account acc);

	public Account getByAccountId(long id);

	public AccountResponcedto getByCustomerinfoByacountId(long id);

	public AccountCustomerdto getbycutsomerdetails(long id);

	

}
