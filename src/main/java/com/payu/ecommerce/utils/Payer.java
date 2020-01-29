package com.payu.ecommerce.utils;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class Payer {

	private String merchantPayerId;
	private String fullName;
	private String emailAddress;
	private String contactPhone;
	private String dniNumber;
	
	
	public Payer(String merchantPayerId, String fullName, String emailAddress, String contactPhone, String dniNumber) {
		super();
		this.merchantPayerId = merchantPayerId;
		this.fullName = fullName;
		this.emailAddress = emailAddress;
		this.contactPhone = contactPhone;
		this.dniNumber = dniNumber;
	}

	public Payer() {
		// TODO Auto-generated constructor stub
	}

	public String getMerchantPayerId() {
		return merchantPayerId;
	}

	public void setMerchantPayerId(String merchantPayerId) {
		this.merchantPayerId = merchantPayerId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getDniNumber() {
		return dniNumber;
	}

	public void setDniNumber(String dniNumber) {
		this.dniNumber = dniNumber;
	}

	

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("merchantPayerId", merchantPayerId).append("fullName", fullName)
				.append("emailAddress", emailAddress).append("contactPhone", contactPhone)
				.append("dniNumber", dniNumber).toString();
	}

}