/**
 * PayU Latam - Copyright (c) 2013 - 2018
 * http://www.payu.com.co
 * Date: 30/01/2020
 */
package com.payu.ecommerce.pojo;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The Class RequestTransaction.
 *
 * @author <a href="andres.florez@payulatam.com">Andres Florez</a>
 * @version 0.0.1
 * @since 0.0.1
 */


public class RequestTransaction {

	/**
	 * The language
	 */
	private String language;

	/**
	 * The command
	 */
	private String command;

	/**
	 * The merchant
	 */
	private Merchant merchant;

	/**
	 * The transaction
	 */
	private Transaction transaction;

	/**
	 * The test
	 */
	private Boolean test;

	/**
	 * @param language
	 * @param command
	 * @param merchant
	 * @param transaction
	 * @param test
	 */
	public RequestTransaction(String language, String command, Merchant merchant, Transaction transaction,
			Boolean test) {
		super();
		this.language = language;
		this.command = command;
		this.merchant = merchant;
		this.transaction = transaction;
		this.test = test;
	}

	/**
	 * 
	 */
	public RequestTransaction() {
		// TODO Auto-generated constructor stub
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
	public String getCommand() {
		return command;
	}

	/**
	 * @param command
	 */
	public void setCommand(String command) {
		this.command = command;
	}

	/**
	 * @return
	 */
	public Merchant getMerchant() {
		return merchant;
	}

	/**
	 * @param merchant
	 */
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	/**
	 * @return
	 */
	public Transaction getTransaction() {
		return transaction;
	}

	/**
	 * @param transaction
	 */
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	/**
	 * @return
	 */
	public Boolean getTest() {
		return test;
	}

	/**
	 * @param test
	 */
	public void setTest(Boolean test) {
		this.test = test;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("language", language).append("command", command)
				.append("merchant", merchant).append("transaction", transaction).append("test", test).toString();
	}

}