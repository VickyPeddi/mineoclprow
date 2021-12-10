package com.iocl.dhruva2api.model.help;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DhruvaHelp
 */
@Entity
@Table(name = "HO_FPRS")
public class DhruvaHelp {

	@Id
	@Column(name = "EMP_CODE")
	private int empCode;

	@Column(name = "USER_TYPE")
	private String userType;

	@Column(name = "ACTIVE")
	private char activeFlag;

	/**
	 * 
	 */

	public DhruvaHelp() {
	}

	/**
	 * @return the empCode
	 */
	public int getEmpCode() {
		return empCode;
	}

	/**
	 * @param empCode the empCode to set
	 */
	public void setEmpCode(int empCode) {
		this.empCode = empCode;
	}

	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * @return the activeFlag
	 */
	public char getActiveFlag() {
		return activeFlag;
	}

	/**
	 * @param activeFlag the activeFlag to set
	 */
	public void setActiveFlag(char activeFlag) {
		this.activeFlag = activeFlag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "DhruvaHelp [activeFlag=" + activeFlag + ", empCode=" + empCode + ", userType=" + userType + "]";
	}

}