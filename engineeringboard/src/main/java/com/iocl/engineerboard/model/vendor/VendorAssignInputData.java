package com.iocl.dhruva2api.model.vendor;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

/**
 * VendorAssignInputData
 */
public class VendorAssignInputData {

    @JsonProperty("SAP Code")
    private String sapCode;

    @JsonProperty("Vendor Code")
    private String vendorCode;

    @JsonProperty("Audit type")
    private String auditType;

    @JsonProperty("Audit Quarter")
    private String auditQuarter;

    @JsonProperty("Start Date")
    private String startDate;

    @JsonProperty("End Date")
    private String endDate;

    /**
     * 
     */

    public VendorAssignInputData() {
    }

    /**
     * @param sapCode
     * @param vendorCode
     * @param auditType
     * @param auditQuarter
     * @param startDate
     * @param endDate
     */

    public VendorAssignInputData(String sapCode, String vendorCode, String auditType, String auditQuarter,
            String startDate, String endDate) {
        this.sapCode = sapCode;
        this.vendorCode = vendorCode;
        this.auditType = auditType;
        this.auditQuarter = auditQuarter;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * @return the sapCode
     */
    public String getSapCode() {
        return sapCode;
    }

    /**
     * @param sapCode the sapCode to set
     */
    public void setSapCode(String sapCode) {
        this.sapCode = Jsoup.clean(sapCode, Whitelist.none());
    }

    /**
     * @return the vendorCode
     */
    public String getVendorCode() {
        return vendorCode;
    }

    /**
     * @param vendorCode the vendorCode to set
     */
    public void setVendorCode(String vendorCode) {
        this.vendorCode = Jsoup.clean(vendorCode, Whitelist.none());
    }

    /**
     * @return the auditType
     */
    public String getAuditType() {
        return auditType;
    }

    /**
     * @param auditType the auditType to set
     */
    public void setAuditType(String auditType) {
        this.auditType = Jsoup.clean(auditType, Whitelist.none());
    }

    /**
     * @return the auditQuarter
     */
    public String getAuditQuarter() {
        return auditQuarter;
    }

    /**
     * @param auditQuarter the auditQuarter to set
     */
    public void setAuditQuarter(String auditQuarter) {
        this.auditQuarter = Jsoup.clean(auditQuarter, Whitelist.none());
    }

    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = Jsoup.clean(startDate, Whitelist.none());
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = Jsoup.clean(endDate, Whitelist.none());
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "VendorAssignInputData [auditQuarter=" + auditQuarter + ", auditType=" + auditType + ", endDate="
                + endDate + ", sapCode=" + sapCode + ", startDate=" + startDate + ", vendorCode=" + vendorCode + "]";
    }

}