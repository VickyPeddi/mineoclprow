package com.iocl.dhruva2api.model.leaderboard;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SOLeaderboard
 */
@Entity
@Table(name = "SO_LEADERBOARD")
public class SOLeaderboard {

	//Made to Integer from int, because DB consists null values and system was giving error. on having it String, problem was coming in sorting
	
    @Id
    @Column(name = "STATEOFFICE")
    private Integer stateOfficeCode;

    @Column(name = "FINAL_INDEX")
    private Integer finalDhruvaIndex;

    @Column(name = "TOTAL_DHRUVA")
    private Integer totalDhruva;

    @Column(name = "AWESUM")
    private Integer awesum;

    @Column(name = "AWESUM_RANK")
    private Integer awesumRank;

    @Column(name = "FACIITY_COMPLETION")
    private Integer facilityCompletion;

    @Column(name = "FACIITY_COMPLETION_RANK")
    private Integer facilityCompletionRank;

    @Column(name = "SPOT_CHECK")
    private Integer spotCheck;

    @Column(name = "SPOT_CHECK_RANK")
    private Integer spotCheckRank;

    @Column(name = "CA_EVALUATION")
    private Integer caEvaluation;

    @Column(name = "CA_EVALUATION_RANK")
    private Integer caEvaluationRank;

    @Column(name = "ACTIVITY_COMPLETION")
    private Integer activityCompletion;

    @Column(name = "ACTIVITY_COMPLETION_RANK")
    private Integer activityCompletionRank;

    @Column(name = "MPOWER")
    private Integer mPower;

    @Column(name = "MPOWER_RANK")
    private Integer mPowerRank;

    @Column(name = "FOQUIZ")
    private Integer foQuiz;

    @Column(name = "FOQUIZ_RANK")
    private Integer foQuizRank;

    @Column(name = "RCA")
    private Integer rca;

    @Column(name = "RCA_RANK")
    private Integer rcaRank;

    @Column(name = "CA_TRANING")
    private Integer caTraining;

    @Column(name = "CA_TRANING_RANK")
    private Integer caTrainingRank;

    @Column(name = "TELECALL")
    private Integer telecall;

    @Column(name = "TELECALL_RANK")
    private Integer telecallRank;

    @Column(name = "FIT")
    private Integer fit;

    @Column(name = "FIT_RANK")
    private Integer fitRank;

    @Column(name = "SEVA")
    private Integer seva;
    
    @Column(name="DSA")
    private Integer dsa; 
    
    @Column(name="DSA_RANK")
    private Integer dsaRank; 

    @Column(name = "SEVA_RANK")
    private Integer sevaRank;

    @Column(name = "SAU_KA_SANKALP")
    private Integer sauKaSankalp;

    @Column(name = "SAU_KA_SANKALP_RANK")
    private Integer sauKaSankalpRank;

    @Column(name = "ATTAINER")
    private Integer attainer;

    @Column(name = "ATTAINER_RANK")
    private Integer attainerRank;

    @Column(name = "XPERIENCE")
    private Integer xperience;

    @Column(name = "XPERIENCE_RANK")
    private Integer xperienceRank;

    @Column(name = "RANK")
    private Integer rank;

