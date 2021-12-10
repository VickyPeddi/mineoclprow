package com.iocl.dhruva2api.model.employee;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EmployeeMaster
 */
@Entity
@Table(name = "MST_EMPLOYEE")
public class EmployeeMaster {

	@Id
	@Column(name = "EMP_CODE")
	private int empCode;

	@Column(name = "EMP_NAME")
	private String empName;

	@Column(name = "DESIGNATION")
	private String designation;

	@Column(name = "SALES_GROUP")
	private String salesGroup;

	@Column(name = "PSA_CODE")
	private String psaCode;

	@Column(name = "PA_CODE")
	private String paCode;

	@Column(name = "LOC_CODE")
	private int locationCode;

	@Column(name = "LOC_NAME")
	private String locationName;

	@Column(name = "CURR_COMP_CODE")
	private int currCompCode;

	@Column(name = "curr_comp")
	private String currCompanyName;

	@Column(name = "so_name")
	private String soName;

	@Column(name = "SALESOFF_NAME")
	private String salesOffName;

	@Column(name = "SALESAREA_NAME")
	private String salesAreaName;

	@Column(name = "LOCN_IC_YN")
	private String locInFlag;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "MOBILE_NO")
	private String mobileNo;

	@Column(name = "FUNC_HEAD_YN")
	private String funcHeadFlag;

	public EmployeeMaster() {

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
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the salesGroup
	 */
	public String getSalesGroup() {
		return salesGroup;
	}

	/**
	 * @param salesGroup the salesGroup to set
	 */
	public void setSalesGroup(String salesGroup) {
		this.salesGroup = salesGroup;
	}

	/**
	 * @return the psaCode
	 */
	public String getPsaCode() {
		return psaCode;
	}

	/**
	 * @param psaCode the psaCode to set
	 */
	public void setPsaCode(String psaCode) {
		this.psaCode = psaCode;
	}

	/**
	 * @return the paCode
	 */
	public String getPaCode() {
		return paCode;
	}

	/**
	 * @param paCode the paCode to set
	 */
	public void setPaCode(String paCode) {
		this.paCode = paCode;
	}

	/**
	 * @return the locationCode
	 */
	public int getLocationCode() {
		return locationCode;
	}

	/**
	 * @param locationCode the locationCode to set
	 */
	public void setLocationCode(int locationCode) {
		this.locationCode = locationCode;
	}

	/**
	 * @return the locationName
	 */
	public String getLocationName() {
		return locationName;
	}

	/**
	 * @param locationName the locationName to set
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	/**
	 * @return the currCompCode
	 */
	public int getCurrCompCode() {
		return currCompCode;
	}

	/**
	 * @param currCompCode the currCompCode to set
	 */
	public void setCurrCompCode(int currCompCode) {
		this.currCompCode = currCompCode;
	}

	/**
	 * @return the currCompanyName
	 */
	public String getCurrCompanyName() {
		return currCompanyName;
	}

	/**
	 * @param currCompanyName the currCompanyName to set
	 */
	public void setCurrCompanyName(String currCompanyName) {
		this.currCompanyName = currCompanyName;
	}

	/**
	 * @return the soName
	 */
	public String getSoName() {
		return soName;
	}

	/**
	 * @param soName the soName to set
	 */
	public void setSoName(String soName) {
		this.soName = soName;
	}

	/**
	 * @return the salesOffName
	 */
	public String getSalesOffName() {
		return salesOffName;
	}

	/**
	 * @param salesOffName the salesOffName to set
	 */
	public void setSalesOffName(String salesOffName) {
		this.salesOffName = salesOffName;
	}

	/**
	 * @return the salesAreaName
	 */
	public String getSalesAreaName() {
		return salesAreaName;
	}

	/**
	 * @param salesAreaName the salesAreaName to set
	 */
	public void setSalesAreaName(String salesAreaName) {
		this.salesAreaName = salesAreaName;
	}

	/**
	 * @return the locInFlag
	 */
	public String getLocInFlag() {
		return locInFlag;
	}

	/**
	 * @param locInFlag the locInFlag to set
	 */
	public void setLocInFlag(String locInFlag) {
		this.locInFlag = locInFlag;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * @return the funcHeadFlag
	 */
	public String getFuncHeadFlag() {
		return funcHeadFlag;
	}

	/**
	 * @param funcHeadFlag the funcHeadFlag to set
	 */
	public void setFuncHeadFlag(String funcHeadFlag) {
		this.funcHeadFlag = funcHeadFlag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */

	@Override
	public int hashCode() {
		return Objects.hash(empCode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof EmployeeMaster))
			return false;
		EmployeeMaster other = (EmployeeMaster) obj;
		return empCode == other.empCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "EmployeeMaster [empCode=" + empCode + ", empName=" + empName + ", designation=" + designation
				+ ", salesGroup=" + salesGroup + ", psaCode=" + psaCode + ", paCode=" + paCode + ", locationCode="
				+ locationCode + ", locationName=" + locationName + ", currCompCode=" + currCompCode
				+ ", currCompanyName=" + currCompanyName + ", soName=" + soName + ", salesOffName=" + salesOffName
				+ ", salesAreaName=" + salesAreaName + ", locInFlag=" + locInFlag + ", emailId=" + emailId
				+ ", mobileNo=" + mobileNo + ", funcHeadFlag=" + funcHeadFlag + "]";
	}
}