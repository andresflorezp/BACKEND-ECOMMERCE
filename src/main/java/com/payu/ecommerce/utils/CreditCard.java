package com.payu.ecommerce.utils;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class CreditCard {

	private String number;
	private String securityCode;
	private String expirationDate;
	private String name;

	public CreditCard() {
		// TODO Auto-generated constructor stub
	}

	public CreditCard(String number, String securityCode, String expirationDate, String name) {
		super();
		this.number = number;
		this.securityCode = securityCode;
		this.expirationDate = expirationDate;
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("number", number).append("securityCode", securityCode)
				.append("expirationDate", expirationDate).append("name", name)
				.toString();
	}

}