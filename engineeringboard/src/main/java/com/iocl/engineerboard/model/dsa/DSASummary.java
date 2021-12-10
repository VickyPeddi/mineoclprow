package com.iocl.dhruva2api.model.dsa;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DSASummary
 */
@Entity
@Table(name = "BCP_DSA_SUMMARY")
public class DSASummary implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dsa_seq")
	@SequenceGenerator(allocationSize = 1, name = "dsa_seq", sequenceName = "DSA_SUMMARY_SEQ")
	@Column(name = "ID")
	private long id;

	@JsonProperty(value = "SO")
	@Column(name = "SO")
	private int salesOrgCode;

	@JsonProperty(value = "DSA Name")
	@Column(name = "DSA_NAME")
	private String dsaName;

	@JsonProperty(value = "User Name")
	@Column(name = "USER_NAME")
	private String userName;

	@JsonProperty(value = "User Status")
	@Column(name = "USER_STATUS")
	private String userStatus;

	@JsonProperty(value = "Cards Enrolled")
	@Column(name = "CARDS_ENROLLED")
	private long cardsEnrolled;

	@JsonProperty(value = "Active Cards")
	@Column(name = "ACTIVE_CARDS")
	private long activeCards;

	@JsonProperty(value = "Customer Enrolled")
	@Column(name = "CUSTOMER_ENROLLED")
	private long customerEnrolled;

	@JsonProperty(value = "Cummulative Sales")
	@Column(name = "CUM_SALES")
	private double cummulativeSales;

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_ON")
	private Date updatedOn;

	public DSASummary() {

	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the salesOrgCode
	 */
	public int getSalesOrgCode() {
		return salesOrgCode;
	}

	/**
	 * @param salesOrgCode the salesOrgCode to set
	 */
	public void setSalesOrgCode(int salesOrgCode) {
		this.salesOrgCode = salesOrgCode;
	}

	/**
	 * @return the dsaName
	 */
	public String getDsaName() {
		return dsaName;
	}

	/**
	 * @param dsaName the dsaName to set
	 */
	public void setDsaName(String dsaName) {
		this.dsaName = dsaName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userStatus
	 */
	public String getUserStatus() {
		return userStatus;
	}

	/**
	 * @param userStatus the userStatus to set
	 */
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	/**
	 * @return the cardsEnrolled
	 */
	public long getCardsEnrolled() {
		return cardsEnrolled;
	}

	/**
	 * @param cardsEnrolled the cardsEnrolled to set
	 */
	public void setCardsEnrolled(long cardsEnrolled) {
		this.cardsEnrolled = cardsEnrolled;
	}

	/**
	 * @return the activeCards
	 */
	public long getActiveCards() {
		return activeCards;
	}

	/**
	 * @param activeCards the activeCards to set
	 */
	public void setActiveCards(long activeCards) {
		this.activeCards = activeCards;
	}

	/**
	 * @return the customerEnrolled
	 */
	public long getCustomerEnrolled() {
		return customerEnrolled;
	}

	/**
	 * @param customerEnrolled the customerEnrolled to set
	 */
	public void setCustomerEnrolled(long customerEnrolled) {
		this.customerEnrolled = customerEnrolled;
	}

	/**
	 * @return the cummulativeSales
	 */
	public double getCummulativeSales() {
		return cummulativeSales;
	}

	/**
	 * @param cummulativeSales the cummulativeSales to set
	 */
	public void setCummulativeSales(double cummulativeSales) {
		this.cummulativeSales = cummulativeSales;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		if (!(obj instanceof DSASummary))
			return false;
		DSASummary other = (DSASummary) obj;
		return id == other.id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "DSASummary [activeCards=" + activeCards + ", cardsEnrolled=" + cardsEnrolled + ", cummulativeSales="
				+ cummulativeSales + ", customerEnrolled=" + customerEnrolled + ", dsaName=" + dsaName + ", id=" + id
				+ ", salesOrgCode=" + salesOrgCode + ", updatedOn=" + updatedOn + ", userName=" + userName + ", userStatus="
				+ userStatus + "]";
	}

}