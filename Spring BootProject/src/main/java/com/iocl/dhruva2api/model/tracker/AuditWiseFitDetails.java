package com.iocl.dhruva2api.model.tracker;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author 00511172
 */
@Entity
@Table(name = "VW_FIT_DETAILS")
public class AuditWiseFitDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	protected FITTrackerPK fitTrackerPK;

	@JsonIgnore
	@Transient
	@Column(name = "RO_CODE")
	private int roCode;

	@Column(name = "CATEGORY_TEXT")
	private String categoryText;

	@Column(name = "SCORE")
	private int score;

	@Column(name = "ACTUAL_START_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date actualStartDate;

	@Column(name = "ACTUAL_COMPLETE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date actualCompleteDate;

	@Column(name = "PLAN_TARGET_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date planTargetDate;

	@Column(name = "STAGE")
	private String stage;

	@Column(name = "ACTION_PLAN")
	private String actionPlan;

	@Column(name = "STATUS")
	private int status;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "AUDIT_ID"), @JoinColumn(name = "CAT_ID") })
	private List<FITTrackerRemarks> fitRemarks;

	public AuditWiseFitDetails() {
	}

	public FITTrackerPK getFitTrackerPK() {
		return fitTrackerPK;
	}

	public void setFitTrackerPK(FITTrackerPK fitTrackerPK) {
		this.fitTrackerPK = fitTrackerPK;
	}

	public int getRoCode() {
		return roCode;
	}

	public void setRoCode(int roCode) {
		this.roCode = roCode;
	}

	public String getCategoryText() {
		return categoryText;
	}

	public void setCategoryText(String categoryText) {
		this.categoryText = categoryText;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getPlanTargetDate() {
		return planTargetDate;
	}

	public void setPlanTargetDate(Date planTargetDate) {
		this.planTargetDate = planTargetDate;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getActionPlan() {
		return actionPlan;
	}

	public void setActionPlan(String actionPlan) {
		this.actionPlan = actionPlan;
	}

	public Date getActualStartDate() {
		return actualStartDate;
	}

	public void setActualStartDate(Date actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public Date getActualCompleteDate() {
		return actualCompleteDate;
	}

	public void setActualCompleteDate(Date actualCompleteDate) {
		this.actualCompleteDate = actualCompleteDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<FITTrackerRemarks> getFitRemarks() {
		return fitRemarks;
	}

	public void setFitRemarks(List<FITTrackerRemarks> fitRemarks) {
		this.fitRemarks = fitRemarks;
	}

}
