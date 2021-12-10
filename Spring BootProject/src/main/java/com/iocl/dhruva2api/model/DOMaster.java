package com.iocl.dhruva2api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * DOMaster
 */
@Entity
@Table(name = "VW_DO")
public class DOMaster {

    @Id
    @Column(name = "SALESOFF")
    private String salesoff;

    @Column(name = "SALESOFF_NAME")
    private String salesOffName;

    @Column(name = "SALESORG", updatable = false, insertable = false)
    private String salesOrg;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "SALESORG", nullable = false)
    private SOMaster salesOrgMaster;

//    @OneToMany(mappedBy = "salesOffMaster")
    @OneToMany
    @JoinColumn(name = "SALESOFF",nullable = false,updatable = false)
    private List<SAMaster> salesAreas;

    public DOMaster() {

    }

    public DOMaster(String salesoff, String salesOffName) {
		super();
		this.salesoff = salesoff;
		this.salesOffName = salesOffName;
	}

	/**
     * @return the salesoff
     */
    public String getSalesoff() {
        return salesoff;
    }

    /**
     * @param salesoff the salesoff to set
     */
    public void setSalesoff(String salesoff) {
        this.salesoff = salesoff;
    }

    /**
     * @return the salesOffName
     */
    public String getSalesOffName() {
        return salesOffName;
    }

    /**
     * @param salesOffName the salesOffName to set
     */
    public void setSalesOffName(String salesOffName) {
        this.salesOffName = salesOffName;
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
     * @return the salesOrgMaster
     */
    public SOMaster getSalesOrgMaster() {
        return salesOrgMaster;
    }

    /**
     * @param salesOrgMaster the salesOrgMaster to set
     */
    public void setSalesOrgMaster(SOMaster salesOrgMaster) {
        this.salesOrgMaster = salesOrgMaster;
    }

    /**
     * @return the salesAreas
     */
    public List<SAMaster> getSalesAreas() {
        return salesAreas;
    }

    /**
     * @param salesAreas the salesAreas to set
     */
    public void setSalesAreas(List<SAMaster> salesAreas) {
        this.salesAreas = salesAreas;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((salesAreas == null) ? 0 : salesAreas.hashCode());
		result = prime * result + ((salesOffName == null) ? 0 : salesOffName.hashCode());
		result = prime * result + ((salesOrg == null) ? 0 : salesOrg.hashCode());
		result = prime * result + ((salesOrgMaster == null) ? 0 : salesOrgMaster.hashCode());
		result = prime * result + ((salesoff == null) ? 0 : salesoff.hashCode());
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
		DOMaster other = (DOMaster) obj;
		if (salesAreas == null) {
			if (other.salesAreas != null)
				return false;
		} else if (!salesAreas.equals(other.salesAreas))
			return false;
		if (salesOffName == null) {
			if (other.salesOffName != null)
				return false;
		} else if (!salesOffName.equals(other.salesOffName))
			return false;
		if (salesOrg == null) {
			if (other.salesOrg != null)
				return false;
		} else if (!salesOrg.equals(other.salesOrg))
			return false;
		if (salesOrgMaster == null) {
			if (other.salesOrgMaster != null)
				return false;
		} else if (!salesOrgMaster.equals(other.salesOrgMaster))
			return false;
		if (salesoff == null) {
			if (other.salesoff != null)
				return false;
		} else if (!salesoff.equals(other.salesoff))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DOMaster [salesoff=" + salesoff + ", salesOffName=" + salesOffName + ", salesOrg=" + salesOrg
				+ ", salesOrgMaster=" + salesOrgMaster + ", salesAreas=" + salesAreas + "]";
	}

}