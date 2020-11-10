package com.eltropy.test.bankingsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	Customer findByCustomerid(Integer customerid);
}
