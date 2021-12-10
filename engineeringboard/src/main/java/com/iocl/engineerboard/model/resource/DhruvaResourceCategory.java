package com.iocl.dhruva2api.model.resource;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

/**
 * DhruvaResourceCategory
 */
@Entity
@Table(name = "DHRUVA_RESOURCE_CATEGORY")
public class DhruvaResourceCategory {

	@Id
	@Column(name = "CATEGORY_ID")
	private long categoryId;

	@Column(name = "CATEGORY_NAME")
	private String categoryName;

	@Column(name = "ACTIVE_FLAG")
	private char activeFlag;

	@Where(clause = "ACTIVE_FLAG = '1'")
	@OneToMany(mappedBy = "category")
	private List<DhruvaResourceFile> resourceFiles;

	/**
	 * 
	 */

	public DhruvaResourceCategory() {
	}

	/**
	 * @return the categoryId
	 */
	public long getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
	 * @return the resourceFiles
	 */
	public List<DhruvaResourceFile> getResourceFiles() {
		return resourceFiles;
	}

	/**
	 * @param resourceFiles the resourceFiles to set
	 */
	public void setResourceFiles(List<DhruvaResourceFile> resourceFiles) {
		this.resourceFiles = resourceFiles;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */

	@Override
	public int hashCode() {
		return Objects.hash(categoryId);
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
		if (!(obj instanceof DhruvaResourceCategory))
			return false;
		DhruvaResourceCategory other = (DhruvaResourceCategory) obj;
		return categoryId == other.categoryId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "DhruvaResourceCategory [activeFlag=" + activeFlag + ", categoryId=" + categoryId + ", categoryName="
				+ categoryName + ", resourceFiles=" + resourceFiles + "]";
	}

}