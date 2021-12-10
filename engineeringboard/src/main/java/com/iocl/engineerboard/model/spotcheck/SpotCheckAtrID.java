package com.iocl.dhruva2api.model.spotcheck;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SpotCheckAtrID
 */
@Embeddable
public class SpotCheckAtrID implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "INSP_NO")
	private long inspNo;

	@Column(name = "MODULE_NO")
	private int moduleNo;

	@Column(name = "QUESTION_NO")
	private String questionNo;

	/**
	 * 
	 */

	public SpotCheckAtrID() {
	}

	/**
	 * @param inspNo
	 * @param moduleNo
	 * @param questionNo
	 */

	public SpotCheckAtrID(long inspNo, int moduleNo, String questionNo) {
		this.inspNo = inspNo;
		this.moduleNo = moduleNo;
		this.questionNo = questionNo;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */

	@Override
	public int hashCode() {
		return Objects.hash(inspNo, moduleNo, questionNo);
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
		if (!(obj instanceof SpotCheckAtrID))
			return false;
		SpotCheckAtrID other = (SpotCheckAtrID) obj;
		return inspNo == other.inspNo && moduleNo == other.moduleNo && Objects.equals(questionNo, other.questionNo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "SpotCheckAtrID [inspNo=" + inspNo + ", moduleNo=" + moduleNo + ", questionNo=" + questionNo + "]";
	}

}