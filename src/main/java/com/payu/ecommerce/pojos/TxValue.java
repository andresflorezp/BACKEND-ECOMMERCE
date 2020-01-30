/**
 * PayU Latam - Copyright (c) 2013 - 2018
 * http://www.payu.com.co
 * Date: 30/01/2020
 */
package com.payu.ecommerce.pojos;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The Class TxValue.
 *
 * @author <a href="andres.florez@payulatam.com">Andres Florez</a>
 * @version 0.0.1
 * @since 0.0.1
 */

public class TxValue {

	/**
	 * 
	 */
	private Integer value;
	/**
	 * 
	 */
	private String currency;

	/**
	 * 
	 */
	public TxValue() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param value
	 * @param currency
	 */
	public TxValue(Integer value, String currency) {
		super();
		this.value = value;
		this.currency = currency;
	}

	/**
	 * @return
	 */
	public Integer getValue() {
		return value;
	}

	/**
	 * @param value
	 */
	public void setValue(Integer value) {
		this.value = value;
	}

	/**
	 * @return
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("value", value).append("currency", currency).toString();
	}

}