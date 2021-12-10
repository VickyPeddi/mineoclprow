package com.iocl.dhruva2api.model.leaderboard;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FO_LEADERBOARD")
public class SASEVAScore {

	@Id
	@Column(name="SALESAREA_NAME")
	private String saMaster;
	
	@Column(name="SALESOff_NAME")
	private String salesoffName;
	
	@Column(name="SEVA")
	private String seva;

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

	public String getSeva() {
		return seva;
	}

	public void setSeva(String seva) {
		this.seva = seva;
	}
	

}
