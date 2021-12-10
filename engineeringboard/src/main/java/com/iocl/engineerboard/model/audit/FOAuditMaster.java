package com.iocl.dhruva2api.model.audit;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "VW_COMPLETED_FO_AUDIT")
public class FOAuditMaster {

	@Id
	@Column(name = "FO_AUDIT_ID")
	private long auditNo;

	@Column(name = "RO_CODE")
	private int roCode;

	@Column(name = "SALESOFF")
	private int doCode;

	@Column(name = "SALESORG")
	private int soCode;

	@Column(name = "SALESAREA")
	private String salesArea;

	@Column(name = "CUST_NAME")
	private String roName;

	@Column(name = "AUDIT_SUBMISSION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date auditSubmissionDate;

	@Column(name = "SALESAREA_NAME")
	private String salesAreaName;

	@Column(name = "SALESOFF_NAME")
	private String salesOffName;

	private String soName;

	private String location;

	private String auditYear;

	public long getAuditNo() {
		return auditNo;
	}

	public void setAuditNo(long auditNo) {
		this.auditNo = auditNo;
	}

	public int getRoCode() {
		return roCode;
	}

	public void setRoCode(int roCode) {
		this.roCode = roCode;
	}

	public int getDoCode() {
		return doCode;
	}

	public void setDoCode(int doCode) {
		this.doCode = doCode;
	}

	public int getSoCode() {
		return soCode;
	}

	public void setSoCode(int soCode) {
		this.soCode = soCode;
	}

	public String getSalesArea() {
		return salesArea;
	}

	public void setSalesArea(String salesArea) {
		this.salesArea = salesArea;
	}

	public String getRoName() {
		return roName;
	}

	public void setRoName(String roName) {
		this.roName = roName;
	}

	public Date getAuditSubmissionDate() {
		return auditSubmissionDate;
	}

	public void setAuditSubmissionDate(Date auditSubmissionDate) {
		this.auditSubmissionDate = auditSubmissionDate;
	}

	public String getSalesAreaName() {
		return salesAreaName;
	}

	public void setSalesAreaName(String salesAreaName) {
		this.salesAreaName = salesAreaName;
	}

	public String getSalesOffName() {
		return salesOffName;
	}

	public void setSalesOffName(String salesOffName) {
		this.salesOffName = salesOffName;
	}

	public String getSoName() {
		return soName;
	}

	public void setSoName(String soName) {
		this.soName = soName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAuditYear() {
		return auditYear;
	}

	public void setAuditYear(String auditYear) {
		this.auditYear = auditYear;
	}

}
