package com.eltropy.test.bankingsystem.pojo;

public class CustomerDetails {
	private Integer customerid;
	private String customername;
	private String emailid;
	private String phonenumber;
	private String kycinfo;
	public Integer getCustomerid() {
		return customerid;
	}
	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getKycinfo() {
		return kycinfo;
	}
	public void setKycinfo(String kycinfo) {
		this.kycinfo = kycinfo;
	}
}
