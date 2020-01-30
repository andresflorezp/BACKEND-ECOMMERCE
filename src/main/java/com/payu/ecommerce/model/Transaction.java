/**
 * PayU Latam - Copyright (c) 2013 - 2018
 * http://www.payu.com.co
 * Date: 30/01/2020
 */
package com.payu.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Transaction.
 *
 * @author <a href="andres.florez@payulatam.com">Andres Florez</a>
 * @version 0.0.1
 * @since 0.0.1
 */

@Entity
@Table(name = "transaction")
public class Transaction {
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	private Long id;

	/**
	 * 
	 */
	private String whoTransaction;

	/**
	 * 
	 */
	private String state;

	/**
	 * 
	 */
	private String orderNumber;

	/**
	 * 
	 */
	private Double valueTransaction;

	/**
	 * @param id
	 * @param whoTransaction
	 * @param state
	 * @param numeroOrden
	 * @param valueTransaction
	 */
	public Transaction(Long id, String whoTransaction, String state, String numeroOrden, Double valueTransaction) {
		super();
		this.id = id;
		this.whoTransaction = whoTransaction;
		this.state = state;
		this.orderNumber = numeroOrden;
		this.valueTransaction = valueTransaction;
	}

	/**
	 * @param whoTransaction
	 * @param state
	 * @param numeroOrden
	 * @param valueTransaction
	 */
	public Transaction(String whoTransaction, String state, String numeroOrden, Double valueTransaction) {
		super();

		this.whoTransaction = whoTransaction;
		this.state = state;
		this.orderNumber = numeroOrden;
		this.valueTransaction = valueTransaction;
	}

	/**
	 * 
	 */
	public Transaction() {
		// TODO Auto-generated constructor stub
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
	public String getWhoTransaction() {
		return whoTransaction;
	}

	/**
	 * @param whoTransaction
	 */
	public void setWhoTransaction(String whoTransaction) {
		this.whoTransaction = whoTransaction;
	}

	/**
	 * @return
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return
	 */
	public String getNumeroOrden() {
		return orderNumber;
	}

	/**
	 * @param numeroOrden
	 */
	public void setNumeroOrden(String numeroOrden) {
		this.orderNumber = numeroOrden;
	}

	/**
	 * @return
	 */
	public Double getValueTransaction() {
		return valueTransaction;
	}

	/**
	 * @param valueTransaction
	 */
	public void setValueTransaction(Double valueTransaction) {
		this.valueTransaction = valueTransaction;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", whoTransaction=" + whoTransaction + ", state=" + state + ", numeroOrden="
				+ orderNumber + ", valueTransaction=" + valueTransaction + "]";
	}

}
