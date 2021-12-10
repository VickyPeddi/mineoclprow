package com.iocl.dhruva2api.model.spotcheck;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

/**
 * ComplianceResponsePayload
 */

public class ComplianceResponsePayload {

	private long inspNo;
	private int moduleNo;
	private String questionNo;
	private String remark;

	/**
	 * 
	 */

	public ComplianceResponsePayload() {
	}

	/**
	 * @param inspNo
	 * @param moduleNo
	 * @param questionNo
	 * @param remark
	 */

	public ComplianceResponsePayload(long inspNo, int moduleNo, String questionNo, String remark) {
		this.inspNo = inspNo;
		this.moduleNo = moduleNo;
		this.questionNo = questionNo;
		this.remark = remark;
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
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = Jsoup.clean(remark, Whitelist.none());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "ComplianceResponsePayload [inspNo=" + inspNo + ", moduleNo=" + moduleNo + ", questionNo=" + questionNo
				+ ", remark=" + remark + "]";
	}

}