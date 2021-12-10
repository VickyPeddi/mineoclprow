package com.iocl.dhruva2api.model.login;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DhruvaParameters
 */
@Entity
@Table(name = "DHRUVA_PARAMETERS")
public class DhruvaParameters {

	@Id
	@Column(name = "PARAMETER_ID")
	private int parameterId;

	@Column(name = "PARAMETER_NAME")
	private String parameterName;

	@Column(name = "PARAMETER_VALUE")
	private String parameterValue;

	@Column(name = "IS_PROD")
	private char production;

	@Column(name = "IS_DEV")
	private char development;

	/**
	 * 
	 */

	public DhruvaParameters() {
	}

	/**
	 * @return the parameterId
	 */
	public int getParameterId() {
		return parameterId;
	}

	/**
	 * @param parameterId the parameterId to set
	 */
	public void setParameterId(int parameterId) {
		this.parameterId = parameterId;
	}

	/**
	 * @return the parameterName
	 */
	public String getParameterName() {
		return parameterName;
	}

	/**
	 * @param parameterName the parameterName to set
	 */
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	/**
	 * @return the parameterValue
	 */
	public String getParameterValue() {
		return parameterValue;
	}

	/**
	 * @param parameterValue the parameterValue to set
	 */
	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}

	/**
	 * @return the production
	 */
	public boolean isProduction() {
		return production == '1';
	}

	/**
	 * @param production the production to set
	 */
	public void setProduction(char production) {
		this.production = production;
	}

	/**
	 * @return the development
	 */
	public boolean isDevelopment() {
		return development == '1';
	}

	/**
	 * @param development the development to set
	 */
	public void setDevelopment(char development) {
		this.development = development;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */

	@Override
	public int hashCode() {
		return Objects.hash(parameterId);
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
		if (!(obj instanceof DhruvaParameters))
			return false;
		DhruvaParameters other = (DhruvaParameters) obj;
		return parameterId == other.parameterId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "DhruvaParameters [development=" + (development == '1') + ", parameterId=" + parameterId + ", parameterName="
				+ parameterName + ", parameterValue=" + parameterValue + ", production=" + (production == '1') + "]";
	}

}