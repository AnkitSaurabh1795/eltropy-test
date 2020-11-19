package com.eltropy.test.bankingsystem.service;

import com.eltropy.test.bankingsystem.pojo.AccountDetails;

public interface AccountService {
	AccountDetails createAccount(AccountDetails account);
	Integer getAccountBalance(Integer accountNumber);
	Integer updateAccountBalance(Integer accountNumber);
}
