package com.iocl.dhruva2api.model.auditor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AuditorAdmin
 */
@Entity
@Table(name = "AUD_VENDOR")
public class AuditorAdmin {

    @Id
    @Column(name = "USERID")
    private String userId;

    @Column(name = "EMP_STATUS")
    private String empStatus;

    /**
     * 
     */

    public AuditorAdmin() {
    }

    /**
     * @param userId
     * @param empStatus
     */

    public AuditorAdmin(String userId, String empStatus) {
        this.userId = userId;
        this.empStatus = empStatus;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the empStatus
     */
    public String getEmpStatus() {
        return empStatus;
    }

    /**
     * @param empStatus the empStatus to set
     */
    public void setEmpStatus(String empStatus) {
        this.empStatus = empStatus;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "AuditorAdmin [empStatus=" + empStatus + ", userId=" + userId + "]";
    }
}