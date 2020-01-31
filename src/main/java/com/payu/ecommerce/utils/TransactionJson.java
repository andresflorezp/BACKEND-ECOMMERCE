/**
 * PayU Latam - Copyright (c) 2013 - 2018
 * http://www.payu.com.co
 * Date: 30/01/2020
 */
package com.payu.ecommerce.utils;

import com.payu.ecommerce.pojo.AdditionalValues;
import com.payu.ecommerce.pojo.CreditCard;
import com.payu.ecommerce.pojo.Merchant;
import com.payu.ecommerce.pojo.Order;
import com.payu.ecommerce.pojo.Payer;
import com.payu.ecommerce.pojo.RequestTransaction;
import com.payu.ecommerce.pojo.TxValue;

/**
 * The Class TransactionJson.
 *
 * @author <a href="andres.florez@payulatam.com">Andres Florez</a>
 * @version 0.0.1
 * @since 0.0.1
 */

public class TransactionJson {
	private static final Double TX_VALUE_VALUE = 2000.0;
	private static final String CURRENCY = "COP";
	private static final String ORDER_NUMBER = "1";
	private static final String DESCRIPTION_ORDER = "payment test";
	private static final String LANGUAGE = "es";
	private static final String PAYER_NUMBER = "1";
	private static final String CONTACT_NUMBER = "3877942";
	private static final String DNI_NUMBER = "5415668464654";
	private static final String MERCHANT_API_LOGIN = "012345678901";
	private static final String MERCHANT_API_KEY = "012345678901";
	private static final String TYPE = "AUTHORIZATION_AND_CAPTURE";
	private static final String PAYMENT_METHOD = "VISA";
	private static final String COMMAND = "SUBMIT_TRANSACTION";
	private static final String REFERENCE_CODE = "TestPayu";
	private static final String EXPIRATION_DATE = "2024/12";
	
	private String dniNumber;
	
	public final static String uri = "https://sandbox.api.payulatam.com/payments-api/4.0/service.cgi";
	private String name;
	private String email;
	private Double valor;
	private String card;
	private String cvv;
	private String expirationDate;
	
	
	
	/**
	 * @param name
	 * @param email
	 * @param valor
	 * @param card
	 * @param cvv
	 * @param expirationDate
	 */
	public TransactionJson(String name, String email, Double valor, String card, String cvv, String expirationDate) {
		super();
		this.name = name;
		this.email = email;
		this.valor = valor;
		this.card = card;
		this.cvv = cvv;
		this.expirationDate = expirationDate;
	}



	/**
	 * This function allows to create the request with the instance to map the payments api
	 * @return
	 */
	public RequestTransaction request() {
		
		TxValue tXVALUE = new TxValue(TX_VALUE_VALUE.intValue(), CURRENCY);
		AdditionalValues additionalValues = new AdditionalValues(tXVALUE);
		Order order = new Order(ORDER_NUMBER, REFERENCE_CODE, DESCRIPTION_ORDER, LANGUAGE, additionalValues);
		Payer payer = new Payer(PAYER_NUMBER, name, email, CONTACT_NUMBER, DNI_NUMBER);
		CreditCard creditCard = new CreditCard(card, cvv, EXPIRATION_DATE, name);
		Merchant merchant = new  Merchant(MERCHANT_API_LOGIN, MERCHANT_API_KEY);
		com.payu.ecommerce.pojo.Transaction transaction = new com.payu.ecommerce.pojo.Transaction(order, payer, creditCard, TYPE, PAYMENT_METHOD);
		RequestTransaction requestTransaction = new  RequestTransaction(LANGUAGE, COMMAND, merchant, transaction, false);
		return requestTransaction;
		
		
	}

}
