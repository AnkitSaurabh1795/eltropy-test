package com.eltropy.test.bankingsystem.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eltropy.test.bankingsystem.pojo.AccountDetails;
import com.eltropy.test.bankingsystem.pojo.CustomerDetails;
import com.eltropy.test.bankingsystem.repo.Account;
import com.eltropy.test.bankingsystem.repo.AccountRepository;
import com.eltropy.test.bankingsystem.repo.Customer;
@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountRepository accountRepository;
	@Override
	public AccountDetails createAccount(AccountDetails account) {
		// TODO Auto-generated method stub
		Account  accountdb = accountRepository.save((this.beanToEntity(account))) ;
		account.setAccountnumber(accountdb.getAccountnumber());
		return account;
	}
	public CustomerDetails entityToBean(Customer entity) {
		CustomerDetails customer = new CustomerDetails();
		BeanUtils.copyProperties(entity, customer);
		return customer;
	}

	public Account beanToEntity(AccountDetails account) {
		Account accountdb = new Account();
		BeanUtils.copyProperties(account, accountdb);
		return accountdb;
	}

}
