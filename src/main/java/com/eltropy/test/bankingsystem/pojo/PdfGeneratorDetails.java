package com.eltropy.test.bankingsystem.pojo;

public class PdfGeneratorDetails {
	
	private String fromdate;
	private Integer accountno;
	private String  todate;
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	public void setTodate(String todate) {
		this.todate = todate;
	}
	public Integer getAccountno() {
		return accountno;
	}
	public void setAccountno(Integer accountno) {
		this.accountno = accountno;
	}
	public String getFromdate() {
		return fromdate;
	}
	public String getTodate() {
		return todate;
	}
}
