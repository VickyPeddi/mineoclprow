package com.iocl.dhruva2api.dao.menu;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.menu.LeaderboardMenuTabs;

import org.springframework.data.repository.CrudRepository;

/**
 * LeaderboardMenuTabsDAO
 */
public interface LeaderboardMenuTabsDAO extends CrudRepository<LeaderboardMenuTabs, Long> {

    ArrayList<LeaderboardMenuTabs> findByFoAccessAndActiveFlag(short foAccess, short activeFlag);

    ArrayList<LeaderboardMenuTabs> findBySoAccessAndActiveFlag(short soAccess, short activeFlag);

    ArrayList<LeaderboardMenuTabs> findByDoAccessAndActiveFlag(short doAccess, short activeFlag);

    ArrayList<LeaderboardMenuTabs> findByRoAccessAndActiveFlag(short roAccess, short activeFlag);

    ArrayList<LeaderboardMenuTabs> findByHoAccessAndActiveFlag(short hoAccess, short activeFlag);

    ArrayList<LeaderboardMenuTabs> findByAdminAccessAndActiveFlag(short adminAccess, short activeFlag);
}