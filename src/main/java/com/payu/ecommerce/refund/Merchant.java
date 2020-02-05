package com.payu.ecommerce.refund;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Merchant {

	private String apiKey;
	private String apiLogin;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Merchant() {
	}

	/**
	 *
	 * @param apiKey
	 * @param apiLogin
	 */
	public Merchant(String apiKey, String apiLogin) {
		super();
		this.apiKey = apiKey;
		this.apiLogin = apiLogin;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getApiLogin() {
		return apiLogin;
	}

	public void setApiLogin(String apiLogin) {
		this.apiLogin = apiLogin;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("apiKey", apiKey).append("apiLogin", apiLogin).toString();
	}

}