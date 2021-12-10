package com.iocl.dhruva2api.model.vendor;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

/**
 * VendorAssignOptionData
 */
public class VendorAssignOptionData {

  private String vendorCode;
  private String auditType;
  private String auditYear;
  private String auditQuarter;
  private String startDate;
  private String endDate;
  private List<Integer> roList;

  /**
   * 
   */

  public VendorAssignOptionData() {
  }

  /**
   * @return the vendorCode
   */
  public String getVendorCode() {
    return vendorCode;
  }

  /**
   * @param vendorCode the vendorCode to set
   */
  public void setVendorCode(String vendorCode) {
    this.vendorCode = Jsoup.clean(vendorCode, Whitelist.none());
  }

  /**
   * @return the auditType
   */
  public String getAuditType() {
    return auditType;
  }

  /**
   * @param auditType the auditType to set
   */
  public void setAuditType(String auditType) {
    this.auditType = auditType;
  }

  /**
   * @return the auditYear
   */
  public String getAuditYear() {
    return auditYear;
  }

  /**
   * @param auditYear the auditYear to set
   */
  public void setAuditYear(String auditYear) {
    this.auditYear = auditYear;
  }

  /**
   * @return the auditQuarter
   */
  public String getAuditQuarter() {
    return auditQuarter;
  }

  /**
   * @param auditQuarter the auditQuarter to set
   */
  public void setAuditQuarter(String auditQuarter) {
    this.auditQuarter = auditQuarter;
  }

  /**
   * @return the startDate
   */
  public String getStartDate() {
    return startDate;
  }

  /**
   * @param startDate the startDate to set
   */
  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  /**
   * @return the endDate
   */
  public String getEndDate() {
    return endDate;
  }

  /**
   * @param endDate the endDate to set
   */
  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  /**
   * @return the roList
   */
  public List<Integer> getRoList() {
    return roList;
  }

  /**
   * @param roList the roList to set
   */
  public void setRoList(List<Integer> roList) {
    this.roList = roList;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */

  @Override
  public String toString() {
    return "VendorAssignOptionData [auditQuarter=" + auditQuarter + ", auditType=" + auditType + ", auditYear="
        + auditYear + ", endDate=" + endDate + ", roList=" + roList + ", startDate=" + startDate + ", vendorCode="
        + vendorCode + "]";
  }

}