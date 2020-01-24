package com.payu.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payu.ecommerce.model.Account;
import com.payu.ecommerce.model.Cart;
import com.payu.ecommerce.repository.AccountRepository;
import com.payu.ecommerce.repository.CartRepository;

@Service
public class CartService {
	@Autowired
	AccountService  accountService;
	
	@Autowired
	CartRepository cartRepository;
	
	public void createCart(Cart cart) {
		
		cart.setAccount(accountService.getAllAccount().get(accountService.getAllAccount().size()-1));
		cartRepository.save(cart);
		
	}
	
	public List<Cart> getAllAccount() {
		List<Cart> accounts = new ArrayList<Cart>();
		for (Cart a : cartRepository.findAll()) {
			accounts.add(a);
		}
		return accounts;
	}
	
	public void addProduct(Long id) {
		
	}
	
	
	
	
	
	

}
