package com.iocl.dhruva2api.model.leaderboard;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FO_LEADERBOARD")
public class SADhruvaCompliant {

	@Id
	@Column(name="SALESAREA_NAME")
	private String saMaster;
	
	@Column(name="SALESOff_NAME")
	private String salesoffName;
	
	@Column(name="DHRUVA_COMPLIANT")
	private String dhruvaCompliant;

	public String getSaMaster() {
		return saMaster;
	}

	public void setSaMaster(String saMaster) {
		this.saMaster = saMaster;
	}

	public String getSalesoffName() {
		return salesoffName;
	}

	public void setSalesoffName(String salesoffName) {
		this.salesoffName = salesoffName;
	}

	public String getDhruvaCompliant() {
		return dhruvaCompliant;
	}

	public void setDhruvaCompliant(String dhruvaCompliant) {
		this.dhruvaCompliant = dhruvaCompliant;
	}

	
	

}
