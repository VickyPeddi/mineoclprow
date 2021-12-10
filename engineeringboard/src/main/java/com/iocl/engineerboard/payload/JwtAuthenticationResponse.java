package com.iocl.dhruva2api.payload;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.DhruvaCustomer;
import com.iocl.dhruva2api.model.spotcheck.ArchetypeWiseModule;
import com.iocl.dhruva2api.model.spotcheck.ArchetypeWiseSpotCheckModuleNumber;
import com.iocl.dhruva2api.model.spotcheck.ModuleQuestionMaster;

public class JwtAuthenticationResponse {

	private String accessToken;
	private String tokenType = "Bearer";
	private String empName;
	private String designation;
	private String empCode;
	private ArrayList<DhruvaCustomer> roList;
	private ArrayList<ArchetypeWiseSpotCheckModuleNumber> archetypeWiseSpotCheckModuleNumber;
	private String soName;
	private String doName;
	private String saName;
	private String userLevel;
	private String locInFlag;
	private long sessionId;

	// Saving this at the point of login, for enabling offline use, will store this
	// in angular service.
	private ArrayList<ArchetypeWiseModule> spotCheckModuleMaster;

	private ArrayList<ModuleQuestionMaster> spotcheckQuestions;

	private int maxAuditCount;

	private boolean development;
	private boolean production;
	private String welcomeMessage;

	public JwtAuthenticationResponse(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the roList
	 */
	public ArrayList<DhruvaCustomer> getRoList() {
		return roList;
	}

	/**
	 * @param roList the roList to set
	 */
	public void setRoList(ArrayList<DhruvaCustomer> roList) {
		this.roList = roList;
	}

	public ArrayList<ArchetypeWiseModule> getSpotCheckModuleMaster() {
		return spotCheckModuleMaster;
	}

	public void setSpotCheckModuleMaster(ArrayList<ArchetypeWiseModule> spotCheckModuleMaster) {
		this.spotCheckModuleMaster = spotCheckModuleMaster;
	}

	public ArrayList<ArchetypeWiseSpotCheckModuleNumber> getArchetypeWiseSpotCheckModuleNumber() {
		return archetypeWiseSpotCheckModuleNumber;
	}

	public void setArchetypeWiseSpotCheckModuleNumber(
			ArrayList<ArchetypeWiseSpotCheckModuleNumber> archetypeWiseSpotCheckModuleNumber) {
		this.archetypeWiseSpotCheckModuleNumber = archetypeWiseSpotCheckModuleNumber;
	}

	public ArrayList<ModuleQuestionMaster> getSpotcheckQuestions() {
		return spotcheckQuestions;
	}

	public void setSpotcheckQuestions(ArrayList<ModuleQuestionMaster> spotcheckQuestions) {
		this.spotcheckQuestions = spotcheckQuestions;
	}

	public String getSoName() {
		return soName;
	}

	public void setSoName(String soName) {
		this.soName = soName;
	}

	public String getDoName() {
		return doName;
	}

	public void setDoName(String doName) {
		this.doName = doName;
	}

	public String getSaName() {
		return saName;
	}

	public void setSaName(String saName) {
		this.saName = saName;
	}

	/**
	 * @return the maxAuditCount
	 */
	public int getMaxAuditCount() {
		return maxAuditCount;
	}

	/**
	 * @param maxAuditCount the maxAuditCount to set
	 */
	public void setMaxAuditCount(int maxAuditCount) {
		this.maxAuditCount = maxAuditCount;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	public String getLocInFlag() {
		return locInFlag;
	}

	public void setLocInFlag(String locInFlag) {
		this.locInFlag = locInFlag;
	}

	/**
	 * @return the sessionId
	 */
	public long getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(long sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return the development
	 */
	public boolean isDevelopment() {
		return development;
	}

	/**
	 * @param development the development to set
	 */
	public void setDevelopment(boolean development) {
		this.development = development;
	}

	/**
	 * @return the production
	 */
	public boolean isProduction() {
		return production;
	}

	/**
	 * @param production the production to set
	 */
	public void setProduction(boolean production) {
		this.production = production;
	}

	/**
	 * @return the welcomeMessage
	 */
	public String getWelcomeMessage() {
		return welcomeMessage;
	}

	/**
	 * @param welcomeMessage the welcomeMessage to set
	 */
	public void setWelcomeMessage(String welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}

}
