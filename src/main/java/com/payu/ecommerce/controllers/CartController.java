package com.payu.ecommerce.controllers;

import java.util.ArrayList;
import java.util.List;

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
import com.payu.ecommerce.model.Cart;
import com.payu.ecommerce.model.Product;
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

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, value = "/all-carts")
	public ResponseEntity<?> getAllAccounts() {
		// System.out.println(accountService.getAllAccount());
		if (cartService.getAllCarts().size() == 0)
			return new ResponseEntity<>("HTTP 404", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(cartService.getAllCarts(), HttpStatus.ACCEPTED);
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, value = "/add-product/{email}")
	public ResponseEntity<?> addProduct(@PathVariable("email") String email, @RequestBody Product product) {

		try {
			cartService.addProduct(email, product);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("HTTP 403", HttpStatus.FORBIDDEN);
		}

	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, value = "/obtain-cart/{email}")
	public ResponseEntity<?> getCart(@PathVariable("email") String email) {

		if (cartService.obtainCart(email).size() == 0) {

			return new ResponseEntity<>("HTTP 403", HttpStatus.FORBIDDEN);
		} else {
			
			return new ResponseEntity<>(cartService.obtainCart(email), HttpStatus.CREATED);
		}

	}

}
