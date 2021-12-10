package com.iocl.dhruva2api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * DhruvaCustomer
 */
@Entity
@Table(name = "VW_DHRUVA_CUST_DETAILS")
public class DhruvaCustomer {

	@Id
	@Column(name = "RO_CODE")
	private int roCode;

	@Column(name = "CUST_NAME")
	private String roName;

	@JsonIgnore
	@Column(name = "SALESOFF")
	private int doCode;

	@JsonIgnore
	@Column(name = "SALESORG")
	private int soCode;

	@Column(name = "SALESORG_NAME")
	private String soName;

	@Column(name = "SALESOFF_NAME")
	private String doName;

	@JsonIgnore
	@Column(name = "SALESAREA")
	private String salesAreaCode;

	@Column(name = "SALESAREA_NAME")
	private String salesAreaName;

	@Column(name = "ARCHETYPE_CODE")
	private int archetypeCode;

	@Column(name = "ARCHE_NAME")
	private String archetypeName;

	@Column(name = "CUST_CITY")
	private String location;

	@Column(name = "PHASE")
	private String phase;

	@Column(name = "SAU_KA_SANKALP")
	private String sauKaSankalp;

	@Column(name = "ATTAINER")
	private String attainer;

	@Column(name = "BRANDED_FUEL")
	private String brandedFuel;

	@Column(name = "PRICEGRP")
	private String priceGrp;

	@Column(name = "SITE")
	private String site;

	// @Transient
	// private ArrayList<Integer> spotCheckModules;
	//
	// public ArrayList<Integer> getSpotCheckModules() {
	// return spotCheckModules;
	// }
	//
	// public void setSpotCheckModules(ArrayList<Integer> spotCheckModules) {
	// this.spotCheckModules = spotCheckModules;
	// }

	public DhruvaCustomer() {

	}

	/**
	 * @return the roCode
	 */
	public int getRoCode() {
		return roCode;
	}

	/**
	 * @param roCode the roCode to set
	 */
	public void setRoCode(int roCode) {
		this.roCode = roCode;
	}

	/**
	 * @return the roName
	 */
	public String getRoName() {
		return roName;
	}

	/**
	 * @param roName the roName to set
	 */
	public void setRoName(String roName) {
		this.roName = roName;
	}

	public int getSoCode() {
		return soCode;
	}

	public void setSoCode(int soCode) {
		this.soCode = soCode;
	}

	/**
	 * @return the doCode
	 */
	public int getDoCode() {
		return doCode;
	}

	/**
	 * @param doCode the doCode to set
	 */
	public void setDoCode(int doCode) {
		this.doCode = doCode;
	}

	/**
	 * @return the doName
	 */
	public String getDoName() {
		return doName.replace("DO", "");
	}

	/**
	 * @param doName the doName to set
	 */
	public void setDoName(String doName) {
		this.doName = doName;
	}

	/**
	 * @return the salesAreaCode
	 */
	public String getSalesAreaCode() {
		return salesAreaCode;
	}

	/**
	 * @param salesAreaCode the salesAreaCode to set
	 */
	public void setSalesAreaCode(String salesAreaCode) {
		this.salesAreaCode = salesAreaCode;
	}

	/**
	 * @return the salesAreaName
	 */
	public String getSalesAreaName() {
		return salesAreaName.replace("RSA", "");
	}

	/**
	 * @param salesAreaName the salesAreaName to set
	 */
	public void setSalesAreaName(String salesAreaName) {
		this.salesAreaName = salesAreaName;
	}

	/**
	 * @return the archetypeCode
	 */
	public int getArchetypeCode() {
		return archetypeCode;
	}

	/**
	 * @param archetypeCode the archetypeCode to set
	 */
	public void setArchetypeCode(int archetypeCode) {
		this.archetypeCode = archetypeCode;
	}

	/**
	 * @return the archetypeName
	 */
	public String getArchetypeName() {
		return archetypeName;
	}

	/**
	 * @param archetypeName the archetypeName to set
	 */
	public void setArchetypeName(String archetypeName) {
		this.archetypeName = archetypeName;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the phase
	 */
	public String getPhase() {
		return phase;
	}

	/**
	 * @param phase the phase to set
	 */
	public void setPhase(String phase) {
		this.phase = phase;
	}

	/**
	 * @return the sauKaSankalp
	 */
	public String getSauKaSankalp() {
		return sauKaSankalp;
	}

	/**
	 * @param sauKaSankalp the sauKaSankalp to set
	 */
	public void setSauKaSankalp(String sauKaSankalp) {
		this.sauKaSankalp = sauKaSankalp;
	}

	/**
	 * @return the attainer
	 */
	public String getAttainer() {
		return attainer;
	}

	/**
	 * @param attainer the attainer to set
	 */
	public void setAttainer(String attainer) {
		this.attainer = attainer;
	}

	/**
	 * @return the brandedFuel
	 */
	public String getBrandedFuel() {
		return brandedFuel;
	}

	/**
	 * @param brandedFuel the brandedFuel to set
	 */
	public void setBrandedFuel(String brandedFuel) {
		this.brandedFuel = brandedFuel;
	}

	/**
	 * @return the priceGrp
	 */
	public String getPriceGrp() {
		return priceGrp;
	}

	/**
	 * @param priceGrp the priceGrp to set
	 */
	public void setPriceGrp(String priceGrp) {
		this.priceGrp = priceGrp;
	}

	/**
	 * @return the site
	 */
	public String getSite() {
		return site;
	}

	/**
	 * @param site the site to set
	 */
	public void setSite(String site) {
		this.site = site;
	}

	/**
	 * @return the soName
	 */
	public String getSoName() {
		return soName;
	}

	/**
	 * @param soName the soName to set
	 */
	public void setSoName(String soName) {
		this.soName = soName;
	}
}