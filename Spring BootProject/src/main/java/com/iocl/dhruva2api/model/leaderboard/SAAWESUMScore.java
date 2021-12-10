package com.iocl.dhruva2api.model.leaderboard;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VA_SA_WISE_AWESUM")
public class SAAWESUMScore {

	@Id
	@Column(name = "SALESAREA_NAME")
	private String saMaster;

	@Column(name = "SALESOff_NAME")
	private String salesoffName;

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

	public SAAWESUMScore() {
	}

	/**
	 * @return the saMaster
	 */
	public String getSaMaster() {
		return saMaster;
	}

	/**
	 * @param saMaster the saMaster to set
	 */
	public void setSaMaster(String saMaster) {
		this.saMaster = saMaster;
	}

	/**
	 * @return the salesoffName
	 */
	public String getSalesoffName() {
		return salesoffName;
	}

	/**
	 * @param salesoffName the salesoffName to set
	 */
	public void setSalesoffName(String salesoffName) {
		this.salesoffName = salesoffName;
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
		return "SAAWESUMScore [air=" + air + ", awesum=" + awesum + ", energy=" + energy + ", machine=" + machine
				+ ", saMaster=" + saMaster + ", safety=" + safety + ", salesoffName=" + salesoffName + ", uniform="
				+ uniform + ", water=" + water + "]";
	}

}
