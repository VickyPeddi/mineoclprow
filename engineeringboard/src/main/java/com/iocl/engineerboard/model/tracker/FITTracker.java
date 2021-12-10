/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iocl.dhruva2api.model.tracker;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

/**
 *
 * @author 00511172
 */
@Entity
@Table(name = "FIT_TRACKER")
public class FITTracker implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	protected FITTrackerPK fitTrackerPK;

	@Column(name = "STATUS")
	private int status;

	@Column(name = "ACTUAL_START_DATE")
	@Temporal(TemporalType.DATE)
	private Date actualStartDate;

	@Column(name = "ACTUAL_COMPLETE_DATE")
	@Temporal(TemporalType.DATE)
	private Date actualCompletionDate;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Column(name = "UPDATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;

	// Remarks does not exist in table. For consuming API body, using this.
	@Transient
	private String remarks;

	@Transient
	private String userLevel;

	public FITTracker() {
	}

	public FITTracker(FITTrackerPK fitTrackerPK) {
		this.fitTrackerPK = fitTrackerPK;
	}

	public FITTracker(FITTrackerPK fitTrackerPK, int status, Date actualStartDate, Date actualCompletionDate,
			String updatedBy, Date updatedOn) {
		this.fitTrackerPK = fitTrackerPK;
		this.status = status;
		this.actualStartDate = actualStartDate;
		this.actualCompletionDate = actualCompletionDate;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

	public FITTracker(long auditId, int catId) {
		this.fitTrackerPK = new FITTrackerPK(auditId, catId);
	}

	public FITTrackerPK getFitTrackerPK() {
		return fitTrackerPK;
	}

	public void setFitTrackerPK(FITTrackerPK fitTrackerPK) {
		this.fitTrackerPK = fitTrackerPK;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getActualStartDate() {
		return actualStartDate;
	}

	public void setActualStartDate(String actualStartDate) {
		if (actualStartDate == null) {
			return;
		}
		try {
			this.actualStartDate = new SimpleDateFormat("yyyy-MM-dd").parse(actualStartDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public Date getActualCompletionDate() {
		return actualCompletionDate;
	}

	public void setActualCompletionDate(String actualCompletionDate) {
		if (actualCompletionDate == null) {
			return;
		}
		try {
			this.actualCompletionDate = new SimpleDateFormat("yyyy-MM-dd").parse(actualCompletionDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = Jsoup.clean(remarks, Whitelist.none());
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (fitTrackerPK != null ? fitTrackerPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof FITTracker)) {
			return false;
		}
		FITTracker other = (FITTracker) object;
		if ((this.fitTrackerPK == null && other.fitTrackerPK != null)
				|| (this.fitTrackerPK != null && !this.fitTrackerPK.equals(other.fitTrackerPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.iocl.dhruva2leaderboardmail.FitTracker[ fitTrackerPK=" + fitTrackerPK + " ]";
	}

}
