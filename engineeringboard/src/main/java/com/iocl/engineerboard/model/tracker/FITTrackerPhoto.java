package com.iocl.dhruva2api.model.tracker;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

/**
 * FITTrackerPhoto
 */
@Entity
@Table(name = "FIT_TRACKER_PHOTO")
public class FITTrackerPhoto {

  @EmbeddedId
  private FITTrackerPK fitTrackerPK;

  @Column(name = "PHOTO")
  private byte[] photo;

  @Column(name = "UPDATED_ON")
  @Temporal(TemporalType.TIMESTAMP)
  @UpdateTimestamp
  private Date updatedOn;

  @Column(name = "UPDATED_BY")
  private String updateddBy;

  /**
   * 
   */

  public FITTrackerPhoto() {
  }

  /**
   * @param fitTrackerPK
   * @param photo
   * @param updatedOn
   * @param updateddBy
   */

  public FITTrackerPhoto(FITTrackerPK fitTrackerPK, byte[] photo, Date updatedOn, String updateddBy) {
    this.fitTrackerPK = fitTrackerPK;
    this.photo = photo;
    this.updatedOn = updatedOn;
    this.updateddBy = updateddBy;
  }

  /**
   * @return the fitTrackerPK
   */
  public FITTrackerPK getFitTrackerPK() {
    return fitTrackerPK;
  }

  /**
   * @param fitTrackerPK the fitTrackerPK to set
   */
  public void setFitTrackerPK(FITTrackerPK fitTrackerPK) {
    this.fitTrackerPK = fitTrackerPK;
  }

  /**
   * @return the photo
   */
  public byte[] getPhoto() {
    return photo;
  }

  /**
   * @param photo the photo to set
   */
  public void setPhoto(byte[] photo) {
    this.photo = photo;
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
   * @return the updateddBy
   */
  public String getUpdateddBy() {
    return updateddBy;
  }

  /**
   * @param updateddBy the updateddBy to set
   */
  public void setUpdateddBy(String updateddBy) {
    this.updateddBy = updateddBy;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#hashCode()
   */

  @Override
  public int hashCode() {
    return Objects.hash(fitTrackerPK);
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
    if (!(obj instanceof FITTrackerPhoto))
      return false;
    FITTrackerPhoto other = (FITTrackerPhoto) obj;
    return Objects.equals(fitTrackerPK, other.fitTrackerPK);
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */

  @Override
  public String toString() {
    return "FITTrackerPhoto [fitTrackerPK=" + fitTrackerPK + ", photo=" + Arrays.toString(photo) + ", updatedOn="
        + updatedOn + ", updateddBy=" + updateddBy + "]";
  }

}