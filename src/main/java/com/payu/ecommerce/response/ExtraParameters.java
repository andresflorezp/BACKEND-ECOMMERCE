package com.payu.ecommerce.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ExtraParameters")
public class ExtraParameters {
	@Id
	@GeneratedValue
	private Long id;
	@JsonProperty("BANK_REFERENCED_CODE")
	private String bankReferenceCode ;
	@JsonProperty("PAYMENT_WAY_ID")
	private String paymentWayId;

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transactionr")
	private TransactionResponse transactionResponse;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public ExtraParameters() {
	}

	/**
	 *
	 * @param bankReferenceCode
	 * @param paymentWayId
	 */
	public ExtraParameters(String bankReferenceCode, String paymentWayId,Long id, TransactionResponse transactionResponse) {
		super();
		this.bankReferenceCode = bankReferenceCode;
		this.paymentWayId = paymentWayId;
		this.id = id;
		this.transactionResponse = transactionResponse;
	}


	public String getBankReferenceCode() {
		return bankReferenceCode;
	}

	public void setBankReferenceCode(String bankReferenceCode) {
		this.bankReferenceCode = bankReferenceCode;
	}

	public String getPaymentWayId() {
		return paymentWayId;
	}

	public void setPaymentWayId(String paymentWayId) {
		this.paymentWayId = paymentWayId;
	}

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public TransactionResponse getTransactionResponse() {

		return transactionResponse;
	}

	public void setTransactionResponse(TransactionResponse transactionResponse) {

		this.transactionResponse = transactionResponse;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("bankReferenceCode", bankReferenceCode).append("paymentWayId", paymentWayId).toString();
	}

}