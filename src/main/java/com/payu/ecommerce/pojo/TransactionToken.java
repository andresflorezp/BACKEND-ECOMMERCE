package com.payu.ecommerce.pojo;

public class TransactionToken {

	/**
	 * The order
	 */
	private Order order;

	/**
	 * The payer
	 */
	private Payer payer;

	/**
	 * The creditCard
	 */
	private String creditCardTokenId;

	/**
	 * The credit card
	 */
	private String type;

	/**
	 * The payment method
	 */
	private String paymentMethod;

	/**
	 * The empty constructor
	 */
	public TransactionToken() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param order
	 * @param payer
	 * @param creditCardTokenId
	 * @param type
	 * @param paymentMethod
	 */
	public TransactionToken(Order order, Payer payer, String creditCardTokenId, String type, String paymentMethod) {
		super();
		this.order = order;
		this.payer = payer;
		this.creditCardTokenId = creditCardTokenId;
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
	 *
	 * @return
	 */
	public String getCreditCardTokenId() {

		return creditCardTokenId;
	}

	/**
	 *
	 * @param creditCardTokenId
	 */
	public void setCreditCardTokenId(String creditCardTokenId) {

		this.creditCardTokenId = creditCardTokenId;
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
	 * @return The representational String Transaction Token
	 */
	@Override public String toString() {

		return "TransactionToken{" +
				"order=" + order +
				", payer=" + payer +
				", creditCardTokenId='" + creditCardTokenId + '\'' +
				", type='" + type + '\'' +
				", paymentMethod='" + paymentMethod + '\'' +
				'}';
	}
}
