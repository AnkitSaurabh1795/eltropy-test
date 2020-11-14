package com.eltropy.test.bankingsystem.repo;

public class Transaction {
	private Integer transactionid;
	private Integer fromaccount;
	private String toaccount;
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
	public String getToaccount() {
		return toaccount;
	}
	public void setToaccount(String toaccount) {
		this.toaccount = toaccount;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}
