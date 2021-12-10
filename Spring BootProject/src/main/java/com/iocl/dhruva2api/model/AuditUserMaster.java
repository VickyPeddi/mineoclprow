package com.iocl.dhruva2api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "aud_vendor")
public class AuditUserMaster {

	@Id
	@Column(name = "userid")
	private String userId;

	private String role;

	private String firstName;

	private String lastName;

	private String vendorAdminCode;

	@Transient
	private String vendorAdminName;

	private String email;

	private long mobile;

	private int status;

	private String qualificationLevel;

	private String idType;

	private String idNo;

	private String idProofExt;

	private String educationProofExt;

	private String photographExt;

	@Column(name = "emp_status")
	private String empStatus;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getVendorAdminCode() {
		return vendorAdminCode;
	}

	public void setVendorAdminCode(String vendorAdminCode) {
		this.vendorAdminCode = vendorAdminCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getQualificationLevel() {
		return qualificationLevel;
	}

	public void setQualificationLevel(String qualificationLevel) {
		this.qualificationLevel = qualificationLevel;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	public String getIdProofExt() {
		return idProofExt;
	}

	public void setIdProofExt(String idProofExt) {
		this.idProofExt = idProofExt;
	}

	public String getEducationProofExt() {
		return educationProofExt;
	}

	public void setEducationProofExt(String educationProofExt) {
		this.educationProofExt = educationProofExt;
	}

	public String getPhotographExt() {
		return photographExt;
	}

	public void setPhotographExt(String photographExt) {
		this.photographExt = photographExt;
	}

	public String getVendorAdminName() {
		return vendorAdminName;
	}

	public void setVendorAdminName(String vendorAdminName) {
		this.vendorAdminName = vendorAdminName;
	}

}
