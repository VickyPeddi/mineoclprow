package com.iocl.dhruva2api.model.leaderboard;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SOAWESUMScore
 */
@Entity
@Table(name = "VW_SO_WISE_AWESUM")
public class SOAWESUMScore {

	@Id
	@Column(name = "SALESORG")
	private Integer stateOfficeCode;

	@Column(name = "SALESORG_SHORT_NAME")
	private String soMaster;

	@Column(name = "AWESUM")
	private float awesum;

	@Column(name = "AIR")
	private float air;

	@Column(name = "WATER")
	private float water;

	@Column(name = "ENERGY")
	private float energy;

	@Column(name = "SAFETY")
	private float safety;

	@Column(name = "UNIFORM")
	private float uniform;

	@Column(name = "MACHINE")
	private float machine;

	// @Column(name = "UPDATED_ON")
	// @Temporal(TemporalType.TIMESTAMP)
	// private Date updatedOn;

	public SOAWESUMScore() {

	}

	/**
	 * @return the stateOfficeCode
	 */
	public Integer getStateOfficeCode() {
		return stateOfficeCode;
	}

	/**
	 * @param stateOfficeCode the stateOfficeCode to set
	 */
	public void setStateOfficeCode(Integer stateOfficeCode) {
		this.stateOfficeCode = stateOfficeCode;
	}

	/**
	 * @return the soMaster
	 */
	public String getSoMaster() {
		return soMaster;
	}

	/**
	 * @param soMaster the soMaster to set
	 */
	public void setSoMaster(String soMaster) {
		this.soMaster = soMaster;
	}

	/**
	 * @return the awesum
	 */
	public float getAwesum() {
		return awesum;
	}

	/**
	 * @param awesum the awesum to set
	 */
	public void setAwesum(float awesum) {
		this.awesum = awesum;
	}

	/**
	 * @return the air
	 */
	public float getAir() {
		return air;
	}

	/**
	 * @param air the air to set
	 */
	public void setAir(float air) {
		this.air = air;
	}

	/**
	 * @return the water
	 */
	public float getWater() {
		return water;
	}

	/**
	 * @param water the water to set
	 */
	public void setWater(float water) {
		this.water = water;
	}

	/**
	 * @return the energy
	 */
	public float getEnergy() {
		return energy;
	}

	/**
	 * @param energy the energy to set
	 */
	public void setEnergy(float energy) {
		this.energy = energy;
	}

	/**
	 * @return the safety
	 */
	public float getSafety() {
		return safety;
	}

	/**
	 * @param safety the safety to set
	 */
	public void setSafety(float safety) {
		this.safety = safety;
	}

	/**
	 * @return the uniform
	 */
	public float getUniform() {
		return uniform;
	}

	/**
	 * @param uniform the uniform to set
	 */
	public void setUniform(float uniform) {
		this.uniform = uniform;
	}

	/**
	 * @return the machine
	 */
	public float getMachine() {
		return machine;
	}

	/**
	 * @param machine the machine to set
	 */
	public void setMachine(float machine) {
		this.machine = machine;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "SOAWESUMScore [air=" + air + ", awesum=" + awesum + ", energy=" + energy + ", machine=" + machine
				+ ", safety=" + safety + ", soMaster=" + soMaster + ", stateOfficeCode=" + stateOfficeCode + ", uniform="
				+ uniform + ", water=" + water + "]";
	}

}