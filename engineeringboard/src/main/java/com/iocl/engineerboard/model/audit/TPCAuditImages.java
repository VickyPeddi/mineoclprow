package com.iocl.dhruva2api.model.audit;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "tpa_audit_mapping_image")
@IdClass(TPCAuditImagesID.class)
public class TPCAuditImages {

	@Id
	private long auditId;

	@Id
	private int mappingId;

	private byte[] imageData;

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

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

}
