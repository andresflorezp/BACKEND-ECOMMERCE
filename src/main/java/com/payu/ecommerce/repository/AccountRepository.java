package com.payu.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.payu.ecommerce.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long>{

}
