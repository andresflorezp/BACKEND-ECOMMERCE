/**
 * PayU Latam - Copyright (c) 2013 - 2018
 * http://www.payu.com.co
 * Date: 30/01/2020
 */
package com.payu.ecommerce.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Class Account.
 *
 * @author <a href="andres.florez@payulatam.com">Andres Florez</a>
 * @version 0.0.1
 * @since 0.0.1
 */

@Entity
@Table(name = "account")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private String email;

	private String password;

	private String fullName;

	private Boolean enabled;

	private String role;

	private Double balance;

	@JsonIgnore
	@OneToOne(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private Cart cart;

	public Account() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param email
	 * @param password
	 * @param fullName
	 * @param enabled
	 * @param role
	 * @param balance
	 * @param cart
	 */
	public Account(Long id, String email, String password, String fullName, Boolean enabled, String role,
			Double balance, Cart cart) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.enabled = enabled;
		this.role = role;
		this.balance = balance;
		this.cart = cart;
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
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return
	 */
	public Double getBalance() {
		return balance;
	}

	/**
	 * @param balance
	 */
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	/**
	 * @return
	 */
	public Cart getCart() {
		return cart;
	}

	/**
	 * @param cart
	 */
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", password=" + password + ", fullName=" + fullName
				+ ", enabled=" + enabled + ", role=" + role + ", balance=" + balance + ", cart=" + cart + "]";
	}

}
