package com.iocl.dhruva2api.model.leaderboard;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * FOLeaderboard
 */
@Entity
@Table(name = "FO_LEADERBOARD")
public class FOLeaderboard {

    @Id
    @Column(name = "SALESAREA")
    private String salesarea;

    @Column(name = "FO_EMP_CODE")
    private Integer foEmpCode;

    @Column(name = "FO_NAME")
    private String foEmpName;

    @Column(name = "TOTAL_DHRUVA")
    private int totalDhruva;

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

    @Column(name = "FIT")
    private Integer fit;

    @Column(name = "FIT_RANK")
    private Integer fitRank;

    @Column(name = "SEVA")
    private Integer seva;

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

    @Column(name = "FINAL_INDEX")
    private Integer finalDhruvaIndex;

    @Column(name = "RANK")
    private int rank;

    @Column(name = "UPDATED_ON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;

    @Column(name = "SALESAREA_NAME")
    private String saMaster;

    @Column(name = "SALESOFF_NAME")
    private String doMaster;

    @Column(name = "SALESORG_NAME")
    private String soMaster;

    @Column(name = "DHRUVA_COMPLIANT")
    private Integer dhruvaCompliant;

    @Column(name = "DHRUVA_COMPLIANT_RANK")
    private Integer dhruvaCompliantRank;

    public FOLeaderboard() {

    }

    /**
     * @return the salesarea
     */
    public String getSalesarea() {
        return salesarea;
    }

    /**
     * @param salesarea the salesarea to set
     */
    public void setSalesarea(String salesarea) {
        this.salesarea = salesarea;
    }

    /**
     * @return the foEmpCode
     */
    public Integer getFoEmpCode() {
        return foEmpCode;
    }

    /**
     * @param foEmpCode the foEmpCode to set
     */
    public void setFoEmpCode(Integer foEmpCode) {
        this.foEmpCode = foEmpCode;
    }

    /**
     * @return the foEmpName
     */
    public String getFoEmpName() {
        return foEmpName;
    }

    /**
     * @param foEmpName the foEmpName to set
     */
    public void setFoEmpName(String foEmpName) {
        this.foEmpName = foEmpName;
    }

    /**
     * @return the totalDhruva
     */
    public int getTotalDhruva() {
        return totalDhruva;
    }

    /**
     * @param totalDhruva the totalDhruva to set
     */
    public void setTotalDhruva(int totalDhruva) {
        this.totalDhruva = totalDhruva;
    }

    /**
     * @return the awesum
     */
    public Integer getAwesum() {
        return awesum;
    }

    /**
     * @param awesum the awesum to set
     */
    public void setAwesum(Integer awesum) {
        this.awesum = awesum;
    }

    /**
     * @return the awesumRank
     */
    public Integer getAwesumRank() {
        return awesumRank;
    }

    /**
     * @param awesumRank the awesumRank to set
     */
    public void setAwesumRank(Integer awesumRank) {
        this.awesumRank = awesumRank;
    }

    /**
     * @return the facilityCompletion
     */
    public Integer getFacilityCompletion() {
        return facilityCompletion;
    }

    /**
     * @param facilityCompletion the facilityCompletion to set
     */
    public void setFacilityCompletion(Integer facilityCompletion) {
        this.facilityCompletion = facilityCompletion;
    }

    /**
     * @return the facilityCompletionRank
     */
    public Integer getFacilityCompletionRank() {
        return facilityCompletionRank;
    }

    /**
     * @param facilityCompletionRank the facilityCompletionRank to set
     */
    public void setFacilityCompletionRank(Integer facilityCompletionRank) {
        this.facilityCompletionRank = facilityCompletionRank;
    }

    /**
     * @return the spotCheck
     */
    public Integer getSpotCheck() {
        return spotCheck;
    }

    /**
     * @param spotCheck the spotCheck to set
     */
    public void setSpotCheck(Integer spotCheck) {
        this.spotCheck = spotCheck;
    }

    /**
     * @return the spotCheckRank
     */
    public Integer getSpotCheckRank() {
        return spotCheckRank;
    }

    /**
     * @param spotCheckRank the spotCheckRank to set
     */
    public void setSpotCheckRank(Integer spotCheckRank) {
        this.spotCheckRank = spotCheckRank;
    }

    /**
     * @return the caEvaluation
     */
    public Integer getCaEvaluation() {
        return caEvaluation;
    }

    /**
     * @param caEvaluation the caEvaluation to set
     */
    public void setCaEvaluation(Integer caEvaluation) {
        this.caEvaluation = caEvaluation;
    }

    /**
     * @return the caEvaluationRank
     */
    public Integer getCaEvaluationRank() {
        return caEvaluationRank;
    }

    /**
     * @param caEvaluationRank the caEvaluationRank to set
     */
    public void setCaEvaluationRank(Integer caEvaluationRank) {
        this.caEvaluationRank = caEvaluationRank;
    }

    /**
     * @return the activityCompletion
     */
    public Integer getActivityCompletion() {
        return activityCompletion;
    }

    /**
     * @param activityCompletion the activityCompletion to set
     */
    public void setActivityCompletion(Integer activityCompletion) {
        this.activityCompletion = activityCompletion;
    }

    /**
     * @return the activityCompletionRank
     */
    public Integer getActivityCompletionRank() {
        return activityCompletionRank;
    }

    /**
     * @param activityCompletionRank the activityCompletionRank to set
     */
    public void setActivityCompletionRank(Integer activityCompletionRank) {
        this.activityCompletionRank = activityCompletionRank;
    }

    /**
     * @return the mPower
     */
    public Integer getmPower() {
        return mPower;
    }

    /**
     * @param mPower the mPower to set
     */
    public void setmPower(Integer mPower) {
        this.mPower = mPower;
    }

    /**
     * @return the mPowerRank
     */
    public Integer getmPowerRank() {
        return mPowerRank;
    }

    /**
     * @param mPowerRank the mPowerRank to set
     */
    public void setmPowerRank(Integer mPowerRank) {
        this.mPowerRank = mPowerRank;
    }

    /**
     * @return the foQuiz
     */
    public Integer getFoQuiz() {
        return foQuiz;
    }

    /**
     * @param foQuiz the foQuiz to set
     */
    public void setFoQuiz(Integer foQuiz) {
        this.foQuiz = foQuiz;
    }

    /**
     * @return the foQuizRank
     */
    public Integer getFoQuizRank() {
        return foQuizRank;
    }

    /**
     * @param foQuizRank the foQuizRank to set
     */
    public void setFoQuizRank(Integer foQuizRank) {
        this.foQuizRank = foQuizRank;
    }

    /**
     * @return the rca
     */
    public Integer getRca() {
        return rca;
    }

    /**
     * @param rca the rca to set
     */
    public void setRca(Integer rca) {
        this.rca = rca;
    }

    /**
     * @return the rcaRank
     */
    public Integer getRcaRank() {
        return rcaRank;
    }

    /**
     * @param rcaRank the rcaRank to set
     */
    public void setRcaRank(Integer rcaRank) {
        this.rcaRank = rcaRank;
    }

    /**
     * @return the caTraining
     */
    public Integer getCaTraining() {
        return caTraining;
    }

    /**
     * @param caTraining the caTraining to set
     */
    public void setCaTraining(Integer caTraining) {
        this.caTraining = caTraining;
    }

    /**
     * @return the caTrainingRank
     */
    public Integer getCaTrainingRank() {
        return caTrainingRank;
    }

    /**
     * @param caTrainingRank the caTrainingRank to set
     */
    public void setCaTrainingRank(Integer caTrainingRank) {
        this.caTrainingRank = caTrainingRank;
    }

    /**
     * @return the fit
     */
    public Integer getFit() {
        return fit;
    }

    /**
     * @param fit the fit to set
     */
    public void setFit(Integer fit) {
        this.fit = fit;
    }

    /**
     * @return the fitRank
     */
    public Integer getFitRank() {
        return fitRank;
    }

    /**
     * @param fitRank the fitRank to set
     */
    public void setFitRank(Integer fitRank) {
        this.fitRank = fitRank;
    }

    /**
     * @return the seva
     */
    public Integer getSeva() {
        return seva;
    }

    /**
     * @param seva the seva to set
     */
    public void setSeva(Integer seva) {
        this.seva = seva;
    }

    /**
     * @return the sevaRank
     */
    public Integer getSevaRank() {
        return sevaRank;
    }

    /**
     * @param sevaRank the sevaRank to set
     */
    public void setSevaRank(Integer sevaRank) {
        this.sevaRank = sevaRank;
    }

    /**
     * @return the sauKaSankalp
     */
    public Integer getSauKaSankalp() {
        return sauKaSankalp;
    }

    /**
     * @param sauKaSankalp the sauKaSankalp to set
     */
    public void setSauKaSankalp(Integer sauKaSankalp) {
        this.sauKaSankalp = sauKaSankalp;
    }

    /**
     * @return the sauKaSankalpRank
     */
    public Integer getSauKaSankalpRank() {
        return sauKaSankalpRank;
    }

    /**
     * @param sauKaSankalpRank the sauKaSankalpRank to set
     */
    public void setSauKaSankalpRank(Integer sauKaSankalpRank) {
        this.sauKaSankalpRank = sauKaSankalpRank;
    }

    /**
     * @return the attainer
     */
    public Integer getAttainer() {
        return attainer;
    }

    /**
     * @param attainer the attainer to set
     */
    public void setAttainer(Integer attainer) {
        this.attainer = attainer;
    }

    /**
     * @return the attainerRank
     */
    public Integer getAttainerRank() {
        return attainerRank;
    }

    /**
     * @param attainerRank the attainerRank to set
     */
    public void setAttainerRank(Integer attainerRank) {
        this.attainerRank = attainerRank;
    }

    /**
     * @return the xperience
     */
    public Integer getXperience() {
        return xperience;
    }

    /**
     * @param xperience the xperience to set
     */
    public void setXperience(Integer xperience) {
        this.xperience = xperience;
    }

    /**
     * @return the xperienceRank
     */
    public Integer getXperienceRank() {
        return xperienceRank;
    }

    /**
     * @param xperienceRank the xperienceRank to set
     */
    public void setXperienceRank(Integer xperienceRank) {
        this.xperienceRank = xperienceRank;
    }

    /**
     * @return the finalDhruvaIndex
     */
    public Integer getFinalDhruvaIndex() {
        return finalDhruvaIndex;
    }

    /**
     * @param finalDhruvaIndex the finalDhruvaIndex to set
     */
    public void setFinalDhruvaIndex(Integer finalDhruvaIndex) {
        this.finalDhruvaIndex = finalDhruvaIndex;
    }

    /**
     * @return the rank
     */
    public int getRank() {
        return rank;
    }

    /**
     * @param rank the rank to set
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     * @return the updatedOn
     */
    public Date getUpdatedOn() {
        return updatedOn;
    }

    /**
     * @param updatedOn the updatedOn to set
     */
    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */

    @Override
    public int hashCode() {
        return Objects.hash(activityCompletion, activityCompletionRank, attainer, attainerRank, awesum, awesumRank,
                caEvaluation, caEvaluationRank, caTraining, caTrainingRank, dhruvaCompliant, dhruvaCompliantRank,
                doMaster, facilityCompletion, facilityCompletionRank, finalDhruvaIndex, fit, fitRank, foEmpCode,
                foEmpName, foQuiz, foQuizRank, mPower, mPowerRank, rank, rca, rcaRank, saMaster, salesarea,
                sauKaSankalp, sauKaSankalpRank, seva, sevaRank, soMaster, spotCheck, spotCheckRank, totalDhruva,
                updatedOn, xperience, xperienceRank);
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
        if (obj == null)
            return false;
        if (!(obj instanceof FOLeaderboard))
            return false;
        FOLeaderboard other = (FOLeaderboard) obj;
        return Objects.equals(activityCompletion, other.activityCompletion)
                && Objects.equals(activityCompletionRank, other.activityCompletionRank)
                && Objects.equals(attainer, other.attainer) && Objects.equals(attainerRank, other.attainerRank)
                && Objects.equals(awesum, other.awesum) && Objects.equals(awesumRank, other.awesumRank)
                && Objects.equals(caEvaluation, other.caEvaluation)
                && Objects.equals(caEvaluationRank, other.caEvaluationRank)
                && Objects.equals(caTraining, other.caTraining) && Objects.equals(caTrainingRank, other.caTrainingRank)
                && Objects.equals(dhruvaCompliant, other.dhruvaCompliant)
                && Objects.equals(dhruvaCompliantRank, other.dhruvaCompliantRank)
                && Objects.equals(doMaster, other.doMaster)
                && Objects.equals(facilityCompletion, other.facilityCompletion)
                && Objects.equals(facilityCompletionRank, other.facilityCompletionRank)
                && Objects.equals(finalDhruvaIndex, other.finalDhruvaIndex) && Objects.equals(fit, other.fit)
                && Objects.equals(fitRank, other.fitRank) && Objects.equals(foEmpCode, other.foEmpCode)
                && Objects.equals(foEmpName, other.foEmpName) && Objects.equals(foQuiz, other.foQuiz)
                && Objects.equals(foQuizRank, other.foQuizRank) && Objects.equals(mPower, other.mPower)
                && Objects.equals(mPowerRank, other.mPowerRank) && rank == other.rank && Objects.equals(rca, other.rca)
                && Objects.equals(rcaRank, other.rcaRank) && Objects.equals(saMaster, other.saMaster)
                && Objects.equals(salesarea, other.salesarea) && Objects.equals(sauKaSankalp, other.sauKaSankalp)
                && Objects.equals(sauKaSankalpRank, other.sauKaSankalpRank) && Objects.equals(seva, other.seva)
                && Objects.equals(sevaRank, other.sevaRank) && Objects.equals(soMaster, other.soMaster)
                && Objects.equals(spotCheck, other.spotCheck) && Objects.equals(spotCheckRank, other.spotCheckRank)
                && totalDhruva == other.totalDhruva && Objects.equals(updatedOn, other.updatedOn)
                && Objects.equals(xperience, other.xperience) && Objects.equals(xperienceRank, other.xperienceRank);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "FOLeaderboard [activityCompletion=" + activityCompletion + ", activityCompletionRank="
                + activityCompletionRank + ", attainer=" + attainer + ", attainerRank=" + attainerRank + ", awesum="
                + awesum + ", awesumRank=" + awesumRank + ", caEvaluation=" + caEvaluation + ", caEvaluationRank="
                + caEvaluationRank + ", caTraining=" + caTraining + ", caTrainingRank=" + caTrainingRank
                + ", dhruvaCompliant=" + dhruvaCompliant + ", dhruvaCompliantRank=" + dhruvaCompliantRank
                + ", doMaster=" + doMaster + ", facilityCompletion=" + facilityCompletion + ", facilityCompletionRank="
                + facilityCompletionRank + ", finalDhruvaIndex=" + finalDhruvaIndex + ", fit=" + fit + ", fitRank="
                + fitRank + ", foEmpCode=" + foEmpCode + ", foEmpName=" + foEmpName + ", foQuiz=" + foQuiz
                + ", foQuizRank=" + foQuizRank + ", mPower=" + mPower + ", mPowerRank=" + mPowerRank + ", rank=" + rank
                + ", rca=" + rca + ", rcaRank=" + rcaRank + ", saMaster=" + saMaster + ", salesarea=" + salesarea
                + ", sauKaSankalp=" + sauKaSankalp + ", sauKaSankalpRank=" + sauKaSankalpRank + ", seva=" + seva
                + ", sevaRank=" + sevaRank + ", soMaster=" + soMaster + ", spotCheck=" + spotCheck + ", spotCheckRank="
                + spotCheckRank + ", totalDhruva=" + totalDhruva + ", updatedOn=" + updatedOn + ", xperience="
                + xperience + ", xperienceRank=" + xperienceRank + "]";
    }

}