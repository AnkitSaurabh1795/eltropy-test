package com.eltropy.test.bankingsystem.customerprofile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	@PreAuthorize("hasRole('EMPLOYEE')")
	public CustomerDetails addCustomer(@RequestBody CustomerDetails customer) {
		return this.customerService.addCustomer(customer);
	}
	@PutMapping("/updateCustomer")
	@PreAuthorize("hasRole('EMPLOYEE')")
	public boolean updateCustomer(@RequestBody CustomerDetails customer) {
		if(this.customerService.updateCustomer(customer))
			return true;
		return false;
	}
	@GetMapping("/getCustomerDetails/{customerId}")
	@PreAuthorize("hasRole('EMPLOYEE')")
	public CustomerDetails getCustomerDetails(@PathVariable  Integer customerId) {
		return customerService.getCustomerDetails(customerId);
	}
	@DeleteMapping("/deleteCustomer/{customerId}")
	@PreAuthorize("hasRole('EMPLOYEE')")
	public void deleteEmployee(@PathVariable Integer customerId) {
		this.customerService.deleteCustomer(customerId);
	}

}
