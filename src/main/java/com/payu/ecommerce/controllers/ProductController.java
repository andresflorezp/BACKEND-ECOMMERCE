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
import com.payu.ecommerce.model.Product;
import com.payu.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	@Autowired
	ProductService productService;

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, value = "/create-product")
	public ResponseEntity<?> addAccount(@RequestBody Product product) {

		try {
			productService.createProduct(product);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("HTTP 403", HttpStatus.FORBIDDEN);
		}

	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, value = "/all-product")
	public ResponseEntity<?> getAllAccounts() {
		System.out.println(productService.allProducts());
		if (productService.allProducts().size() == 0)
			return new ResponseEntity<>("HTTP 404", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(productService.allProducts(), HttpStatus.ACCEPTED);
	}

}
