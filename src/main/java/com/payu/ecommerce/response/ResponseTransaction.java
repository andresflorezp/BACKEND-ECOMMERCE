package com.payu.ecommerce.response;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ResponseTransaction {

	private String code;
	private TransactionResponse transactionResponse;
	private Object error;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public ResponseTransaction() {
	}

	/**
	 *
	 * @param code
	 * @param transactionResponse
	 * @param error
	 */
	public ResponseTransaction(String code, TransactionResponse transactionResponse, Object error) {
		super();
		this.code = code;
		this.transactionResponse = transactionResponse;
		this.error = error;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public TransactionResponse getTransactionResponse() {
		return transactionResponse;
	}

	public void setTransactionResponse(TransactionResponse transactionResponse) {
		this.transactionResponse = transactionResponse;
	}

	public Object getError() {
		return error;
	}

	public void setError(Object error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("code", code).append("transactionResponse", transactionResponse).append("error", error).toString();
	}

}