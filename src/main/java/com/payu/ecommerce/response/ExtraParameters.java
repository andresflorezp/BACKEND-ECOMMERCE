package com.payu.ecommerce.response;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ExtraParameters {

	private String bANKREFERENCEDCODE;
	private String pAYMENTWAYID;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public ExtraParameters() {
	}

	/**
	 *
	 * @param bANKREFERENCEDCODE
	 * @param pAYMENTWAYID
	 */
	public ExtraParameters(String bANKREFERENCEDCODE, String pAYMENTWAYID) {
		super();
		this.bANKREFERENCEDCODE = bANKREFERENCEDCODE;
		this.pAYMENTWAYID = pAYMENTWAYID;
	}

	public String getBANKREFERENCEDCODE() {
		return bANKREFERENCEDCODE;
	}

	public void setBANKREFERENCEDCODE(String bANKREFERENCEDCODE) {
		this.bANKREFERENCEDCODE = bANKREFERENCEDCODE;
	}

	public String getPAYMENTWAYID() {
		return pAYMENTWAYID;
	}

	public void setPAYMENTWAYID(String pAYMENTWAYID) {
		this.pAYMENTWAYID = pAYMENTWAYID;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("bANKREFERENCEDCODE", bANKREFERENCEDCODE).append("pAYMENTWAYID", pAYMENTWAYID).toString();
	}

}