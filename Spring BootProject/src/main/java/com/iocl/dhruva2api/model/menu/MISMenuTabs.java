package com.iocl.dhruva2api.model.menu;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iocl.dhruva2api.model.MISMenuItems;

import org.hibernate.annotations.Where;

/**
 * MISMenuTabs
 */
@Entity
@Table(name = "DHRUVA_REPORTS_TABS")
public class MISMenuTabs {

	@Id
	@Column(name = "TAB_ID")
	private long tabId;

	@Column(name = "TAB_NAME")
	private String tabName;

	@Column(name = "ACTIVE_FLAG")
	private short activeFlag;

	@JsonIgnore
	@Column(name = "FO_ACCESS")
	private short foAccess;

	@JsonIgnore
	@Column(name = "SO_ACCESS")
	private short soAccess;

	@JsonIgnore
	@Column(name = "DO_ACCESS")
	private short doAccess;

	// Regional Office
	@JsonIgnore
	@Column(name = "RO_ACCESS")
	private short roAccess;

	@JsonIgnore
	@Column(name = "HO_ACCESS")
	private short hoAccess;

	@JsonIgnore
	@Column(name = "ADMIN_ACCESS")
	private short adminAccess;

	@Transient
	@Where(clause = "ACTIVE_FLAG = 1")
	@OneToMany(mappedBy = "menuTabs")
	private List<MISMenuItems> menuItems;

	public MISMenuTabs() {

	}

	/**
	 * @return the tabId
	 */
	public long getTabId() {
		return tabId;
	}

	/**
	 * @param tabId the tabId to set
	 */
	public void setTabId(long tabId) {
		this.tabId = tabId;
	}

	/**
	 * @return the tabName
	 */
	public String getTabName() {

		return tabName.equals("MPower Plus") ? "mPower Plus" : tabName;
	}

	/**
	 * @param tabName the tabName to set
	 */
	public void setTabName(String tabName) {
		this.tabName = tabName;
	}

	/**
	 * @return the activeFlag
	 */
	public short getActiveFlag() {
		return activeFlag;
	}

	/**
	 * @param activeFlag the activeFlag to set
	 */
	public void setActiveFlag(short activeFlag) {
		this.activeFlag = activeFlag;
	}

	/**
	 * @return the foAccess
	 */
	public short getFoAccess() {
		return foAccess;
	}

	/**
	 * @param foAccess the foAccess to set
	 */
	public void setFoAccess(short foAccess) {
		this.foAccess = foAccess;
	}

	/**
	 * @return the soAccess
	 */
	public short getSoAccess() {
		return soAccess;
	}

	/**
	 * @param soAccess the soAccess to set
	 */
	public void setSoAccess(short soAccess) {
		this.soAccess = soAccess;
	}

	/**
	 * @return the doAccess
	 */
	public short getDoAccess() {
		return doAccess;
	}

	/**
	 * @param doAccess the doAccess to set
	 */
	public void setDoAccess(short doAccess) {
		this.doAccess = doAccess;
	}

	/**
	 * @return the roAccess
	 */
	public short getRoAccess() {
		return roAccess;
	}

	/**
	 * @param roAccess the roAccess to set
	 */
	public void setRoAccess(short roAccess) {
		this.roAccess = roAccess;
	}

	/**
	 * @return the hoAccess
	 */
	public short getHoAccess() {
		return hoAccess;
	}

	/**
	 * @param hoAccess the hoAccess to set
	 */
	public void setHoAccess(short hoAccess) {
		this.hoAccess = hoAccess;
	}

	/**
	 * @return the adminAccess
	 */
	public short getAdminAccess() {
		return adminAccess;
	}

	/**
	 * @param adminAccess the adminAccess to set
	 */
	public void setAdminAccess(short adminAccess) {
		this.adminAccess = adminAccess;
	}

	/**
	 * @return the menuItems
	 */
	public List<MISMenuItems> getMenuItems() {
		return menuItems;
	}

	/**
	 * @param menuItems the menuItems to set
	 */
	public void setMenuItems(List<MISMenuItems> menuItems) {
		this.menuItems = menuItems;
	}

	@Override
	public String toString() {
		return "MISMenuTabs [activeFlag=" + activeFlag + ", adminAccess=" + adminAccess + ", doAccess=" + doAccess
				+ ", foAccess=" + foAccess + ", hoAccess=" + hoAccess + ", menuItems=" + menuItems + ", roAccess=" + roAccess
				+ ", soAccess=" + soAccess + ", tabId=" + tabId + ", tabName=" + tabName + "]";
	}

}