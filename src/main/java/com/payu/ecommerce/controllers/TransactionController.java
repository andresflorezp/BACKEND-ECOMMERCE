package com.payu.ecommerce.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.payu.ecommerce.model.Product;
import com.payu.ecommerce.model.Transaction;
import com.payu.ecommerce.service.TransactionService;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
	@Autowired
	TransactionService transactionService;

	

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, value = "/all-transactions")
	public ResponseEntity<?> getAllAccounts() {
		// System.out.println(accountService.getAllAccount());
		if (transactionService.allTransactions().size() == 0)
			return new ResponseEntity<>("HTTP 404", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(transactionService.allTransactions(), HttpStatus.ACCEPTED);
	}


	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, value = "/add-product/{name}/{email}/{valor}")
	public ResponseEntity<?> addProduct(@PathVariable("name") String name,@PathVariable("email") String email, Double valor) {

		try {
			transactionService.generarResponse(name, email, valor);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("HTTP 403", HttpStatus.FORBIDDEN);
		}

	}

}
