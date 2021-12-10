package com.iocl.dhruva2api.model.spotcheck;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * SpotCheckAverageComplianceScore
 */
@Entity
@Table(name = "VW_SPOT_CHECK_AVG_COMP_SCORE")
public class SpotCheckAverageComplianceScore {

	@EmbeddedId
	private SpotCheckAverageComplianceScoreId id;

	@Column(name = "AVERAGE_SCORE")
	private float averageScore;

	/**
	 * 
	 */

	public SpotCheckAverageComplianceScore() {
	}

	/**
	 * @return the id
	 */
	public SpotCheckAverageComplianceScoreId getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(SpotCheckAverageComplianceScoreId id) {
		this.id = id;
	}

	/**
	 * @return the averageScore
	 */
	public float getAverageScore() {
		return averageScore;
	}

	/**
	 * @param averageScore the averageScore to set
	 */
	public void setAverageScore(float averageScore) {
		this.averageScore = averageScore;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "SpotCheckAverageComplianceScore [averageScore=" + averageScore + ", id=" + id + "]";
	}

}