package com.payu.ecommerce.utils;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class AdditionalValues {

	private TX_VALUE TX_VALUE;
	
	public AdditionalValues() {
		// TODO Auto-generated constructor stub
	}

	public AdditionalValues(TX_VALUE tXVALUE) {
		super();
		this.TX_VALUE = tXVALUE;
	}

	public TX_VALUE getTXVALUE() {
		return TX_VALUE;
	}

	public void setTXVALUE(TX_VALUE tXVALUE) {
		this.TX_VALUE = tXVALUE;
	}



	@Override
	public String toString() {
		return new ToStringBuilder(this).append("tXVALUE", TX_VALUE)
				.toString();
	}

}