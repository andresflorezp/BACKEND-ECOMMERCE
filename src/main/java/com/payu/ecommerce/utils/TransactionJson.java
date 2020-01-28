package com.payu.ecommerce.utils;

public class TransactionJson {
	private final String language = "es";
	private final String command = "SUBMIT_TRANSACTION";
	private final String apiLogin = "012345678901";
	private final String apiKey = "012345678901";
	private String accountId;
	private String referenceCode;
	private final String descriptionTransaction = "TestPayu";
	private final String languageTransaction = "es";
	private final Double TX_VALUE_value = 2000.0;
	private final  String TX_VALUE_currency = "COP";
	private String PAYER_merchantPayerId;
	private String PAYER_fullName;
	private String emailAddress;
	private final String contactPhone = "7563126";
	private final String dniNumber = "5415668464654";
	private final String CREDITCARD_number = "4097440000000004";
	private final String CREDITCARD_securityCode = "321";
	private final String CREDITCARD_expirationDate = "2024/12";
	private String CREDITCARD_name;
	private final Integer INSTALLMENTS_NUMBER = 1;
	private final String typeTransaction = "AUTHORIZATION_AND_CAPTURE";
	private final String paymentMethodTransaction = "VISA";
	private final boolean test = false;
	
	public TransactionJson(String accountId, String referenceCode, String pAYER_merchantPayerId, String pAYER_fullName,
			String emailAddress, String cREDITCARD_name) {
		super();
		this.accountId = accountId;
		this.referenceCode = referenceCode;
		PAYER_merchantPayerId = pAYER_merchantPayerId;
		PAYER_fullName = pAYER_fullName;
		this.emailAddress = emailAddress;
		CREDITCARD_name = cREDITCARD_name;
	}
	
	public String generateJson() {

		return "{"+
		    "\"language\": \"es\", " +
		    "\"command\": \"SUBMIT_TRANSACTION\","+
		    "\"merchant\": {" +
		      "\"apiLogin\": \"012345678901\","+
		      "\"apiKey\": \"012345678901\""+ 
		    "},"+
			"\"transaction\": {"+
		      "\"order\": {"+
		         "\"accountId\":"+'"' +accountId+ '"' +","+ 
		         "\"referenceCode\":"+'"'+referenceCode+'"' +","+ 
		         "\"description\": \"payment test\","+ 
		         "\"language\": \"es\","+ 
		         "\"additionalValues\": {"+
		            "\"TX_VALUE\": {"+
		               "\"value\": 20000,"+ 
		               "\"currency\": \"COP\""+
		         "}"+
		       "}"+
		      "},"+
		      "\"payer\": {" +
		         "\"merchantPayerId\":"+'"'+PAYER_merchantPayerId+'"'+","+ 
		         "\"fullName\":"+'"'+PAYER_fullName+'"'+","+
		         "\"emailAddress\":"+'"'+emailAddress+'"'+","+
		         "\"contactPhone\": \"7563126\","+
		         "\"dniNumber\": \"5415668464654\""+ 
		      "},"+
		      "\"creditCard\": {"+
		         "\"number\": \"4097440000000004\","+ 
		         "\"securityCode\": \"321\","+
		         "\"expirationDate\": \"2024/12\","+
		         "\"name\":"+'"'+CREDITCARD_name+'"'+
		      "},"+
		      "\"extraParameters\": {"+
		         "\"INSTALLMENTS_NUMBER\": 1"+
		      "},"+
		      "\"type\":\"AUTHORIZATION_AND_CAPTURE\"," + 
		      "\"paymentMethod\": \"VISA\""+
		   "},"+
		   "\"test\": false"+ 
		"}";
	}
	
	
	
	
	
	

}
