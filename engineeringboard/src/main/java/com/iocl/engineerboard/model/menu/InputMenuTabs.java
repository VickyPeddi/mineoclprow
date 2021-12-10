package com.iocl.dhruva2api.model.menu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * InputMenuTabs
 */
@Entity
@Table(name = "DHRUVA_INPUT_MENUS")
public class InputMenuTabs {

    @Id
    @Column(name = "SR_NO")
    private long srNo;

    @Column(name = "INPUT_NAME")
    private String inputName;

    @Column(name = "ROUTE_PATH")
    private String routePath;

    @Column(name = "ACCESS_COUNT")
    private long accessCount;

    @JsonIgnore
    @Column(name = "FO_ACCESS")
    private short foAccess;

    @JsonIgnore
    @Column(name = "SO_ACCESS")
    private short soAccess;

    @JsonIgnore
    @Column(name = "DO_ACCESS")
    private short doAccess;

    @JsonIgnore
    @Column(name = "RO_ACCESS")
    private short roAccess;

    @JsonIgnore
    @Column(name = "HO_ACCESS")
    private short hoAccess;

    @JsonIgnore
    @Column(name = "ADMIN_ACCESS")
    private short adminAccess;

    @JsonIgnore
    @Column(name = "ACTIVE_FLAG")
    private short activeFlag;

    @Column(name = "NEW_FLAG")
    private short newFlag;

    public InputMenuTabs() {

    }

    /**
     * @return the srNo
     */
    public long getSrNo() {
        return srNo;
    }

    /**
     * @param srNo the srNo to set
     */
    public void setSrNo(long srNo) {
        this.srNo = srNo;
    }

    /**
     * @return the inputName
     */
    public String getInputName() {
        return inputName;
    }

    /**
     * @param inputName the inputName to set
     */
    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    /**
     * @return the routePath
     */
    public String getRoutePath() {
        return routePath;
    }

    /**
     * @param routePath the routePath to set
     */
    public void setRoutePath(String routePath) {
        this.routePath = routePath;
    }

    /**
     * @return the accessCount
     */
    public long getAccessCount() {
        return accessCount;
    }

    /**
     * @param accessCount the accessCount to set
     */
    public void setAccessCount(long accessCount) {
        this.accessCount = accessCount;
    }

    /**
     * @return the foAccess
     */
    public short getFoAccess() {
        return foAccess;
    }

    /**
     * @param foAccess the foAccess to set
     */
    public void setFoAccess(short foAccess) {
        this.foAccess = foAccess;
    }

    /**
     * @return the soAccess
     */
    public short getSoAccess() {
        return soAccess;
    }

    /**
     * @param soAccess the soAccess to set
     */
    public void setSoAccess(short soAccess) {
        this.soAccess = soAccess;
    }

    /**
     * @return the doAccess
     */
    public short getDoAccess() {
        return doAccess;
    }

    /**
     * @param doAccess the doAccess to set
     */
    public void setDoAccess(short doAccess) {
        this.doAccess = doAccess;
    }

    /**
     * @return the roAccess
     */
    public short getRoAccess() {
        return roAccess;
    }

    /**
     * @param roAccess the roAccess to set
     */
    public void setRoAccess(short roAccess) {
        this.roAccess = roAccess;
    }

    /**
     * @return the hoAccess
     */
    public short getHoAccess() {
        return hoAccess;
    }

    /**
     * @param hoAccess the hoAccess to set
     */
    public void setHoAccess(short hoAccess) {
        this.hoAccess = hoAccess;
    }

    /**
     * @return the adminAccess
     */
    public short getAdminAccess() {
        return adminAccess;
    }

    /**
     * @param adminAccess the adminAccess to set
     */
    public void setAdminAccess(short adminAccess) {
        this.adminAccess = adminAccess;
    }

    /**
     * @return the activeFlag
     */
    public short getActiveFlag() {
        return activeFlag;
    }

    /**
     * @param activeFlag the activeFlag to set
     */
    public void setActiveFlag(short activeFlag) {
        this.activeFlag = activeFlag;
    }

    /**
     * @return the newFlag
     */
    public short getNewFlag() {
        return newFlag;
    }

    /**
     * @param newFlag the newFlag to set
     */
    public void setNewFlag(short newFlag) {
        this.newFlag = newFlag;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (accessCount ^ (accessCount >>> 32));
        result = prime * result + activeFlag;
        result = prime * result + adminAccess;
        result = prime * result + doAccess;
        result = prime * result + foAccess;
        result = prime * result + hoAccess;
        result = prime * result + ((inputName == null) ? 0 : inputName.hashCode());
        result = prime * result + newFlag;
        result = prime * result + roAccess;
        result = prime * result + ((routePath == null) ? 0 : routePath.hashCode());
        result = prime * result + soAccess;
        result = prime * result + (int) (srNo ^ (srNo >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InputMenuTabs other = (InputMenuTabs) obj;
        if (accessCount != other.accessCount)
            return false;
        if (activeFlag != other.activeFlag)
            return false;
        if (adminAccess != other.adminAccess)
            return false;
        if (doAccess != other.doAccess)
            return false;
        if (foAccess != other.foAccess)
            return false;
        if (hoAccess != other.hoAccess)
            return false;
        if (inputName == null) {
            if (other.inputName != null)
                return false;
        } else if (!inputName.equals(other.inputName))
            return false;
        if (newFlag != other.newFlag)
            return false;
        if (roAccess != other.roAccess)
            return false;
        if (routePath == null) {
            if (other.routePath != null)
                return false;
        } else if (!routePath.equals(other.routePath))
            return false;
        if (soAccess != other.soAccess)
            return false;
        if (srNo != other.srNo)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "InputMenuTabs [accessCount=" + accessCount + ", activeFlag=" + activeFlag + ", adminAccess="
                + adminAccess + ", doAccess=" + doAccess + ", foAccess=" + foAccess + ", hoAccess=" + hoAccess
                + ", inputName=" + inputName + ", newFlag=" + newFlag + ", roAccess=" + roAccess + ", routePath="
                + routePath + ", soAccess=" + soAccess + ", srNo=" + srNo + "]";
    }

}