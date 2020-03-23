/**
 * PayU Latam - Copyright (c) 2013 - 2018
 * http://www.payu.com.co
 * Date: 30/01/2020
 */
package com.payu.ecommerce.controller;

import com.payu.ecommerce.model.Cart;
import com.payu.ecommerce.model.Product;
import com.payu.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class CartController.
 *
 * @author <a href="andres.florez@payulatam.com">Andres Florez</a>
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
@RequestMapping("/api/cart")
public class CartController {

	@Autowired
	CartService cartService;

	/**
	 * This Controller allow create a cart by a user
	 * @param cart
	 * @return
	 */
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

	/**
	 * @return all carts
	 */
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, value = "/all-carts")
	public ResponseEntity<?> getAllAccounts() {
		if (cartService.getAllCarts().size() == 0)
			return new ResponseEntity<>("HTTP 404", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(cartService.getAllCarts(), HttpStatus.ACCEPTED);
	}

	/**
	 * this controller allow add product in a cart specific
	 * @param email
	 * @param product
	 * @return
	 */
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

	/**
	 * This controller allow empty cart
	 * @param email
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(method = RequestMethod.DELETE, value = "/empty-cart/{email}")
	public ResponseEntity<?> EmptyCart(@PathVariable("email") String email) {
		try {
			cartService.emptyCart(email);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("HTTP 403", HttpStatus.FORBIDDEN);
		}
	}

	/**
	 * This controller obtain a cart specific
	 * @param email
	 * @return 
	 */
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
