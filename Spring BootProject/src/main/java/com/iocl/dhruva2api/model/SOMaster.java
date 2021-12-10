package com.iocl.dhruva2api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SODOMaster
 */
@Entity
@Table(name = "VW_SO")
public class SOMaster {

    @Id
    @Column(name = "SALESORG")
    private String salesOrg;

    @Column(name = "SALESORG_NAME")
    private String salesOrgName;

    @OneToMany(mappedBy = "salesOrgMaster")
    private List<DOMaster> salesOffs;

    public SOMaster() {

    }

    public SOMaster(String salesOrg, String salesOrgName) {
        super();
        this.salesOrg = salesOrg;
        this.salesOrgName = salesOrgName;
    }

    /**
     * @return the salesOrg
     */
    public String getSalesOrg() {
        return salesOrg;
    }

    /**
     * @param salesOrg the salesOrg to set
     */
    public void setSalesOrg(String salesOrg) {
        this.salesOrg = salesOrg;
    }

    /**
     * @return the salesOrgName
     */
    public String getSalesOrgName() {
        return salesOrgName;
    }

    /**
     * @param salesOrgName the salesOrgName to set
     */
    public void setSalesOrgName(String salesOrgName) {
        this.salesOrgName = salesOrgName;
    }

    /**
     * @return the salesOffs
     */
    public List<DOMaster> getSalesOffs() {
        return salesOffs;
    }

    /**
     * @param salesOffs the salesOffs to set
     */
    public void setSalesOffs(List<DOMaster> salesOffs) {
        this.salesOffs = salesOffs;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((salesOffs == null) ? 0 : salesOffs.hashCode());
        result = prime * result + ((salesOrg == null) ? 0 : salesOrg.hashCode());
        result = prime * result + ((salesOrgName == null) ? 0 : salesOrgName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SOMaster other = (SOMaster) obj;
        if (salesOffs == null) {
            if (other.salesOffs != null)
                return false;
        } else if (!salesOffs.equals(other.salesOffs))
            return false;
        if (salesOrg == null) {
            if (other.salesOrg != null)
                return false;
        } else if (!salesOrg.equals(other.salesOrg))
            return false;
        if (salesOrgName == null) {
            if (other.salesOrgName != null)
                return false;
        } else if (!salesOrgName.equals(other.salesOrgName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SOMaster [salesOffs=" + salesOffs + ", salesOrg=" + salesOrg + ", salesOrgName=" + salesOrgName + "]";
    }
}