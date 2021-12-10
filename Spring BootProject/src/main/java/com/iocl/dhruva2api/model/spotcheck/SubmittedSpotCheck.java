package com.iocl.dhruva2api.model.spotcheck;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.iocl.dhruva2api.model.DhruvaCustomer;

@Entity
@Table(name = "VW_SPOT_TRAN_HEADER")
//In case RO is not there in master, but it is there in spot_tran_header, then system fails for fetching records. So we are giving view instead
//of spot_tran_header table
public class SubmittedSpotCheck {

	@Id
	@Column(name = "insp_no")
	private long inspNo;

	@Column(name = "RO_CODE")
	private int roCode;

	@Column(name = "UPDATED_ON")
	private Date inspDate;

	@Column(name = "user_details")
	private String userDetails;

	// Since it is joining to primary key of other table hence referenced column is
	// not required.
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "RO_CODE", insertable = false, updatable = false)
	private DhruvaCustomer retailOutlet;

	public long getInspNo() {
		return inspNo;
	}

	public void setInspNo(long inspNo) {
		this.inspNo = inspNo;
	}

	public int getRoCode() {
		return roCode;
	}

	public void setRoCode(int roCode) {
		this.roCode = roCode;
	}

	public Date getInspDate() {
		return inspDate;
	}

	public void setInspDate(Date inspDate) {
		this.inspDate = inspDate;
	}

	public String getUserDetails() {
		return userDetails.split("---")[1] + " [" + userDetails.split("---")[2] + "]";
	}

	public void setUserDetails(String userDetails) {
		this.userDetails = userDetails;
	}

	public DhruvaCustomer getRetailOutlet() {
		return retailOutlet;
	}

	public void setRetailOutlet(DhruvaCustomer retailOutlet) {
		this.retailOutlet = retailOutlet;
	}

}
