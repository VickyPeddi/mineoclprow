package com.iocl.dhruva2api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aud_vendor")
public class AuditUserDocuments {

	@Id
	@Column(name = "userid")
	private String userId;

	private byte[] idProof;

	private byte[] educationProof;

	private byte[] photograph;

	private String idProofExt;

	private String educationProofExt;

	private String photographExt;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public byte[] getIdProof() {
		return idProof;
	}

	public void setIdProof(byte[] idProof) {
		this.idProof = idProof;
	}

	public byte[] getEducationProof() {
		return educationProof;
	}

	public void setEducationProof(byte[] educationProof) {
		this.educationProof = educationProof;
	}

	public byte[] getPhotograph() {
		return photograph;
	}

	public void setPhotograph(byte[] photograph) {
		this.photograph = photograph;
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

}
