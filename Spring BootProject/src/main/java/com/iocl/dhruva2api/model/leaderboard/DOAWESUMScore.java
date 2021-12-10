package com.iocl.dhruva2api.model.leaderboard;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VW_DO_WISE_AWESUM")
public class DOAWESUMScore {

	@Id
	@Column(name = "SALES_OFF_NAME")
	private String doMaster;

	@Column(name = "SALESORG_NAME")
	private String salesorgName;

	@Column(name = "awesum")
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

	/**
	 * 
	 */

	public DOAWESUMScore() {
	}

	/**
	 * @return the doMaster
	 */
	public String getDoMaster() {
		return doMaster;
	}

	/**
	 * @param doMaster the doMaster to set
	 */
	public void setDoMaster(String doMaster) {
		this.doMaster = doMaster;
	}

	/**
	 * @return the salesorgName
	 */
	public String getSalesorgName() {
		return salesorgName;
	}

	/**
	 * @param salesorgName the salesorgName to set
	 */
	public void setSalesorgName(String salesorgName) {
		this.salesorgName = salesorgName;
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
		return "DOAWESUMScore [air=" + air + ", awesum=" + awesum + ", doMaster=" + doMaster + ", energy=" + energy
				+ ", machine=" + machine + ", safety=" + safety + ", salesorgName=" + salesorgName + ", uniform=" + uniform
				+ ", water=" + water + "]";
	}

}
