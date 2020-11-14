package com.eltropy.test.bankingsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer>{
	Account findByAccountnumber(Integer accountnumber);

}
