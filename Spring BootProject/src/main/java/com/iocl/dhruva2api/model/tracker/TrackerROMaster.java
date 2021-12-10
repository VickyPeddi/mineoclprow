package com.iocl.dhruva2api.model.tracker;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "VW_LATEST_AUDIT_FOR_TRACKER")
public class TrackerROMaster {

	@Id
	@Column(name = "AUDIT_ID")
	private long auditNo;

	@Column(name = "RO_CODE")
	private int roCode;

	@Column(name = "CUST_NAME")
	private String roName;

	@Column(name = "SALESAREA")
	private String salesArea;

	@Column(name = "SALESAREA_NAME")
	private String salesAreaName;

	@Column(name = "SALESOFF_NAME")
	private String salesOffName;

	@Column(name = "PLAN_START_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date planStartDate;

	@Column(name = "ACTUAL_AUDIT_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date actualAuditDate;

	@Column(name = "LOCATION")
	private String location;

	@Column(name = "SALESOFF")
	private int salesOff;

	@Column(name = "SALESORG")
	private int salesOrg;

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

	public String getRoName() {
		return roName;
	}

	public void setRoName(String roName) {
		this.roName = roName;
	}

	public String getSalesArea() {
		return salesArea;
	}

	public void setSalesArea(String salesArea) {
		this.salesArea = salesArea;
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

	public Date getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(Date planStartDate) {
		this.planStartDate = planStartDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getSalesoff() {
		return salesOff;
	}

	public void setSalesoff(int salesOff) {
		this.salesOff = salesOff;
	}

	public int getSalesorg() {
		return salesOrg;
	}

	public void setSalesorg(int salesOrg) {
		this.salesOrg = salesOrg;
	}

	public Date getActualAuditDate() {
		return actualAuditDate;
	}

	public void setActualAuditDate(Date actualAuditDate) {
		this.actualAuditDate = actualAuditDate;
	}

	public int getSalesOff() {
		return salesOff;
	}

	public void setSalesOff(int salesOff) {
		this.salesOff = salesOff;
	}

	public int getSalesOrg() {
		return salesOrg;
	}

	public void setSalesOrg(int salesOrg) {
		this.salesOrg = salesOrg;
	}

}
