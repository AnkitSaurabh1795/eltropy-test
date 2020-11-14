package com.eltropy.test.bankingsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Account,Integer>{
	Account findByTransactionid(Integer transactionid);
}
