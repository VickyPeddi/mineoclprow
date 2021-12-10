package com.iocl.dhruva2api.model.spotcheck;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

/**
 * SpotCheckAtr
 */
@Entity
@Table(name = "SPOT_CHECK_ATR")
public class SpotCheckAtr {

	@EmbeddedId
	private SpotCheckAtrID id;

	@Column(name = "REMARKS")
	private String remarks;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Column(name = "UPDATED_FLAG")
	private String updatedFlag;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_ON")
	private Date updatedOn;

	/**
	 * 
	 */

	public SpotCheckAtr() {
	}

	/**
	 * @param id
	 * @param remarks
	 * @param updatedBy
	 * @param updatedFlag
	 * @param updatedOn
	 */

	public SpotCheckAtr(SpotCheckAtrID id, String remarks, String updatedBy, String updatedFlag, Date updatedOn) {
		this.id = id;
		this.remarks = remarks;
		this.updatedBy = updatedBy;
		this.updatedFlag = updatedFlag;
		this.updatedOn = updatedOn;
	}

	/**
	 * @return the id
	 */
	public SpotCheckAtrID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(SpotCheckAtrID id) {
		this.id = id;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the updatedFlag
	 */
	public String getUpdatedFlag() {
		return updatedFlag;
	}

	/**
	 * @param updatedFlag the updatedFlag to set
	 */
	public void setUpdatedFlag(String updatedFlag) {
		this.updatedFlag = updatedFlag;
	}

	/**
	 * @return the updatedOn
	 */
	public Date getUpdatedOn() {
		return updatedOn;
	}

	/**
	 * @param updatedOn the updatedOn to set
	 */
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		if (!(obj instanceof SpotCheckAtr))
			return false;
		SpotCheckAtr other = (SpotCheckAtr) obj;
		return Objects.equals(id, other.id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "SpotCheckAtr [id=" + id + ", remarks=" + remarks + ", updatedBy=" + updatedBy + ", updatedFlag="
				+ updatedFlag + ", updatedOn=" + updatedOn + "]";
	}

}