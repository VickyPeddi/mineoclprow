package com.iocl.dhruva2api.model.menu;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iocl.dhruva2api.model.MISMenuItems;

/**
 * SubMenu
 */
@Entity
@Table(name = "DHRUVA_SUBMENUS")
public class SubMenu {

	@Id
	@Column(name = "SUBMENU_ID")
	private long subMenuId;

	@Column(name = "MENU_ID")
	private long menuId;

	@Column(name = "SUBMENU_NAME")
	private String subMenuName;

	@Column(name = "ROUTE_PATH")
	private String routePath;

	@Column(name = "ACCESS_COUNT")
	private long accessCount;

	@JsonIgnore
	@Column(name = "FO_ACCESS")
	private short foAccess;

	@JsonIgnore
	@Column(name = "SO_ACCESS")
	private short soAccess;

	@JsonIgnore
	@Column(name = "DO_ACCESS")
	private short doAccess;

	@JsonIgnore
	@Column(name = "RO_ACCESS")
	private short roAccess;

	@JsonIgnore
	@Column(name = "DRSM_ACCESS")
	private short drsmAccess;

	@JsonIgnore
	@Column(name = "SRH_ACCESS")
	private short srhAccess;

	@JsonIgnore
	@Column(name = "HO_ACCESS")
	private short hoAccess;

	@JsonIgnore
	@Column(name = "ADMIN_ACCESS")
	private short adminAccess;

	@JsonIgnore
	@Column(name = "ACTIVE_FLAG")
	private short activeFlag;

	@Column(name = "NEW_FLAG")
	private short newFlag;

	@Transient
	private List<MISMenuItems> menuItems;

	/**
	 * 
	 */

	public SubMenu() {
	}

	/**
	 * @return the subMenuId
	 */
	public long getSubMenuId() {
		return subMenuId;
	}

	/**
	 * @param subMenuId the subMenuId to set
	 */
	public void setSubMenuId(long subMenuId) {
		this.subMenuId = subMenuId;
	}

	/**
	 * @return the subMenuName
	 */
	public String getSubMenuName() {
		
		return  subMenuName.equals("MPower Plus")?"mPower Plus":subMenuName;
	}

	/**
	 * @param subMenuName the subMenuName to set
	 */
	public void setSubMenuName(String subMenuName) {
		this.subMenuName = subMenuName;
	}

	/**
	 * @return the routePath
	 */
	public String getRoutePath() {
		return routePath;
	}

	/**
	 * @param routePath the routePath to set
	 */
	public void setRoutePath(String routePath) {
		this.routePath = routePath;
	}

	/**
	 * @return the accessCount
	 */
	public long getAccessCount() {
		return accessCount;
	}

	/**
	 * @param accessCount the accessCount to set
	 */
	public void setAccessCount(long accessCount) {
		this.accessCount = accessCount;
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
	 * @return the drsmAccess
	 */
	public short getDrsmAccess() {
		return drsmAccess;
	}

	/**
	 * @param drsmAccess the drsmAccess to set
	 */
	public void setDrsmAccess(short drsmAccess) {
		this.drsmAccess = drsmAccess;
	}

	/**
	 * @return the srhAccess
	 */
	public short getSrhAccess() {
		return srhAccess;
	}

	/**
	 * @param srhAccess the srhAccess to set
	 */
	public void setSrhAccess(short srhAccess) {
		this.srhAccess = srhAccess;
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
	 * @return the newFlag
	 */
	public short getNewFlag() {
		return newFlag;
	}

	/**
	 * @param newFlag the newFlag to set
	 */
	public void setNewFlag(short newFlag) {
		this.newFlag = newFlag;
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

	/**
	 * @return the menuId
	 */
	public long getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */

	@Override
	public int hashCode() {
		return Objects.hash(subMenuId);
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
		if (!(obj instanceof SubMenu))
			return false;
		SubMenu other = (SubMenu) obj;
		return subMenuId == other.subMenuId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "SubMenu [accessCount=" + accessCount + ", activeFlag=" + activeFlag + ", adminAccess=" + adminAccess
				+ ", doAccess=" + doAccess + ", drsmAccess=" + drsmAccess + ", foAccess=" + foAccess + ", hoAccess=" + hoAccess
				+ ", menuItems=" + menuItems + ", newFlag=" + newFlag + ", roAccess=" + roAccess + ", routePath=" + routePath
				+ ", soAccess=" + soAccess + ", srhAccess=" + srhAccess + ", subMenuId=" + subMenuId + ", subMenuName="
				+ subMenuName + "]";
	}

}