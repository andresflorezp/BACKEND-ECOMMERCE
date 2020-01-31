/**
 * PayU Latam - Copyright (c) 2013 - 2018
 * http://www.payu.com.co
 * Date: 30/01/2020
 */
package com.payu.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.payu.ecommerce.model.Account;
import com.payu.ecommerce.service.AccountService;

/**
 * The Class AccountController.
 *
 * @author <a href="andres.florez@payulatam.com">Andres Florez</a>
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
@RequestMapping("/api/account")
public class AccountController {

	@Autowired
	AccountService accountService;

	/**
	 * @return all accounts of the Ecommerce
	 */
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, value = "/all-account")
	public ResponseEntity<?> getAllAccounts() {
		if (accountService.getAllAccount().size() == 0)
			return new ResponseEntity<>("HTTP 404", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(accountService.getAllAccount(), HttpStatus.ACCEPTED);
	}

	/**
	 * This controller allow create a account
	 * @param account
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, value = "/add-account")
	public ResponseEntity<?> addAccount(@RequestBody Account account) {
		try {
			accountService.createAccount(account);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("HTTP 403", HttpStatus.FORBIDDEN);
		}
	}

	/**
	 * This controller allow obtain user with email and password
	 * @param user
	 * @param password
	 * @return a User
	 */
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, value = "/isLogin/{user}/{password}")
	public ResponseEntity<?> login(@PathVariable("user") String user, @PathVariable("password") String password) {
		if (accountService.getAccountWithByEmailAndPassword(user, password) == null)
			return new ResponseEntity<>("HTTP 404", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(accountService.getAccountWithByEmailAndPassword(user, password),
				HttpStatus.ACCEPTED);
	}

}
