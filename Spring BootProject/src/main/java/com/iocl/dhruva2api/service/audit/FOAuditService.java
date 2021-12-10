package com.iocl.dhruva2api.service.audit;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iocl.dhruva2api.dao.audit.FOAuditDAO;
import com.iocl.dhruva2api.model.audit.FOAuditMaster;
import com.iocl.dhruva2api.model.employee.EmployeeMaster;
import com.iocl.dhruva2api.service.EmpJurisdictionService;
import com.iocl.dhruva2api.service.EmployeeMasterService;

@Service
public class FOAuditService {

	@Autowired
	private FOAuditDAO foAuditDAO;

	@Autowired
	private EmployeeMasterService emMasterService;

	@Autowired
	private EmpJurisdictionService empJurService;

	public ArrayList<FOAuditMaster> getFOSubmittedAuditByEmpCode(int empCode) {

		EmployeeMaster employee = emMasterService.getEmployeeMaster(empCode);
		String salesGrp = employee.getSalesGroup();

		ArrayList<FOAuditMaster> auditList = null;
		// Field officer in this case
		if (salesGrp != null && !salesGrp.equalsIgnoreCase("N/A") && employee.getPsaCode().equalsIgnoreCase("SL01")) {
			auditList = foAuditDAO.getFOAuditMasterBySalesArea(salesGrp);
		}
		if (auditList == null) {
			String userLevel = empJurService.getUserLevelByPaAndPsa(employee.getPaCode().substring(0, 2),
					employee.getPsaCode());
			switch (userLevel) {
			case "DO":
				auditList = foAuditDAO.getFOAuditMasterByDoCode(employee.getLocationCode());
				break;
			case "SO":
				auditList = foAuditDAO.getFOAuditMasterBySoCode(employee.getLocationCode());
				break;
			case "RO":
				// For User from Regional Office, we have to show ROs from all states.
				auditList = foAuditDAO.getFOAuditMasterByRegion(String.valueOf(employee.getLocationCode()).substring(0, 1) + "%");
				break;
			case "HO":
				auditList = (ArrayList<FOAuditMaster>) foAuditDAO.findAll();
				break;
			default:
				auditList = new ArrayList<>();
				break;
			}
		}
		return auditList;
	}

}
