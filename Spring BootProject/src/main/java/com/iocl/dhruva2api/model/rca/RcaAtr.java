package com.iocl.dhruva2api.model.rca;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TRN_RCA_ATR")
public class RcaAtr {

	@EmbeddedId
	private RcaAtrId embeddedkey;
	
	@Column(name="ISOTHER")
	private String isOther;
	
	@Column(name="VALUE")
	private String value;
	
	@Column(name="UPDATED_ON")
	private Date updatedOn;
	
	@Column(name="USER_DETAILS")
	private String userDetails;
	
	public RcaAtr() {
		this.updatedOn = new Date();
	}

	public RcaAtrId getEmbeddedkey() {
		return embeddedkey;
	}

	public void setEmbeddedkey(RcaAtrId embeddedkey) {
		this.embeddedkey = embeddedkey;
	}

	public String getIsOther() {
		return isOther;
	}

	public void setIsOther(String isOther) {
		this.isOther = isOther;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(String userDetails) {
		this.userDetails = userDetails;
	}
}