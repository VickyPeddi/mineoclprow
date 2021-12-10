package com.iocl.dhruva2api.model.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MST_LEADERBOARD_WEIGHTAGE")

public class MstLeaderboardWeightage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "SR_NO")
	private int srNo;
	@Column(name = "AWESUM")
	private float awesum;
	@Column(name = "FACILITY")
	private float facility;
	@Column(name = "SPOT")
	private float spot;
	@Column(name = "CA_EVAL")
	private float caEval;
	@Column(name = "ACTIVITY")
	private float activity;
//	@Column(name = "USP")
//	private float usp;
	@Column(name = "MPOWER")
	private float mpower;
	@Column(name = "QUIZ")
	private float quiz;
	@Column(name = "RCA")
	private float rca;
	@Column(name = "CA_TRAIN")
	private float caTrain;
//	@Column(name = "SHORT_TERM")
//	private float shortTerm;
	@Column(name = "TELECALL")
	private float telecall;
	@Column(name = "FIT")
	private float fit;
	@Column(name = "SEVA")
	private float seva;
	@Column(name = "XPERIENCE")
	private float xperience;
	@Column(name = "SKS")
	private float sks;
	@Column(name = "ATTAINER")
	private float attainer;
	@Column(name = "DSA")
	private float dsa;
	

	public MstLeaderboardWeightage() {
	}

	public MstLeaderboardWeightage(int srNo) {
		this.srNo = srNo;
	}

	public float getAwesum() {
		return awesum;
	}

	public void setAwesum(float awesum) {
		this.awesum = awesum;
	}

	public float getFacility() {
		return facility;
	}

	public void setFacility(float facility) {
		this.facility = facility;
	}

	public float getSpot() {
		return spot;
	}

	public void setSpot(float spot) {
		this.spot = spot;
	}

	public float getCaEval() {
		return caEval;
	}

	public void setCaEval(float caEval) {
		this.caEval = caEval;
	}

	public float getActivity() {
		return activity;
	}

	public void setActivity(float activity) {
		this.activity = activity;
	}

//	public float getUsp() {
//		return usp;
//	}
//
//	public void setUsp(float usp) {
//		this.usp = usp;
//	}

	public float getMpower() {
		return mpower;
	}

	public void setMpower(float mpower) {
		this.mpower = mpower;
	}

	public float getQuiz() {
		return quiz;
	}

	public void setQuiz(float quiz) {
		this.quiz = quiz;
	}

	public float getRca() {
		return rca;
	}

	public void setRca(float rca) {
		this.rca = rca;
	}

	public float getCaTrain() {
		return caTrain;
	}

	public void setCaTrain(float caTrain) {
		this.caTrain = caTrain;
	}

//	public float getShortTerm() {
//		return shortTerm;
//	}
//
//	public void setShortTerm(float shortTerm) {
//		this.shortTerm = shortTerm;
//	}

	public float getTelecall() {
		return telecall;
	}

	public void setTelecall(float telecall) {
		this.telecall = telecall;
	}

	public float getFit() {
		return fit;
	}

	public void setFit(float fit) {
		this.fit = fit;
	}

	public float getSeva() {
		return seva;
	}

	public void setSeva(float seva) {
		this.seva = seva;
	}

	public float getXperience() {
		return xperience;
	}

	public void setXperience(float xperience) {
		this.xperience = xperience;
	}

	public float getSks() {
		return sks;
	}

	public void setSks(float sks) {
		this.sks = sks;
	}

	public float getAttainer() {
		return attainer;
	}

	public void setAttainer(float attainer) {
		this.attainer = attainer;
	}

	public float getDsa() {
		return dsa;
	}

	public void setDsa(float dsa) {
		this.dsa = dsa;
	}

	public float getSrNo() {
		return srNo;
	}

	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}

	@Override
	public String toString() {
		return "invoicedownload.MstLeaderboardWeightage[ srNo=" + srNo + " ]";
	}

}
