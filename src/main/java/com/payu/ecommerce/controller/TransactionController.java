/**
 * PayU Latam - Copyright (c) 2013 - 2018
 * http://www.payu.com.co
 * Date: 30/01/2020
 */
package com.payu.ecommerce.controller;

import com.payu.ecommerce.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

	@Autowired
	TransactionService transactionService;

	/**
	 * This controller allow obtain all transactions
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
	 * This controller allow create transaction
	 * @param name
	 * @param email
	 * @param value
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, value = "/add-product/{name}/{email}/{valor}/{card}/{cvv}/{expiration}")
	public ResponseEntity<?> addProduct(@PathVariable("name") String name, @PathVariable("email") String email,
			@PathVariable("valor") Double value,@PathVariable("card") String card,@PathVariable("cvv") String cvv,@PathVariable("expiration") String expiration) {
		try {
			return new ResponseEntity<>(transactionService.doPaymentsAPI(name, email, value,card,cvv,expiration), HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("HTTP 403", HttpStatus.FORBIDDEN);
		}

	}

	/**
	 * This controller allow create transaction
	 * @param name
	 * @param email
	 * @param value
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, value = "/add-product-token/{name}/{email}/{valor}/{token}")
	public ResponseEntity<?> addProductToken(@PathVariable("name") String name, @PathVariable("email") String email,
										@PathVariable("valor") Double value,@PathVariable("token") String token) {
		try {
			return new ResponseEntity<>(transactionService.doPaymentsAPIToken(name, email, value,token), HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("HTTP 403", HttpStatus.FORBIDDEN);
		}

	}

	/**
	 *
	 * @param email
	 * @param card
	 * @param name
	 * @param expirationDate
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(method = RequestMethod.PUT, value = "/createToken/{email}/{card}/{name}/{expirationDate}")
	public ResponseEntity<?> doCreateToken(@PathVariable("email") String email,@PathVariable("card") String card,@PathVariable("name") String name,@PathVariable("expirationDate") String expirationDate) {
		try {
			return new ResponseEntity<>(transactionService.createToken(email,card,name,expirationDate), HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("HTTP 403", HttpStatus.FORBIDDEN);
		}

	}

	/**
	 * This controller create of refund
	 * @param numeroOrden
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(method = RequestMethod.PUT, value = "/dorefund/{numeroOrden}")
	public ResponseEntity<?> doRefundTransaction(@PathVariable("numeroOrden") String numeroOrden) {
		try {
			return new ResponseEntity<>(transactionService.doRefund(numeroOrden), HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("HTTP 403", HttpStatus.FORBIDDEN);
		}

	}
}
