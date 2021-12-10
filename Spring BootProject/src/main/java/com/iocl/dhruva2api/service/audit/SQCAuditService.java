package com.iocl.dhruva2api.service.audit;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iocl.dhruva2api.dao.audit.SQCAuditDAO;
import com.iocl.dhruva2api.model.audit.SQCAuditMaster;
import com.iocl.dhruva2api.model.employee.EmployeeMaster;
import com.iocl.dhruva2api.service.EmpJurisdictionService;
import com.iocl.dhruva2api.service.EmployeeMasterService;

@Service
public class SQCAuditService {

	@Autowired
	private SQCAuditDAO sqcAuditDao;

	@Autowired
	private EmployeeMasterService emMasterService;

	@Autowired
	private EmpJurisdictionService empJurService;

	public ArrayList<SQCAuditMaster> getSQCSubmittedAuditsByEmpCode(int empCode) {

		EmployeeMaster employee = emMasterService.getEmployeeMaster(empCode);
		String salesGrp = employee.getSalesGroup();

		ArrayList<SQCAuditMaster> sqcAuditList = null;
		// Field officer in this case
		if (salesGrp != null && !salesGrp.equalsIgnoreCase("N/A") && employee.getPsaCode().equalsIgnoreCase("SL01")) {
			sqcAuditList = sqcAuditDao.getSQCAuditMasterBySalesArea(salesGrp);
		}
		if (sqcAuditList == null) {
			String userLevel = empJurService.getUserLevelByPaAndPsa(employee.getPaCode().substring(0, 2),
					employee.getPsaCode());
			switch (userLevel) {
			case "DO":
				sqcAuditList = sqcAuditDao.getSQCAuditMasterByDoCode(employee.getLocationCode());
				break;
			case "SO":
				sqcAuditList = sqcAuditDao.getSQCAuditsMasterBySoCode(employee.getLocationCode());
				break;
			case "RO":
				// For User from Regional Office, we have to show ROs from all states.
				sqcAuditList = sqcAuditDao
						.getSQCAuditMasterByRegion(String.valueOf(employee.getLocationCode()).substring(0, 1) + "%");
				break;
			case "HO":
				sqcAuditList = (ArrayList<SQCAuditMaster>) sqcAuditDao.findAll();
				break;
			default:
				sqcAuditList = new ArrayList<>();
				break;
			}
		}
		return sqcAuditList;
	}

}
