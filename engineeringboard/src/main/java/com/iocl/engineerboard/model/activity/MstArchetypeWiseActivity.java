package com.iocl.dhruva2api.model.activity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * MstArchetypeWiseActivity
 */
@Entity(name="MST_ACTIVITY_ARCH")
public class MstArchetypeWiseActivity {

    @Id
    @Column(name="SR_NO")
    private int srNo;
    
    @Column(name="ACTIVITY_NO")
    private int activityNo;

    @Column(name="ARCHETYPE")
    private String archetypeCode;

    /**
     * @return the activityNo
     */
    public int getActivityNo() {
        return activityNo;
    }

    /**
     * @param activityNo the activityNo to set
     */
    public void setActivityNo(int activityNo) {
        this.activityNo = activityNo;
    }

    /**
     * @return the archetypeCode
     */
    public String getArchetypeCode() {
        return archetypeCode;
    }

    /**
     * @param archetypeCode the archetypeCode to set
     */
    public void setArchetypeCode(String archetypeCode) {
        this.archetypeCode = archetypeCode;
    }

	public int getSrNo() {
		return srNo;
	}

	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
    
    

   
}