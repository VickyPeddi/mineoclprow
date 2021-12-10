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
@Table(name = "SO_ENGG_LEADERBOARD")
public class SoEnggLeaderboard {

	@Id
	@Column(name = "STATEOFFICE")
	private Integer soCode;

	@Column(name = "TOTAL_DHRUVA")
	private Integer totalDhruva;

	@Column(name = "FINAL_INDEX")
	private Integer finalDhruvaIndex;

	@Column(name = "RANK")
	private Integer rank;

	@Column(name = "UPDATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;

	@Column(name = "STATE_OFFICE_NAME")
	private String soName;

	public SoEnggLeaderboard() {

	}

	/**
	 * @return the soCode
	 */
	public Integer getSoCode() {
		return soCode;
	}

	/**
	 * @param soCode the soCode to set
	 */
	public void setSoCode(Integer soCode) {
		this.soCode = soCode;
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
	 * @return the soName
	 */
	public String getSoName() {
		return soName;
	}

	/**
	 * @param soName the soName to set
	 */
	public void setSoName(String soName) {
		this.soName = soName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */

	@Override
	public int hashCode() {
		return Objects.hash(finalDhruvaIndex, rank, soCode, soName, totalDhruva, updatedOn);
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
		if (!(obj instanceof SoEnggLeaderboard))
			return false;
		SoEnggLeaderboard other = (SoEnggLeaderboard) obj;
		return Objects.equals(finalDhruvaIndex, other.finalDhruvaIndex) && Objects.equals(rank, other.rank)
				&& Objects.equals(soCode, other.soCode) && Objects.equals(soName, other.soName)
				&& Objects.equals(totalDhruva, other.totalDhruva) && Objects.equals(updatedOn, other.updatedOn);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "SoEnggLeaderboard [finalDhruvaIndex=" + finalDhruvaIndex + ", rank=" + rank + ", soCode=" + soCode
				+ ", soName=" + soName + ", totalDhruva=" + totalDhruva + ", updatedOn=" + updatedOn + "]";
	}

}
