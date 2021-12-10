package com.iocl.dhruva2api.model.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MST_EMPLOYEE_JURISDICTION")
public class MstEmpJurisdiction {

	@Id
	@Column(name = "SR_NO")
	private int srNo;
	
	@Column(name = "PSA_CODE")
	private String psaCode;
	
	@Column(name = "PA_CODE")
	private String paCodeLike;
	
	@Column(name = "USER_LEVEL")
	private String userLevel;

	public int getSrNo() {
		return srNo;
	}

	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}

	public String getPsaCode() {
		return psaCode;
	}

	public void setPsaCode(String psaCode) {
		this.psaCode = psaCode;
	}

	public String getPaCodeLike() {
		return paCodeLike;
	}

	public void setPaCodeLike(String paCodeLike) {
		this.paCodeLike = paCodeLike;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	
	
}
