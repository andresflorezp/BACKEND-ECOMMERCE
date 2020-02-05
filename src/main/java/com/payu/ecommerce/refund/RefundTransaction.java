package com.payu.ecommerce.refund;

import org.apache.commons.lang.builder.ToStringBuilder;

public class RefundTransaction {

	private String language;
	private String command;
	private Merchant merchant;
	private Transaction transaction;
	private Boolean test;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public RefundTransaction() {
	}

	/**
	 *
	 * @param test
	 * @param merchant
	 * @param language
	 * @param command
	 * @param transaction
	 */
	public RefundTransaction(String language, String command, Merchant merchant, Transaction transaction, Boolean test) {
		super();
		this.language = language;
		this.command = command;
		this.merchant = merchant;
		this.transaction = transaction;
		this.test = test;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public Boolean getTest() {
		return test;
	}

	public void setTest(Boolean test) {
		this.test = test;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("language", language).append("command", command).append("merchant", merchant).append("transaction", transaction).append("test", test).toString();
	}

}