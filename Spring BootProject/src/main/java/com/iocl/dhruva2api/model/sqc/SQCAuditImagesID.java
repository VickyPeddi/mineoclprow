package com.iocl.dhruva2api.model.sqc;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class SQCAuditImagesID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3523477071361961342L;
	private long sqcAuditId;
	private int mappingId;

	public SQCAuditImagesID(long sqcAuditId, int mappingId) {
		super();
		this.sqcAuditId = sqcAuditId;
		this.mappingId = mappingId;
	}

	public long getSqcAuditId() {
		return sqcAuditId;
	}

	public void setSqcAuditId(long sqcAuditId) {
		this.sqcAuditId = sqcAuditId;
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
