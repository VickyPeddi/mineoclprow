package com.iocl.dhruva2api.model.vendor;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VendorManage
 */
@Entity
@Table(name = "VW_AUD_VENDORS")
public class VendorManage {

    @Id
    @Column(name = "VENDOR_CODE")
    private String vendorCode;

    @Column(name = "VENDOR_ROLE")
    private String vendorRole;

    @Column(name = "VENDOR_NAME")
    private String vendorName;

    @Column(name = "EMAIL")
    private String vendorEmail;

    @Column(name = "MOBILE")
    private long vendorMobile;

    @Column(name = "EMP_STATUS")
    private String empStaus;

    @Column(name = "STATUS")
    private String status;

    /**
     * 
     */

    public VendorManage() {
    }

    /**
     * @param vendorCode
     * @param vendorRole
     * @param vendorName
     * @param vendorEmail
     * @param vendorMobile
     * @param empStaus
     * @param status
     */

    public VendorManage(String vendorCode, String vendorRole, String vendorName, String vendorEmail, long vendorMobile,
            String empStaus, String status) {
        this.vendorCode = vendorCode;
        this.vendorRole = vendorRole;
        this.vendorName = vendorName;
        this.vendorEmail = vendorEmail;
        this.vendorMobile = vendorMobile;
        this.empStaus = empStaus;
        this.status = status;
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
     * @return the vendorRole
     */
    public String getVendorRole() {
        return vendorRole;
    }

    /**
     * @param vendorRole the vendorRole to set
     */
    public void setVendorRole(String vendorRole) {
        this.vendorRole = vendorRole;
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
     * @return the vendorEmail
     */
    public String getVendorEmail() {
        return vendorEmail;
    }

    /**
     * @param vendorEmail the vendorEmail to set
     */
    public void setVendorEmail(String vendorEmail) {
        this.vendorEmail = vendorEmail;
    }

    /**
     * @return the vendorMobile
     */
    public long getVendorMobile() {
        return vendorMobile;
    }

    /**
     * @param vendorMobile the vendorMobile to set
     */
    public void setVendorMobile(long vendorMobile) {
        this.vendorMobile = vendorMobile;
    }

    /**
     * @return the empStaus
     */
    public String getEmpStaus() {
        return empStaus;
    }

    /**
     * @param empStaus the empStaus to set
     */
    public void setEmpStaus(String empStaus) {
        this.empStaus = empStaus;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */

    @Override
    public int hashCode() {
        return Objects.hash(vendorCode);
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
        if (!(obj instanceof VendorManage))
            return false;
        VendorManage other = (VendorManage) obj;
        return Objects.equals(vendorCode, other.vendorCode);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "VendorManage [empStaus=" + empStaus + ", status=" + status + ", vendorCode=" + vendorCode
                + ", vendorEmail=" + vendorEmail + ", vendorMobile=" + vendorMobile + ", vendorName=" + vendorName
                + ", vendorRole=" + vendorRole + "]";
    }

}