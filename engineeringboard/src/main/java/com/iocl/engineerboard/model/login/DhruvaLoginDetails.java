package com.iocl.dhruva2api.model.login;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

/**
 * DhruvaLoginDetails
 */
@Entity
@Table(name = "DHRUVA_LOGIN_DETAILS")
public class DhruvaLoginDetails {

	@Id
	@GeneratedValue(generator = "loginAccessSeq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(allocationSize = 1, name = "loginAccessSeq", sequenceName = "LOGIN_ACCESS_SEQ")
	@Column(name = "SESSION_ID")
	private long sessionId;

	@Column(name = "USER_DETAILS")
	private String userDetails;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LOGIN_TIME")
	private Date loginTime;

	@Column(name = "LOGOUT_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date logoutTime;

//	@Column(name = "REMARKS")
//	private String remarks;
//
//	@Column(name = "ACTIVE_FLAG")
//	private int activeFlag;

	/**
	 * 
	 */

	public DhruvaLoginDetails() {
	}

	/**
	 * @return the sessionId
	 */
	public long getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(long sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return the userDetails
	 */
	public String getUserDetails() {
		return userDetails;
	}

	/**
	 * @param userDetails the userDetails to set
	 */
	public void setUserDetails(String userDetails) {
		this.userDetails = userDetails;
	}

	/**
	 * @return the loginTime
	 */
	public Date getLoginTime() {
		return loginTime;
	}

	/**
	 * @param loginTime the loginTime to set
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	/**
	 * @return the logoutTime
	 */
	public Date getLogoutTime() {
		return logoutTime;
	}

	/**
	 * @param logoutTime the logoutTime to set
	 */
	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}

	/**
	 * @return the reamrks
	 */
//	public String getRemarks() {
//		return remarks;
//	}
//
//	/**
//	 * @param reamrks the reamrks to set
//	 */
//	public void setRemarks(String remarks) {
//		this.remarks = remarks;
//	}
//
//	/**
//	 * @return the activeFlag
//	 */
//	public int getActiveFlag() {
//		return activeFlag;
//	}
//
//	/**
//	 * @param activeFlag the activeFlag to set
//	 */
//	public void setActiveFlag(int activeFlag) {
//		this.activeFlag = activeFlag;
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */

	@Override
	public int hashCode() {
		return Objects.hash(sessionId);
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
		if (!(obj instanceof DhruvaLoginDetails))
			return false;
		DhruvaLoginDetails other = (DhruvaLoginDetails) obj;
		return sessionId == other.sessionId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

//	@Override
//	public String toString() {
//		return "DhruvaLoginDetails [activeFlag=" + activeFlag + ", loginTime=" + loginTime + ", logoutTime=" + logoutTime
//				+ ", remarks=" + remarks + ", sessionId=" + sessionId + ", userDetails=" + userDetails + "]";
//	}

}