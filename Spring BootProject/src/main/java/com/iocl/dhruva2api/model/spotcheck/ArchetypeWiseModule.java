package com.iocl.dhruva2api.model.spotcheck;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SPOT_MST_MODULE_ARCH")
public class ArchetypeWiseModule implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "SR_NO")
    private int srNo;

    @Column(name = "MODULE")
    private int module;

    @Column(name = "ARCHETYPE_CODE")
    private String archetypeCode;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MODULE", nullable = false, insertable = false, updatable = false)
    private ModuleMaster moduleMaster;

    public ArchetypeWiseModule() {
    }

    public ArchetypeWiseModule(int srNo) {
        this.srNo = srNo;
    }

    public ArchetypeWiseModule(Short srNo, int module, String archetypeCode) {
        this.srNo = srNo;
        this.module = module;
        this.archetypeCode = archetypeCode;
    }

    public int getModule() {
        return module;
    }

    public void setModule(int module) {
        this.module = module;
    }

    public String getArchetypeCode() {
        return archetypeCode;
    }

    public void setArchetypeCode(String archetypeCode) {
        this.archetypeCode = archetypeCode;
    }

    public int getSrNo() {
        return srNo;
    }

    public void setSrNo(Short srNo) {
        this.srNo = srNo;
    }

    /**
     * @param srNo the srNo to set
     */
    public void setSrNo(int srNo) {
        this.srNo = srNo;
    }

    /**
     * @return the moduleMaster
     */
    public ModuleMaster getModuleMaster() {
        return moduleMaster;
    }

    /**
     * @param moduleMaster the moduleMaster to set
     */
    public void setModuleMaster(ModuleMaster moduleMaster) {
        this.moduleMaster = moduleMaster;
    }

    @Override
    public String toString() {
        return module + " " + archetypeCode + " " + moduleMaster;
    }

}