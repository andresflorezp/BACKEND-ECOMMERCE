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
	
	@GeneratedValue
	private String accountId;
	//El reference Code lo creamos apartir de la concatenacion de nombre|valor|numero_random
	private String referenceCode;
	
	@GeneratedValue
	private String merchantPayerId;
	
	//Lo generamos apartir del Fullname; guardado en la base de datos;
	private String payerFullName;
	
	//Lo generamos apartir de email guardado en la bse de datos
	private String payerEmail;
	
	//Lo generamos apartir del fullname guardado en la base de datos;
	private String nameCard;

	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	public static String randomAlphaNumeric(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
	
	public Transaction(Long id, String accountId, String referenceCode, String merchantPayerId, String payerFullName,
			String payerEmail, String nameCard) {
		super();
		this.id = id;
		this.accountId = randomAlphaNumeric(10);
		this.referenceCode = randomAlphaNumeric(10);
		this.merchantPayerId = randomAlphaNumeric(10);
		this.payerFullName = payerFullName;
		this.payerEmail = payerEmail;
		this.nameCard = nameCard;
	}
	

	



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getReferenceCode() {
		return referenceCode;
	}

	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}

	public String getMerchantPayerId() {
		return merchantPayerId;
	}

	public void setMerchantPayerId(String merchantPayerId) {
		this.merchantPayerId = merchantPayerId;
	}

	public String getPayerFullName() {
		return payerFullName;
	}

	public void setPayerFullName(String payerFullName) {
		this.payerFullName = payerFullName;
	}

	public String getPayerEmail() {
		return payerEmail;
	}

	public void setPayerEmail(String payerEmail) {
		this.payerEmail = payerEmail;
	}

	public String getNameCard() {
		return nameCard;
	}

	public void setNameCard(String nameCard) {
		this.nameCard = nameCard;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", accountId=" + accountId + ", referenceCode=" + referenceCode
				+ ", merchantPayerId=" + merchantPayerId + ", payerFullName=" + payerFullName + ", payerEmail="
				+ payerEmail + ", nameCard=" + nameCard + "]";
	}
	
	
	
	
	

}
