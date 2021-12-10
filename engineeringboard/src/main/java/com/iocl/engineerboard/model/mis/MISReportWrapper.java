package com.iocl.dhruva2api.model.mis;

import java.util.ArrayList;

/**
 * MISReportWrapper
 */
public class MISReportWrapper {

    private ArrayList<String> reportHeaders;

    private ArrayList<ArrayList<Object>> reportDatas;
    
    private boolean isValid;

    public MISReportWrapper() {
        super();
        isValid = true;
    }

    /**
     * @return the reportHeaders
     */
    public ArrayList<String> getReportHeaders() {
        return reportHeaders;
    }

    /**
     * @param reportHeaders the reportHeaders to set
     */
    public void setReportHeaders(ArrayList<String> reportHeaders) {
        this.reportHeaders = reportHeaders;
    }

    /**
     * @return the reportDatas
     */
    public ArrayList<ArrayList<Object>> getReportDatas() {
        return reportDatas;
    }

    /**
     * @param reportDatas the reportDatas to set
     */
    public void setReportDatas(ArrayList<ArrayList<Object>> reportDatas) {
        this.reportDatas = reportDatas;
    }

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
    

}