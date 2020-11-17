package com.eltropy.test.bankingsystem.repo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer transactionid;
	private Integer fromaccount;
	private Integer toaccount;
	private Integer amount;
	public Integer getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(Integer transactionid) {
		this.transactionid = transactionid;
	}
	public Integer getFromaccount() {
		return fromaccount;
	}
	public void setFromaccount(Integer fromaccount) {
		this.fromaccount = fromaccount;
	}
	public Integer getToaccount() {
		return toaccount;
	}
	public void setToaccount(Integer toaccount) {
		this.toaccount = toaccount;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}
