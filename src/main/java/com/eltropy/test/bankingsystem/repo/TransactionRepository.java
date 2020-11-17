package com.eltropy.test.bankingsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer>{
	Transaction findByTransactionid(Integer transactionid);
}
