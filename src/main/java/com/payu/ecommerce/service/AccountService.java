package com.payu.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payu.ecommerce.model.Account;
import com.payu.ecommerce.repository.AccountRepository;
import java.util.*;

@Service
public class AccountService {
	@Autowired
	AccountRepository accountRepository;

	public void createAccount(Account account) {
		accountRepository.save(account);
	}

	public Account getAccountWithByEmailAndPassword(String email, String password) {
		for (Account a : accountRepository.findAll()) {
			if (a.getEmail().equals(email) && a.getPassword().equals(password)) {
				System.out.println(a);
				return a;

			} 
		}
		return null;

	}

	public List<Account> getAllAccount() {
		List<Account> accounts = new ArrayList<Account>();
		for (Account a : accountRepository.findAll()) {
			accounts.add(a);
		}
		return accounts;
	}
	
	

}
