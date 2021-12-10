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
 * VendorAssign
 */
@Entity
@Table(name = "AUD_RO_VENDOR_ASSIGNMENT")
public class VendorAssign {

    @EmbeddedId
    private VendorAssignID id;

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

    /**
     * 
     */

    public VendorAssign() {
    }

    /**
     * @param id
     * @param auditType
     * @param startDate
     * @param endDate
     * @param updatedBy
     * @param updatedOn
     */

    public VendorAssign(VendorAssignID id, String auditType, Date startDate, Date endDate, String updatedBy,
            Date updatedOn) {
        this.id = id;
        this.auditType = auditType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.updatedBy = updatedBy;
        this.updatedOn = updatedOn;
    }

    /**
     * @return the id
     */
    public VendorAssignID getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(VendorAssignID id) {
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
        if (!(obj instanceof VendorAssign))
            return false;
        VendorAssign other = (VendorAssign) obj;
        return Objects.equals(id, other.id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "VendorAssign [auditType=" + auditType + ", endDate=" + endDate + ", id=" + id + ", startDate="
                + startDate + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + "]";
    }

}