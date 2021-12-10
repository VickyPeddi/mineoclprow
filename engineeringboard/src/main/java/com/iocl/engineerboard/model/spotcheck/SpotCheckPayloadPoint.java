package com.iocl.dhruva2api.model.spotcheck;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

/**
 * SpotCheckPayloadPoint
 */
public class SpotCheckPayloadPoint {

	private int spotCheckPointModuleNo;
	private String spotCheckPointNo;
	private String spotCheckPointValue;
	private String spotCheckPointResponsible;

	public SpotCheckPayloadPoint() {

	}

	/**
	 * @return the spotCheckPointModuleNo
	 */
	public int getSpotCheckPointModuleNo() {
		return spotCheckPointModuleNo;
	}

	/**
	 * @param spotCheckPointModuleNo the spotCheckPointModuleNo to set
	 */
	public void setSpotCheckPointModuleNo(int spotCheckPointModuleNo) {
		this.spotCheckPointModuleNo = spotCheckPointModuleNo;
	}

	/**
	 * @return the spotCheckPointNo
	 */
	public String getSpotCheckPointNo() {
		return spotCheckPointNo;
	}

	/**
	 * @param spotCheckPointNo the spotCheckPointNo to set
	 */
	public void setSpotCheckPointNo(String spotCheckPointNo) {
		this.spotCheckPointNo = spotCheckPointNo;
	}

	/**
	 * @return the spotCheckPointValue
	 */
	public String getSpotCheckPointValue() {
		return spotCheckPointValue;
	}

	/**
	 * @param spotCheckPointValue the spotCheckPointValue to set
	 */
	public void setSpotCheckPointValue(String spotCheckPointValue) {
		this.spotCheckPointValue = Jsoup.clean(spotCheckPointValue, Whitelist.none());
	}

	/**
	 * @return the spotCheckPointResponsible
	 */
	public String getSpotCheckPointResponsible() {
		return spotCheckPointResponsible;
	}

	/**
	 * @param spotCheckPointResponsible the spotCheckPointResponsible to set
	 */
	public void setSpotCheckPointResponsible(String spotCheckPointResponsible) {
		this.spotCheckPointResponsible = spotCheckPointResponsible;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "SpotCheckPayloadPoint [spotCheckPointModuleNo=" + spotCheckPointModuleNo + ", spotCheckPointNo="
				+ spotCheckPointNo + ", spotCheckPointResponsible=" + spotCheckPointResponsible + ", spotCheckPointValue="
				+ spotCheckPointValue + "]";
	}

}