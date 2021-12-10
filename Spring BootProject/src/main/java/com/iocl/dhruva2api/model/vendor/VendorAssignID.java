package com.iocl.dhruva2api.model.vendor;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VendorAssignID
 */
@Embeddable
public class VendorAssignID implements Serializable {

    private static final long serialVersionUID = 5286747507923671936L;

    @Column(name = "QRTR_ID")
    private String quarterId;

    @Column(name = "RO_CODE")
    private String roCode;

    @Column(name = "VENDOR_CODE")
    private String vendorCode;

    /**
     * 
     */

    public VendorAssignID() {
    }

    /**
     * @param quarterId
     * @param roCode
     * @param vendorCode
     */

    public VendorAssignID(String quarterId, String roCode, String vendorCode) {
        this.quarterId = quarterId;
        this.roCode = roCode;
        this.vendorCode = vendorCode;
    }

    /**
     * @return the quarterId
     */
    public String getQuarterId() {
        return quarterId;
    }

    /**
     * @param quarterId the quarterId to set
     */
    public void setQuarterId(String quarterId) {
        this.quarterId = quarterId;
    }

    /**
     * @return the roCode
     */
    public String getRoCode() {
        return roCode;
    }

    /**
     * @param roCode the roCode to set
     */
    public void setRoCode(String roCode) {
        this.roCode = roCode;
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
        this.vendorCode = vendorCode;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */

    @Override
    public int hashCode() {
        return Objects.hash(quarterId, roCode, vendorCode);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof VendorAssignID))
            return false;
        VendorAssignID other = (VendorAssignID) obj;
        return Objects.equals(quarterId, other.quarterId) && Objects.equals(roCode, other.roCode)
                && Objects.equals(vendorCode, other.vendorCode);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "VendorAssignID [quarterId=" + quarterId + ", roCode=" + roCode + ", vendorCode=" + vendorCode + "]";
    }

}