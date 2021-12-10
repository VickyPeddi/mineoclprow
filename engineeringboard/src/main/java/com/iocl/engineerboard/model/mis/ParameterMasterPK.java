package com.iocl.dhruva2api.model.mis;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ParameterMasterPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "PARAM_ID")
	private int parameterId;

	@Column(name = "INDEX_ID")
	private int indexId;

	public ParameterMasterPK() {

	}

	public int getParameterId() {
		return parameterId;
	}

	public void setParameterId(int parameterId) {
		this.parameterId = parameterId;
	}

	public int getindexId() {
		return indexId;
	}

	public void setindexId(int indexId) {
		this.indexId = indexId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */

	@Override
	public int hashCode() {
		return Objects.hash(indexId, parameterId);
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
		if (!(obj instanceof ParameterMasterPK))
			return false;
		ParameterMasterPK other = (ParameterMasterPK) obj;
		return indexId == other.indexId && parameterId == other.parameterId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "ParameterMasterPK [indexId=" + indexId + ", parameterId=" + parameterId + "]";
	}

}
