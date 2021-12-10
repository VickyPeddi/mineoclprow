package com.iocl.dhruva2api.model.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DhruvaAdmin
 */
@Entity
@Table(name = "DHRUVA_ADMIN")
public class DhruvaAdmin {

    @Id
    @Column(name = "EMP_CODE")
    private int empCode;

    @Column(name = "ACTIVE_FLAG")
    private short activeFlag;

    @Column(name = "ADMIN_COMMENT")
    private String adminComment;

    public DhruvaAdmin() {

    }

    /**
     * @return the empCode
     */
    public int getEmpCode() {
        return empCode;
    }

    /**
     * @param empCode the empCode to set
     */
    public void setEmpCode(int empCode) {
        this.empCode = empCode;
    }

    /**
     * @return the activeFlag
     */
    public short getActiveFlag() {
        return activeFlag;
    }

    /**
     * @param activeFlag the activeFlag to set
     */
    public void setActiveFlag(short activeFlag) {
        this.activeFlag = activeFlag;
    }

    /**
     * @return the adminComment
     */
    public String getAdminComment() {
        return adminComment;
    }

    /**
     * @param adminComment the adminComment to set
     */
    public void setAdminComment(String adminComment) {
        this.adminComment = adminComment;
    }

    @Override
    public String toString() {
        return "DhruvaAdmin [activeFlag=" + activeFlag + ", adminComment=" + adminComment + ", empCode=" + empCode
                + "]";
    }

}