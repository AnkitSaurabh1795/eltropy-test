package com.eltropy.test.bankingsystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional
public interface TransactionRepository extends JpaRepository<Transaction,Integer>{
	Transaction findByTransactionid(Integer transactionid);
	@Query("SELECT t from Transaction t where (t.fromaccount =:fromaccount OR t.toaccount =:toaccount) and (t.date between :fromdate and :todate)")
	List<Transaction> findByFromaccountOrToaccountAndDate(@Param("fromaccount") Integer fromaccount,@Param("toaccount") Integer toaccount,@Param("fromdate")String fromdate,@Param("todate")String todate);
	
}
