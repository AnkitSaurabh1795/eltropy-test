package com.eltropy.test.bankingsystem.employeeprofile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eltropy.test.bankingsystem.pojo.UserDetails;
import com.eltropy.test.bankingsystem.service.EmployeeService;

@RestController
@RequestMapping("/users")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/addEmployee")
	@PreAuthorize("hasRole('ADMIN')")
	public UserDetails addEmployee(@RequestBody UserDetails user) {
		return this.employeeService.addEmployee(user);
	}
	@DeleteMapping("/deleteEmployee/{userId}")
	public void deleteEmployee(@PathVariable Integer userId) {
		this.employeeService.deleteEmployee(userId);
	}
}
