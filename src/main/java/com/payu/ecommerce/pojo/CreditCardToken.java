package com.payu.ecommerce.pojo;
/**
 * PayU Latam - Copyright (c) 2020
 * http://www.payu.com.co
 * Date: 30/01/2020
 */

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The Class Credit Card Token.
 *
 * @author <a href="andres.florez@payulatam.com">Andres Florez</a>
 * @version 0.0.1
 * @since 0.0.1
 */
public class CreditCardToken {

	private String payerId;
	private String name;
	private String identificationNumber;
	private String paymentMethod;
	private String number;
	private String expirationDate;

	/**
	 * No args constructor for use in serialization
	 */
	public CreditCardToken() {

	}

	/**
	 * @param number
	 * @param payerId
	 * @param name
	 * @param identificationNumber
	 * @param paymentMethod
	 * @param expirationDate
	 */
	public CreditCardToken(String payerId, String name, String identificationNumber, String paymentMethod,
						   String number, String expirationDate) {

		super();
		this.payerId = payerId;
		this.name = name;
		this.identificationNumber = identificationNumber;
		this.paymentMethod = paymentMethod;
		this.number = number;
		this.expirationDate = expirationDate;
	}

	/**
	 * @return
	 */
	public String getPayerId() {

		return payerId;
	}

	/**
	 * @param payerId
	 */
	public void setPayerId(String payerId) {

		this.payerId = payerId;
	}

	/**
	 * @return
	 */
	public String getName() {

		return name;
	}

	/**
	 *
	 * @param name
	 */
	public void setName(String name) {

		this.name = name;
	}

	/**
	 *
	 * @return
	 */
	public String getIdentificationNumber() {

		return identificationNumber;
	}

	/**
	 *
	 * @param identificationNumber
	 */
	public void setIdentificationNumber(String identificationNumber) {

		this.identificationNumber = identificationNumber;
	}

	/**
	 *
	 * @return
	 */
	public String getPaymentMethod() {

		return paymentMethod;
	}

	/**
	 *
	 * @param paymentMethod
	 */
	public void setPaymentMethod(String paymentMethod) {

		this.paymentMethod = paymentMethod;
	}

	/**
	 *
	 * @return
	 */
	public String getNumber() {

		return number;
	}

	/**
	 *
	 * @param number
	 */
	public void setNumber(String number) {

		this.number = number;
	}

	/**
	 *
	 * @return
	 */
	public String getExpirationDate() {

		return expirationDate;
	}

	/**
	 *
	 * @param expirationDate
	 */
	public void setExpirationDate(String expirationDate) {

		this.expirationDate = expirationDate;
	}

	/**
	 * The representational Credit Card Token String
	 * @return
	 */
	@Override
	public String toString() {

		return new ToStringBuilder(this).append("payerId", payerId).append("name", name)
										.append("identificationNumber", identificationNumber)
										.append("paymentMethod", paymentMethod).append("number", number)
										.append("expirationDate", expirationDate).toString();
	}

}