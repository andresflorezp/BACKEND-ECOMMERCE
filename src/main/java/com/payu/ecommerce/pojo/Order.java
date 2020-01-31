/**
 * PayU Latam - Copyright (c) 2013 - 2018
 * http://www.payu.com.co
 * Date: 30/01/2020
 */
package com.payu.ecommerce.pojo;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The Class Order.
 *future-payulatamClient
 * @author <a href="andres.florez@payulatam.com">Andres Florez</a>
 * @version 0.0.1
 * @since 0.0.1
 */

public class Order {

	private String accountId;

	private String referenceCode;

	private String description;

	private String language;

	private AdditionalValues additionalValues;

	public Order() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param accountId
	 * @param referenceCode
	 * @param description
	 * @param language
	 * @param additionalValues
	 */
	public Order(String accountId, String referenceCode, String description, String language,
			AdditionalValues additionalValues) {
		super();
		this.accountId = accountId;
		this.referenceCode = referenceCode;
		this.description = description;
		this.language = language;
		this.additionalValues = additionalValues;
	}

	/**
	 * @return
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return
	 */
	public String getReferenceCode() {
		return referenceCode;
	}

	/**
	 * @param referenceCode
	 */
	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}

	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return
	 */
	public AdditionalValues getAdditionalValues() {
		return additionalValues;
	}

	/**
	 * @param additionalValues
	 */
	public void setAdditionalValues(AdditionalValues additionalValues) {
		this.additionalValues = additionalValues;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("accountId", accountId).append("referenceCode", referenceCode)
				.append("description", description).append("language", language)
				.append("additionalValues", additionalValues).toString();
	}

}