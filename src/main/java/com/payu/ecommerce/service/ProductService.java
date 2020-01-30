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

import com.payu.ecommerce.model.Product;
import com.payu.ecommerce.repository.ProductRepository;

/**
 * The Class ProductService.
 *
 * @author <a href="andres.florez@payulatam.com">Andres Florez</a>
 * @version 0.0.1
 * @since 0.0.1
 */


@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	/**
	 * @param product
	 */
	public void createProduct(Product product) {
		productRepository.save(product);
	}

	/**
	 * @return
	 */
	public List<Product> allProducts() {
		List<Product> products = new ArrayList<Product>();
		for (Product p : productRepository.findAll())
			products.add(p);
		return products;

	}

	/**
	 * @param name
	 * @return
	 */
	public Product getProductByName(String name) {
		for (Product p : productRepository.findAll())
			if (p.getName().equals(name))
				return p;
		return null;

	}

}
