package com.iocl.dhruva2api.model.vendor;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

/**
 * VendorAdminInputData
 */
public class VendorAdminInputData {

    private String vendorCode;
    private String vendorName;
    private String vendorAddress;
    private String vendorWorkOrder;
    private String vendorValidFrom;
    private String vendorValidTo;
    private String vendorAdminName;
    private String vendorAdminEmail;
    private String vendorAdminCell;

    /**
     * 
     */

    public VendorAdminInputData() {
    }

    /**
     * @param vendorCode
     * @param vendorName
     * @param vendorAddress
     * @param vendorWorkOrder
     * @param vendorValidFrom
     * @param vendorValidTo
     * @param vendorAdminName
     * @param vendorAdminEmail
     * @param vendorAdminCell
     */

    public VendorAdminInputData(String vendorCode, String vendorName, String vendorAddress, String vendorWorkOrder,
            String vendorValidFrom, String vendorValidTo, String vendorAdminName, String vendorAdminEmail,
            String vendorAdminCell) {
        this.vendorCode = Jsoup.clean(vendorCode, Whitelist.none());
        this.vendorName = Jsoup.clean(vendorName, Whitelist.none());
        this.vendorAddress = Jsoup.clean(vendorAddress, Whitelist.none());
        this.vendorWorkOrder = Jsoup.clean(vendorWorkOrder, Whitelist.none());
        this.vendorValidFrom = vendorValidFrom;
        this.vendorValidTo = vendorValidTo;
        this.vendorAdminName = Jsoup.clean(vendorAdminName, Whitelist.none());
        this.vendorAdminEmail = Jsoup.clean(vendorAdminEmail, Whitelist.none());
        this.vendorAdminCell = Jsoup.clean(vendorAdminCell, Whitelist.none());
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
     * @return the vendorName
     */
    public String getVendorName() {
        return vendorName;
    }

    /**
     * @param vendorName the vendorName to set
     */
    public void setVendorName(String vendorName) {
        this.vendorName = Jsoup.clean(vendorName, Whitelist.none());
    }

    /**
     * @return the vendorAddress
     */
    public String getVendorAddress() {
        return vendorAddress;
    }

    /**
     * @param vendorAddress the vendorAddress to set
     */
    public void setVendorAddress(String vendorAddress) {
        this.vendorAddress = Jsoup.clean(vendorAddress, Whitelist.none());
    }

    /**
     * @return the vendorWorkOrder
     */
    public String getVendorWorkOrder() {
        return vendorWorkOrder;
    }

    /**
     * @param vendorWorkOrder the vendorWorkOrder to set
     */
    public void setVendorWorkOrder(String vendorWorkOrder) {
        this.vendorWorkOrder = Jsoup.clean(vendorWorkOrder, Whitelist.none());
    }

    /**
     * @return the vendorValidFrom
     */
    public String getVendorValidFrom() {
        return vendorValidFrom;
    }

    /**
     * @param vendorValidFrom the vendorValidFrom to set
     */
    public void setVendorValidFrom(String vendorValidFrom) {
        this.vendorValidFrom = vendorValidFrom;
    }

    /**
     * @return the vendorValidTo
     */
    public String getVendorValidTo() {
        return vendorValidTo;
    }

    /**
     * @param vendorValidTo the vendorValidTo to set
     */
    public void setVendorValidTo(String vendorValidTo) {
        this.vendorValidTo = vendorValidTo;
    }

    /**
     * @return the vendorAdminName
     */
    public String getVendorAdminName() {
        return vendorAdminName;
    }

    /**
     * @param vendorAdminName the vendorAdminName to set
     */
    public void setVendorAdminName(String vendorAdminName) {
        this.vendorAdminName = Jsoup.clean(vendorAdminName, Whitelist.none());
    }

    /**
     * @return the vendorAdminEmail
     */
    public String getVendorAdminEmail() {
        return vendorAdminEmail;
    }

    /**
     * @param vendorAdminEmail the vendorAdminEmail to set
     */
    public void setVendorAdminEmail(String vendorAdminEmail) {
        this.vendorAdminEmail = Jsoup.clean(vendorAdminEmail, Whitelist.none());
    }

    /**
     * @return the vendorAdminCell
     */
    public String getVendorAdminCell() {
        return vendorAdminCell;
    }

    /**
     * @param vendorAdminCell the vendorAdminCell to set
     */
    public void setVendorAdminCell(String vendorAdminCell) {
        this.vendorAdminCell = Jsoup.clean(vendorAdminCell, Whitelist.none());
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "VendorAdminInputData [vendorAddress=" + vendorAddress + ", vendorAdminCell=" + vendorAdminCell
                + ", vendorAdminEmail=" + vendorAdminEmail + ", vendorAdminName=" + vendorAdminName + ", vendorCode="
                + vendorCode + ", vendorName=" + vendorName + ", vendorValidFrom=" + vendorValidFrom
                + ", vendorValidTo=" + vendorValidTo + ", vendorWorkOrder=" + vendorWorkOrder + "]";
    }

}