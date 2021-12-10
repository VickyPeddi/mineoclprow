package com.iocl.dhruva2api.model.spotcheck;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ModuleQuestionMasterId
 */
@Embeddable
public class ModuleQuestionMasterId implements Serializable {

	private static final long serialVersionUID = 7115370147539305652L;

	@Column(name = "PARENT_MODULE")
	private int parentModuleId;

	@Column(name = "QUESTION_NO")
	private String questionNo;

	public ModuleQuestionMasterId() {

	}

	/**
	 * @return the parentModuleId
	 */
	public int getParentModuleId() {
		return parentModuleId;
	}

	/**
	 * @param parentModuleId the parentModuleId to set
	 */
	public void setParentModuleId(int parentModuleId) {
		this.parentModuleId = parentModuleId;
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
		return Objects.hash(parentModuleId, questionNo);
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
		if (!(obj instanceof ModuleQuestionMasterId))
			return false;
		ModuleQuestionMasterId other = (ModuleQuestionMasterId) obj;
		return parentModuleId == other.parentModuleId && Objects.equals(questionNo, other.questionNo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "ModuleQuestionMasterId [parentModuleId=" + parentModuleId + ", questionNo=" + questionNo + "]";
	}

}