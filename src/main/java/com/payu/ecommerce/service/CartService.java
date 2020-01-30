package com.payu.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payu.ecommerce.model.Account;
import com.payu.ecommerce.model.Cart;
import com.payu.ecommerce.model.Product;
import com.payu.ecommerce.repository.AccountRepository;
import com.payu.ecommerce.repository.CartRepository;

@Service
public class CartService {
	@Autowired
	AccountService accountService;

	@Autowired
	CartRepository cartRepository;
	


	public void createCart(Cart cart) {

		cart.setAccount(accountService.getAllAccount().get(accountService.getAllAccount().size() - 1));
		cartRepository.save(cart);

	}

	public List<Cart> getAllCarts() {
		List<Cart> accounts = new ArrayList<Cart>();
		for (Cart a : cartRepository.findAll()) {
			accounts.add(a);
		}
		return accounts;
	}

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
	
	public void emptyCart(String email) {
		for (Account a : accountService.getAllAccount()) {
			if (a.getEmail().equals(email)) {
				
				a.getCart().setAllproducts(new ArrayList<>());
				accountService.createAccount(a);
				break;
			}

		}
	}

	public List<Product> obtainCart(String email) {
		List<Account> accounts = accountService.getAllAccount();
		//accountService.deleteAll();

		for (Account a : accounts) {
			if (a.getEmail().equals(email)) {
				System.out.println("ENRO PARA OBTENER PRODUCTOS");
				System.out.println(a.getCart().getAllproducts().size());
				return a.getCart().getAllproducts();
			}

		}
		return null;

	}

}
