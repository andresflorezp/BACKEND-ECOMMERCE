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
	 * The id
	 */
	@Id
	@GeneratedValue
	private Long id;

	/**
	 * The who transaction
	 */
	private String whoTransaction;

	/**
	 * The state
	 */
	private String state;

	/**
	 * The order number
	 */
	private String orderNumber;

	/**
	 * The value Transaction
	 */
	private Double valueTransaction;

	/**
	 * The transaction Id
	 */
	private String transactionId;

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
	 *
	 * @param whoTransaction
	 * @param state
	 * @param numeroOrden
	 * @param valueTransaction
	 * @param transactionId
	 */
	public Transaction(String whoTransaction, String state, String numeroOrden, Double valueTransaction,String transactionId) {
		super();
		this.id = id;
		this.whoTransaction = whoTransaction;
		this.state = state;
		this.orderNumber = numeroOrden;
		this.valueTransaction = valueTransaction;
		this.transactionId = transactionId;
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
	 * @return the id
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
	 * @return the who transaction
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
	 * @return the state
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
	 * @return the numberOrder
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
	 * @return value Transaction
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
	 * @return
	 */
	public String getOrderNumber() {

		return orderNumber;
	}

	/**
	 *
	 * @param orderNumber
	 */
	public void setOrderNumber(String orderNumber) {

		this.orderNumber = orderNumber;
	}

	/**
	 *
	 * @return
	 */
	public String getTransactionId() {

		return transactionId;
	}

	/**
	 *
	 * @param transactionId
	 */
	public void setTransactionId(String transactionId) {

		this.transactionId = transactionId;
	}

	@Override public String toString() {

		return "Transaction{" +
				"id=" + id +
				", whoTransaction='" + whoTransaction + '\'' +
				", state='" + state + '\'' +
				", orderNumber='" + orderNumber + '\'' +
				", valueTransaction=" + valueTransaction +
				", transactionId='" + transactionId + '\'' +
				'}';
	}
}
