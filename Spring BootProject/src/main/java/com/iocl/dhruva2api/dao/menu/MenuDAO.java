package com.iocl.dhruva2api.dao.menu;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.menu.Menu;

import org.springframework.data.repository.CrudRepository;

/**
 * MenuDAO
 */
public interface MenuDAO extends CrudRepository<Menu, Long> {

  ArrayList<Menu> findAllByActiveFlagOrderByMenuId(short activeFlag);

  ArrayList<Menu> findByAdminAccessAndActiveFlagOrderByMenuId(short flag, short flag2);

  ArrayList<Menu> findByHoAccessAndActiveFlagOrderByMenuId(short flag, short flag2);

  ArrayList<Menu> findBySrhAccessAndActiveFlagOrderByMenuId(short flag, short flag2);
  
  ArrayList<Menu> findByDrsmAccessAndActiveFlagOrderByMenuId(short flag, short flag2);

  ArrayList<Menu> findByRoAccessAndActiveFlagOrderByMenuId(short flag, short flag2);

  ArrayList<Menu> findBySoAccessAndActiveFlagOrderByMenuId(short flag, short flag2);

  ArrayList<Menu> findByDoAccessAndActiveFlagOrderByMenuId(short flag, short flag2);

  ArrayList<Menu> findByFoAccessAndActiveFlagOrderByMenuId(short flag, short flag2);
}