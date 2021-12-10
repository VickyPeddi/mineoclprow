package com.iocl.dhruva2api.model.mis;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ArchetypeMaster
 */
@Entity
@Table(name = "MST_ARCHETYPE")
public class ArchetypeMaster {

    @Id
    @Column(name = "ARCHE_CODE")
    private int archetypeCode;

    @Column(name = "ARCHE_NAME")
    private String archetypeName;

    public ArchetypeMaster() {

    }

    /**
     * @return the archetypeCode
     */
    public int getArchetypeCode() {
        return archetypeCode;
    }

    /**
     * @param archetypeCode the archetypeCode to set
     */
    public void setArchetypeCode(int archetypeCode) {
        this.archetypeCode = archetypeCode;
    }

    /**
     * @return the archetypeName
     */
    public String getArchetypeName() {
        return archetypeName;
    }

    /**
     * @param archetypeName the archetypeName to set
     */
    public void setArchetypeName(String archetypeName) {
        this.archetypeName = archetypeName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + archetypeCode;
        result = prime * result + ((archetypeName == null) ? 0 : archetypeName.hashCode());
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
        ArchetypeMaster other = (ArchetypeMaster) obj;
        if (archetypeCode != other.archetypeCode)
            return false;
        if (archetypeName == null) {
            if (other.archetypeName != null)
                return false;
        } else if (!archetypeName.equals(other.archetypeName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ArchetypeMaster [archetypeCode=" + archetypeCode + ", archetypeName=" + archetypeName + "]";
    }
}