package com.iocl.dhruva2api.model.activity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ActivityMaster
 */

@Entity
@Table(name = "MST_ACTIVITY")
public class ActivityMaster {

    @Id
    @Column(name = "ACTIVITY_NO")
    private int activityNo;

    @Column(name = "ACTIVITY_NAME")
    private String activityName;

    @Column(name = "ENTRYTYPE")
    private String entrytype;

    public ActivityMaster() {

    }

    public ActivityMaster(int activityNo, String activityName) {
        this();
        this.activityNo = activityNo;
        this.activityName = activityName;
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
     * @return the activityName
     */
    public String getActivityName() {
        return activityName;
    }

    /**
     * @param activityName the activityName to set
     */
    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    /**
     * @return the entrytype
     */
    public String getEntrytype() {
        return entrytype;
    }

    /**
     * @param entrytype the entrytype to set
     */
    public void setEntrytype(String entrytype) {
        this.entrytype = entrytype;
    }

}