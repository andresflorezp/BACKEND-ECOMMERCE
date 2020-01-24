package com.payu.ecommerce.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.*;

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id")
	private Account account;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> alltransactions;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}


	public Cart(Long id, Account account, List<Product> alltransactions) {
		super();
		this.id = id;
		this.account = account;
		this.alltransactions = alltransactions;
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


	public List<Product> getAlltransactions() {
		return alltransactions;
	}


	public void setAlltransactions(List<Product> alltransactions) {
		this.alltransactions = alltransactions;
	}


	@Override
	public String toString() {
		return "Cart [id=" + id + ", account=" + account + ", alltransactions=" + alltransactions + "]";
	}
	
	
	
	
	
	

}
