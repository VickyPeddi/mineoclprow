package com.iocl.dhruva2api.model.vendor;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

/**
 * VendorAssignError
 */
@Entity
@Table(name = "AUD_RO_VENDOR_ASSIGNMENT_ERROR")
public class VendorAssignError {

    @EmbeddedId
    private VendorAssignErrorID id;

    @Column(name = "AUDIT_TYPE")
    private String auditType;

    @Column(name = "START_DATE")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "END_DATE")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "UPD_BY")
    private String updatedBy;

    @Column(name = "UPD_DATE")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;

    @Column(name = "REASON")
    private String reason;

    /**
     * 
     */

    public VendorAssignError() {
    }

    /**
     * @param id
     * @param auditType
     * @param startDate
     * @param endDate
     * @param updatedBy
     * @param updatedOn
     * @param reason
     */

    public VendorAssignError(VendorAssignErrorID id, String auditType, Date startDate, Date endDate, String updatedBy,
            Date updatedOn, String reason) {
        this.id = id;
        this.auditType = auditType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.updatedBy = updatedBy;
        this.updatedOn = updatedOn;
        this.reason = reason;
    }

    /**
     * @return the id
     */
    public VendorAssignErrorID getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(VendorAssignErrorID id) {
        this.id = id;
    }

    /**
     * @return the auditType
     */
    public String getAuditType() {
        return auditType;
    }

    /**
     * @param auditType the auditType to set
     */
    public void setAuditType(String auditType) {
        this.auditType = auditType;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the updatedBy
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * @param updatedBy the updatedBy to set
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
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
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */

    @Override
    public int hashCode() {
        return Objects.hash(id);
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
        if (!(obj instanceof VendorAssignError))
            return false;
        VendorAssignError other = (VendorAssignError) obj;
        return Objects.equals(id, other.id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "VendorAssignError [auditType=" + auditType + ", endDate=" + endDate + ", id=" + id + ", reason="
                + reason + ", startDate=" + startDate + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + "]";
    }

}