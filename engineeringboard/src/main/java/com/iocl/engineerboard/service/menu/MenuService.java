package com.iocl.dhruva2api.service.menu;

import java.util.ArrayList;

import com.iocl.dhruva2api.dao.menu.MISMenuItemsDAO;
import com.iocl.dhruva2api.dao.menu.MenuDAO;
import com.iocl.dhruva2api.dao.menu.SubMenuDAO;
import com.iocl.dhruva2api.model.MISMenuItems;
import com.iocl.dhruva2api.model.employee.EmployeeMaster;
import com.iocl.dhruva2api.model.menu.Menu;
import com.iocl.dhruva2api.model.menu.SubMenu;
import com.iocl.dhruva2api.service.EmpJurisdictionService;
import com.iocl.dhruva2api.service.EmployeeMasterService;
import com.iocl.dhruva2api.service.employee.DhruvaAdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MenuService
 */
@Service
public class MenuService {

	short flag = 1;

	@Autowired
	private MenuDAO menuDAO;

	@Autowired
	private SubMenuDAO subMenuDAO;

	@Autowired
	private MISMenuItemsDAO menuItemsDAO;

	@Autowired
	public EmployeeMasterService employeeMasterService;

	@Autowired
	private EmpJurisdictionService empJurService;

	@Autowired
	private DhruvaAdminService dhruvaAdminService;

	public ArrayList<Menu> getTabsAndMenus(int empCode) {

		EmployeeMaster employee = employeeMasterService.getEmployeeMaster(empCode);
		String salesGrp = employee.getSalesGroup();

		String userLevel = empJurService.getUserLevelByPaAndPsa(employee.getPaCode().substring(0, 2),
				employee.getPsaCode());
		// Field officer in this case
		if (salesGrp != null && !salesGrp.equalsIgnoreCase("N/A") && employee.getPsaCode().equalsIgnoreCase("SL01")) {
			userLevel = "FO";
		}
		// Ideally we should check func head only, but flagging is not done correctly in many cases
		if (userLevel.equals("DO") && (("X").equalsIgnoreCase(employee.getLocInFlag()) || ("X").equalsIgnoreCase(employee.getFuncHeadFlag()))) {
			userLevel = "DRSM";
		}

		if (userLevel.equals("SO") && (("X").equalsIgnoreCase(employee.getLocInFlag()) || ("X").equalsIgnoreCase(employee.getFuncHeadFlag()))) {
			userLevel = "SRH";
		}

		if (dhruvaAdminService.getDhruvaAdmin(empCode) != null) {
			userLevel = "ADMIN";
		}

		switch (userLevel) {
		case "FO":
			return getMenusAndSubMenusForFO();
		case "DO":
			return getMenusAndSubMenusForDO();
		case "SO":
			return getMenusAndSubMenusForSO();
		case "RO":
			// For User from Regional Office, we have to show ROs from all states.
			return getMenusAndSubMenusForRO();
		case "HO":
			return getMenusAndSubMenusForHO();
		case "DRSM":
			return getMenusAndSubMenusForDRSM();
		case "SRH":
			return getMenusAndSubMenusForSRH();
		case "ADMIN":
			return getMenusAndSubMenusForAdmin();
		default:
			return new ArrayList<>();
		}

	}

	private ArrayList<Menu> getMenusAndSubMenusForFO() {
		ArrayList<Menu> menus = menuDAO.findByFoAccessAndActiveFlagOrderByMenuId(flag, flag);

		menus.forEach(menu -> {
			ArrayList<SubMenu> subMenus = subMenuDAO
					.findByMenuIdAndFoAccessAndActiveFlagOrderBySubMenuName(menu.getMenuId(), flag, flag);
			subMenus.forEach(subMenu -> {
				ArrayList<MISMenuItems> menuItems = menuItemsDAO
						.findByTabIdAndFoAccessAndActiveFlagOrderByRepId(subMenu.getSubMenuId(), flag, flag);
				subMenu.setMenuItems(menuItems);
			});
			menu.setSubMenus(subMenus);
		});

		return menus;
	}

	private ArrayList<Menu> getMenusAndSubMenusForDO() {
		ArrayList<Menu> menus = menuDAO.findByDoAccessAndActiveFlagOrderByMenuId(flag, flag);

		menus.forEach(menu -> {
			ArrayList<SubMenu> subMenus = subMenuDAO
					.findByMenuIdAndDoAccessAndActiveFlagOrderBySubMenuName(menu.getMenuId(), flag, flag);
			subMenus.forEach(subMenu -> {
				ArrayList<MISMenuItems> menuItems = menuItemsDAO
						.findByTabIdAndDoAccessAndActiveFlagOrderByRepId(subMenu.getSubMenuId(), flag, flag);
				subMenu.setMenuItems(menuItems);
			});
			menu.setSubMenus(subMenus);
		});

		return menus;
	}

