package com.eltropy.test.bankingsystem.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eltropy.test.bankingsystem.pojo.AccountDetails;
import com.eltropy.test.bankingsystem.service.AccountService;

@RestController
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/createAccount")
	public AccountDetails createAccount(@RequestBody AccountDetails account) {
		return this.accountService.createAccount(account);
	}
	@GetMapping("getAccountBalance/{accountNumber}")
	public Integer getAccountBalance(@PathVariable Integer accountNumber) {
		return this.accountService.getAccountBalance(accountNumber);
	}
	@GetMapping("updateAccountBalance/{accountNumber}")
	public Integer updateAccountBalance(@PathVariable Integer accountNumber) {
		return this.accountService.updateAccountBalance(accountNumber);
	}
}
