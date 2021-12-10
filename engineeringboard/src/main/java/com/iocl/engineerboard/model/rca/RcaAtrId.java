package com.iocl.dhruva2api.model.rca;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class RcaAtrId implements Serializable {

	private static final long serialVersionUID = -2539475393806363817L;

	@Column(name = "RO_CODE")
	private int roCode;

	@JsonIgnore
	@Column(name = "ATTRIBUTE_NO")
	private int attributeNo;
	
	@Column(name="ROOTCAUSE_SR")
	private int rootCauseSrNo;

	public RcaAtrId() {
		super();
	}

	public RcaAtrId(int roCode, int attributeNo, int rootCauseSrNo) {
		super();
		this.roCode = roCode;
		this.attributeNo = attributeNo;
		this.rootCauseSrNo = rootCauseSrNo;
	}

	public int getRoCode() {
		return roCode;
	}

	public void setRoCode(int roCode) {
		this.roCode = roCode;
	}

	public int getAttributeNo() {
		return attributeNo;
	}

	public void setAttributeNo(int attributeNo) {
		this.attributeNo = attributeNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + attributeNo;
		result = prime * result + roCode;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RcaAtrId other = (RcaAtrId) obj;
		if (attributeNo != other.attributeNo)
			return false;
		if (roCode != other.roCode)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RcaAtrId [attributeNo=" + attributeNo + ", roCode=" + roCode + "]";
	}

	public int getRootCauseSrNo() {
		return rootCauseSrNo;
	}

	public void setRootCauseSrNo(int rootCauseSrNo) {
		this.rootCauseSrNo = rootCauseSrNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
