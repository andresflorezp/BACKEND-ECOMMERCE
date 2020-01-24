package com.payu.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.payu.ecommerce.model.Account;
import com.payu.ecommerce.model.Cart;
import com.payu.ecommerce.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {
	@Autowired
	CartService cartService;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, value = "/add-cart")
	public ResponseEntity<?> addAccount(@RequestBody Cart cart) {

		try {
			cartService.createCart(cart);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("HTTP 403", HttpStatus.FORBIDDEN);
		}

	}

}
