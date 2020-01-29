package com.payu.ecommerce.utils;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class TX_VALUE {

	private Integer value;
	private String currency;

	public TX_VALUE() {
		// TODO Auto-generated constructor stub
	}
	public TX_VALUE(Integer value, String currency) {
		super();
		this.value = value;
		this.currency = currency;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}


	@Override
	public String toString() {
		return new ToStringBuilder(this).append("value", value).append("currency", currency)
				.toString();
	}

}