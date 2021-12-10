package com.iocl.dhruva2api.model.menu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * LeaderboardMenuTabs
 */
@Entity
@Table(name = "DHRUVA_LEADERBOARD_MENUS")
public class LeaderboardMenuTabs {

    @Id
    @Column(name = "SR_NO")
    private long srNo;

    @Column(name = "LEADERBOARD_NAME")
    private String leaderboardName;

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

    public LeaderboardMenuTabs() {

    }

    public long getSrNo() {
        return srNo;
    }

    public void setSrNo(long srNo) {
        this.srNo = srNo;
    }

    public String getLeaderboardName() {
        return leaderboardName;
    }

    public void setLeaderboardName(String leaderboardName) {
        this.leaderboardName = leaderboardName;
    }

    public String getRoutePath() {
        return routePath;
    }

    public void setRoutePath(String routePath) {
        this.routePath = routePath;
    }

    public long getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(long accessCount) {
        this.accessCount = accessCount;
    }

    public short getFoAccess() {
        return foAccess;
    }

    public void setFoAccess(short foAccess) {
        this.foAccess = foAccess;
    }

    public short getSoAccess() {
        return soAccess;
    }

    public void setSoAccess(short soAccess) {
        this.soAccess = soAccess;
    }

    public short getDoAccess() {
        return doAccess;
    }

    public void setDoAccess(short doAccess) {
        this.doAccess = doAccess;
    }

    public short getRoAccess() {
        return roAccess;
    }

    public void setRoAccess(short roAccess) {
        this.roAccess = roAccess;
    }

    public short getHoAccess() {
        return hoAccess;
    }

    public void setHoAccess(short hoAccess) {
        this.hoAccess = hoAccess;
    }

    public short getAdminAccess() {
        return adminAccess;
    }

    public void setAdminAccess(short adminAccess) {
        this.adminAccess = adminAccess;
    }

    public short getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(short activeFlag) {
        this.activeFlag = activeFlag;
    }

    public short getNewFlag() {
        return newFlag;
    }

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
        result = prime * result + ((leaderboardName == null) ? 0 : leaderboardName.hashCode());
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
        LeaderboardMenuTabs other = (LeaderboardMenuTabs) obj;
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
        if (leaderboardName == null) {
            if (other.leaderboardName != null)
                return false;
        } else if (!leaderboardName.equals(other.leaderboardName))
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
        return "LeaderboardMenuTabs [accessCount=" + accessCount + ", activeFlag=" + activeFlag + ", adminAccess="
                + adminAccess + ", doAccess=" + doAccess + ", foAccess=" + foAccess + ", hoAccess=" + hoAccess
                + ", leaderboardName=" + leaderboardName + ", newFlag=" + newFlag + ", roAccess=" + roAccess
                + ", routePath=" + routePath + ", soAccess=" + soAccess + ", srNo=" + srNo + "]";
    }

}