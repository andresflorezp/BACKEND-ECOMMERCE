package com.payu.ecommerce.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "responsetransaction")

public class ResponseTransaction implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private String code;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private TransactionResponse transactionResponse;

	private String error;

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
	public ResponseTransaction(String code, TransactionResponse transactionResponse, String error) {
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

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("code", code).append("transactionResponse", transactionResponse).append("error", error).toString();
	}

}