package com.eltropy.test.bankingsystem.pojo;

import java.util.Date;

public class TransactionDetails {
	private Integer transactionid;
	private Integer fromaccount;
	private Integer toaccount;
	private Integer amount;
	private String date;
	public String getDate() {
		return date;
	}
	public void setDate(String currentdate) {
		this.date = currentdate;
	}
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
