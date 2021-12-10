package com.iocl.dhruva2api.model.vendor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VendorMaster
 */
@Entity
@Table(name = "VW_BTS_VENDOR_MASTER")
public class VendorMaster {

    @Id
    @Column(name = "VENDCODE")
    private String vendorCode;

    @Column(name = "VENDNAME")
    private String vendorName;

    @Column(name = "ADD_LN_1")
    private String addressLine1;

    @Column(name = "ADD_LN_2")
    private String addressLine2;

    @Column(name = "ADD_LN_3")
    private String addressLine3;

    @Column(name = "CITY")
    private String city;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PANCARD")
    private String pancard;

    /**
     * 
     */

    public VendorMaster() {
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
     * @return the vendorName
     */
    public String getVendorName() {
        return vendorName;
    }

    /**
     * @param vendorName the vendorName to set
     */
    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    /**
     * @return the addressLine1
     */
    public String getAddressLine1() {
        return addressLine1 != null ? addressLine1 + ", " : "";
    }

    /**
     * @param addressLine1 the addressLine1 to set
     */
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    /**
     * @return the addressLine2
     */
    public String getAddressLine2() {
        return addressLine2 != null ? addressLine2 + ", " : "";
    }

    /**
     * @param addressLine2 the addressLine2 to set
     */
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    /**
     * @return the addressLine3
     */
    public String getAddressLine3() {
        return addressLine3 != null ? addressLine3 + ", " : "";
    }

    /**
     * @param addressLine3 the addressLine3 to set
     */
    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the pancard
     */
    public String getPancard() {
        return pancard;
    }

    /**
     * @param pancard the pancard to set
     */
    public void setPancard(String pancard) {
        this.pancard = pancard;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "VendorMaster [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", addressLine3="
                + addressLine3 + ", city=" + city + ", email=" + email + ", pancard=" + pancard + ", vendorCode="
                + vendorCode + ", vendorName=" + vendorName + "]";
    }

}