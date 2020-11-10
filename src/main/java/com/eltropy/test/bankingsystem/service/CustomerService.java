package com.eltropy.test.bankingsystem.service;

import com.eltropy.test.bankingsystem.pojo.CustomerDetails;

public interface CustomerService {
	CustomerDetails addCustomer(CustomerDetails customer);
	void deleteCustomer(Integer customerId);
	boolean updateCustomer(CustomerDetails customer);
}
