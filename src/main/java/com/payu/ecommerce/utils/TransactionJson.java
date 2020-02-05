/**
 * PayU Latam - Copyright (c) 2013 - 2018
 * http://www.payu.com.co
 * Date: 30/01/2020
 */
package com.payu.ecommerce.utils;

import com.payu.ecommerce.model.Transaction;
import com.payu.ecommerce.pojo.AdditionalValues;
import com.payu.ecommerce.pojo.CreditCard;
import com.payu.ecommerce.pojo.Merchant;
import com.payu.ecommerce.pojo.Order;
import com.payu.ecommerce.pojo.Payer;
import com.payu.ecommerce.pojo.RequestTransaction;
import com.payu.ecommerce.pojo.TxValue;
import com.payu.ecommerce.pojo.Utils;
import com.payu.ecommerce.refund.RefundTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.concurrent.ThreadLocalRandom;

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

		int numero = ThreadLocalRandom.current().nextInt(1, 1000000 + 1);
		TxValue tXVALUE = new TxValue(Integer.parseInt(util.getTxValue()), util.getCurrency());
		AdditionalValues additionalValues = new AdditionalValues(tXVALUE);
		Order order = new Order(util.getOrderNumber(), util.getReferenceCode()+"TTT"+numero, util.getDescriptionOrder(), util.getLanguage(), additionalValues);
		Payer payer = new Payer(util.getPayerNumber(), name, email, util.getContactNUmber(), util.getDniNumber());
		CreditCard creditCard = new CreditCard(card, cvv, util.getExpirationDate(), "APPROVED");
		Merchant merchant = new  Merchant(util.getMerchantApiLogin(), util.getMerchantApiKey());
		com.payu.ecommerce.pojo.Transaction transaction = new com.payu.ecommerce.pojo.Transaction(order, payer, creditCard, util.getType(), util.getPaymentMethod());
		RequestTransaction requestTransaction = new  RequestTransaction(util.getLanguage(), util.getCommand(), merchant, transaction, true);
		System.out.println(requestTransaction.toString());
		return requestTransaction;

	}

	public RefundTransaction requestRefund(Transaction transaction){

		com.payu.ecommerce.refund.Order order = new com.payu.ecommerce.refund.Order(transaction.getOrderNumber());
		com.payu.ecommerce.refund.Merchant merchant = new com.payu.ecommerce.refund.Merchant(util.getMerchantApiKey(),util.getMerchantApiLogin());
		com.payu.ecommerce.refund.Transaction transaction1 = new com.payu.ecommerce.refund.Transaction(
				order, "REFUND", "Reason for requesting the refund or cancellation of the transaction", transaction.getTransactionId());
		RefundTransaction refundTransaction = new RefundTransaction(util.getLanguage(), util.getCommand(),
																	merchant,
																	transaction1, false);
		return refundTransaction;


	}

}
