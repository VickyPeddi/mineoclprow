package com.iocl.dhruva2api.model.menu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * AuditMenuTabs
 */
@Entity
@Table(name = "DHRUVA_AUDITOR_MENUS")
public class AuditMenuTabs {

    @Id
    @Column(name = "SR_NO")
    private long srNo;

    @Column(name = "MENU_NAME")
    private String menuName;

    @Column(name = "ROUTE_PATH")
    private String routePath;

    @Column(name = "ACCESS_COUNT")
    private long accessCount;

    @JsonIgnore
    @Column(name = "ACTIVE_FLAG")
    private short activeFlag;

    @Column(name = "NEW_FLAG")
    private short newFlag;

    /**
     * 
     */

    public AuditMenuTabs() {
    }

    /**
     * @param srNo
     * @param menuName
     * @param routePath
     * @param accessCount
     * @param activeFlag
     * @param newFlag
     */

    public AuditMenuTabs(long srNo, String menuName, String routePath, long accessCount, short activeFlag,
            short newFlag) {
        this.srNo = srNo;
        this.menuName = menuName;
        this.routePath = routePath;
        this.accessCount = accessCount;
        this.activeFlag = activeFlag;
        this.newFlag = newFlag;
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
     * @return the menuName
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * @param menuName the menuName to set
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "AuditMenuTabs [accessCount=" + accessCount + ", activeFlag=" + activeFlag + ", menuName=" + menuName
                + ", newFlag=" + newFlag + ", routePath=" + routePath + ", srNo=" + srNo + "]";
    }

}