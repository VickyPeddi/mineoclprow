package com.iocl.dhruva2api.model.activity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MstFacilityWiseActivity
 */
@Entity
@Table(name = "MST_ACTIVITY_OTHERS")
public class MstFacilityWiseActivity {

    @Id
    @Column(name = "SR_NO")
    private int srNo;

    @Column(name = "ACTIVITY_NO")
    private int activityNo;

    @Column(name = "PARAMETER_NAME")
    private String parameterName;

    public MstFacilityWiseActivity() {

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
     * @return the activityNo
     */
    public int getActivityNo() {
        return activityNo;
    }

    /**
     * @param activityNo the activityNo to set
     */
    public void setActivityNo(int activityNo) {
        this.activityNo = activityNo;
    }

    /**
     * @return the parameterName
     */
    public String getParameterName() {
        return parameterName;
    }

    /**
     * @param parameterName the parameterName to set
     */
    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }
}