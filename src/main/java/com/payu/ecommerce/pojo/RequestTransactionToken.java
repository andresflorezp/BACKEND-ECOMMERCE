package com.payu.ecommerce.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestTransactionToken {

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
	@JsonProperty("transaction")
	private TransactionToken transaction;

	/**
	 * The test
	 */
	private Boolean test;

	/**
	 *
	 * @param language
	 * @param command
	 * @param merchant
	 * @param transaction
	 * @param test
	 */
	public RequestTransactionToken(String language, String command, Merchant merchant, TransactionToken transaction,
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
	public RequestTransactionToken() {
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
	 *
	 * @return
	 */
	@JsonProperty("transaction")
	public TransactionToken getTransactionToken() {

		return transaction;
	}

	/**
	 *
	 * @param transactionToken
	 */
	@JsonProperty("transaction")
	public void setTransactionToken(TransactionToken transactionToken) {

		this.transaction = transactionToken;
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
	 * @return The representational String Request Transaction Token
	 */
	@Override public String toString() {

		return "RequestTransactionToken{" +
				"language='" + language + '\'' +
				", command='" + command + '\'' +
				", merchant=" + merchant +
				", transaction=" + transaction +
				", test=" + test +
				'}';
	}
}
