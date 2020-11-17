package com.eltropy.test.bankingsystem.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eltropy.test.bankingsystem.pojo.TransactionDetails;
import com.eltropy.test.bankingsystem.service.TransactionService;

@RestController
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	@PostMapping("/doTransaction")
	public String doTransaction(@RequestBody TransactionDetails transaction) {
		return this.transactionService.doTransaction(transaction);
	}
}
