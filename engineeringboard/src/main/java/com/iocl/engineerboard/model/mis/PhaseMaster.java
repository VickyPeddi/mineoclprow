package com.iocl.dhruva2api.model.mis;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PhaseMaster
 */
@Entity
@Table(name = "MST_DHRUVA_PHASE")
public class PhaseMaster {

    @Id
    @Column(name = "PHASE")
    private String phase;

    @Column(name = "PHASE_NAME")
    private String phaseName;

    public PhaseMaster() {

    }

    /**
     * @return the phase
     */
    public String getPhase() {
        return phase;
    }

    /**
     * @param phase the phase to set
     */
    public void setPhase(String phase) {
        this.phase = phase;
    }

    /**
     * @return the phaseName
     */
    public String getPhaseName() {
        return phaseName;
    }

    /**
     * @param phaseName the phaseName to set
     */
    public void setPhaseName(String phaseName) {
        this.phaseName = phaseName;
    }

    @Override
    public String toString() {
        return "PhaseMaster [phase=" + phase + ", phaseName=" + phaseName + "]";
    }
}