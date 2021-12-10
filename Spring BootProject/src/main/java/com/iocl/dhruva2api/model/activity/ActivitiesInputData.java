package com.iocl.dhruva2api.model.activity;

import java.util.List;

/**
 * ActivitiesInputData
 */
public class ActivitiesInputData {

    private int roCode;
    private String roName;
    private int archetypeCode;
    private String archetypeName;

    private List<DhruvaActivitiesData> dhruvaActivities;

    public ActivitiesInputData() {

    }

    /**
     * @return the roCode
     */
    public int getRoCode() {
        return roCode;
    }

    /**
     * @param roCode the roCode to set
     */
    public void setRoCode(int roCode) {
        this.roCode = roCode;
    }

    /**
     * @return the roName
     */
    public String getRoName() {
        return roName;
    }

    /**
     * @param roName the roName to set
     */
    public void setRoName(String roName) {
        this.roName = roName;
    }

    /**
     * @return the archetypeCode
     */
    public int getArchetypeCode() {
        return archetypeCode;
    }

    /**
     * @param archetypeCode the archetypeCode to set
     */
    public void setArchetypeCode(int archetypeCode) {
        this.archetypeCode = archetypeCode;
    }

    /**
     * @return the archetypeName
     */
    public String getArchetypeName() {
        return archetypeName;
    }

    /**
     * @param archetypeName the archetypeName to set
     */
    public void setArchetypeName(String archetypeName) {
        this.archetypeName = archetypeName;
    }

    /**
     * @return the dhruvaActivities
     */
    public List<DhruvaActivitiesData> getDhruvaActivities() {
        return dhruvaActivities;
    }

    /**
     * @param dhruvaActivities the dhruvaActivities to set
     */
    public void setDhruvaActivities(List<DhruvaActivitiesData> dhruvaActivities) {
        this.dhruvaActivities = dhruvaActivities;
    }
}