/**
 * PayU Latam - Copyright (c) 2013 - 2018
 * http://www.payu.com.co
 * Date: 30/01/2020
 */
package com.payu.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payu.ecommerce.model.Account;
import com.payu.ecommerce.repository.AccountRepository;
import java.util.*;

/**
 * The Class AccountService.
 *
 * @author <a href="andres.florez@payulatam.com">Andres Florez</a>
 * @version 0.0.1
 * @since 0.0.1
 */


@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	/**
	 * create a account
	 * @param account
	 */
	public void createAccount(Account account) {
		accountRepository.save(account);
	}
	
	/**
	 * Delete all accounts
	 */
	public void deleteAll() {
		accountRepository.deleteAll();
	}

	/**
	 * Obtain Account by Email and password
	 * @param email
	 * @param password
	 * @return
	 */
	public Account getAccountWithByEmailAndPassword(String email, String password) {
		for (Account a : accountRepository.findAll()) {
			if (a.getEmail().equals(email) && a.getPassword().equals(password)) {
				System.out.println(a);
				return a;

			} 
		}
		return null;

	}

	/**
	 * Obtain all accounts
	 * @return
	 */
	public List<Account> getAllAccount() {
		List<Account> accounts = new ArrayList<Account>();
		for (Account a : accountRepository.findAll()) {
			accounts.add(a);
		}
		return accounts;
	}
	
	

}
