package com.eltropy.test.bankingsystem.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eltropy.test.bankingsystem.pojo.AccountDetails;
import com.eltropy.test.bankingsystem.pojo.CustomerDetails;
import com.eltropy.test.bankingsystem.repo.Account;
import com.eltropy.test.bankingsystem.repo.AccountRepository;
import com.eltropy.test.bankingsystem.repo.Customer;
import com.eltropy.test.bankingsystem.utility.CalculateInterest;
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
	@Override
	public Integer getAccountBalance(Integer accountNumber) {
		Account  accountdb =accountRepository.findOne(accountNumber);
		if(accountdb == null) {
			throw new RuntimeException("Account No not find");
		}
		return accountdb.getBalance();
	}
	public Integer updateAccountBalance(Integer accountNumber) {
		Account  accountdb =accountRepository.findOne(accountNumber);
		if(accountdb == null) {
			throw new RuntimeException("Account No not find");
		}
		CalculateInterest calculator = new CalculateInterest();
		Integer updatedAmount = calculator.interestCalculator(accountdb.getBalance(), (Integer)12, 3.5, (Integer)1);
		accountdb.setBalance(updatedAmount);
		accountRepository.save(accountdb) ;
		return updatedAmount;
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
