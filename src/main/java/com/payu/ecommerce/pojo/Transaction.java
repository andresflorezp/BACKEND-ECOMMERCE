/**
 * PayU Latam - Copyright (c) 2013 - 2018
 * http://www.payu.com.co
 * Date: 30/01/2020
 */
package com.payu.ecommerce.pojo;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The Class Transaction.
 *
 * @author <a href="andres.florez@payulatam.com">Andres Florez</a>
 * @version 0.0.1
 * @since 0.0.1
 */


public class Transaction {

	private Order order;

	private Payer payer;

	private CreditCard creditCard;
	
	private String type;

	private String paymentMethod;

	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param order
	 * @param payer
	 * @param creditCard
	 * @param type
	 * @param paymentMethod
	 */
	public Transaction(Order order, Payer payer, CreditCard creditCard, String type, String paymentMethod) {
		super();
		this.order = order;
		this.payer = payer;
		this.creditCard = creditCard;
		this.type = type;
		this.paymentMethod = paymentMethod;
	}

	/**
	 * @return
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * @return
	 */
	public Payer getPayer() {
		return payer;
	}

	/**
	 * @param payer
	 */
	public void setPayer(Payer payer) {
		this.payer = payer;
	}

	/**
	 * @return
	 */
	public CreditCard getCreditCard() {
		return creditCard;
	}

	/**
	 * @param creditCard
	 */
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	/**
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * @param paymentMethod
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("order", order).append("payer", payer).append("creditCard", creditCard)
				.append("type", type).append("paymentMethod", paymentMethod).toString();
	}

}