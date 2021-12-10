package com.iocl.dhruva2api.model.resource;

import java.util.Arrays;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * DhruvaResourceFile
 */
@Entity
@Table(name = "DHRUVA_RESOURCE_FILE")
public class DhruvaResourceFile {

	@Id
	@Column(name = "RESOURCE_ID")
	private long resourceId;

	@Column(name = "RESOURCE_NAME")
	private String resourceName;

	@JsonIgnore
	@Transient
	@Column(name = "RESOURCE_DATA")
	private byte[] resourceData;

	@Column(name = "RESOURCE_FILE_EXTENSION")
	private String resourceFileExtension;

	@Column(name = "ACTIVE_FLAG")
	private char activeFlag;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID", nullable = false)
	private DhruvaResourceCategory category;

	/**
	 * 
	 */

	public DhruvaResourceFile() {
	}

	/**
	 * @return the resourceId
	 */
	public long getResourceId() {
		return resourceId;
	}

	/**
	 * @param resourceId the resourceId to set
	 */
	public void setResourceId(long resourceId) {
		this.resourceId = resourceId;
	}

	/**
	 * @return the resourceName
	 */
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * @param resourceName the resourceName to set
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	/**
	 * @return the resourcedata
	 */
	public byte[] getResourceData() {
		return resourceData;
	}

	/**
	 * @param resourcedata the resourcedata to set
	 */
	public void setResourceData(byte[] resourceData) {
		this.resourceData = resourceData;
	}

	/**
	 * @return the activeFlag
	 */
	public char getActiveFlag() {
		return activeFlag;
	}

	/**
	 * @param activeFlag the activeFlag to set
	 */
	public void setActiveFlag(char activeFlag) {
		this.activeFlag = activeFlag;
	}

	/**
	 * @return the category
	 */
	public DhruvaResourceCategory getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(DhruvaResourceCategory category) {
		this.category = category;
	}

	/**
	 * @return the resourceFileExtension
	 */
	public String getResourceFileExtension() {
		return resourceFileExtension;
	}

	/**
	 * @param resourceFileExtension the resourceFileExtension to set
	 */
	public void setResourceFileExtension(String resourceFileExtension) {
		this.resourceFileExtension = resourceFileExtension;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */

	@Override
	public int hashCode() {
		return Objects.hash(resourceId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof DhruvaResourceFile))
			return false;
		DhruvaResourceFile other = (DhruvaResourceFile) obj;
		return resourceId == other.resourceId;
	}

}