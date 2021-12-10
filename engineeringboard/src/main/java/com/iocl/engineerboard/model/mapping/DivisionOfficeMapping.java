package com.iocl.dhruva2api.model.mapping;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

/**
 * DivisionOfficeMapping
 */
@Entity
@Table(name = "SO_MANAGER_DO_MAPPING")
public class DivisionOfficeMapping {

  @Id
  @Column(name = "SALESOFF")
  private int salesOff;

  @Column(name = "MANAGER_EMP_CODE")
  private int stateManager;

  @Column(name = "UPDATED_BY")
  private String updatedBy;

  @Column(name = "UPDATED_ON")
  @Temporal(TemporalType.TIMESTAMP)
  @UpdateTimestamp
  private Date updatedOn;

  /**
   * 
   */

  public DivisionOfficeMapping() {
  }

  /**
   * @return the salesOff
   */
  public int getSalesOff() {
    return salesOff;
  }

  /**
   * @param salesOff the salesOff to set
   */
  public void setSalesOff(int salesOff) {
    this.salesOff = salesOff;
  }

  /**
   * @return the stateManager
   */
  public int getStateManager() {
    return stateManager;
  }

  /**
   * @param stateManager the stateManager to set
   */
  public void setStateManager(int stateManager) {
    this.stateManager = stateManager;
  }

  /**
   * @return the updatedBy
   */
  public String getUpdatedBy() {
    return updatedBy;
  }

  /**
   * @param updatedBy the updatedBy to set
   */
  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
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

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#hashCode()
   */

  @Override
  public int hashCode() {
    return Objects.hash(salesOff);
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof DivisionOfficeMapping))
      return false;
    DivisionOfficeMapping other = (DivisionOfficeMapping) obj;
    return salesOff == other.salesOff;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */

  @Override
  public String toString() {
    return "DivisionOfficeMapping [salesOff=" + salesOff + ", stateManager=" + stateManager + ", updatedBy=" + updatedBy
        + ", updatedOn=" + updatedOn + "]";
  }

}