/**
 * PayU Latam - Copyright (c) 2013 - 2018
 * http://www.payu.com.co
 * Date: 30/01/2020
 */
package com.payu.ecommerce.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;
import com.payu.ecommerce.model.Transaction;
import com.payu.ecommerce.pojos.AdditionalValues;
import com.payu.ecommerce.pojos.CreditCard;
import com.payu.ecommerce.pojos.Merchant;
import com.payu.ecommerce.pojos.Order;
import com.payu.ecommerce.pojos.Payer;
import com.payu.ecommerce.pojos.RequestTransaction;
import com.payu.ecommerce.pojos.TxValue;
import com.payu.ecommerce.repository.TransactionRepository;

import java.util.*;

/**
 * The Class TransactionService.
 *
 * @author <a href="andres.florez@payulatam.com">Andres Florez</a>
 * @version 0.0.1
 * @since 0.0.1
 */


@Service
public class TransactionService {
	private static final String ALPHA_NUMERIC_STRING = "123456789";
	/**
	 * 
	 */
	@Autowired
	TransactionRepository transactionRepository;
	
	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
	
	/**
	 * @return
	 */
	public List<Transaction> allTransactions(){
		List<Transaction> transactions = new ArrayList<Transaction>();
		for(Transaction t : transactionRepository.findAll()) {
			transactions.add(t);
		}
		return transactions;
	}
	
	
	
	/**
	 * @param name
	 * @param email
	 * @param valor
	 * @return
	 */
	public String generarResponse(String name, String email, Double valor) {
		TxValue tXVALUE = new TxValue(2000, "COP");
		AdditionalValues additionalValues = new AdditionalValues(tXVALUE);
		Order order = new Order("1", "TestPayu", "payment test", "es", additionalValues);
		Payer payer = new Payer("1", name, "payer_test@test.com", "3877942", "5415668464654");
		CreditCard creditCard = new CreditCard("4097440000000004", "321", "2024/12", name);
		Merchant merchant = new  Merchant("012345678901", "012345678901");
		com.payu.ecommerce.pojos.Transaction transaction = new com.payu.ecommerce.pojos.Transaction(order, payer, creditCard, "AUTHORIZATION_AND_CAPTURE", "VISA");
		RequestTransaction requestTransaction = new  RequestTransaction("es", "SUBMIT_TRANSACTION", merchant, transaction, false);
		final String uri = "https://sandbox.api.payulatam.com/payments-api/4.0/service.cgi";
	     
		Gson gson = new Gson();
	    RestTemplate restTemplate = new RestTemplate();
	    String JSON = gson.toJson(requestTransaction);
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);  
	    headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
	 
	    HttpEntity<String> entity = new HttpEntity<>(JSON, headers);
	     
	    ResponseEntity<String> e = restTemplate.postForEntity(uri, entity, String.class);
	     
	    JSONObject jsonObject = new JSONObject(e.getBody());
	    String state= jsonObject.getJSONObject("transactionResponse").get("state").toString();
	    String numeroOrden= jsonObject.getJSONObject("transactionResponse").get("orderId").toString();
	    transactionRepository.save(new Transaction( name, state, numeroOrden, valor));
	    return state;
		
		
		
	}
	
	
}
