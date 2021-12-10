package com.iocl.dhruva2api.model.spotcheck;

/**
 * SpotCheckInspNo
 */
public class SpotCheckInspNo {

    private long inspNo;
    private boolean existing;

    public SpotCheckInspNo(long inspNo, boolean existing) {
        this.inspNo = inspNo;
        this.existing = existing;
    }

    /**
     * @return the inspNo
     */
    public long getInspNo() {
        return inspNo;
    }

    /**
     * @param inspNo the inspNo to set
     */
    public void setInspNo(long inspNo) {
        this.inspNo = inspNo;
    }

    /**
     * @return the isExisting
     */
    public boolean isExisting() {
        return existing;
    }

    /**
     * @param isExisting the isExisting to set
     */
    public void setExisting(boolean existing) {
        this.existing = existing;
    }

}