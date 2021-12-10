package com.iocl.dhruva2api.model.sqc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "sqc_audit_mapping_image")
@IdClass(SQCAuditImagesID.class)
public class SQCAuditImages {

	@Id
	private long sqcAuditId;

	@Id
	private int mappingId;

	private byte[] imageData;

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

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

}
