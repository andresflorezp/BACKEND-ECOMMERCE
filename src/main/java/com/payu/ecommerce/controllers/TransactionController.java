/**
 * PayU Latam - Copyright (c) 2013 - 2018
 * http://www.payu.com.co
 * Date: 30/01/2020
 */
package com.payu.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.payu.ecommerce.service.TransactionService;

/**
 * The Class TransactionController.
 *
 * @author <a href="andres.florez@payulatam.com">Andres Florez</a>
 * @version 0.0.1
 * @since 0.0.1
 */


@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
	/**
	 * 
	 */
	@Autowired
	TransactionService transactionService;

	

	/**
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, value = "/all-transactions")
	public ResponseEntity<?> getAllAccounts() {
		if (transactionService.allTransactions().size() == 0)
			return new ResponseEntity<>("HTTP 404", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(transactionService.allTransactions(), HttpStatus.ACCEPTED);
	}


	/**
	 * @param name
	 * @param email
	 * @param value
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, value = "/add-product/{name}/{email}/{valor}")
	public ResponseEntity<?> addProduct(@PathVariable("name") String name,@PathVariable("email") String email,@PathVariable("valor") Double value) {
		try {
			return new ResponseEntity<>(transactionService.generarResponse(name, email, value),HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("HTTP 403", HttpStatus.FORBIDDEN);
		}

	}

}
