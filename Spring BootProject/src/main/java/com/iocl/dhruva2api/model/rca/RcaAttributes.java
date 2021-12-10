package com.iocl.dhruva2api.model.rca;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MST_RCA_ATTRIBUTES")
public class RcaAttributes {

	@Id
	@Column(name="PROPERTY_NAME")
	private String propertyName;
	
	@Column(name="sr_no")
	private int srNo;

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public int getSrNo() {
		return srNo;
	}

	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	
	
	
}
