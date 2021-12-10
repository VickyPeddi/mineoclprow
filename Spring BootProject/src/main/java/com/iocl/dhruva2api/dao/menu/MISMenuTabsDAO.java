package com.iocl.dhruva2api.dao.menu;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.menu.MISMenuTabs;

import org.springframework.data.repository.CrudRepository;

/**
 * MISMenuTabsDAO
 */
public interface MISMenuTabsDAO extends CrudRepository<MISMenuTabs, Long> {

//    public ArrayList<MISMenuTabs> getMISMenuTabsByActiveFlagOrderByTabName(short activeFlag);

    ArrayList<MISMenuTabs> findByFoAccessAndActiveFlagOrderByTabName(short foAccess, short activeFlag);

    ArrayList<MISMenuTabs> findBySoAccessAndActiveFlagOrderByTabName(short soAccess, short activeFlag);

    ArrayList<MISMenuTabs> findByDoAccessAndActiveFlagOrderByTabName(short doAccess, short activeFlag);

    ArrayList<MISMenuTabs> findByRoAccessAndActiveFlagOrderByTabName(short roAccess, short activeFlag);

    ArrayList<MISMenuTabs> findByHoAccessAndActiveFlagOrderByTabName(short hoAccess, short activeFlag);

    ArrayList<MISMenuTabs> findByAdminAccessAndActiveFlagOrderByTabName(short adminAccess, short activeFlag);

}