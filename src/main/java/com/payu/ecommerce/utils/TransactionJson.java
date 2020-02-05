/**
 * PayU Latam - Copyright (c) 2013 - 2018
 * http://www.payu.com.co
 * Date: 30/01/2020
 */
package com.payu.ecommerce.utils;

import com.payu.ecommerce.pojo.AdditionalValues;
import com.payu.ecommerce.pojo.CreditCard;
import com.payu.ecommerce.pojo.Merchant;
import com.payu.ecommerce.pojo.Order;
import com.payu.ecommerce.pojo.Payer;
import com.payu.ecommerce.pojo.RequestTransaction;
import com.payu.ecommerce.pojo.TxValue;
import com.payu.ecommerce.pojo.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * The Class TransactionJson.
 *
 * @author <a href="andres.florez@payulatam.com">Andres Florez</a>
 * @version 0.0.1
 * @since 0.0.1
 */
@Service
public class TransactionJson {

	@Autowired
	Utils util;

	/**
	 * This function allows to create the request with the instance to map the payments api
	 * @return
	 */
	public RequestTransaction request(String name, String email, String valor, String card, String cvv, String expirationDate) {
		TxValue tXVALUE = new TxValue(Integer.parseInt(util.getTxValue()), util.getCurrency());
		AdditionalValues additionalValues = new AdditionalValues(tXVALUE);
		Order order = new Order(util.getOrderNumber(), util.getReferenceCode(), util.getDescriptionOrder(), util.getLanguage(), additionalValues);
		Payer payer = new Payer(util.getPayerNumber(), name, email, util.getContactNUmber(), util.getDniNumber());
		CreditCard creditCard = new CreditCard(card, cvv, util.getExpirationDate(), name);
		Merchant merchant = new  Merchant(util.getMerchantApiLogin(), util.getMerchantApiKey());
		com.payu.ecommerce.pojo.Transaction transaction = new com.payu.ecommerce.pojo.Transaction(order, payer, creditCard, util.getType(), util.getPaymentMethod());
		RequestTransaction requestTransaction = new  RequestTransaction(util.getLanguage(), util.getCommand(), merchant, transaction, false);
		System.out.println(requestTransaction.toString());
		return requestTransaction;

	}

}
