package com.iocl.dhruva2api.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * MISMenuItems
 */
@Entity
@Table(name = "DHRUVA_REPORTS_MENUS")
public class MISMenuItems implements Comparable<MISMenuItems> {

	@Id
	@Column(name = "REP_ID")
	private long repId;

	@Column(name = "TAB_ID")
	private long tabId;

	@Column(name = "REP_NAME")
	private String repName;

	@JsonIgnore
	@Column(name = "REP_QUERY1")
	private String repQuery1;

	@JsonIgnore
	@Column(name = "REP_QUERY2")
	private String repQuery2;

	@JsonIgnore
	@Column(name = "ACCESS_COUNT")
	private long accessCount;

	@Column(name = "REPORT_TYPE")
	private int reportType;

	@Column(name = "ACTIVE_FLAG")
	private short activeFlag;

	@Column(name = "NEW_FLAG")
	private short newFlag;

	@Column(name = "MESSAGE")
	private String reportMessage;

	@JsonIgnore
	@Column(name = "FO_ACCESS")
	private short foAccess;

	@JsonIgnore
	@Column(name = "SO_ACCESS")
	private short soAccess;

	@JsonIgnore
	@Column(name = "DO_ACCESS")
	private short doAccess;

	@JsonIgnore
	@Column(name = "RO_ACCESS")
	private short roAccess;

	@JsonIgnore
	@Column(name = "DRSM_ACCESS")
	private short drsmAccess;

	@JsonIgnore
	@Column(name = "SRH_ACCESS")
	private short srhAccess;

	@JsonIgnore
	@Column(name = "HO_ACCESS")
	private short hoAccess;

	@JsonIgnore
	@Column(name = "ADMIN_ACCESS")
	private short adminAccess;

	public MISMenuItems() {

	}

	/**
	 * @return the repId
	 */
	public long getRepId() {
		return repId;
	}

	/**
	 * @param repId the repId to set
	 */
	public void setRepId(long repId) {
		this.repId = repId;
	}

	/**
	 * @return the repName
	 */
	public String getRepName() {
		return repName;
	}

	/**
	 * @param repName the repName to set
	 */
	public void setRepName(String repName) {
		this.repName = repName;
	}

	/**
	 * @return the repQuery1
	 */
	public String getRepQuery1() {
		return repQuery1;
	}

	/**
	 * @param repQuery1 the repQuery1 to set
	 */
	public void setRepQuery1(String repQuery1) {
		this.repQuery1 = repQuery1;
	}

	/**
	 * @return the repQuery2
	 */
	public String getRepQuery2() {
		return repQuery2;
	}

	/**
	 * @param repQuery2 the repQuery2 to set
	 */
	public void setRepQuery2(String repQuery2) {
		this.repQuery2 = repQuery2;
	}

	/**
	 * @return the accessCount
	 */
	public long getAccessCount() {
		return accessCount;
	}

	/**
	 * @param accessCount the accessCount to set
	 */
	public void setAccessCount(long accessCount) {
		this.accessCount = accessCount;
	}

	/**
	 * @return the reportType
	 */
	public int getReportType() {
		return reportType;
	}

	/**
	 * @param reportType the reportType to set
	 */
	public void setReportType(int reportType) {
		this.reportType = reportType;
	}

	/**
	 * @return the activeFlag
	 */
	public short getActiveFlag() {
		return activeFlag;
	}

	/**
	 * @param activeFlag the activeFlag to set
	 */
	public void setActiveFlag(short activeFlag) {
		this.activeFlag = activeFlag;
	}

	/**
	 * @return the newFlag
	 */
	public short getNewFlag() {
		return newFlag;
	}

	/**
	 * @param newFlag the newFlag to set
	 */
	public void setNewFlag(short newFlag) {
		this.newFlag = newFlag;
	}

	/**
	 * @return the reportMessage
	 */
	public String getReportMessage() {
		return reportMessage;
	}

	/**
	 * @param reportMessage the reportMessage to set
	 */
	public void setReportMessage(String reportMessage) {
		this.reportMessage = reportMessage;
	}

	/**
	 * @return the foAccess
	 */
	public short getFoAccess() {
		return foAccess;
	}

	/**
	 * @param foAccess the foAccess to set
	 */
	public void setFoAccess(short foAccess) {
		this.foAccess = foAccess;
	}

	/**
	 * @return the soAccess
	 */
	public short getSoAccess() {
		return soAccess;
	}

	/**
	 * @param soAccess the soAccess to set
	 */
	public void setSoAccess(short soAccess) {
		this.soAccess = soAccess;
	}

	/**
	 * @return the doAccess
	 */
	public short getDoAccess() {
		return doAccess;
	}

	/**
	 * @param doAccess the doAccess to set
	 */
	public void setDoAccess(short doAccess) {
		this.doAccess = doAccess;
	}

	/**
	 * @return the roAccess
	 */
	public short getRoAccess() {
		return roAccess;
	}

	/**
	 * @param roAccess the roAccess to set
	 */
	public void setRoAccess(short roAccess) {
		this.roAccess = roAccess;
	}

	/**
	 * @return the drsmAccess
	 */
	public short getDrsmAccess() {
		return drsmAccess;
	}

	/**
	 * @param drsmAccess the drsmAccess to set
	 */
	public void setDrsmAccess(short drsmAccess) {
		this.drsmAccess = drsmAccess;
	}

	/**
	 * @return the srhAccess
	 */
	public short getSrhAccess() {
		return srhAccess;
	}

	/**
	 * @param srhAccess the srhAccess to set
	 */
	public void setSrhAccess(short srhAccess) {
		this.srhAccess = srhAccess;
	}

	/**
	 * @return the hoAccess
	 */
	public short getHoAccess() {
		return hoAccess;
	}

	/**
	 * @param hoAccess the hoAccess to set
	 */
	public void setHoAccess(short hoAccess) {
		this.hoAccess = hoAccess;
	}

	/**
	 * @return the adminAccess
	 */
	public short getAdminAccess() {
		return adminAccess;
	}

	/**
	 * @param adminAccess the adminAccess to set
	 */
	public void setAdminAccess(short adminAccess) {
		this.adminAccess = adminAccess;
	}

	/**
	 * @return the tabId
	 */
	public long getTabId() {
		return tabId;
	}

	/**
	 * @param tabId the tabId to set
	 */
	public void setTabId(long tabId) {
		this.tabId = tabId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */

	@Override
	public int hashCode() {
		return Objects.hash(repId);
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
		if (!(obj instanceof MISMenuItems))
			return false;
		MISMenuItems other = (MISMenuItems) obj;
		return repId == other.repId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "MISMenuItems [accessCount=" + accessCount + ", activeFlag=" + activeFlag + ", adminAccess=" + adminAccess
				+ ", doAccess=" + doAccess + ", drsmAccess=" + drsmAccess + ", foAccess=" + foAccess + ", hoAccess=" + hoAccess
				+ ", newFlag=" + newFlag + ", repId=" + repId + ", repName=" + repName + ", repQuery1=" + repQuery1
				+ ", repQuery2=" + repQuery2 + ", reportMessage=" + reportMessage + ", reportType=" + reportType + ", roAccess="
				+ roAccess + ", soAccess=" + soAccess + ", srhAccess=" + srhAccess + ", tabId=" + tabId + "]";
	}

	@Override
	public int compareTo(MISMenuItems candidate) {
		return (this.getRepId() < candidate.getRepId() ? -1 : 1);
	}

}