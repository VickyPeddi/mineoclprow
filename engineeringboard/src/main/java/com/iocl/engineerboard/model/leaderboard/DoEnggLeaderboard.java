package com.iocl.dhruva2api.model.leaderboard;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "DO_ENGG_LEADERBOARD")
public class DoEnggLeaderboard {

	@Id
	@Column(name = "SALESOFF")
	private Integer doCode;

	@Column(name = "TOTAL_DHRUVA")
	private Integer totalDhruva;

	@Column(name = "FINAL_INDEX")
	private Integer finalDhruvaIndex;

	@Column(name = "RANK")
	private Integer rank;

	@Column(name = "UPDATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;

	@Column(name = "SALES_OFF_NAME")
	private String doName;

	public DoEnggLeaderboard() {

	}

	/**
	 * @return the doCode
	 */
	public Integer getDoCode() {
		return doCode;
	}

	/**
	 * @param doCode the doCode to set
	 */
	public void setDoCode(Integer doCode) {
		this.doCode = doCode;
	}

	/**
	 * @return the totalDhruva
	 */
	public Integer getTotalDhruva() {
		return totalDhruva;
	}

	/**
	 * @param totalDhruva the totalDhruva to set
	 */
	public void setTotalDhruva(Integer totalDhruva) {
		this.totalDhruva = totalDhruva;
	}

	/**
	 * @return the finalDhruvaIndex
	 */
	public Integer getFinalDhruvaIndex() {
		return finalDhruvaIndex;
	}

	/**
	 * @param finalDhruvaIndex the finalDhruvaIndex to set
	 */
	public void setFinalDhruvaIndex(Integer finalDhruvaIndex) {
		this.finalDhruvaIndex = finalDhruvaIndex;
	}

	/**
	 * @return the rank
	 */
	public Integer getRank() {
		return rank;
	}

	/**
	 * @param rank the rank to set
	 */
	public void setRank(Integer rank) {
		this.rank = rank;
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
	 * @return the doName
	 */
	public String getDoName() {
		return doName;
	}

	/**
	 * @param doName the doName to set
	 */
	public void setDoName(String doName) {
		this.doName = doName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */

	@Override
	public int hashCode() {
		return Objects.hash(doCode, doName, finalDhruvaIndex, rank, totalDhruva, updatedOn);
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
		if (obj == null)
			return false;
		if (!(obj instanceof DoEnggLeaderboard))
			return false;
		DoEnggLeaderboard other = (DoEnggLeaderboard) obj;
		return Objects.equals(doCode, other.doCode) && Objects.equals(doName, other.doName)
				&& Objects.equals(finalDhruvaIndex, other.finalDhruvaIndex) && Objects.equals(rank, other.rank)
				&& Objects.equals(totalDhruva, other.totalDhruva) && Objects.equals(updatedOn, other.updatedOn);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "DoEnggLeaderboard [doCode=" + doCode + ", doName=" + doName + ", finalDhruvaIndex=" + finalDhruvaIndex
				+ ", rank=" + rank + ", totalDhruva=" + totalDhruva + ", updatedOn=" + updatedOn + "]";
	}

}
