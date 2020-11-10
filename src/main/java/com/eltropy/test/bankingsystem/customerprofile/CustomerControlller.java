package com.eltropy.test.bankingsystem.customerprofile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eltropy.test.bankingsystem.pojo.CustomerDetails;
import com.eltropy.test.bankingsystem.service.CustomerService;

@RestController
public class CustomerControlller {
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/addCustomer")
	public CustomerDetails addCustomer(@RequestBody CustomerDetails customer) {
		return this.customerService.addCustomer(customer);
	}
	@PutMapping("/updateCustomer")
	public boolean updateCustomer(@RequestBody CustomerDetails customer) {
		if(this.customerService.updateCustomer(customer))
			return true;
		return false;
	}
	@DeleteMapping("/deleteCustomer/{customerId}")
	public void deleteEmployee(@PathVariable Integer customerId) {
		this.customerService.deleteCustomer(customerId);
	}

}
