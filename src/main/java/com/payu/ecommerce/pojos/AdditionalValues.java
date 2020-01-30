/**
 * PayU Latam - Copyright (c) 2013 - 2018
 * http://www.payu.com.co
 * Date: 30/01/2020
 */
package com.payu.ecommerce.pojos;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The Class AdditionalValues.
 *
 * @author <a href="andres.florez@payulatam.com">Andres Florez</a>
 * @version 0.0.1
 * @since 0.0.1
 */

public class AdditionalValues {
	
	/**
	 * 
	 */
	private TxValue TX_VALUE;

	/**
	 * 
	 */
	public AdditionalValues() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param tXVALUE
	 */
	public AdditionalValues(TxValue tXVALUE) {
		super();
		this.TX_VALUE = tXVALUE;
	}

	/**
	 * @return
	 */
	public TxValue getTXVALUE() {
		return TX_VALUE;
	}

	/**
	 * @param tXVALUE
	 */
	public void setTXVALUE(TxValue tXVALUE) {
		this.TX_VALUE = tXVALUE;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("tXVALUE", TX_VALUE).toString();
	}

}