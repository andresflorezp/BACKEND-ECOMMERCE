package com.payu.ecommerce.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "cart")
public class Cart implements Serializable {
	@Id
	@GeneratedValue
	private Long id;

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id")
	private Account account;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CartProducto", joinColumns = { @JoinColumn(name = "IdCart") }, inverseJoinColumns = {
			@JoinColumn(name = "IdProduct") })
	private List<Product> allproducts = new ArrayList<>();

	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(Account account) {
		super();
		this.account = account;

	}

	public void addTag(Product product) {
		allproducts.add(product);
		//tag.getPosts().add(this);
	}

	public void removeTag(Product product) {
		allproducts.remove(product);
		//tag.getPosts().remove(this);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	

	public List<Product> getAllproducts() {
		return allproducts;
	}

	public void setAllproducts(List<Product> allproducts) {
		this.allproducts = allproducts;
	}

	public void setAlltransactions(List<Product> alltransactions) {
		this.allproducts = alltransactions;
	}


	
	

}
