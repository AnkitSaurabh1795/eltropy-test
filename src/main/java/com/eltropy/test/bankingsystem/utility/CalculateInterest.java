package com.eltropy.test.bankingsystem.utility;

public class CalculateInterest {

	public Integer interestCalculator(Integer principal,Integer n,double rate,Integer time) {
		double ratef =  (rate/100.0);
		double interest = Math.pow((1 + (ratef/n)), rate*time);
		Integer Amount = (int) (principal * interest);
		return Amount;
	}

}
