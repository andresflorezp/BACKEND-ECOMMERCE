package com.payu.ecommerce.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		else {
			List<Product> nP = new ArrayList();
			for (Product p : productService.allProducts()) {
				//nP.add(p);
				boolean entro = false;
				for(int i=0;i<nP.size();i++) {
					if(nP.get(i).getName().equals(p.getName())) {
						entro=true;
					}
				}
				if(!entro)nP.add(p);
			}

			return new ResponseEntity<>(nP, HttpStatus.ACCEPTED);
		}
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, value = "/productName/{name}")
	public ResponseEntity<?> getProduct(@PathVariable("name") String name) {
		if (productService.getProductByName(name) == null)
			return new ResponseEntity<>("HTTP 404", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(productService.getProductByName(name), HttpStatus.ACCEPTED);
	}

}
