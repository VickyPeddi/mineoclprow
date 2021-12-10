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
 * SalesAreaMapping
 */
@Entity
@Table(name = "DO_MANAGER_SA_MAPPING")
public class SalesAreaMapping {

  @Id
  @Column(name = "SALESAREA_CODE")
  private String salesArea;

  @Column(name = "MANAGER_EMP_CODE")
  private int divisionManager;

  @Column(name = "UPDATED_BY")
  private String updatedBy;

  @Column(name = "UPDATED_ON")
  @Temporal(TemporalType.TIMESTAMP)
  @UpdateTimestamp
  private Date updatedOn;

  /**
   * 
   */

  public SalesAreaMapping() {
  }

  /**
   * @return the salesArea
   */
  public String getSalesArea() {
    return salesArea;
  }

  /**
   * @param salesArea the salesArea to set
   */
  public void setSalesArea(String salesArea) {
    this.salesArea = salesArea;
  }

  /**
   * @return the divisionManager
   */
  public int getDivisionManager() {
    return divisionManager;
  }

  /**
   * @param divisionManager the divisionManager to set
   */
  public void setDivisionManager(int divisionManager) {
    this.divisionManager = divisionManager;
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
    return Objects.hash(salesArea);
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
    if (!(obj instanceof SalesAreaMapping))
      return false;
    SalesAreaMapping other = (SalesAreaMapping) obj;
    return Objects.equals(salesArea, other.salesArea);
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */

  @Override
  public String toString() {
    return "SalesAreaMapping [divisionManager=" + divisionManager + ", salesArea=" + salesArea + ", updatedBy="
        + updatedBy + ", updatedOn=" + updatedOn + "]";
  }

}