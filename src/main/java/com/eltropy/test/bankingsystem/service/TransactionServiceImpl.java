package com.eltropy.test.bankingsystem.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eltropy.test.bankingsystem.pojo.TransactionDetails;
import com.eltropy.test.bankingsystem.repo.Account;
import com.eltropy.test.bankingsystem.repo.AccountRepository;
import com.eltropy.test.bankingsystem.repo.Transaction;
import com.eltropy.test.bankingsystem.repo.TransactionRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
@Service
public class TransactionServiceImpl implements TransactionService{
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private AccountRepository accountRepository;
	@Override
	public String doTransaction(TransactionDetails transaction) {
		// TODO Auto-generated method stub
		Account accountdb = accountRepository.findByAccountnumber(transaction.getFromaccount());
		Account accountdbto = accountRepository.findByAccountnumber(transaction.getToaccount());
		if(accountdb == null) {
			return "Account number" + transaction.getFromaccount() + "does not exist";
		}else if(accountdbto == null) {
			return "Account number" + transaction.getToaccount() + "does not exist";
		}else {
			if(transaction.getDate() == null) {
				DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
				String currentdate = dateFormatter.format(new Date());
				transaction.setDate(currentdate);
			}
			if(accountdb.getBalance() >= transaction.getAmount()) {
				try {
					accountdb.setBalance(accountdb.getBalance() - transaction.getAmount());
					accountdbto.setBalance(accountdbto.getBalance() + transaction.getAmount());
					transactionRepository.save(beanToEntity(transaction));
				}
				catch (Exception e){
					return e.toString();
				}
			}else {
				return "Insufficient balance";
			}
		}
		
		
		return "Transaction Succesfully Completed";
	}
	public Transaction beanToEntity(TransactionDetails transaction) {
		Transaction transactiondb = new Transaction();
		BeanUtils.copyProperties(transaction, transactiondb);
		return transactiondb;
	}
}
