package com.payu.ecommerce.utils;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class Transaction {

	private Order order;
	private Payer payer;
	private CreditCard creditCard;
	private String type;
	private String paymentMethod;

	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	public Transaction(Order order, Payer payer, CreditCard creditCard, String type, String paymentMethod) {
		super();
		this.order = order;
		this.payer = payer;
		this.creditCard = creditCard;
		this.type = type;
		this.paymentMethod = paymentMethod;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Payer getPayer() {
		return payer;
	}

	public void setPayer(Payer payer) {
		this.payer = payer;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}


	@Override
	public String toString() {
		return new ToStringBuilder(this).append("order", order).append("payer", payer).append("creditCard", creditCard)
				.append("type", type).append("paymentMethod", paymentMethod)
				.toString();
	}

}