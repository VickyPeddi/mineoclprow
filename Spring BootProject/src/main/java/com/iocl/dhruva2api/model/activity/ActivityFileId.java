package com.iocl.dhruva2api.model.activity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable

public class ActivityFileId implements Serializable {

	private static final long serialVersionUID = 6575053859220935115L;

	@Column(name = "RO_CODE")
	private int roCode;

	@Column(name = "ACTIVITY_NO")
	private int activityNo;

	public ActivityFileId() {
		super();
	}

	public ActivityFileId(int roCode, int activityNo) {
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
		ActivityFileId other = (ActivityFileId) obj;
		if (activityNo != other.activityNo)
			return false;
		if (roCode != other.roCode)
			return false;
		return true;
	}

}
