package com.payu.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {

	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	@Id
	@GeneratedValue
	private Long id;

	private String whoTransaction;

	private String state;

	private String numeroOrden;

	private Double valueTransaction;
	

	public Transaction(Long id, String whoTransaction, String state, String numeroOrden, Double valueTransaction) {
		super();
		this.id = id;
		this.whoTransaction = whoTransaction;
		this.state = state;
		this.numeroOrden = numeroOrden;
		this.valueTransaction = valueTransaction;
	}
	public Transaction(String whoTransaction, String state, String numeroOrden, Double valueTransaction) {
		super();
		
		this.whoTransaction = whoTransaction;
		this.state = state;
		this.numeroOrden = numeroOrden;
		this.valueTransaction = valueTransaction;
	}


	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWhoTransaction() {
		return whoTransaction;
	}

	public void setWhoTransaction(String whoTransaction) {
		this.whoTransaction = whoTransaction;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getNumeroOrden() {
		return numeroOrden;
	}

	public void setNumeroOrden(String numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public Double getValueTransaction() {
		return valueTransaction;
	}

	public void setValueTransaction(Double valueTransaction) {
		this.valueTransaction = valueTransaction;
	}

	public static String getAlphaNumericString() {
		return ALPHA_NUMERIC_STRING;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", whoTransaction=" + whoTransaction + ", state=" + state + ", numeroOrden="
				+ numeroOrden + ", valueTransaction=" + valueTransaction + "]";
	}

}
