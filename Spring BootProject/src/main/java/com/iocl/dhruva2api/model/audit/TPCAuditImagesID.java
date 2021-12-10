package com.iocl.dhruva2api.model.audit;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TPCAuditImagesID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1782858217530101651L;
	private long auditId;
	private int mappingId;

	public TPCAuditImagesID(long auditId, int mappingId) {
		super();
		this.auditId = auditId;
		this.mappingId = mappingId;
	}

	public long getAuditId() {
		return auditId;
	}

	public void setAuditId(long auditId) {
		this.auditId = auditId;
	}

	public int getMappingId() {
		return mappingId;
	}

	public void setMappingId(int mappingId) {
		this.mappingId = mappingId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
