package com.payu.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payu.ecommerce.model.Product;
import com.payu.ecommerce.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	public void createProduct(Product product) {
		productRepository.save(product);
	}
	
	public List<Product> allProducts(){
		List<Product> products = new ArrayList<Product>();
		for(Product p : productRepository.findAll())products.add(p);
		return products;
		
	}
	
}
