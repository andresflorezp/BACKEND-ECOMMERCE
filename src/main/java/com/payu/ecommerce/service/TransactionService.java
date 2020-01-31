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
import com.payu.ecommerce.pojo.AdditionalValues;
import com.payu.ecommerce.pojo.CreditCard;
import com.payu.ecommerce.pojo.Merchant;
import com.payu.ecommerce.pojo.Order;
import com.payu.ecommerce.pojo.Payer;
import com.payu.ecommerce.pojo.RequestTransaction;
import com.payu.ecommerce.pojo.TxValue;
import com.payu.ecommerce.repository.TransactionRepository;
import com.payu.ecommerce.utils.TransactionJson;

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

	@Autowired
	TransactionRepository transactionRepository;
	

	/**
	 * The all transactions
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
	 * This function allows you to connect to the payment api and obtain the indicated values of the transaction
	 * @param name
	 * @param email
	 * @param valor
	 * @return
	 */
	public String generarResponse(String name, String email, Double valor, String card,String cvv, String expirationDate) {
		TransactionJson transactionJson = new TransactionJson(name, email, valor, card, cvv, expirationDate);
		Gson gson = new Gson();
	    RestTemplate restTemplate = new RestTemplate();
	    String JSON = gson.toJson(transactionJson.request());
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);  
	    headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
	 
	    HttpEntity<String> entity = new HttpEntity<>(JSON, headers);
	     
	    ResponseEntity<String> e = restTemplate.postForEntity(TransactionJson.uri, entity, String.class);
	     
	    JSONObject jsonObject = new JSONObject(e.getBody());
	    System.out.println(jsonObject.toString());
	    String state= jsonObject.getJSONObject("transactionResponse").get("state").toString();
	    String numeroOrden= jsonObject.getJSONObject("transactionResponse").get("orderId").toString();
	    transactionRepository.save(new Transaction( name, state, numeroOrden, valor));
	    return state;
		
		
		
	}
	
	
}
