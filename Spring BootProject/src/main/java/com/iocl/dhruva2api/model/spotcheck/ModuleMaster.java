package com.iocl.dhruva2api.model.spotcheck;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * ModuleMaster
 */
@Entity
@Table(name = "SPOT_MST_MODULE")
public class ModuleMaster {

    @Id
    @Column(name = "MODULE_NO")
    private int moduleNo;

    @Column(name = "MODULE_NAME")
    private String moduleName;

    @JsonIgnore
    @OneToOne(mappedBy = "moduleMaster", cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    private ArchetypeWiseModule archetypeWiseModule;

    @OneToMany(mappedBy = "master")
    private List<ModuleQuestionMaster> questionMasters;

    public ModuleMaster() {

    }

    /**
     * @return the moduleNo
     */
    public int getModuleNo() {
        return moduleNo;
    }

    /**
     * @param moduleNo the moduleNo to set
     */
    public void setModuleNo(int moduleNo) {
        this.moduleNo = moduleNo;
    }

    /**
     * @return the moduleName
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * @param moduleName the moduleName to set
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    /**
     * @return the archetypeWiseModule
     */
    public ArchetypeWiseModule getArchetypeWiseModule() {
        return archetypeWiseModule;
    }

    /**
     * @param archetypeWiseModule the archetypeWiseModule to set
     */
    public void setArchetypeWiseModule(ArchetypeWiseModule archetypeWiseModule) {
        this.archetypeWiseModule = archetypeWiseModule;
    }

    /**
     * @return the questionMasters
     */
    public List<ModuleQuestionMaster> getQuestionMasters() {
        return questionMasters;
    }

    /**
     * @param questionMasters the questionMasters to set
     */
    public void setQuestionMasters(List<ModuleQuestionMaster> questionMasters) {
        this.questionMasters = questionMasters;
    }

}