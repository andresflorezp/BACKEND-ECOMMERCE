
package com.payu.ecommerce.refund;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Transaction {

	private Order order;
	private String type;
	private String reason;
	private String parentTransactionId;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Transaction() {
	}

	/**
	 *
	 * @param reason
	 * @param type
	 * @param order
	 * @param parentTransactionId
	 */
	public Transaction(Order order, String type, String reason, String parentTransactionId) {
		super();
		this.order = order;
		this.type = type;
		this.reason = reason;
		this.parentTransactionId = parentTransactionId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getParentTransactionId() {
		return parentTransactionId;
	}

	public void setParentTransactionId(String parentTransactionId) {
		this.parentTransactionId = parentTransactionId;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("order", order).append("type", type).append("reason", reason).append("parentTransactionId", parentTransactionId).toString();
	}

}