	private ArrayList<Menu> getMenusAndSubMenusForSO() {
		ArrayList<Menu> menus = menuDAO.findBySoAccessAndActiveFlagOrderByMenuId(flag, flag);

		menus.forEach(menu -> {
			ArrayList<SubMenu> subMenus = subMenuDAO
					.findByMenuIdAndSoAccessAndActiveFlagOrderBySubMenuName(menu.getMenuId(), flag, flag);
			subMenus.forEach(subMenu -> {
				ArrayList<MISMenuItems> menuItems = menuItemsDAO
						.findByTabIdAndSoAccessAndActiveFlagOrderByRepId(subMenu.getSubMenuId(), flag, flag);
				subMenu.setMenuItems(menuItems);
			});
			menu.setSubMenus(subMenus);
		});

		return menus;
	}

	private ArrayList<Menu> getMenusAndSubMenusForRO() {
		ArrayList<Menu> menus = menuDAO.findByRoAccessAndActiveFlagOrderByMenuId(flag, flag);

		menus.forEach(menu -> {
			ArrayList<SubMenu> subMenus = subMenuDAO
					.findByMenuIdAndRoAccessAndActiveFlagOrderBySubMenuName(menu.getMenuId(), flag, flag);

			subMenus.forEach(subMenu -> {
				ArrayList<MISMenuItems> menuItems = menuItemsDAO
						.findByTabIdAndRoAccessAndActiveFlagOrderByRepId(subMenu.getSubMenuId(), flag, flag);
				subMenu.setMenuItems(menuItems);
			});
			menu.setSubMenus(subMenus);
		});

		return menus;
	}

	private ArrayList<Menu> getMenusAndSubMenusForHO() {
		ArrayList<Menu> menus = menuDAO.findByHoAccessAndActiveFlagOrderByMenuId(flag, flag);

		menus.forEach(menu -> {
			ArrayList<SubMenu> subMenus = subMenuDAO
					.findByMenuIdAndHoAccessAndActiveFlagOrderBySubMenuName(menu.getMenuId(), flag, flag);

			subMenus.forEach(subMenu -> {
				ArrayList<MISMenuItems> menuItems = menuItemsDAO
						.findByTabIdAndHoAccessAndActiveFlagOrderByRepId(subMenu.getSubMenuId(), flag, flag);
				subMenu.setMenuItems(menuItems);
			});
			menu.setSubMenus(subMenus);
		});

		return menus;
	}

	private ArrayList<Menu> getMenusAndSubMenusForAdmin() {
		ArrayList<Menu> menus = menuDAO.findByAdminAccessAndActiveFlagOrderByMenuId(flag, flag);

		menus.forEach(menu -> {
			ArrayList<SubMenu> subMenus = subMenuDAO
					.findByMenuIdAndAdminAccessAndActiveFlagOrderBySubMenuName(menu.getMenuId(), flag, flag);

			subMenus.forEach(subMenu -> {
				ArrayList<MISMenuItems> menuItems = menuItemsDAO
						.findByTabIdAndAdminAccessAndActiveFlagOrderByRepId(subMenu.getSubMenuId(), flag, flag);
				subMenu.setMenuItems(menuItems);
			});
			menu.setSubMenus(subMenus);
		});

		return menus;
	}

	private ArrayList<Menu> getMenusAndSubMenusForDRSM() {
		ArrayList<Menu> menus = menuDAO.findByDrsmAccessAndActiveFlagOrderByMenuId(flag, flag);

		menus.forEach(menu -> {
			ArrayList<SubMenu> subMenus = subMenuDAO
					.findByMenuIdAndDrsmAccessAndActiveFlagOrderBySubMenuName(menu.getMenuId(), flag, flag);

			subMenus.forEach(subMenu -> {
				ArrayList<MISMenuItems> menuItems = menuItemsDAO
						.findByTabIdAndDrsmAccessAndActiveFlagOrderByRepId(subMenu.getSubMenuId(), flag, flag);
				subMenu.setMenuItems(menuItems);
			});
			menu.setSubMenus(subMenus);
		});

		return menus;
	}

	private ArrayList<Menu> getMenusAndSubMenusForSRH() {
		ArrayList<Menu> menus = menuDAO.findBySrhAccessAndActiveFlagOrderByMenuId(flag, flag);

		menus.forEach(menu -> {
			ArrayList<SubMenu> subMenus = subMenuDAO
					.findByMenuIdAndSrhAccessAndActiveFlagOrderBySubMenuName(menu.getMenuId(), flag, flag);

			subMenus.forEach(subMenu -> {
				ArrayList<MISMenuItems> menuItems = menuItemsDAO
						.findByTabIdAndSrhAccessAndActiveFlagOrderByRepId(subMenu.getSubMenuId(), flag, flag);
				subMenu.setMenuItems(menuItems);
			});
			menu.setSubMenus(subMenus);
		});

		return menus;
	}

}