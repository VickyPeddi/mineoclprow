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
 * StateFITScore
 */
@Entity
@Table(name = "SO_LEADERBOARD")
public class SOFITScore {

    @Id
    @Column(name = "STATEOFFICE")
    private Integer stateOfficeCode;

    @Column(name = "STATE_OFFICE_NAME")
    private String soMaster;

    @Column(name = "FIT")
    private Integer fit;

    @Column(name = "UPDATED_ON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;

    public SOFITScore() {

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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */

    @Override
    public int hashCode() {
        return Objects.hash(fit, soMaster, stateOfficeCode, updatedOn);
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
        if (!(obj instanceof SOFITScore))
            return false;
        SOFITScore other = (SOFITScore) obj;
        return Objects.equals(fit, other.fit) && Objects.equals(soMaster, other.soMaster)
                && Objects.equals(stateOfficeCode, other.stateOfficeCode) && Objects.equals(updatedOn, other.updatedOn);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "SOFITScore [fit=" + fit + ", soMaster=" + soMaster + ", stateOfficeCode=" + stateOfficeCode
                + ", updatedOn=" + updatedOn + "]";
    }

}