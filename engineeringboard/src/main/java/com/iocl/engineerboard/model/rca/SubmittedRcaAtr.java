package com.iocl.dhruva2api.model.rca;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * SubmittedRcaAtr
 */
@Entity
@Table(name="VW_RCA_ATR_REPORT")
public class SubmittedRcaAtr {

    @EmbeddedId
    private RcaAtrId embeddedkey;
    
    @Column(name="VALUE")
	private String value;
	
	@Column(name="UPDATED_ON")
	private Date updatedOn;
	
	@Column(name="ATTRIBUTE_NAME")
    private String attributeName;

	
    /**
     * @return the embeddedkey
     */
    public RcaAtrId getEmbeddedkey() {
        return embeddedkey;
    }

    /**
     * @param embeddedkey the embeddedkey to set
     */
    public void setEmbeddedkey(RcaAtrId embeddedkey) {
        this.embeddedkey = embeddedkey;
    }

    /**
     * @return the value
     */
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
     * @return the attributeName
     */
    public String getAttributeName() {
        return attributeName;
    }

    /**
     * @param attributeName the attributeName to set
     */
    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }


}