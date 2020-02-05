package com.payu.ecommerce.refund;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Order {

	private String id;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Order() {
	}

	/**
	 * @param id
	 */
	public Order(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).toString();
	}

}