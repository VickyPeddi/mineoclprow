package com.iocl.dhruva2api.model.activity;

/**
 * DhruvaActivitiesData
 */
public class DhruvaActivitiesData {

    private int activityNo;
    private String activityName;
    private String selectedValue;

    public DhruvaActivitiesData() {

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
     * @return the selectedValue
     */
    public String getSelectedValue() {
        return selectedValue;
    }

    /**
     * @param selectedValue the selectedValue to set
     */
    public void setSelectedValue(String selectedValue) {
        this.selectedValue = selectedValue;
    }
}