package com.eltropy.test.bankingsystem.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
	@PreAuthorize("hasRole('EMPLOYEE')")
	public AccountDetails createAccount(@RequestBody AccountDetails account) {
		return this.accountService.createAccount(account);
	}
	@GetMapping("getAccountBalance/{accountNumber}")
	@PreAuthorize("hasRole('EMPLOYEE')")
	public Integer getAccountBalance(@PathVariable Integer accountNumber) {
		return this.accountService.getAccountBalance(accountNumber);
	}
	@GetMapping("updateAccountBalance/{accountNumber}")
	@PreAuthorize("hasRole('EMPLOYEE')")
	public Integer updateAccountBalance(@PathVariable Integer accountNumber) {
		return this.accountService.updateAccountBalance(accountNumber);
	}
}
