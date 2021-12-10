package com.iocl.dhruva2api.model.mis;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ParameterMaster
 */
@Entity
@Table(name = "VW_MST_PARAMETERS")
public class ParameterMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ParameterMasterPK embeddedId;
	
	@Column(name = "PARAM_TEXT")
	private String parameterName;

	

	public ParameterMaster() {

	}



	public ParameterMasterPK getEmbeddedId() {
		return embeddedId;
	}



	public void setEmbeddedId(ParameterMasterPK embeddedId) {
		this.embeddedId = embeddedId;
	}



	public String getParameterName() {
		return parameterName;
	}



	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}




	

	

	

	

	

	

}