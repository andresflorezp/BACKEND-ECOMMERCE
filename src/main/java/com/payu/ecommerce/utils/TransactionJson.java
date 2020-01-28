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
		    "\"language\": \"es\",\n" +
		    "\"command\": \"SUBMIT_TRANSACTION\",\n"+
		    "\"merchant\": {" +
		      "\"apiLogin\": \"012345678901\",\n"+
		      "\"apiKey\": \"012345678901\"\n"+ 
		    "},\n"+
			"\"transaction\": {\n"+
		      "\"order\": {\n"+
		         "\"accountId\":"+'"' +accountId+ '"' +",\n"+ 
		         "\"referenceCode\":"+'"'+referenceCode+'"' +",\n"+ 
		         "\"description\": \"payment test\",\n"+ 
		         "\"language\": \"es\",\n"+ 
		         "\"additionalValues\": {\n"+
		            "\"TX_VALUE\": {\n"+
		               "\"value\": 20000,\n"+ 
		               "\"currency\": \"COP\"\n"+
		         "}\n"+
		       "}\n"+
		      "},\n"+
		      "\"payer\": {\n" +
		         "\"merchantPayerId\":"+'"'+PAYER_merchantPayerId+'"'+",\n"+ 
		         "\"fullName\":"+'"'+PAYER_fullName+'"'+",\n"+
		         "\"emailAddress\":"+'"'+emailAddress+'"'+",\n"+
		         "\"contactPhone\": \"7563126\",\n"+
		         "\"dniNumber\": \"5415668464654\"\n"+ 
		      "},\n"+
		      "\"creditCard\": {\n"+
		         "\"number\": \"4097440000000004\",\n"+ 
		         "\"securityCode\": \"321\",\n"+
		         "\"expirationDate\": \"2024/12\",\n"+
		         "\"name\":"+'"'+CREDITCARD_name+'"'+"\n"+
		      "},\n"+
		      "\"extraParameters\": {\n"+
		         "\"INSTALLMENTS_NUMBER\": 1\n"+
		      "},\n"+
		      "\"type\":\"AUTHORIZATION_AND_CAPTURE\",\n" + 
		      "\"paymentMethod\": \"VISA\"\n"+
		   "},\n"+
		   "\"test\": false\n"+ 
		"}";
	}
	
	
	
	
	
	

}
