package com.iocl.dhruva2api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SAMaster
 */
@Entity
@Table(name = "VW_SA")
public class SAMaster {

    @Id
    @Column(name = "SALESAREA")
    private String salesArea;

    @Column(name = "SALESAREA_NAME")
    private String salesAreaName;

    @Column(name = "SALESOFF", updatable = false, insertable = false)
    private String salesOff;

//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "SALESOFF", nullable = false)
//    private DOMaster salesOffMaster;

    public SAMaster() {

    }

    /**
     * @return the salesArea
     */
    public String getSalesArea() {
        return salesArea;
    }

    /**
     * @param salesArea the salesArea to set
     */
    public void setSalesArea(String salesArea) {
        this.salesArea = salesArea;
    }

    /**
     * @return the salesAreaName
     */
    public String getSalesAreaName() {
        return salesAreaName;
    }

    /**
     * @param salesAreaName the salesAreaName to set
     */
    public void setSalesAreaName(String salesAreaName) {
        this.salesAreaName = salesAreaName;
    }

    /**
     * @return the salesOff
     */
    public String getSalesOff() {
        return salesOff;
    }

    /**
     * @param salesOff the salesOff to set
     */
    public void setSalesOff(String salesOff) {
        this.salesOff = salesOff;
    }

//    /**
//     * @return the salesOffMaster
//     */
//    public DOMaster getSalesOffMaster() {
//        return salesOffMaster;	
//    }
//
//    /**
//     * @param salesOffMaster the salesOffMaster to set
//     */
//    public void setSalesOffMaster(DOMaster salesOffMaster) {
//        this.salesOffMaster = salesOffMaster;
//    }

}