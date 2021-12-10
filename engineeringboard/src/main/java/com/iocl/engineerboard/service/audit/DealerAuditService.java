package com.iocl.dhruva2api.service.audit;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iocl.dhruva2api.dao.audit.DealerAuditDAO;
import com.iocl.dhruva2api.model.audit.DealerAuditMaster;
import com.iocl.dhruva2api.model.employee.EmployeeMaster;
import com.iocl.dhruva2api.service.EmpJurisdictionService;
import com.iocl.dhruva2api.service.EmployeeMasterService;

@Service
public class DealerAuditService {

	@Autowired
	private DealerAuditDAO dealerAuditDAO;

	@Autowired
	private EmployeeMasterService emMasterService;

	@Autowired
	private EmpJurisdictionService empJurService;

	public ArrayList<DealerAuditMaster> getDealerSubmittedAuditByEmpCode(int empCode) {

		EmployeeMaster employee = emMasterService.getEmployeeMaster(empCode);
		String salesGrp = employee.getSalesGroup();

		ArrayList<DealerAuditMaster> auditList = null;
		// Field officer in this case
		if (salesGrp != null && !salesGrp.equalsIgnoreCase("N/A") && employee.getPsaCode().equalsIgnoreCase("SL01")) {
			auditList = dealerAuditDAO.getDealerAuditMasterBySalesArea(salesGrp);
		}
		if (auditList == null) {
			String userLevel = empJurService.getUserLevelByPaAndPsa(employee.getPaCode().substring(0, 2),
					employee.getPsaCode());
			switch (userLevel) {
			case "DO":
				auditList = dealerAuditDAO.getDealerAuditMasterByDoCode(employee.getLocationCode());
				break;
			case "SO":
				auditList = dealerAuditDAO.getDealerAuditMasterBySoCode(employee.getLocationCode());
				break;
			case "RO":
				// For User from Regional Office, we have to show ROs from all states.
				auditList = dealerAuditDAO
						.getDealerAuditMasterByRegion(String.valueOf(employee.getLocationCode()).substring(0, 1) + "%");
				break;
			case "HO":
				auditList = (ArrayList<DealerAuditMaster>) dealerAuditDAO.findAll();
				break;
			default:
				auditList = new ArrayList<>();
				break;
			}
		}
		return auditList;
	}

}
