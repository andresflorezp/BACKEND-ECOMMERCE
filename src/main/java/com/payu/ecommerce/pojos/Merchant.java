/**
 * PayU Latam - Copyright (c) 2013 - 2018
 * http://www.payu.com.co
 * Date: 30/01/2020
 */
package com.payu.ecommerce.pojos;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The Class Merchant.
 *
 * @author <a href="andres.florez@payulatam.com">Andres Florez</a>
 * @version 0.0.1
 * @since 0.0.1
 */


public class Merchant {

	/**
	 * 
	 */
	private String apiLogin;
	/**
	 * 
	 */
	private String apiKey;

	/**
	 * 
	 */
	public Merchant() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param apiLogin
	 * @param apiKey
	 */
	public Merchant(String apiLogin, String apiKey) {
		super();
		this.apiLogin = apiLogin;
		this.apiKey = apiKey;
	}

	/**
	 * @return
	 */
	public String getApiLogin() {
		return apiLogin;
	}

	/**
	 * @param apiLogin
	 */
	public void setApiLogin(String apiLogin) {
		this.apiLogin = apiLogin;
	}

	/**
	 * @return
	 */
	public String getApiKey() {
		return apiKey;
	}

	/**
	 * @param apiKey
	 */
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("apiLogin", apiLogin).append("apiKey", apiKey).toString();
	}

}