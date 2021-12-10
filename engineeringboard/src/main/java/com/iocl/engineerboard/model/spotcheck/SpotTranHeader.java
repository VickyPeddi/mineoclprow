package com.iocl.dhruva2api.model.spotcheck;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

/**
 * SpotTranHeader
 */
@Entity
@Table(name = "SPOT_TRAN_HEADER")
public class SpotTranHeader {

    @Id
    @Column(name = "INSP_NO")
    private long inspNo;
   
    @Column(name = "RO_CODE")
    private int roCode;

    @Column(name = "USER_DETAILS")
    private String userDetails;

    @Column(name="USER_LEVEL")
    private String userLevel;
    
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_ON")
    private Date updatedOn;

    // @OneToMany(mappedBy = "header")
    // @OneToMany
    // @JoinColumns({ @JoinColumn(name = "INSP_NO", insertable = false, updatable =
    // false),
    // @JoinColumn(name = "MODULE_NO", insertable = false, updatable = false) })
    // private List<SpotTranAnswer> answers;

    public SpotTranHeader() {

    }

    /**
     * @return the inspNo
     */
    public long getInspNo() {
        return inspNo;
    }

    /**
     * @param inspNo the inspNo to set
     */
    public void setInspNo(long inspNo) {
        this.inspNo = inspNo;
    }

    /**
     * @return the roCode
     */
    public int getRoCode() {
        return roCode;
    }

    /**
     * @param roCode the roCode to set
     */
    public void setRoCode(int roCode) {
        this.roCode = roCode;
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

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

}