package com.payu.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payu.ecommerce.model.Transaction;
import com.payu.ecommerce.repository.TransactionRepository;
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
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
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
	public void createTransacction(Transaction transaction) {
		
		transaction.setReferenceCode(randomAlphaNumeric(10));
		transaction.setMerchantPayerId(randomAlphaNumeric(10));
	
		transaction.setAccountId(randomAlphaNumeric(10));
		transactionRepository.save(transaction);
	}
	public List<Transaction> allTransactions(){
		List<Transaction> transactions = new ArrayList();
		for(Transaction t : transactionRepository.findAll()) {
			transactions.add(t);
		}
		return transactions;
	}
	
	public String generarRespuestaTransaccion() throws IOException {
		List<Transaction> transactions = new ArrayList();
		for(Transaction t : transactionRepository.findAll()) {
			transactions.add(t);
		}
		Transaction choice = transactions.get(transactions.size()-1);
		TransactionJson json = new TransactionJson(choice.getAccountId(), choice.getReferenceCode(), choice.getMerchantPayerId(), 
				choice.getPayerFullName(), choice.getPayerEmail(), choice.getNameCard());
		String jsonInputString = json.generateJson();
		System.out.println("ESTE ES El JSON");
		System.out.println(jsonInputString);
		
		try {
			URL url = new URL ("https://sandbox.api.payulatam.com/payments-api/4.0/service.cgi");
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			try(OutputStream os = con.getOutputStream()) {
			    byte[] input = jsonInputString.getBytes("utf-8");
			    os.write(input, 0, input.length);           
			}
			try(BufferedReader br = new BufferedReader(
					  new InputStreamReader(con.getInputStream(), "utf-8"))) {
					    StringBuilder response = new StringBuilder();
					    String responseLine = null;
					    while ((responseLine = br.readLine()) != null) {
					        response.append(responseLine.trim());
					    }
					    System.out.println(response.toString());
					    return response.toString();
					}
			

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "NOFUNCIONO";
		
		
	}
	
	
}
