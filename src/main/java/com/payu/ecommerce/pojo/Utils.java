package com.payu.ecommerce.pojo;

public class Utils {
	private  String txValue;
	private  String currency;
	private  String orderNumber;
	private  String descriptionOrder;
	private  String language;
	private  String payerNumber;
	private  String contactNUmber;
	private  String dniNumber;
	private  String merchantApiLogin;
	private  String merchantApiKey;
	private  String type;
	private  String paymentMethod;
	private  String command;
	private  String referenceCode;
	private  String expirationDate;
	private String uri;


	public Utils(){

	}
	public Utils(String txValue, String currency, String orderNumber, String descriptionOrder, String language,
				 String payerNumber, String contactNUmber, String dniNumber, String merchantApiLogin,
				 String merchantApiKey, String type, String paymentMethod, String command, String referenceCode,
				 String expirationDate,String uri) {

		this.txValue = txValue;
		this.currency = currency;
		this.orderNumber = orderNumber;
		this.descriptionOrder = descriptionOrder;
		this.language = language;
		this.payerNumber = payerNumber;
		this.contactNUmber = contactNUmber;
		this.dniNumber = dniNumber;
		this.merchantApiLogin = merchantApiLogin;
		this.merchantApiKey = merchantApiKey;
		this.type = type;
		this.paymentMethod = paymentMethod;
		this.command = command;
		this.referenceCode = referenceCode;
		this.expirationDate = expirationDate;
		this.uri = uri;
	}

	public String getTxValue() {

		return txValue;
	}

	public void setTxValue(String txValue) {

		this.txValue = txValue;
	}

	public String getCurrency() {

		return currency;
	}

	public void setCurrency(String currency) {

		this.currency = currency;
	}

	public String getOrderNumber() {

		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {

		this.orderNumber = orderNumber;
	}

	public String getDescriptionOrder() {

		return descriptionOrder;
	}

	public void setDescriptionOrder(String descriptionOrder) {

		this.descriptionOrder = descriptionOrder;
	}

	public String getLanguage() {

		return language;
	}

	public void setLanguage(String language) {

		this.language = language;
	}

	public String getPayerNumber() {

		return payerNumber;
	}

	public void setPayerNumber(String payerNumber) {

		this.payerNumber = payerNumber;
	}

	public String getContactNUmber() {

		return contactNUmber;
	}

	public void setContactNUmber(String contactNUmber) {

		this.contactNUmber = contactNUmber;
	}

	public String getDniNumber() {

		return dniNumber;
	}

	public void setDniNumber(String dniNumber) {

		this.dniNumber = dniNumber;
	}

	public String getMerchantApiLogin() {

		return merchantApiLogin;
	}

	public void setMerchantApiLogin(String merchantApiLogin) {

		this.merchantApiLogin = merchantApiLogin;
	}

	public String getMerchantApiKey() {

		return merchantApiKey;
	}

	public void setMerchantApiKey(String merchantApiKey) {

		this.merchantApiKey = merchantApiKey;
	}

	public String getType() {

		return type;
	}

	public void setType(String type) {

		this.type = type;
	}

	public String getPaymentMethod() {

		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {

		this.paymentMethod = paymentMethod;
	}

	public String getCommand() {

		return command;
	}

	public void setCommand(String command) {

		this.command = command;
	}

	public String getReferenceCode() {

		return referenceCode;
	}

	public void setReferenceCode(String referenceCode) {

		this.referenceCode = referenceCode;
	}

	public String getExpirationDate() {

		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {

		this.expirationDate = expirationDate;
	}

	public String getUri() {

		return uri;
	}

	public void setUri(String uri) {

		this.uri = uri;
	}

	@Override public String toString() {

		return "Utils{" +
				"txValue='" + txValue + '\'' +
				", currency='" + currency + '\'' +
				", orderNumber='" + orderNumber + '\'' +
				", descriptionOrder='" + descriptionOrder + '\'' +
				", language='" + language + '\'' +
				", payerNumber='" + payerNumber + '\'' +
				", contactNUmber='" + contactNUmber + '\'' +
				", dniNumber='" + dniNumber + '\'' +
				", merchantApiLogin='" + merchantApiLogin + '\'' +
				", merchantApiKey='" + merchantApiKey + '\'' +
				", type='" + type + '\'' +
				", paymentMethod='" + paymentMethod + '\'' +
				", command='" + command + '\'' +
				", referenceCode='" + referenceCode + '\'' +
				", expirationDate='" + expirationDate + '\'' +
				", uri='" + uri + '\'' +
				'}';
	}
}
