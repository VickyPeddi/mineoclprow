package com.iocl.dhruva2api.dao.menu;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.menu.SubMenu;

import org.springframework.data.repository.CrudRepository;

/**
 * SubMenuDAO
 */
public interface SubMenuDAO extends CrudRepository<SubMenu, Long> {

  ArrayList<SubMenu> findByMenuIdAndAdminAccessAndActiveFlagOrderBySubMenuName(long menuId, short flag, short flag2);

  ArrayList<SubMenu> findByMenuIdAndHoAccessAndActiveFlagOrderBySubMenuName(long menuId, short flag, short flag2);

  ArrayList<SubMenu> findByMenuIdAndSrhAccessAndActiveFlagOrderBySubMenuName(long menuId, short flag, short flag2);

  ArrayList<SubMenu> findByMenuIdAndDrsmAccessAndActiveFlagOrderBySubMenuName(long menuId, short flag, short flag2);

  ArrayList<SubMenu> findByMenuIdAndRoAccessAndActiveFlagOrderBySubMenuName(long menuId, short flag, short flag2);

  ArrayList<SubMenu> findByMenuIdAndSoAccessAndActiveFlagOrderBySubMenuName(long menuId, short flag, short flag2);

  ArrayList<SubMenu> findByMenuIdAndDoAccessAndActiveFlagOrderBySubMenuName(long menuId, short flag, short flag2);

  ArrayList<SubMenu> findByMenuIdAndFoAccessAndActiveFlagOrderBySubMenuName(long menuId, short flag, short flag2);
}