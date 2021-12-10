package com.iocl.dhruva2api.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * TelecallCadenceData
 */

@Entity
@Table(name = "TRN_TELECALL_HEADER")
public class TelecallCadenceData {

	@Id
	@Column(name = "SO_DATE")
	private String soDate;

	@Column(name = "SDC_PRESENT")
	private String sdcPresent;

	@Column(name = "SRH_PRESENT")
	private String srhPresent;

	@Column(name = "USER_DETAILS")
	private String userDetails;

	@Temporal(TemporalType.DATE)
	@Column(name = "updated_on")
	private Date updatedOn;

	@Transient
	private int salesOrg;

	@Transient
	private String telecallDate;

	@Transient
	private ArrayList<TelecallCadenceDOData> salesOffDetails;

	public TelecallCadenceData() {
		super();
	}

	public int getSalesOrg() {
		return salesOrg;
	}

	public void setSalesOrg(int salesOrg) {
		this.salesOrg = salesOrg;
	}

	public String getTelecallDate() {
		return telecallDate;
	}

	public void setTelecallDate(String telecallDate) {
		this.telecallDate = telecallDate;
	}

	public ArrayList<TelecallCadenceDOData> getSalesOffDetails() {
		return salesOffDetails;
	}

	public void setSalesOffDetails(ArrayList<TelecallCadenceDOData> salesOffDetails) {
		this.salesOffDetails = salesOffDetails;
	}

	public void setSoDate(String soDate) {
		this.soDate = soDate;
	}

	public String getSoDate() {
		return soDate;
	}

	public void setSoDate() {
		this.soDate = salesOrg + "#" + telecallDate;
	}

	public String getSdcPresent() {
		return sdcPresent;
	}

	public void setSdcPresent(String sdcPresent) {
		this.sdcPresent = sdcPresent;
	}

	public String getSrhPresent() {
		return srhPresent;
	}

	public void setSrhPresent(String srhPresent) {
		this.srhPresent = srhPresent;
	}

	public String getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(String userDetails) {
		this.userDetails = userDetails;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

}