package com.iocl.dhruva2api.model.help;

/**
 * DhruvaHelpResponsePayload
 */
public class DhruvaHelpResponsePayload {

	private int empCode;
	private String empName;
	private String emailId;
	private String mobileNo;
	private String userType;

	/**
	 * 
	 */

	public DhruvaHelpResponsePayload() {
	}

	/**
	 * @param empCode
	 * @param empName
	 * @param emailId
	 * @param mobileNo
	 * @param userType
	 */

	public DhruvaHelpResponsePayload(int empCode, String empName, String emailId, String mobileNo, String userType) {
		this.empCode = empCode;
		this.empName = empName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.userType = userType;
	}

	/**
	 * @return the empCode;
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
		if (mobileNo != null && mobileNo.length() == 12) {
			return "+" + mobileNo;
		}
		return mobileNo;
	}

	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "DhruvaHelpResponsePayload [emailId=" + emailId + ", empCode=" + empCode + ", empName=" + empName
				+ ", mobileNo=" + mobileNo + ", userType=" + userType + "]";
	}

}