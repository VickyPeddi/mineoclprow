package com.iocl.dhruva2api.model.vendor;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

/**
 * VendorAdmin
 */
@Entity
@Table(name = "AUD_VENDOR_ADMIN")
public class VendorAdmin {

	// @EmbeddedId
	// private VendorAdminId id;

	@Id
	@Column(name = "VENDOR_CODE")
	private String vendorCode;

	@Column(name = "QRTR_ID")
	private String quarterId;

	@Column(name = "VENDOR_NAME")
	private String vendorName;

	@Column(name = "VENDOR_ADDRESS")
	private String vendorAddress;

	@Column(name = "WORK_ORDER")
	private String workOrder;

	@Column(name = "VALID_FROM")
	@Temporal(TemporalType.DATE)
	private Date validFrom;

	@Column(name = "VALID_TO")
	@Temporal(TemporalType.DATE)
	private Date validTo;

	@Column(name = "VENDOR_ADMIN_NAME")
	private String vendorAdminName;

	@Column(name = "VENDOR_ADMIN_MAIL")
	private String vendorAdminEmail;

	@Column(name = "VENDOR_ADMIN_MOB")
	private long vendorAdminMobile;

	@Column(name = "UPD_BY")
	private String updatedBy;

	@Column(name = "UPD_DATE")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;

	@Column(name = "MAIL_STATUS")
	private String mailStatus;

	@Column(name = "REG_STATUS")
	private String regStatus;

	@Column(name = "EMP_STATUS")
	private String empStatus;

	/**
	 * 
	 */

	public VendorAdmin() {
	}

	/**
	 * @param vendorCode
	 * @param quarterId
	 * @param vendorName
	 * @param vendorAddress
	 * @param workOrder
	 * @param validFrom
	 * @param validTo
	 * @param vendorAdminName
	 * @param vendorAdminEmail
	 * @param vendorAdminMobile
	 * @param updatedBy
	 * @param updatedOn
	 * @param mailStatus
	 * @param regStatus
	 * @param empStatus
	 */

	public VendorAdmin(String vendorCode, String quarterId, String vendorName, String vendorAddress, String workOrder,
			Date validFrom, Date validTo, String vendorAdminName, String vendorAdminEmail, long vendorAdminMobile,
			String updatedBy, Date updatedOn, String mailStatus, String regStatus, String empStatus) {
		this.vendorCode = vendorCode;
		this.quarterId = quarterId;
		this.vendorName = vendorName;
		this.vendorAddress = vendorAddress;
		this.workOrder = workOrder;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.vendorAdminName = vendorAdminName;
		this.vendorAdminEmail = vendorAdminEmail;
		this.vendorAdminMobile = vendorAdminMobile;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
		this.mailStatus = mailStatus;
		this.regStatus = regStatus;
		this.empStatus = empStatus;
	}

	/**
	 * @return the vendorCode
	 */
	public String getVendorCode() {
		return vendorCode;
	}

	/**
	 * @param vendorCode the vendorCode to set
	 */
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	/**
	 * @return the quarterId
	 */
	public String getQuarterId() {
		return quarterId;
	}

	/**
	 * @param quarterId the quarterId to set
	 */
	public void setQuarterId(String quarterId) {
		this.quarterId = quarterId;
	}

	/**
	 * @return the vendorName
	 */
	public String getVendorName() {
		return vendorName;
	}

	/**
	 * @param vendorName the vendorName to set
	 */
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	/**
	 * @return the vendorAddress
	 */
	public String getVendorAddress() {
		return vendorAddress;
	}

	/**
	 * @param vendorAddress the vendorAddress to set
	 */
	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	/**
	 * @return the workOrder
	 */
	public String getWorkOrder() {
		return workOrder;
	}

	/**
	 * @param workOrder the workOrder to set
	 */
	public void setWorkOrder(String workOrder) {
		this.workOrder = workOrder;
	}

	/**
	 * @return the validFrom
	 */
	public Date getValidFrom() {
		return validFrom;
	}

	/**
	 * @param validFrom the validFrom to set
	 */
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	/**
	 * @return the validTo
	 */
	public Date getValidTo() {
		return validTo;
	}

	/**
	 * @param validTo the validTo to set
	 */
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	/**
	 * @return the vendorAdminName
	 */
	public String getVendorAdminName() {
		return vendorAdminName;
	}

	/**
	 * @param vendorAdminName the vendorAdminName to set
	 */
	public void setVendorAdminName(String vendorAdminName) {
		this.vendorAdminName = vendorAdminName;
	}

	/**
	 * @return the vendorAdminEmail
	 */
	public String getVendorAdminEmail() {
		return vendorAdminEmail;
	}

	/**
	 * @param vendorAdminEmail the vendorAdminEmail to set
	 */
	public void setVendorAdminEmail(String vendorAdminEmail) {
		this.vendorAdminEmail = vendorAdminEmail;
	}

	/**
	 * @return the vendorAdminMobile
	 */
	public long getVendorAdminMobile() {
		return vendorAdminMobile;
	}

	/**
	 * @param vendorAdminMobile the vendorAdminMobile to set
	 */
	public void setVendorAdminMobile(long vendorAdminMobile) {
		this.vendorAdminMobile = vendorAdminMobile;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the updatedOn
	 */
	public Date getUpdatedOn() {
		return updatedOn;
	}

	/**
	 * @param updatedOn the updatedOn to set
	 */
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	/**
	 * @return the mailStatus
	 */
	public String getMailStatus() {
		return mailStatus;
	}

	/**
	 * @param mailStatus the mailStatus to set
	 */
	public void setMailStatus(String mailStatus) {
		this.mailStatus = mailStatus;
	}

	/**
	 * @return the regStatus
	 */
	public String getRegStatus() {
		return regStatus;
	}

	/**
	 * @param regStatus the regStatus to set
	 */
	public void setRegStatus(String regStatus) {
		this.regStatus = regStatus;
	}

	/**
	 * @return the empStatus
	 */
	public String getEmpStatus() {
		return empStatus;
	}

	/**
	 * @param empStatus the empStatus to set
	 */
	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */

	@Override
	public int hashCode() {
		return Objects.hash(vendorCode);
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
		if (!(obj instanceof VendorAdmin))
			return false;
		VendorAdmin other = (VendorAdmin) obj;
		return Objects.equals(vendorCode, other.vendorCode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "VendorAdmin [empStatus=" + empStatus + ", mailStatus=" + mailStatus + ", quarterId=" + quarterId
				+ ", regStatus=" + regStatus + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + ", validFrom="
				+ validFrom + ", validTo=" + validTo + ", vendorAddress=" + vendorAddress + ", vendorAdminEmail="
				+ vendorAdminEmail + ", vendorAdminMobile=" + vendorAdminMobile + ", vendorAdminName=" + vendorAdminName
				+ ", vendorCode=" + vendorCode + ", vendorName=" + vendorName + ", workOrder=" + workOrder + "]";
	}

}