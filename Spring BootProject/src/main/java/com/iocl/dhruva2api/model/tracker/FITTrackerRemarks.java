package com.iocl.dhruva2api.model.tracker;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "FIT_TRACKER_REMARKS")
public class FITTrackerRemarks implements Serializable {

	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fit_rem_seq")
	@SequenceGenerator(allocationSize = 1, sequenceName = "FIT_REMARK_SEQ", name = "fit_rem_seq")
	@Column(name = "REMARKS_ID")
	private BigDecimal remarksId;

	@JsonIgnore
	@Column(name = "AUDIT_ID")
	private long auditId;

	@JsonIgnore
	@Column(name = "CAT_ID")
	private int catId;

	@Column(name = "REMARKS")
	private String remarks;

	@Column(name = "REMARKS_LEVEL")
	private String remarksLevel;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Column(name = "UPDATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;

	public FITTrackerRemarks() {
	}

	public FITTrackerRemarks(BigDecimal remarksId) {
		this.remarksId = remarksId;
	}

	public FITTrackerRemarks(long auditId, int catId, String remarks, String remarksLevel, String updatedBy,
			Date updatedOn) {
		this.auditId = auditId;
		this.catId = catId;
		this.remarks = remarks;
		this.remarksLevel = remarksLevel;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

	public BigDecimal getRemarksId() {
		return remarksId;
	}

	public void setRemarksId(BigDecimal remarksId) {
		this.remarksId = remarksId;
	}

	public long getAuditId() {
		return auditId;
	}

	public void setAuditId(long auditId) {
		this.auditId = auditId;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRemarksLevel() {
		return remarksLevel;
	}

	public void setRemarksLevel(String remarksLevel) {
		this.remarksLevel = remarksLevel;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (remarksId != null ? remarksId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof FITTrackerRemarks)) {
			return false;
		}
		FITTrackerRemarks other = (FITTrackerRemarks) object;
		if ((this.remarksId == null && other.remarksId != null)
				|| (this.remarksId != null && !this.remarksId.equals(other.remarksId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.iocl.dhruva2leaderboardmail.FitTrackerRemarks[ remarksId=" + remarksId + " ]";
	}

}
