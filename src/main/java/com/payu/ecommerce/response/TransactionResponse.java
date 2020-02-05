package com.payu.ecommerce.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.payu.ecommerce.model.Account;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TransactionResponse")
public class TransactionResponse {
	@Id
	private Long id;
	private String operationDate;
	private String paymentNetworkResponseErrorMessage;
	private String orderId;
	private String authorizationCode;
	private String referenceQuestionnaire;
	private String pendingReason;
	private String errorCode;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private ExtraParameters extraParameters;
	private String transactionDate;
	private String transactionTime;
	private String transactionId;
	private String responseCode;
	private String paymentNetworkResponseCode;
	private String additionalInfo;
	private String state;
	private String responseMessage;
	private String trazabilityCode;

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "response_id")
	private ResponseTransaction responseTransaction;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public TransactionResponse() {
	}

	/**
	 *
	 * @param operationDate
	 * @param paymentNetworkResponseErrorMessage
	 * @param orderId
	 * @param authorizationCode
	 * @param referenceQuestionnaire
	 * @param pendingReason
	 * @param errorCode
	 * @param extraParameters
	 * @param transactionDate
	 * @param transactionTime
	 * @param transactionId
	 * @param responseCode
	 * @param paymentNetworkResponseCode
	 * @param additionalInfo
	 * @param state
	 * @param responseMessage
	 * @param trazabilityCode
	 */
	public TransactionResponse(String operationDate, String paymentNetworkResponseErrorMessage, String orderId, String authorizationCode, String referenceQuestionnaire, String pendingReason, String errorCode, ExtraParameters extraParameters, String transactionDate, String transactionTime, String transactionId, String responseCode, String paymentNetworkResponseCode, String additionalInfo, String state, String responseMessage, String trazabilityCode) {
		super();
		this.operationDate = operationDate;
		this.paymentNetworkResponseErrorMessage = paymentNetworkResponseErrorMessage;
		this.orderId = orderId;
		this.authorizationCode = authorizationCode;
		this.referenceQuestionnaire = referenceQuestionnaire;
		this.pendingReason = pendingReason;
		this.errorCode = errorCode;
		this.extraParameters = extraParameters;
		this.transactionDate = transactionDate;
		this.transactionTime = transactionTime;
		this.transactionId = transactionId;
		this.responseCode = responseCode;
		this.paymentNetworkResponseCode = paymentNetworkResponseCode;
		this.additionalInfo = additionalInfo;
		this.state = state;
		this.responseMessage = responseMessage;
		this.trazabilityCode = trazabilityCode;
	}

	public String getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(String operationDate) {
		this.operationDate = operationDate;
	}

	public String getPaymentNetworkResponseErrorMessage() {
		return paymentNetworkResponseErrorMessage;
	}

	public void setPaymentNetworkResponseErrorMessage(String paymentNetworkResponseErrorMessage) {
		this.paymentNetworkResponseErrorMessage = paymentNetworkResponseErrorMessage;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getAuthorizationCode() {
		return authorizationCode;
	}

	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}

	public String getReferenceQuestionnaire() {
		return referenceQuestionnaire;
	}

	public void setReferenceQuestionnaire(String referenceQuestionnaire) {
		this.referenceQuestionnaire = referenceQuestionnaire;
	}

	public String getPendingReason() {
		return pendingReason;
	}

	public void setPendingReason(String pendingReason) {
		this.pendingReason = pendingReason;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public ExtraParameters getExtraParameters() {
		return extraParameters;
	}

	public void setExtraParameters(ExtraParameters extraParameters) {
		this.extraParameters = extraParameters;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getPaymentNetworkResponseCode() {
		return paymentNetworkResponseCode;
	}

	public void setPaymentNetworkResponseCode(String paymentNetworkResponseCode) {
		this.paymentNetworkResponseCode = paymentNetworkResponseCode;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getTrazabilityCode() {
		return trazabilityCode;
	}

	public void setTrazabilityCode(String trazabilityCode) {
		this.trazabilityCode = trazabilityCode;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("operationDate", operationDate).append("paymentNetworkResponseErrorMessage", paymentNetworkResponseErrorMessage).append("orderId", orderId).append("authorizationCode", authorizationCode).append("referenceQuestionnaire", referenceQuestionnaire).append("pendingReason", pendingReason).append("errorCode", errorCode).append("extraParameters", extraParameters).append("transactionDate", transactionDate).append("transactionTime", transactionTime).append("transactionId", transactionId).append("responseCode", responseCode).append("paymentNetworkResponseCode", paymentNetworkResponseCode).append("additionalInfo", additionalInfo).append("state", state).append("responseMessage", responseMessage).append("trazabilityCode", trazabilityCode).toString();
	}

}
