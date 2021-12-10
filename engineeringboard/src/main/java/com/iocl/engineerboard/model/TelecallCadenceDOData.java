package com.iocl.dhruva2api.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * TelecallCadenceDOData
 */

@Entity
@Table(name = "TRN_TELECALL_DO")
public class TelecallCadenceDOData {

	@Transient
	private int salesOff;

	@Column(name = "DOMANAGER_PRESENT")
	private String doManager;

	@Column(name = "DRSM_PRESENT")
	private String drsm;

	@EmbeddedId
	private TelecallCadenceDODataId embeddedKey;

	public TelecallCadenceDOData() {

	}

	public int getSalesOff() {
		return salesOff;
	}

	public void setSalesOff(int salesOff) {
		this.salesOff = salesOff;
	}

	public String getDoManager() {
		return doManager;
	}

	public void setDoManager(String doManager) {
		this.doManager = doManager;
	}

	public String getDrsm() {
		return drsm;
	}

	public void setDrsm(String drsm) {
		this.drsm = drsm;
	}

	public TelecallCadenceDODataId getEmbeddedKey() {
		return embeddedKey;
	}

	public void setEmbeddedKey(TelecallCadenceDODataId embeddedKey) {
		this.embeddedKey = embeddedKey;
	}

}