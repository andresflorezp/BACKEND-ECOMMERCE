package com.payu.ecommerce.utils;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class Order {

	private String accountId;
	private String referenceCode;
	private String description;
	private String language;
	private AdditionalValues additionalValues;

	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	public Order(String accountId, String referenceCode, String description, String language,
			AdditionalValues additionalValues) {
		super();
		this.accountId = accountId;
		this.referenceCode = referenceCode;
		this.description = description;
		this.language = language;
		this.additionalValues = additionalValues;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getReferenceCode() {
		return referenceCode;
	}

	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public AdditionalValues getAdditionalValues() {
		return additionalValues;
	}

	public void setAdditionalValues(AdditionalValues additionalValues) {
		this.additionalValues = additionalValues;
	}


	@Override
	public String toString() {
		return new ToStringBuilder(this).append("accountId", accountId).append("referenceCode", referenceCode)
				.append("description", description).append("language", language)
				.append("additionalValues", additionalValues)
				.toString();
	}

}