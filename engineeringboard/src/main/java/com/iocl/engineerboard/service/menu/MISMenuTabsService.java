package com.iocl.dhruva2api.service.menu;

import java.util.ArrayList;

import com.iocl.dhruva2api.dao.menu.MISMenuTabsDAO;
import com.iocl.dhruva2api.model.employee.EmployeeMaster;
import com.iocl.dhruva2api.model.menu.MISMenuTabs;
import com.iocl.dhruva2api.service.EmpJurisdictionService;
import com.iocl.dhruva2api.service.EmployeeMasterService;
import com.iocl.dhruva2api.service.employee.DhruvaAdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MISMenuTabsService
 */
@Service
public class MISMenuTabsService {

    @Autowired
    private MISMenuTabsDAO misMenuTabsDAO;

    @Autowired
    public EmployeeMasterService employeeMasterService;

    @Autowired
    private EmpJurisdictionService empJurService;

    @Autowired
    private DhruvaAdminService dhruvaAdminService;

    public ArrayList<MISMenuTabs> getTabsAndMenus(int empCode) {
        short flag = 1;
        EmployeeMaster employee = employeeMasterService.getEmployeeMaster(empCode);
        String salesGrp = employee.getSalesGroup();

        String userLevel = empJurService.getUserLevelByPaAndPsa(employee.getPaCode().substring(0, 2),
                employee.getPsaCode());
        // Field officer in this case
        if (salesGrp != null && !salesGrp.equalsIgnoreCase("N/A") && employee.getPsaCode().equalsIgnoreCase("SL01")) {
            userLevel = "FO";
        }

        if (dhruvaAdminService.getDhruvaAdmin(empCode) != null) {
            userLevel = "ADMIN";
        }
        switch (userLevel) {
        case "FO":
            return misMenuTabsDAO.findByFoAccessAndActiveFlagOrderByTabName(flag, flag);
        case "DO":
            return misMenuTabsDAO.findByDoAccessAndActiveFlagOrderByTabName(flag, flag);
        case "SO":
            return misMenuTabsDAO.findBySoAccessAndActiveFlagOrderByTabName(flag, flag);
        case "RO":
            // For User from Regional Office, we have to show ROs from all states.
            return misMenuTabsDAO.findByRoAccessAndActiveFlagOrderByTabName(flag, flag);
        case "HO":
            return misMenuTabsDAO.findByHoAccessAndActiveFlagOrderByTabName(flag, flag);
        case "ADMIN":
        	ArrayList<MISMenuTabs> temp = misMenuTabsDAO.findByAdminAccessAndActiveFlagOrderByTabName(flag, flag);
            return  
            		temp;
            //misMenuTabsDAO.findByAdminAccessAndActiveFlagOrderByTabName(flag, flag);
        default:
            return null;
        }
    }
}