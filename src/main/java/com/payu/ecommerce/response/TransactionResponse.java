package com.payu.ecommerce.response;

import org.apache.commons.lang.builder.ToStringBuilder;

public class TransactionResponse {

	private Integer operationDate;
	private Object paymentNetworkResponseErrorMessage;
	private Integer orderId;
	private String authorizationCode;
	private Object referenceQuestionnaire;
	private Object pendingReason;
	private Object errorCode;
	private ExtraParameters extraParameters;
	private Object transactionDate;
	private Object transactionTime;
	private String transactionId;
	private String responseCode;
	private String paymentNetworkResponseCode;
	private Object additionalInfo;
	private String state;
	private Object responseMessage;
	private String trazabilityCode;

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
	public TransactionResponse(Integer operationDate, Object paymentNetworkResponseErrorMessage, Integer orderId, String authorizationCode, Object referenceQuestionnaire, Object pendingReason, Object errorCode, ExtraParameters extraParameters, Object transactionDate, Object transactionTime, String transactionId, String responseCode, String paymentNetworkResponseCode, Object additionalInfo, String state, Object responseMessage, String trazabilityCode) {
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

	public Integer getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(Integer operationDate) {
		this.operationDate = operationDate;
	}

	public Object getPaymentNetworkResponseErrorMessage() {
		return paymentNetworkResponseErrorMessage;
	}

	public void setPaymentNetworkResponseErrorMessage(Object paymentNetworkResponseErrorMessage) {
		this.paymentNetworkResponseErrorMessage = paymentNetworkResponseErrorMessage;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getAuthorizationCode() {
		return authorizationCode;
	}

	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}

	public Object getReferenceQuestionnaire() {
		return referenceQuestionnaire;
	}

	public void setReferenceQuestionnaire(Object referenceQuestionnaire) {
		this.referenceQuestionnaire = referenceQuestionnaire;
	}

	public Object getPendingReason() {
		return pendingReason;
	}

	public void setPendingReason(Object pendingReason) {
		this.pendingReason = pendingReason;
	}

	public Object getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Object errorCode) {
		this.errorCode = errorCode;
	}

	public ExtraParameters getExtraParameters() {
		return extraParameters;
	}

	public void setExtraParameters(ExtraParameters extraParameters) {
		this.extraParameters = extraParameters;
	}

	public Object getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Object transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Object getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(Object transactionTime) {
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

	public Object getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(Object additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Object getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(Object responseMessage) {
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
