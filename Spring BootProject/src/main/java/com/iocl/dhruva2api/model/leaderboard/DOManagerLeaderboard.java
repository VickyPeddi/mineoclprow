package com.iocl.dhruva2api.model.leaderboard;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "do_manager_leaderboard")
public class DOManagerLeaderboard {

	@Id
	@Column(name = "DO_MANAGER_EMP_CODE")
	private int doManagerEmpCode;

	@Column(name = "DO_MANAGER_NAME")
	private String doManagerName;

	@Column(name = "TOTAL_DHRUVA")
	private String totalDhruva;

	@Column(name = "SALESAREA_COUNT")
	private int salesAreaCount;

	@Column(name = "EMPLOYEE_LOCATION")
	private String employeeLocation;

	@Column(name = "AWESUM")
	private String awesum;

	@Column(name = "FACILITY_COMPLETION")
	private String facilityCompletion;

	@Column(name = "SPOT_CHECK")
	private String spotCheck;

	@Column(name = "CA_EVALUATION")
	private String caEvaluation;

	@Column(name = "ACTIVITY_COMPLETION")
	private String activityCompletion;

	@Column(name = "MPOWER")
	private String mPower;

	@Column(name = "FOQUIZ")
	private String foQuiz;

	@Column(name = "RCA")
	private String rca;

	@Column(name = "CA_TRANING")
	private String caTraining;

	@Column(name = "FIT")
	private String fit;

	@Column(name = "SEVA")
	private String seva;

	@Column(name = "SAU_KA_SANKALP")
	private String sauKaSankalp;

	@Column(name = "ATTAINER")
	private String attainer;

	@Column(name = "XPERIENCE")
	private String xperience;

	@Column(name = "FINAL_INDEX")
	private String finalDhruvaIndex;

	@Column(name = "RANK")
	private String rank;

	@Column(name = "DHRUVA_COMPLIANT")
	private String dhruvaCompliant;

	@Column(name = "UPDATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;

	public int getDoManagerEmpCode() {
		return doManagerEmpCode;
	}

	public void setDoManagerEmpCode(int doManagerEmpCode) {
		this.doManagerEmpCode = doManagerEmpCode;
	}

	public String getDoManagerName() {
		return doManagerName;
	}

	public void setDoManagerName(String doManagerName) {
		this.doManagerName = doManagerName;
	}

	public String getTotalDhruva() {
		return totalDhruva;
	}

	public void setTotalDhruva(String totalDhruva) {
		this.totalDhruva = totalDhruva;
	}

	public int getSalesAreaCount() {
		return salesAreaCount;
	}

	public void setSalesAreaCount(int salesAreaCount) {
		this.salesAreaCount = salesAreaCount;
	}

	public String getEmployeeLocation() {
		return employeeLocation;
	}

	public void setEmployeeLocation(String employeeLocation) {
		this.employeeLocation = employeeLocation;
	}

	public String getAwesum() {
		return awesum;
	}

	public void setAwesum(String awesum) {
		this.awesum = awesum;
	}

	public String getFacilityCompletion() {
		return facilityCompletion;
	}

	public void setFacilityCompletion(String facilityCompletion) {
		this.facilityCompletion = facilityCompletion;
	}

	public String getSpotCheck() {
		return spotCheck;
	}

	public void setSpotCheck(String spotCheck) {
		this.spotCheck = spotCheck;
	}

	public String getCaEvaluation() {
		return caEvaluation;
	}

	public void setCaEvaluation(String caEvaluation) {
		this.caEvaluation = caEvaluation;
	}

	public String getActivityCompletion() {
		return activityCompletion;
	}

	public void setActivityCompletion(String activityCompletion) {
		this.activityCompletion = activityCompletion;
	}

	public String getmPower() {
		return mPower;
	}

	public void setmPower(String mPower) {
		this.mPower = mPower;
	}

	public String getFoQuiz() {
		return foQuiz;
	}

	public void setFoQuiz(String foQuiz) {
		this.foQuiz = foQuiz;
	}

	public String getRca() {
		return rca;
	}

	public void setRca(String rca) {
		this.rca = rca;
	}

	public String getCaTraining() {
		return caTraining;
	}

	public void setCaTraining(String caTraining) {
		this.caTraining = caTraining;
	}

	public String getFit() {
		return fit;
	}

	public void setFit(String fit) {
		this.fit = fit;
	}

	public String getSeva() {
		return seva;
	}

	public void setSeva(String seva) {
		this.seva = seva;
	}

	public String getSauKaSankalp() {
		return sauKaSankalp;
	}

	public void setSauKaSankalp(String sauKaSankalp) {
		this.sauKaSankalp = sauKaSankalp;
	}

	public String getAttainer() {
		return attainer;
	}

	public void setAttainer(String attainer) {
		this.attainer = attainer;
	}

	public String getXperience() {
		return xperience;
	}

	public void setXperience(String xperience) {
		this.xperience = xperience;
	}

	public String getFinalDhruvaIndex() {
		return finalDhruvaIndex;
	}

	public void setFinalDhruvaIndex(String finalDhruvaIndex) {
		this.finalDhruvaIndex = finalDhruvaIndex;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	/**
	 * @return the dhruvaCompliant
	 */
	public String getDhruvaCompliant() {
		return dhruvaCompliant;
	}

	/**
	 * @param dhruvaCompliant the dhruvaCompliant to set
	 */
	public void setDhruvaCompliant(String dhruvaCompliant) {
		this.dhruvaCompliant = dhruvaCompliant;
	}

}
