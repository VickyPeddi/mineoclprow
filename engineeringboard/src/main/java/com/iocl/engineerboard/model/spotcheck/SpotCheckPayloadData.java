package com.iocl.dhruva2api.model.spotcheck;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

/**
 * SpotCheckPayloadData
 */
public class SpotCheckPayloadData {

    private int roCode;
    private ArrayList<SpotCheckPayloadPoint> spotCheckPoints;
    private String user;

    public SpotCheckPayloadData() {

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
     * @return the spotCheckPoints
     */
    public ArrayList<SpotCheckPayloadPoint> getSpotCheckPoints() {
        return spotCheckPoints;
    }

    /**
     * @param spotCheckPoints the spotCheckPoints to set
     */
    public void setSpotCheckPoints(ArrayList<SpotCheckPayloadPoint> spotCheckPoints) {
        this.spotCheckPoints = spotCheckPoints;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = Jsoup.clean(user, Whitelist.none());
    }

}