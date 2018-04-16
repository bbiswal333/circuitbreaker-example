package com.circuitbreaker.example;

import java.math.BigDecimal;

public class Tax {

	private BigDecimal taxAmount;
	private double taxPercentage;
	
	public BigDecimal getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}
	public double getTaxPercentage() {
		return taxPercentage;
	}
	public void setTaxPercentage(double taxPercentage) {
		this.taxPercentage = taxPercentage;
	}
	
	
}
