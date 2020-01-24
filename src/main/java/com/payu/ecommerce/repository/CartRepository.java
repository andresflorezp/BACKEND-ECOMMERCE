package com.payu.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.payu.ecommerce.model.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long>{

}
