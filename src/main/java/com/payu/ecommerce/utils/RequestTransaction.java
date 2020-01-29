package com.payu.ecommerce.utils;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class RequestTransaction {

	private String language;
	private String command;
	private Merchant merchant;
	private Transaction transaction;
	private Boolean test;
	
	
	public RequestTransaction(String language, String command, Merchant merchant, Transaction transaction,
			Boolean test) {
		super();
		this.language = language;
		this.command = command;
		this.merchant = merchant;
		this.transaction = transaction;
		this.test = test;
	}
	public RequestTransaction() {
		// TODO Auto-generated constructor stub
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
		return new ToStringBuilder(this).append("language", language).append("command", command)
				.append("merchant", merchant).append("transaction", transaction).append("test", test)
				.toString();
	}

}