package com.iocl.dhruva2api.model.spotcheck;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SpotCheckModule
 */
@Entity
@Table(name = "SPOT_MST_MODULE")
public class SpotCheckModule {

	@Id
	@Column(name = "MODULE_NO")
	private int moduleNo;

	@Column(name = "MODULE_NAME")
	private String moduleName;

	/**
	 * 
	 */

	public SpotCheckModule() {
	}

	/**
	 * @return the moduleNo
	 */
	public int getModuleNo() {
		return moduleNo;
	}

	/**
	 * @param moduleNo the moduleNo to set
	 */
	public void setModuleNo(int moduleNo) {
		this.moduleNo = moduleNo;
	}

	/**
	 * @return the moduleName
	 */
	public String getModuleName() {
		return moduleName;
	}

	/**
	 * @param moduleName the moduleName to set
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "SpotCheckModule [moduleName=" + moduleName + ", moduleNo=" + moduleNo + "]";
	}

}