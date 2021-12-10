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
 * ActivityFileTran
 */
@Entity
@Table(name = "TRN_ACTIVITY_DOC")
public class ActivityFileTran {

	@EmbeddedId
	private ActivityFileId embeddedKey;

    @Column(name = "DOC_NAME")
    private String docName;

    @Column(name = "USER_DETAILS")
    private String userDetails;

    @Column(name = "DATA")
    private byte[] data;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_ON")
    private Date updatedOn;
    
    public ActivityFileId getEmbeddedKey() {
		return embeddedKey;
	}

	public void setEmbeddedKey(ActivityFileId embeddedKey) {
		this.embeddedKey = embeddedKey;
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
     * @return the data
     */
    public byte[] getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(byte[] data) {
        this.data = data;
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

    /**
     * @return the docName
     */
    public String getDocName() {
        return docName;
    }

    /**
     * @param docName the docName to set
     */
    public void setDocName(String docName) {
        this.docName = docName;
    }
}