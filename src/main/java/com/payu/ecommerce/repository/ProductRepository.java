package com.payu.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.payu.ecommerce.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
