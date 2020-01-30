/**
 * PayU Latam - Copyright (c) 2013 - 2018
 * http://www.payu.com.co
 * Date: 30/01/2020
 */
package com.payu.ecommerce.pojos;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The Class CreditCard.
 *
 * @author <a href="andres.florez@payulatam.com">Andres Florez</a>
 * @version 0.0.1
 * @since 0.0.1
 */

public class CreditCard {

	/**
	 * 
	 */
	private String number;
	/**
	 * 
	 */
	private String securityCode;
	/**
	 * 
	 */
	private String expirationDate;
	/**
	 * 
	 */
	private String name;

	public CreditCard() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param number
	 * @param securityCode
	 * @param expirationDate
	 * @param name
	 */
	public CreditCard(String number, String securityCode, String expirationDate, String name) {
		super();
		this.number = number;
		this.securityCode = securityCode;
		this.expirationDate = expirationDate;
		this.name = name;
	}

	/**
	 * @return
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return
	 */
	public String getSecurityCode() {
		return securityCode;
	}

	/**
	 * @param securityCode
	 */
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	/**
	 * @return
	 */
	public String getExpirationDate() {
		return expirationDate;
	}

	/**
	 * @param expirationDate
	 */
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("number", number).append("securityCode", securityCode)
				.append("expirationDate", expirationDate).append("name", name).toString();
	}

}