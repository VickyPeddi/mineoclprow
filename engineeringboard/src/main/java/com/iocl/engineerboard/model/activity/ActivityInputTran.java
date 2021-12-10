package com.iocl.dhruva2api.model.activity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;


/**
 * ActivityInputTran
 */
@Entity
@Table(name = "TRN_ACTIVITY_INPUT")
public class ActivityInputTran {

    @EmbeddedId
	private ActivityTranId embeddedkey;

    @Column(name = "VALUE")
    private String value;

    @Column(name = "USER_DETAILS")
    private String userDetails;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_ON")
    private Date updatedOn;

    public ActivityInputTran() {

    }

   

    
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return the userDetails
     */
    public String getUserDetails() {
        return userDetails;
    }

    /**
     * @param userDetails the userDetails to set
     */
    public void setUserDetails(String userDetails) {
        this.userDetails = userDetails;
    }

    /**
     * @return the updatedOn
     */
    public Date getUpdatedOn() {
        return updatedOn;
    }

    /**
     * @param updatedOn the updatedOn to set
     */
    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

	public ActivityTranId getEmbeddedkey() {
		return embeddedkey;
	}

	public void setEmbeddedkey(ActivityTranId embeddedkey) {
		this.embeddedkey = embeddedkey;
	}
    
    

}