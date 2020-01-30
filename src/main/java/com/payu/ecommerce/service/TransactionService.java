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
import com.google.gson.JsonObject;
import com.payu.ecommerce.model.Transaction;
import com.payu.ecommerce.repository.TransactionRepository;
import com.payu.ecommerce.utils.AdditionalValues;
import com.payu.ecommerce.utils.CreditCard;
import com.payu.ecommerce.utils.Merchant;
import com.payu.ecommerce.utils.Order;
import com.payu.ecommerce.utils.Payer;
import com.payu.ecommerce.utils.RequestTransaction;
import com.payu.ecommerce.utils.TX_VALUE;
import com.payu.ecommerce.utils.TransactionJson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

@Service
public class TransactionService {
	private static final String ALPHA_NUMERIC_STRING = "123456789";
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
	
	public List<Transaction> allTransactions(){
		List<Transaction> transactions = new ArrayList();
		for(Transaction t : transactionRepository.findAll()) {
			transactions.add(t);
		}
		return transactions;
	}
	
	
	
	public String generarResponse(String name, String email, Double valor) {
		TX_VALUE tXVALUE = new TX_VALUE(2000, "COP");
		AdditionalValues additionalValues = new AdditionalValues(tXVALUE);
		Order order = new Order("1", "TestPayu", "payment test", "es", additionalValues);
		Payer payer = new Payer("1", name, "payer_test@test.com", "3877942", "5415668464654");
		CreditCard creditCard = new CreditCard("4097440000000004", "321", "2024/12", name);
		Merchant merchant = new  Merchant("012345678901", "012345678901");
		com.payu.ecommerce.utils.Transaction transaction = new com.payu.ecommerce.utils.Transaction(order, payer, creditCard, "AUTHORIZATION_AND_CAPTURE", "VISA");
		RequestTransaction requestTransaction = new  RequestTransaction("es", "SUBMIT_TRANSACTION", merchant, transaction, false);
		final String uri = "https://sandbox.api.payulatam.com/payments-api/4.0/service.cgi";
	     
		Gson gson = new Gson();
	    RestTemplate restTemplate = new RestTemplate();
	    String JSON = gson.toJson(requestTransaction);
	    System.out.println(JSON);
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);  
	    headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
	 
	    HttpEntity<String> entity = new HttpEntity<>(JSON, headers);
	     
	    ResponseEntity<String> e = restTemplate.postForEntity(uri, entity, String.class);
	     
	    //System.out.println(e);
	    JSONObject jsonObject = new JSONObject(e.getBody());
	    System.out.println(jsonObject.toString());
	    System.out.println("DEBERIA IMPRIMIR");
	    System.out.println(jsonObject.getJSONObject("transactionResponse").get("state"));
	    System.out.println("Paso por la parte del estado");
	    String state= jsonObject.getJSONObject("transactionResponse").get("state").toString();
	    String numeroOrden= jsonObject.getJSONObject("transactionResponse").get("orderId").toString();
	    //System.out.println(jsonObject.getJSONObject("transactionResponse").getString("responseCode"));
	    transactionRepository.save(new Transaction( name, state, numeroOrden, valor));
	    return state;
		
		
		
	}
	
	
}
