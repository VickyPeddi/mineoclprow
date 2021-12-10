package com.iocl.dhruva2api.model.spotcheck;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SpotCheckComplianceDRSM
 */
@Entity
@Table(name = "VW_SPOT_CHECK_COMP_DRSM")
public class SpotCheckComplianceDRSM {

	@Id
	@Column(name = "INSP_NO")
	private long inspNo;

	@Column(name = "RO_CODE")
	private int roCode;

	@Column(name = "CUST_NAME")
	private String roName;

	@Column(name = "SALESAREA")
	private String salesAreaCode;

	@Column(name = "SALESAREA_NAME")
	private String salesAreaName;

	@Column(name = "CUST_CITY")
	private String location;

	/**
	 * 
	 */

	public SpotCheckComplianceDRSM() {
	}

	/**
	 * @return the inspNo
	 */
	public long getInspNo() {
		return inspNo;
	}

	/**
	 * @param inspNo the inspNo to set
	 */
	public void setInspNo(long inspNo) {
		this.inspNo = inspNo;
	}

	/**
	 * @return the roCode
	 */
	public int getRoCode() {
		return roCode;
	}

	/**
	 * @param roCode the roCode to set
	 */
	public void setRoCode(int roCode) {
		this.roCode = roCode;
	}

	/**
	 * @return the roName
	 */
	public String getRoName() {
		return roName;
	}

	/**
	 * @param roName the roName to set
	 */
	public void setRoName(String roName) {
		this.roName = roName;
	}

	/**
	 * @return the salesAreaCode
	 */
	public String getSalesAreaCode() {
		return salesAreaCode;
	}

	/**
	 * @param salesAreaCode the salesAreaCode to set
	 */
	public void setSalesAreaCode(String salesAreaCode) {
		this.salesAreaCode = salesAreaCode;
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
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */

	@Override
	public int hashCode() {
		return Objects.hash(inspNo);
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
		if (!(obj instanceof SpotCheckComplianceDRSM))
			return false;
		SpotCheckComplianceDRSM other = (SpotCheckComplianceDRSM) obj;
		return inspNo == other.inspNo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "SpotCheckComplianceDRSM [inspNo=" + inspNo + ", location=" + location + ", roCode=" + roCode + ", roName="
				+ roName + ", salesAreaCode=" + salesAreaCode + ", salesAreaName=" + salesAreaName + "]";
	}

}