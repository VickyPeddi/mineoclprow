package com.iocl.dhruva2api.model.rca;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DhruvaRootCauseData
 */
@Entity
@Table(name = "VW_MST_RCA_ROOTCAUSE")
public class DhruvaRootCauseData {

    @Id
    @Column(name = "SR_NO")
    private int srNo;

    @Column(name = "CAUSE")
    private String cause;

    // @OneToMany(mappedBy = "rootCauseData")
    // private List<RootCauseIssues> rootCauseIssues;

    public DhruvaRootCauseData() {

    }

    /**
     * @return the srNo
     */
    public int getSrNo() {
        return srNo;
    }

    /**
     * @param srNo the srNo to set
     */
    public void setSrNo(int srNo) {
        this.srNo = srNo;
    }

    /**
     * @return the cause
     */
    public String getCause() {
        return cause;
    }

    /**
     * @param cause the cause to set
     */
    public void setCause(String cause) {
        this.cause = cause;
    }

    /**
     * @return the rootCauseIssues
     */
    // public List<RootCauseIssues> getRootCauseIssues() {
    //     return rootCauseIssues;
    // }

    /**
     * @param rootCauseIssues the rootCauseIssues to set
     */
    // public void setRootCauseIssues(List<RootCauseIssues> rootCauseIssues) {
    //     this.rootCauseIssues = rootCauseIssues;
    // }
}