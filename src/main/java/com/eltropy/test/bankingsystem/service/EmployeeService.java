package com.eltropy.test.bankingsystem.service;

import com.eltropy.test.bankingsystem.pojo.UserDetails;

public interface EmployeeService {
	UserDetails addEmployee(UserDetails user);
	void deleteEmployee(Integer user);
}
