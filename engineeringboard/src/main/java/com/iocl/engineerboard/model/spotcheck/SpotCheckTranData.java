package com.iocl.dhruva2api.model.spotcheck;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SpotCheckTranData
 */
@Entity
@Table(name = "VW_SPOT_TRAN_DATA")
public class SpotCheckTranData {

	@Id
	@Column(name = "SR_NO")
	private long srNo;

	@Column(name = "INSP_NO")
	private long inspNo;

	@Column(name = "MODULE_NO")
	private int moduleNo;

	@Column(name = "QUESTION_NO")
	private String questionNo;

	@Column(name = "TEXT")
	private String questionText;

	@Column(name = "ANSWER")
	private String answer;

	@Column(name = "SCORE")
	private int score;

	@Column(name = "STATUS")
	private int status;

	/**
	 * 
	 */

	public SpotCheckTranData() {
	}

	/**
	 * @return the srNo
	 */
	public long getSrNo() {
		return srNo;
	}

	/**
	 * @param srNo the srNo to set
	 */
	public void setSrNo(long srNo) {
		this.srNo = srNo;
	}

	/**
	 * @return the inspNo
	 */
	public long getInspNo() {
		return inspNo;
	}

	/**
	 * @param inspNo the inspNo to set
	 */
	public void setInspNo(long inspNo) {
		this.inspNo = inspNo;
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
	 * @return the questionNo
	 */
	public String getQuestionNo() {
		return questionNo;
	}

	/**
	 * @param questionNo the questionNo to set
	 */
	public void setQuestionNo(String questionNo) {
		this.questionNo = questionNo;
	}

	/**
	 * @return the questionText
	 */
	public String getQuestionText() {
		return questionText;
	}

	/**
	 * @param questionText the questionText to set
	 */
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
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
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
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
		return "SpotCheckTranData [answer=" + answer + ", inspNo=" + inspNo + ", moduleNo=" + moduleNo + ", questionNo="
				+ questionNo + ", questionText=" + questionText + ", score=" + score + ", srNo=" + srNo + ", status="
				+ status + "]";
	}

}