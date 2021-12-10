package com.iocl.dhruva2api.model.activity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ActivityTranId implements Serializable {

	private static final long serialVersionUID = -668071400145615341L;

	@Column(name = "RO_CODE")
	private int roCode;

	@Column(name = "ACTIVITY_NO")
	private int activityNo;

	public ActivityTranId() {
		super();
	}

	public ActivityTranId(int roCode, int activityNo) {
		super();
		this.roCode = roCode;
		this.activityNo = activityNo;
	}

	public int getRoCode() {
		return roCode;
	}

	public void setRoCode(int roCode) {
		this.roCode = roCode;
	}

	public int getActivityNo() {
		return activityNo;
	}

	public void setActivityNo(int activityNo) {
		this.activityNo = activityNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + activityNo;
		result = prime * result + roCode;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActivityTranId other = (ActivityTranId) obj;
		if (activityNo != other.activityNo)
			return false;
		if (roCode != other.roCode)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ActivityTranId [activityNo=" + activityNo + ", roCode=" + roCode + "]";
	}

}
