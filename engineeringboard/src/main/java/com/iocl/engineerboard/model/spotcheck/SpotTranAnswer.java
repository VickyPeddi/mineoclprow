package com.iocl.dhruva2api.model.spotcheck;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * SpotTranAnswer
 */
@Entity
@Table(name = "SPOT_TRAN_ANSWERS")
public class SpotTranAnswer {

	@EmbeddedId
	private SpotTranAnswerId id;

	@Column(name = "ANSWER")
	private String answer;

	@Column(name = "STATUS")
	private int status;

	// @ManyToOne
	// @JoinColumns({ @JoinColumn(name = "INSP_NO", nullable = false, insertable =
	// false, updatable = false),
	// @JoinColumn(name = "MODULE_NO", nullable = false, insertable = false,
	// updatable = false) })
	// private SpotTranHeader header;

	public SpotTranAnswer() {

	}

	/**
	 * @return the id
	 */
	public SpotTranAnswerId getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(SpotTranAnswerId id) {
		this.id = id;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "SpotTranAnswer [answer=" + answer + ", id=" + id + ", status=" + status + "]";
	}

}