/**
 * PayU Latam - Copyright (c) 2013 - 2018
 * http://www.payu.com.co
 * Date: 30/01/2020
 */
package com.payu.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.payu.ecommerce.model.Account;
import com.payu.ecommerce.model.Cart;
import com.payu.ecommerce.model.Product;
import com.payu.ecommerce.repository.CartRepository;

/**
 * The Class CartService.
 *
 * @author <a href="andres.florez@payulatam.com">Andres Florez</a>
 * @version 0.0.1
 * @since 0.0.1
 */


@Service
public class CartService {
	
	@Autowired
	AccountService accountService;

	/**
	 * 
	 */
	@Autowired
	CartRepository cartRepository;
	


	/**
	 * @param cart
	 */
	public void createCart(Cart cart) {
		cart.setAccount(accountService.getAllAccount().get(accountService.getAllAccount().size() - 1));
		cartRepository.save(cart);

	}

	/**
	 * @return
	 */
	public List<Cart> getAllCarts() {
		List<Cart> accounts = new ArrayList<Cart>();
		for (Cart a : cartRepository.findAll()) {
			accounts.add(a);
		}
		return accounts;
	}

	/**
	 * @param email
	 * @param product
	 */
	public void addProduct(String email, Product product) {
		List<Account> accounts = accountService.getAllAccount();
		accountService.deleteAll();
		for (Account a : accounts) {
			if (a.getEmail().equals(email)) {
				Account ac = a;
				ac.getCart().addTag(product);
				accountService.createAccount(ac);
			} else {
				accountService.createAccount(a);
			}

		}

	}
	
	/**
	 * @param email
	 */
	public void emptyCart(String email) {
		for (Account a : accountService.getAllAccount()) {
			if (a.getEmail().equals(email)) {
				a.getCart().setAllproducts(new ArrayList<>());
				accountService.createAccount(a);
				break;
			}

		}
	}

	/**
	 * @param email
	 * @return
	 */
	public List<Product> obtainCart(String email) {
		List<Account> accounts = accountService.getAllAccount();
		for (Account a : accounts) {
			if (a.getEmail().equals(email)) {
				return a.getCart().getAllproducts();
			}
		}
		return null;

	}

}
