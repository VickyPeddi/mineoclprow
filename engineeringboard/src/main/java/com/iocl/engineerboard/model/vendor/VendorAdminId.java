package com.iocl.dhruva2api.model.vendor;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VendorAdminId
 */
@Embeddable
public class VendorAdminId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "VENDOR_CODE")
    private String vendorCode;

    @Column(name = "QRTR_ID")
    private String quarterId;

    /**
     * 
     */

    public VendorAdminId() {
    }

    /**
     * @param vendorCode
     * @param quarterId
     */

    public VendorAdminId(String vendorCode, String quarterId) {
        this.vendorCode = vendorCode;
        this.quarterId = quarterId;
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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */

    @Override
    public int hashCode() {
        return Objects.hash(quarterId, vendorCode);
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
        if (!(obj instanceof VendorAdminId))
            return false;
        VendorAdminId other = (VendorAdminId) obj;
        return Objects.equals(quarterId, other.quarterId) && Objects.equals(vendorCode, other.vendorCode);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "VendorAdminId [quarterId=" + quarterId + ", vendorCode=" + vendorCode + "]";
    }

}