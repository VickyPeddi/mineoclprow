/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iocl.dhruva2api.model.tracker;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author 00511172
 */
@Embeddable
public class FITTrackerPK implements Serializable {

	private static final long serialVersionUID = 6411947305985858928L;

	@Column(name = "AUDIT_ID")
	private long auditId;

	@Basic(optional = false)
	@Column(name = "CAT_ID")
	private int catId;

	/**
	 * 
	 */

	public FITTrackerPK() {
	}

	/**
	 * @param auditId
	 * @param catId
	 */

	public FITTrackerPK(long auditId, int catId) {
		this.auditId = auditId;
		this.catId = catId;
	}

	/**
	 * @return the auditId
	 */
	public long getAuditId() {
		return auditId;
	}

	/**
	 * @param auditId the auditId to set
	 */
	public void setAuditId(long auditId) {
		this.auditId = auditId;
	}

	/**
	 * @return the catId
	 */
	public int getCatId() {
		return catId;
	}

	/**
	 * @param catId the catId to set
	 */
	public void setCatId(int catId) {
		this.catId = catId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */

	@Override
	public int hashCode() {
		return Objects.hash(auditId, catId);
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
		if (!(obj instanceof FITTrackerPK))
			return false;
		FITTrackerPK other = (FITTrackerPK) obj;
		return auditId == other.auditId && catId == other.catId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "FitTrackerPK [auditId=" + auditId + ", catId=" + catId + "]";
	}

}
