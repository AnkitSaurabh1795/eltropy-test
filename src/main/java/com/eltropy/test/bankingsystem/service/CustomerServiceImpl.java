package com.eltropy.test.bankingsystem.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eltropy.test.bankingsystem.pojo.CustomerDetails;
import com.eltropy.test.bankingsystem.repo.Customer;
import com.eltropy.test.bankingsystem.repo.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public CustomerDetails addCustomer(CustomerDetails customer) {
		// TODO Auto-generated method stub
		Customer  customer1 = customerRepository.save(this.beanToEntity(customer));
		customer.setCustomerid(customer1.getCustomerid());
		return customer;
	}
	@Override
	public boolean updateCustomer(CustomerDetails customer1) {
		// TODO Auto-generated method stub
		Customer  customer = customerRepository.findOne(customer1.getCustomerid());
		if(customer == null) {
			throw new RuntimeException("Customer Id not find");
		}
		if(customer1.getKycinfo() != null)
			customer.setKycinfo(customer1.getKycinfo());
		if(customer1.getEmailid() != null)
			customer.setEmailid(customer1.getEmailid());
		if(customer1.getPhonenumber() != null)
			customer.setPhonenumber(customer1.getPhonenumber());
		customer = this.customerRepository.save(customer);
		if(customer == null)
			return false;
		return true;
	}
	@Override
	public void deleteCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		Customer  customer = customerRepository.findOne(customerId);
		if(customer == null) {
			throw new RuntimeException("Customer Id not find");
		}
		this.customerRepository.save(customer);
	}
	public CustomerDetails entityToBean(Customer entity) {
		CustomerDetails customer = new CustomerDetails();
		BeanUtils.copyProperties(entity, customer);
		return customer;
	}

	public Customer beanToEntity(CustomerDetails customer) {
		Customer customer1 = new Customer();
		BeanUtils.copyProperties(customer, customer1);
		return customer1;
	}
}
