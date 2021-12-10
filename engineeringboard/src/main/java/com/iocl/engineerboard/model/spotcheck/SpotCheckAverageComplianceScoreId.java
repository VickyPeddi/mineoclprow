package com.iocl.dhruva2api.model.spotcheck;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SpotCheckAverageComplianceScoreId
 */
@Embeddable
public class SpotCheckAverageComplianceScoreId implements Serializable {

	private static final long serialVersionUID = -8281266165613453353L;

	@Column(name = "INSP_NO")
	private long inspNo;

	@Column(name = "MODULE_NAME")
	private String moduleName;

	/**
	 * 
	 */

	public SpotCheckAverageComplianceScoreId() {
	}

	/**
	 * @param inspNo
	 * @param moduleName
	 */

	public SpotCheckAverageComplianceScoreId(long inspNo, String moduleName) {
		this.inspNo = inspNo;
		this.moduleName = moduleName;
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
	 * @return the moduleName
	 */
	public String getModuleName() {
		return moduleName;
	}

	/**
	 * @param moduleName the moduleName to set
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */

	@Override
	public int hashCode() {
		return Objects.hash(inspNo, moduleName);
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
		if (!(obj instanceof SpotCheckAverageComplianceScoreId))
			return false;
		SpotCheckAverageComplianceScoreId other = (SpotCheckAverageComplianceScoreId) obj;
		return inspNo == other.inspNo && Objects.equals(moduleName, other.moduleName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "SpotCheckAverageComplianceScoreId [inspNo=" + inspNo + ", moduleName=" + moduleName + "]";
	}

}