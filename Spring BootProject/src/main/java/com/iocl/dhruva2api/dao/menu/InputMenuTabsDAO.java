package com.iocl.dhruva2api.dao.menu;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.menu.InputMenuTabs;

import org.springframework.data.repository.CrudRepository;

/**
 * InputMenuTabsDAO
 */
public interface InputMenuTabsDAO extends CrudRepository<InputMenuTabs, Long> {

    ArrayList<InputMenuTabs> findByFoAccessAndActiveFlag(short foAccess, short activeFlag);

    ArrayList<InputMenuTabs> findBySoAccessAndActiveFlag(short soAccess, short activeFlag);

    ArrayList<InputMenuTabs> findByDoAccessAndActiveFlag(short doAccess, short activeFlag);

    ArrayList<InputMenuTabs> findByRoAccessAndActiveFlag(short roAccess, short activeFlag);

    ArrayList<InputMenuTabs> findByHoAccessAndActiveFlag(short hoAccess, short activeFlag);

    ArrayList<InputMenuTabs> findByAdminAccessAndActiveFlag(short adminAccess, short activeFlag);
}