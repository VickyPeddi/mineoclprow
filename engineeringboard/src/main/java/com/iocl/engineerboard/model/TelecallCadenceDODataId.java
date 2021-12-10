package com.iocl.dhruva2api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TelecallCadenceDODataId implements Serializable {

	private static final long serialVersionUID = -5213732449872146326L;

	@Column(name = "SALESOFF")
	private int salesOff;

	@Column(name = "SO_DATE")
	private String soDate;

	public TelecallCadenceDODataId() {

	}

	public TelecallCadenceDODataId(int salesOff, String soDate) {
		this.salesOff = salesOff;
		this.soDate = soDate;
	}

	public int getSalesOff() {
		return salesOff;
	}

	public void setSalesOff(int salesOff) {
		this.salesOff = salesOff;
	}

	public String getSoDate() {
		return soDate;
	}

	public void setSoDate(String soDate) {
		this.soDate = soDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + salesOff;
		result = prime * result + ((soDate == null) ? 0 : soDate.hashCode());
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
		TelecallCadenceDODataId other = (TelecallCadenceDODataId) obj;
		if (salesOff != other.salesOff)
			return false;
		if (soDate == null) {
			if (other.soDate != null)
				return false;
		} else if (!soDate.equals(other.soDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TelecallCadenceDODataId [salesOff=" + salesOff + ", soDate=" + soDate + "]";
	}
}
