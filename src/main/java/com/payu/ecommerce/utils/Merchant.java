package com.payu.ecommerce.utils;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class Merchant {

	private String apiLogin;
	private String apiKey;
	
	public Merchant() {
		// TODO Auto-generated constructor stub
	}

	public Merchant(String apiLogin, String apiKey) {
		super();
		this.apiLogin = apiLogin;
		this.apiKey = apiKey;
	}

	public String getApiLogin() {
		return apiLogin;
	}

	public void setApiLogin(String apiLogin) {
		this.apiLogin = apiLogin;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}



	@Override
	public String toString() {
		return new ToStringBuilder(this).append("apiLogin", apiLogin).append("apiKey", apiKey)
				.toString();
	}

}