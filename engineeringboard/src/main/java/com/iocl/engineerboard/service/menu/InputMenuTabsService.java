package com.iocl.dhruva2api.service.menu;

import java.util.ArrayList;

import com.iocl.dhruva2api.dao.menu.InputMenuTabsDAO;
import com.iocl.dhruva2api.model.employee.EmployeeMaster;
import com.iocl.dhruva2api.model.menu.InputMenuTabs;
import com.iocl.dhruva2api.service.EmpJurisdictionService;
import com.iocl.dhruva2api.service.EmployeeMasterService;
import com.iocl.dhruva2api.service.employee.DhruvaAdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * InputMenuTabsService
 */
@Service
public class InputMenuTabsService {

    @Autowired
    private InputMenuTabsDAO inputMenuTabsDAO;

    @Autowired
    public EmployeeMasterService employeeMasterService;

    @Autowired
    private EmpJurisdictionService empJurService;

    @Autowired
    private DhruvaAdminService dhruvaAdminService;

    public ArrayList<InputMenuTabs> getInputMenuTabs(int empCode) {
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
            return inputMenuTabsDAO.findByFoAccessAndActiveFlag(flag, flag);
        case "DO":
            return inputMenuTabsDAO.findByDoAccessAndActiveFlag(flag, flag);
        case "SO":
            return inputMenuTabsDAO.findBySoAccessAndActiveFlag(flag, flag);
        case "RO":
            // For User from Regional Office, we have to show ROs from all states.
            return inputMenuTabsDAO.findByRoAccessAndActiveFlag(flag, flag);
        case "HO":
            return inputMenuTabsDAO.findByHoAccessAndActiveFlag(flag, flag);
        case "ADMIN":
            return inputMenuTabsDAO.findByAdminAccessAndActiveFlag(flag, flag);
        default:
            return null;
        }
    }
}