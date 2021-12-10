package com.iocl.dhruva2api.model.rca;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * RootCauseIssues
 */
@Entity
@Table(name = "VW_MST_RCA_ISSUES")
public class RootCauseIssues {

    @Id
    @Column(name = "SR_NO")
    private int srNo;

    @Column(name = "ISSUE")
    private String issue;

    @Column(name = "PARENT_CAUSE")
    private int parentCause;

    // @JsonIgnore
    // @ManyToOne
    // @JoinColumn(name = "PARENT_CAUSE", nullable = false)
    // private DhruvaRootCauseData rootCauseData;

    // @OneToMany(mappedBy = "rootCauseIssue")
    // private List<RootCauseSupportOptions> causeSupportOptions;

    public RootCauseIssues() {

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
     * @return the issue
     */
    public String getIssue() {
        return issue;
    }

    /**
     * @param issue the issue to set
     */
    public void setIssue(String issue) {
        this.issue = issue;
    }

    /**
     * @return the parentCause
     */
    public int getParentCause() {
        return parentCause;
    }

    /**
     * @param parentCause the parentCause to set
     */
    public void setParentCause(int parentCause) {
        this.parentCause = parentCause;
    }
    

    /**
     * @return the rootCauseData
     */
    // public DhruvaRootCauseData getRootCauseData() {
    // return rootCauseData;
    // }

    /**
     * @param rootCauseData the rootCauseData to set
     */
    // public void setRootCauseData(DhruvaRootCauseData rootCauseData) {
    // this.rootCauseData = rootCauseData;
    // }

    /**
     * @return the causeSupportOptions
     */
    // public List<RootCauseSupportOptions> getCauseSupportOptions() {
    // return causeSupportOptions;
    // }

    /**
     * @param causeSupportOptions the causeSupportOptions to set
     */
    // public void setCauseSupportOptions(List<RootCauseSupportOptions>
    // causeSupportOptions) {
    // this.causeSupportOptions = causeSupportOptions;
    // }
}