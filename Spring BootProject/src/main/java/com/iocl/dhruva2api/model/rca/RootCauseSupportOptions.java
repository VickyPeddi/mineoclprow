package com.iocl.dhruva2api.model.rca;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * RootCauseSupportOptions
 */
@Entity
@Table(name = "VW_MST_RCA_SUPPORT_OPTION")
public class RootCauseSupportOptions {

    @Id
    @Column(name = "SR_NO")
    private int srNo;

    @Column(name = "OPTION_TEXT")
    private String optionText;

    @Column(name = "PARENT_ISSUE")
    private int parentIssue;

    // @JsonIgnore
    // @ManyToOne
    // @JoinColumn(name = "PARENT_CAUSE", nullable = false)
    // @JoinColumns({ @JoinColumn(name = "PARENT_ISSUE", nullable = false),
    // @JoinColumn(name = "PARENT_CAUSE", nullable = false) })
    // private RootCauseIssues rootCauseIssue;

    public RootCauseSupportOptions() {

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
     * @return the optionText
     */
    public String getOptionText() {
        return optionText;
    }

    /**
     * @param optionText the optionText to set
     */
    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    /**
     * @return the parentIssue
     */
    public int getParentIssue() {
        return parentIssue;
    }

    /**
     * @param parentIssue the parentIssue to set
     */
    public void setParentIssue(int parentIssue) {
        this.parentIssue = parentIssue;
    }

    /**
     * @return the rootCauseIssue
     */
    // public RootCauseIssues getRootCauseIssue() {
    // return rootCauseIssue;
    // }

    /**
     * @param rootCauseIssue the rootCauseIssue to set
     */
    // public void setRootCauseIssue(RootCauseIssues rootCauseIssue) {
    // this.rootCauseIssue = rootCauseIssue;
    // }
}