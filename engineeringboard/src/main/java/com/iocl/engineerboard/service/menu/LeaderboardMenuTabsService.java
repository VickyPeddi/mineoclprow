package com.iocl.dhruva2api.service.menu;

import java.util.ArrayList;

import com.iocl.dhruva2api.dao.menu.LeaderboardMenuTabsDAO;
import com.iocl.dhruva2api.model.employee.EmployeeMaster;
import com.iocl.dhruva2api.model.menu.LeaderboardMenuTabs;
import com.iocl.dhruva2api.service.EmpJurisdictionService;
import com.iocl.dhruva2api.service.EmployeeMasterService;
import com.iocl.dhruva2api.service.employee.DhruvaAdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * LeaderboardMenuTabsService
 */
@Service
public class LeaderboardMenuTabsService {

    @Autowired
    private LeaderboardMenuTabsDAO leaderboardMenuTabsDAO;

    @Autowired
    public EmployeeMasterService employeeMasterService;

    @Autowired
    private EmpJurisdictionService empJurService;

    @Autowired
    private DhruvaAdminService dhruvaAdminService;

    public ArrayList<LeaderboardMenuTabs> getLeaderboardMenuTabs(int empCode) {
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
            return leaderboardMenuTabsDAO.findByFoAccessAndActiveFlag(flag, flag);
        case "DO":
            return leaderboardMenuTabsDAO.findByDoAccessAndActiveFlag(flag, flag);
        case "SO":
            return leaderboardMenuTabsDAO.findBySoAccessAndActiveFlag(flag, flag);
        case "RO":
            // For User from Regional Office, we have to show ROs from all states.
            return leaderboardMenuTabsDAO.findByRoAccessAndActiveFlag(flag, flag);
        case "HO":
            return leaderboardMenuTabsDAO.findByHoAccessAndActiveFlag(flag, flag);
        case "ADMIN":
            return leaderboardMenuTabsDAO.findByAdminAccessAndActiveFlag(flag, flag);
        default:
            return null;
        }
    }

}