    @Column(name = "UPDATED_ON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;

    @Column(name = "STATE_OFFICE_NAME")
    private String soMaster;

    @Column(name = "DHRUVA_COMPLIANT")
    private Integer dhruvaCompliant;

    @Column(name = "DHRUVA_COMPLIANT_RANK")
    private Integer dhruvaCompliantRank;

    public SOLeaderboard() {

    }

    public Integer getStateOfficeCode() {
        return stateOfficeCode;
    }

    public void setStateOfficeCode(Integer stateOfficeCode) {
        this.stateOfficeCode = stateOfficeCode;
    }

    public Integer getFinalDhruvaIndex() {
        return finalDhruvaIndex;
    }

    public void setFinalDhruvaIndex(Integer finalDhruvaIndex) {
        this.finalDhruvaIndex = finalDhruvaIndex;
    }

    public Integer getTotalDhruva() {
        return totalDhruva;
    }

    public void setTotalDhruva(Integer totalDhruva) {
        this.totalDhruva = totalDhruva;
    }

    public Integer getAwesum() {
        return awesum;
    }

    public void setAwesum(Integer awesum) {
        this.awesum = awesum;
    }

    public Integer getFacilityCompletion() {
        return facilityCompletion;
    }

    public void setFacilityCompletion(Integer facilityCompletion) {
        this.facilityCompletion = facilityCompletion;
    }

    public Integer getSpotCheck() {
        return spotCheck;
    }

    public void setSpotCheck(Integer spotCheck) {
        this.spotCheck = spotCheck;
    }

    public Integer getCaEvaluation() {
        return caEvaluation;
    }

    public void setCaEvaluation(Integer caEvaluation) {
        this.caEvaluation = caEvaluation;
    }

    public Integer getActivityCompletion() {
        return activityCompletion;
    }

    public void setActivityCompletion(Integer activityCompletion) {
        this.activityCompletion = activityCompletion;
    }

    public Integer getmPower() {
        return mPower;
    }

    public void setmPower(Integer mPower) {
        this.mPower = mPower;
    }

    public Integer getAwesumRank() {
		return awesumRank;
	}

	public void setAwesumRank(Integer awesumRank) {
		this.awesumRank = awesumRank;
	}

	public Integer getFacilityCompletionRank() {
		return facilityCompletionRank;
	}

	public void setFacilityCompletionRank(Integer facilityCompletionRank) {
		this.facilityCompletionRank = facilityCompletionRank;
	}

	public Integer getSpotCheckRank() {
		return spotCheckRank;
	}

	public void setSpotCheckRank(Integer spotCheckRank) {
		this.spotCheckRank = spotCheckRank;
	}

	public Integer getCaEvaluationRank() {
		return caEvaluationRank;
	}

	public void setCaEvaluationRank(Integer caEvaluationRank) {
		this.caEvaluationRank = caEvaluationRank;
	}

	public Integer getActivityCompletionRank() {
		return activityCompletionRank;
	}

	public void setActivityCompletionRank(Integer activityCompletionRank) {
		this.activityCompletionRank = activityCompletionRank;
	}

	public Integer getmPowerRank() {
		return mPowerRank;
	}

	public void setmPowerRank(Integer mPowerRank) {
		this.mPowerRank = mPowerRank;
	}

	public Integer getFoQuizRank() {
		return foQuizRank;
	}

	public void setFoQuizRank(Integer foQuizRank) {
		this.foQuizRank = foQuizRank;
	}

	public Integer getRcaRank() {
		return rcaRank;
	}

	public void setRcaRank(Integer rcaRank) {
		this.rcaRank = rcaRank;
	}

	public Integer getCaTrainingRank() {
		return caTrainingRank;
	}

	public void setCaTrainingRank(Integer caTrainingRank) {
		this.caTrainingRank = caTrainingRank;
	}

	public Integer getTelecallRank() {
		return telecallRank;
	}

	public void setTelecallRank(Integer telecallRank) {
		this.telecallRank = telecallRank;
	}

	public Integer getFitRank() {
		return fitRank;
	}

	public void setFitRank(Integer fitRank) {
		this.fitRank = fitRank;
	}

	public Integer getDsaRank() {
		return dsaRank;
	}

	public void setDsaRank(Integer dsaRank) {
		this.dsaRank = dsaRank;
	}

	public Integer getSevaRank() {
		return sevaRank;
	}

	public void setSevaRank(Integer sevaRank) {
		this.sevaRank = sevaRank;
	}

	public Integer getSauKaSankalpRank() {
		return sauKaSankalpRank;
	}

	public void setSauKaSankalpRank(Integer sauKaSankalpRank) {
		this.sauKaSankalpRank = sauKaSankalpRank;
	}

	public Integer getAttainerRank() {
		return attainerRank;
	}

	public void setAttainerRank(Integer attainerRank) {
		this.attainerRank = attainerRank;
	}

	public Integer getXperienceRank() {
		return xperienceRank;
	}

	public void setXperienceRank(Integer xperienceRank) {
		this.xperienceRank = xperienceRank;
	}

	public Integer getFoQuiz() {
        return foQuiz;
    }

    public void setFoQuiz(Integer foQuiz) {
        this.foQuiz = foQuiz;
    }

    public Integer getRca() {
        return rca;
    }

    public void setRca(Integer rca) {
        this.rca = rca;
    }

    public Integer getCaTraining() {
        return caTraining;
    }

    public void setCaTraining(Integer caTraining) {
        this.caTraining = caTraining;
    }

    public Integer getTelecall() {
        return telecall;
    }

    public void setTelecall(Integer telecall) {
        this.telecall = telecall;
    }

    public Integer getFit() {
        return fit;
    }

    public void setFit(Integer fit) {
        this.fit = fit;
    }

    public Integer getSeva() {
        return seva;
    }

    public void setSeva(Integer seva) {
        this.seva = seva;
    }

    public Integer getSauKaSankalp() {
        return sauKaSankalp;
    }

    public void setSauKaSankalp(Integer sauKaSankalp) {
        this.sauKaSankalp = sauKaSankalp;
    }

    public Integer getDsa() {
        return dsa;
    }

    public void setDsa(Integer dsa) {
        this.dsa = dsa;
    }

    public Integer getAttainer() {
        return attainer;
    }

    public void setAttainer(Integer attainer) {
        this.attainer = attainer;
    }

    public Integer getXperience() {
        return xperience;
    }

    public void setXperience(Integer xperience) {
        this.xperience = xperience;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    // We don't really need whole SO Master with all one to one mapping. So changed
    // return type. As we are using
    // this model only for dashboard graphics.
    public String getSoMaster() {
        return this.soMaster;
    }

    public void setSoMaster(String soMaster) {
        this.soMaster = soMaster;
    }

    /**
     * @return the dhruvaCompliant
     */
    public Integer getDhruvaCompliant() {
        return dhruvaCompliant;
    }

    /**
     * @param dhruvaCompliant the dhruvaCompliant to set
     */
    public void setDhruvaCompliant(Integer dhruvaCompliant) {
        this.dhruvaCompliant = dhruvaCompliant;
    }

    /**
     * @return the dhruvaCompliantRank
     */
    public Integer getDhruvaCompliantRank() {
        return dhruvaCompliantRank;
    }

    /**
     * @param dhruvaCompliantRank the dhruvaCompliantRank to set
     */
    public void setDhruvaCompliantRank(Integer dhruvaCompliantRank) {
        this.dhruvaCompliantRank = dhruvaCompliantRank;
    }

}