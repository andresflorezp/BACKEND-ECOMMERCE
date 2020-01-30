/**
 * PayU Latam - Copyright (c) 2013 - 2018
 * http://www.payu.com.co
 * Date: 30/01/2020
 */
package com.payu.ecommerce.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.*;

/**
 * The Class Cart.
 *
 * @author <a href="andres.florez@payulatam.com">Andres Florez</a>
 * @version 0.0.1
 * @since 0.0.1
 */

@Entity
@Table(name = "cart")
public class Cart implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue
	private Long id;

	/**
	 * 
	 */
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id")
	private Account account;

	/**
	 * 
	 */
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CartProducto", joinColumns = { @JoinColumn(name = "IdCart") }, inverseJoinColumns = {
			@JoinColumn(name = "IdProduct") })
	private List<Product> allProducts = new ArrayList<>();

	/**
	 * 
	 */
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param account
	 */
	public Cart(Account account) {
		super();
		this.account = account;

	}

	/**
	 * @param product
	 */
	public void addTag(Product product) {
		allProducts.add(product);

	}

	/**
	 * @param product
	 */
	public void removeTag(Product product) {
		allProducts.remove(product);

	}

	/**
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * @return
	 */
	public List<Product> getAllproducts() {
		return allProducts;
	}

	/**
	 * @param allproducts
	 */
	public void setAllproducts(List<Product> allproducts) {
		this.allProducts = allproducts;
	}

	/**
	 * @param alltransactions
	 */
	public void setAlltransactions(List<Product> alltransactions) {
		this.allProducts = alltransactions;
	}

}
