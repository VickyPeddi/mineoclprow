package com.iocl.dhruva2api.model.audit;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="VW_COMPLETED_AUDIT")
public class AuditMaster {

	@Id
	@Column(name="AUDIT_ID")
    private long auditNo;
	
	@Column(name="RO_CODE")
    private int roCode;
	
	@Column(name="SALESOFF")
	private int doCode;
	
	@Column(name="SALESORG")
	private int soCode;
	
	@Column(name="SALESAREA")
	private String salesArea;
	
	@Column(name="CUST_NAME")
	private String roName;
	
	@Column(name="ACTUAL_AUDIT_DATE")
	@Temporal(TemporalType.TIMESTAMP)
    private Date actualAuditDate;
	
	@Column(name="SALESAREA_NAME")
	private String salesAreaName;
	
	@Column(name="SALESOFF_NAME")
	private String salesOffName;
	
	public int getSoCode() {
		return soCode;
	}

	public void setSoCode(int soCode) {
		this.soCode = soCode;
	}

	@Column(name="SO_NAME")
	private String soName;
	
	@Column(name="LOCATION")
	private String location;
		
	
  
	

	public int getDoCode() {
		return doCode;
	}

	public void setDoCode(int doCode) {
		this.doCode = doCode;
	}

	public String getSalesArea() {
		return salesArea;
	}

	public void setSalesArea(String salesArea) {
		this.salesArea = salesArea;
	}

	public AuditMaster() {
    }

    public AuditMaster(long auditNo, int roCode, Date actualAuditDate) {
        this.auditNo = auditNo;
        this.roCode = roCode;
        this.actualAuditDate = actualAuditDate;
    }

    public long getAuditNo() {
        return auditNo;
    }

    public void setAuditNo(long auditNo) {
        this.auditNo = auditNo;
    }

    public int getRoCode() {
        return roCode;
    }

    public void setRoCode(int roCode) {
        this.roCode = roCode;
    }

    public Date getActualAuditDate() {
        return actualAuditDate;
    }

    public void setActualAuditDate(Date actualAuditDate) {
        this.actualAuditDate = actualAuditDate;
    }

    
    
    public String getSalesAreaName() {
		return salesAreaName;
	}

	public void setSalesAreaName(String salesAreaName) {
		this.salesAreaName = salesAreaName;
	}

	public String getSalesOffName() {
		return salesOffName;
	}

	public void setSalesOffName(String salesOffName) {
		this.salesOffName = salesOffName;
	}

	public String getSoName() {
		return soName;
	}

	public void setSoName(String soName) {
		this.soName = soName;
	}

	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (int) (this.auditNo ^ (this.auditNo >>> 32));
        hash = 41 * hash + this.roCode;
        hash = 41 * hash + Objects.hashCode(this.actualAuditDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AuditMaster other = (AuditMaster) obj;
        if (this.auditNo != other.auditNo) {
            return false;
        }
        if (this.roCode != other.roCode) {
            return false;
        }
        if (!Objects.equals(this.actualAuditDate, other.actualAuditDate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AuditMaster{" + "auditNo=" + auditNo + ", roCode=" + roCode + ", actualAuditDate=" + actualAuditDate + '}';
    }

	public String getRoName() {
		return roName;
	}

	public void setRoName(String roName) {
		this.roName = roName;
	}
    
    
}
