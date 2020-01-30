/**
 * PayU Latam - Copyright (c) 2013 - 2018
 * http://www.payu.com.co
 * Date: 30/01/2020
 */
package com.payu.ecommerce.pojos;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The Class Payer.
 *
 * @author <a href="andres.florez@payulatam.com">Andres Florez</a>
 * @version 0.0.1
 * @since 0.0.1
 */


public class Payer {

	/**
	 * 
	 */
	private String merchantPayerId;
	/**
	 * 
	 */
	private String fullName;
	/**
	 * 
	 */
	private String emailAddress;
	/**
	 * 
	 */
	private String contactPhone;
	/**
	 * 
	 */
	private String dniNumber;

	/**
	 * @param merchantPayerId
	 * @param fullName
	 * @param emailAddress
	 * @param contactPhone
	 * @param dniNumber
	 */
	public Payer(String merchantPayerId, String fullName, String emailAddress, String contactPhone, String dniNumber) {
		super();
		this.merchantPayerId = merchantPayerId;
		this.fullName = fullName;
		this.emailAddress = emailAddress;
		this.contactPhone = contactPhone;
		this.dniNumber = dniNumber;
	}

	/**
	 * 
	 */
	public Payer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return
	 */
	public String getMerchantPayerId() {
		return merchantPayerId;
	}

	/**
	 * @param merchantPayerId
	 */
	public void setMerchantPayerId(String merchantPayerId) {
		this.merchantPayerId = merchantPayerId;
	}

	/**
	 * @return
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return
	 */
	public String getContactPhone() {
		return contactPhone;
	}

	/**
	 * @param contactPhone
	 */
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	/**
	 * @return
	 */
	public String getDniNumber() {
		return dniNumber;
	}

	/**
	 * @param dniNumber
	 */
	public void setDniNumber(String dniNumber) {
		this.dniNumber = dniNumber;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("merchantPayerId", merchantPayerId).append("fullName", fullName)
				.append("emailAddress", emailAddress).append("contactPhone", contactPhone)
				.append("dniNumber", dniNumber).toString();
	}

}