package com.payu.ecommerce.repository;

import com.payu.ecommerce.response.ResponseTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseTransactionRepository extends CrudRepository<ResponseTransaction, String> {

}
