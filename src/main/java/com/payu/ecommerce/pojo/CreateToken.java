/**
 * PayU Latam - Copyright (c) 2020
 * http://www.payu.com.co
 * Date: 30/01/2020
 */
package com.payu.ecommerce.pojo;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The Class Create Token.
 *
 * @author <a href="andres.florez@payulatam.com">Andres Florez</a>
 * @version 0.0.1
 * @since 0.0.1
 */
public class CreateToken {

	private String language;
	private String command;
	private Merchant merchant;
	private CreditCardToken creditCardToken;

	/**
	 * No args constructor for use in serialization
	 */
	public CreateToken() {

	}

	/**
	 * @param creditCardToken
	 * @param merchant
	 * @param language
	 * @param command
	 */
	public CreateToken(String language, String command, Merchant merchant, CreditCardToken creditCardToken) {

		super();
		this.language = language;
		this.command = command;
		this.merchant = merchant;
		this.creditCardToken = creditCardToken;
	}

	public String getLanguage() {

		return language;
	}

	public void setLanguage(String language) {

		this.language = language;
	}

	public String getCommand() {

		return command;
	}

	public void setCommand(String command) {

		this.command = command;
	}

	public Merchant getMerchant() {

		return merchant;
	}

	public void setMerchant(Merchant merchant) {

		this.merchant = merchant;
	}

	public CreditCardToken getCreditCardToken() {

		return creditCardToken;
	}

	public void setCreditCardToken(CreditCardToken creditCardToken) {

		this.creditCardToken = creditCardToken;
	}

	@Override
	public String toString() {

		return new ToStringBuilder(this).append("language", language).append("command", command)
										.append("merchant", merchant).append("creditCardToken", creditCardToken)
										.toString();
	}

}