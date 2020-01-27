package com.payu.ecommerce.controllers;

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

@RestController
@RequestMapping("/api/account")
public class AccountController {
	@Autowired
	AccountService accountService;

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, value = "/all-account")
	public ResponseEntity<?> getAllAccounts() {
		//System.out.println(accountService.getAllAccount());
		if (accountService.getAllAccount().size() == 0)
			return new ResponseEntity<>("HTTP 404", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(accountService.getAllAccount(), HttpStatus.ACCEPTED);
	}

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

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, value = "/isLogin/{user}/{password}")
	public ResponseEntity<?> login(@PathVariable("user") String user, @PathVariable("password") String password) {
		if (accountService.getAccountWithByEmailAndPassword(user, password) == null)
			return new ResponseEntity<>("HTTP 404", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(accountService.getAccountWithByEmailAndPassword(user, password),
				HttpStatus.ACCEPTED);
	}

}
