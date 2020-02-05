/**
 * PayU Latam - Copyright (c) 2013 - 2018
 * http://www.payu.com.co
 * Date: 30/01/2020
 */
package com.payu.ecommerce.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.payu.ecommerce.pojo.Utils;
import com.payu.ecommerce.repository.ResponseTransactionRepository;
import com.payu.ecommerce.response.ExtraParameters;
import com.payu.ecommerce.response.ResponseTransaction;
import com.payu.ecommerce.response.TransactionResponse;
import org.json.JSONArray;
import org.json.JSONException;
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

import java.io.IOException;
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

	@Autowired
	TransactionJson transactionJson;

	@Autowired
	ResponseTransactionRepository responseTransactionRepository;

	@Autowired
	Utils util2;



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
	 *
	 * @param name
	 * @param email
	 * @param valor
	 * @return
	 */
	public String doPaymentsAPI(String name, String email, Double valor, String card,String cvv, String expirationDate)
			throws IOException {

		Gson gson = new Gson();
	    RestTemplate restTemplate = new RestTemplate();
	    String JSON = gson.toJson(transactionJson.request(name, email, String.valueOf(valor),card,cvv,expirationDate));
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);  
	    headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
	 
	    HttpEntity<String> entity = new HttpEntity<>(JSON, headers);
	     
	    ResponseEntity<String> e = restTemplate.postForEntity(util2.getUri(), entity, String.class);
	     
	    JSONObject jsonObject = new JSONObject(e.getBody().replaceAll("null","empty"));
		JsonNode jsonNode = convertJsonFormat(jsonObject);
		ObjectMapper mapper = new ObjectMapper();
		ResponseTransaction responseTransaction = mapper.readValue(new TreeTraversingParser(jsonNode),ResponseTransaction.class);


		responseTransaction.setTransactionResponse(buildTransaction(jsonObject));
		responseTransactionRepository.save(responseTransaction);
	    String state= jsonObject.getJSONObject("transactionResponse").get("state").toString();
	    String numeroOrden= jsonObject.getJSONObject("transactionResponse").get("orderId").toString();
		String transactionId= jsonObject.getJSONObject("transactionResponse").get("transactionId").toString();
	    transactionRepository.save(new Transaction( name, state, numeroOrden, valor,transactionId));
	    return state;
		
		
		
	}

	/**
	 * This method allow refund in payment
	 * @param numeroOrden
	 * @return
	 */
	public String doRefund(String numeroOrden){
		Gson gson = new Gson();
		RestTemplate restTemplate = new RestTemplate();
		Transaction tempTransaction = null;
		for(Transaction tr:transactionRepository.findAll()){
			System.out.println(tr.getOrderNumber());
			if(tr.getOrderNumber().equals(numeroOrden)){
				tempTransaction = tr;
				tempTransaction.setState("REFUND");
				System.out.println(tempTransaction);
				transactionRepository.save(tr);
				break;
			}
		}
		String JSON = gson.toJson(transactionJson.requestRefund(tempTransaction));
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<String> entity = new HttpEntity<>(JSON, headers);
		ResponseEntity<String> e = restTemplate.postForEntity(util2.getUri(), entity, String.class);
		JSONObject jsonObject = new JSONObject(e.getBody());
		System.out.println(jsonObject.toString());
		System.out.println("se realizo refund");
		String state= jsonObject.getJSONObject("transactionResponse").get("state").toString();
		return state;



	}





	/**
	 * This method allow create the transaction Response, from of Json Object
	 * @param jsonObject
	 * @return
	 */
	public static TransactionResponse buildTransaction(JSONObject jsonObject){

		ExtraParameters extraParameters = new ExtraParameters();
		extraParameters.setBankReferenceCode(jsonObject.getJSONObject("transactionResponse").getJSONObject("extraParameters").get("BANK_REFERENCED_CODE").toString());
		extraParameters.setBankReferenceCode(jsonObject.getJSONObject("transactionResponse").getJSONObject("extraParameters").get("PAYMENT_WAY_ID").toString());
		TransactionResponse transactionResponse = new TransactionResponse();
		transactionResponse.setExtraParameters(extraParameters);

		transactionResponse.setOperationDate(jsonObject.getJSONObject("transactionResponse").get("operationDate").toString());
		transactionResponse.setPaymentNetworkResponseErrorMessage(jsonObject.getJSONObject("transactionResponse").get("paymentNetworkResponseErrorMessage").toString());
		transactionResponse.setOrderId(jsonObject.getJSONObject("transactionResponse").get("orderId").toString());
		transactionResponse.setAuthorizationCode(jsonObject.getJSONObject("transactionResponse").get("authorizationCode").toString());
		transactionResponse.setReferenceQuestionnaire(jsonObject.getJSONObject("transactionResponse").get("referenceQuestionnaire").toString());
		transactionResponse.setPendingReason(jsonObject.getJSONObject("transactionResponse").get("pendingReason").toString());
		transactionResponse.setErrorCode(jsonObject.getJSONObject("transactionResponse").get("errorCode").toString());
		transactionResponse.setTransactionDate(jsonObject.getJSONObject("transactionResponse").get("transactionDate").toString());
		transactionResponse.setTransactionId(jsonObject.getJSONObject("transactionResponse").get("transactionId").toString());
		transactionResponse.setResponseCode(jsonObject.getJSONObject("transactionResponse").get("responseCode").toString());
		transactionResponse.setPaymentNetworkResponseErrorMessage(jsonObject.getJSONObject("transactionResponse").get("paymentNetworkResponseCode").toString());
		transactionResponse.setAdditionalInfo(jsonObject.getJSONObject("transactionResponse").get("additionalInfo").toString());
		transactionResponse.setState(jsonObject.getJSONObject("transactionResponse").get("state").toString());
		transactionResponse.setResponseMessage(jsonObject.getJSONObject("transactionResponse").get("responseMessage").toString());
		transactionResponse.setTrazabilityCode(jsonObject.getJSONObject("transactionResponse").get("trazabilityCode").toString());

		return transactionResponse;

	}

	/**
	 * This method convert a Json Object to Json Node
	 * @param json
	 * @return
	 */
	static JsonNode convertJsonFormat(JSONObject json) {
		ObjectNode ret = JsonNodeFactory.instance.objectNode();

		@SuppressWarnings("unchecked")
		Iterator<String> iterator = json.keys();
		for (; iterator.hasNext();) {
			String key = iterator.next();
			Object value;
			try {
				value = json.get(key);
			} catch (JSONException e) {
				throw new RuntimeException(e);
			}
			if (json.isNull(key))
				ret.putNull(key);
			else if (value instanceof String)
				ret.put(key, (String) value);
			else if (value instanceof Integer)
				ret.put(key, (Integer) value);
			else if (value instanceof Long)
				ret.put(key, (Long) value);
			else if (value instanceof Double)
				ret.put(key, (Double) value);
			else if (value instanceof Boolean)
				ret.put(key, (Boolean) value);
			else if (value instanceof JSONObject)
				ret.put(key, convertJsonFormat((JSONObject) value));
			else if (value instanceof JSONArray)
				ret.put(key, convertJsonFormat((JSONArray) value));
			else
				throw new RuntimeException("not prepared for converting instance of class " + value.getClass());
		}
		return ret;
	}

	/**
	 * This method convert to Json Array to Json Node
	 * @param json
	 * @return
	 */
	static JsonNode convertJsonFormat(JSONArray json) {
		ArrayNode ret = JsonNodeFactory.instance.arrayNode();
		for (int i = 0; i < json.length(); i++) {
			Object value;
			try {
				value = json.get(i);
			} catch (JSONException e) {
				throw new RuntimeException(e);
			}
			if (json.isNull(i))
				ret.addNull();
			else if (value instanceof String)
				ret.add((String) value);
			else if (value instanceof Integer)
				ret.add((Integer) value);
			else if (value instanceof Long)
				ret.add((Long) value);
			else if (value instanceof Double)
				ret.add((Double) value);
			else if (value instanceof Boolean)
				ret.add((Boolean) value);
			else if (value instanceof JSONObject)
				ret.add(convertJsonFormat((JSONObject) value));
			else if (value instanceof JSONArray)
				ret.add(convertJsonFormat((JSONArray) value));
			else
				throw new RuntimeException("not prepared for converting instance of class " + value.getClass());
		}
		return ret;
	}
	
	
}
