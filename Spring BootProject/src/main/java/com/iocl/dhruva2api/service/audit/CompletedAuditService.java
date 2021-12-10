package com.iocl.dhruva2api.service.audit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import com.iocl.dhruva2api.dao.audit.CompletedAuditDAO;
import com.iocl.dhruva2api.model.audit.AuditMaster;
import com.iocl.dhruva2api.model.employee.EmployeeMaster;
import com.iocl.dhruva2api.service.EmpJurisdictionService;
import com.iocl.dhruva2api.service.EmployeeMasterService;
import com.iocl.dhruva2api.util.DateUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompletedAuditService {

	@Autowired
	private CompletedAuditDAO completedAuditDao;

	@Autowired
	private EmployeeMasterService emMasterService;

	@Autowired
	private EmpJurisdictionService empJurService;

//	public ArrayList<AuditMaster> getSubmittedAuditByEmpCode(int empCode) {
//
//		EmployeeMaster employee = emMasterService.getEmployeeMaster(empCode);
//		String salesGrp = employee.getSalesGroup();
//
//		ArrayList<AuditMaster> auditList = null;
//		// Field officer in this case
//		if (salesGrp != null && !salesGrp.equalsIgnoreCase("N/A") && employee.getPsaCode().equalsIgnoreCase("SL01")) {
//			auditList = completedAuditDao.getAuditMasterBySalesArea(salesGrp);
//		}
//		if (auditList == null) {
//			String userLevel = empJurService.getUserLevelByPaAndPsa(employee.getPaCode().substring(0, 2),
//					employee.getPsaCode());
//			switch (userLevel) {
//			case "DO":
//				auditList = completedAuditDao.getAuditMasterByDoCode(employee.getLocationCode());
//				break;
//			case "SO":
//				auditList = completedAuditDao.getAuditsMasterBySoCode(employee.getLocationCode());
//				break;
//			case "RO":
//				// For User from Regional Office, we have to show ROs from all states.
//				auditList = completedAuditDao
//						.getAuditMasterByRegion(String.valueOf(employee.getLocationCode()).substring(0, 1) + "%");
//				break;
//			case "HO":
//				auditList = (ArrayList<AuditMaster>) completedAuditDao.findAll();
//				break;
//			default:
//				auditList = new ArrayList<>();
//				break;
//			}
//		}
//		return auditList;
//	}
//
//	
	
	public ArrayList<AuditMaster> getSubmittedAuditByEmpCodePost(int empCode, String fromDate, String toDate,
			String roCode) {
		EmployeeMaster employee = emMasterService.getEmployeeMaster(empCode);
		String salesGrp = employee.getSalesGroup();
		Date fromDateInDateFormat = DateUtils.convertStringToDate(fromDate, "dd-MM-yyyy");
		Date toDateInDateFormat = DateUtils.convertStringToDate(toDate, "dd-MM-yyyy");
		int roCodeInInteger = roCode.equals("NA") ? 0 : Integer.parseInt(roCode);
		ArrayList<AuditMaster> auditList = null;

		if (salesGrp != null && !salesGrp.equalsIgnoreCase("N/A") && employee.getPsaCode().equalsIgnoreCase("SL01")) {

			if (roCode.equals("NA")) {
				auditList = completedAuditDao.getAuditMasterBySalesAreaAndActualAuditDateBetween(salesGrp,
						fromDateInDateFormat, toDateInDateFormat);
			} else {
				auditList = completedAuditDao.getAuditMasterBySalesAreaAndRoCodeAndActualAuditDateBetween(salesGrp,
						roCodeInInteger, fromDateInDateFormat, toDateInDateFormat);
			}

		}
		if (auditList == null) {
			String userLevel = empJurService.getUserLevelByPaAndPsa(employee.getPaCode().substring(0, 2),
					employee.getPsaCode());
			switch (userLevel) {
			case "DO":
				
				if (roCode.equals("NA")) {
					auditList = completedAuditDao.getAuditMasterByDoCodeAndActualAuditDateBetween(employee.getLocationCode(),
							fromDateInDateFormat, toDateInDateFormat);
				} else {
					auditList = completedAuditDao.getAuditMasterByDoCodeAndRoCodeAndActualAuditDateBetween(salesGrp,
							roCodeInInteger, fromDateInDateFormat, toDateInDateFormat);
				}
				break;
			case "SO":
				if (roCode.equals("NA")) {
					auditList = completedAuditDao.getBySoCodeAndActualAuditDateBetween(employee.getLocationCode(),
							fromDateInDateFormat, toDateInDateFormat);
					System.out.println(auditList.size());
				} else {
					auditList = completedAuditDao.getBySoCodeAndRoCodeAndActualAuditDateBetween(
							employee.getLocationCode(), roCodeInInteger, fromDateInDateFormat, toDateInDateFormat);
				}
				break;
			case "RO":
				auditList = new ArrayList<>();
				if (roCode.equals("NA")) {
					auditList = completedAuditDao.getAuditMasterByRegionDateFilter(fromDate, toDate,
							String.valueOf(employee.getLocationCode()).substring(0, 1) + "%");
				} else {
					auditList = completedAuditDao.getAuditMasterByRegionRoSpecific(fromDate, toDate, roCode,
							String.valueOf(employee.getLocationCode()).substring(0, 1) + "%");
				}

				break;
			case "HO": 
				if (roCode.equals("NA")) {
					auditList = completedAuditDao.getAuditMasterByActualAuditDateBetween(fromDateInDateFormat, toDateInDateFormat);
				} else {
					auditList = completedAuditDao.getAuditMasterByRoCodeAndActualAuditDateBetween(roCodeInInteger,fromDateInDateFormat, toDateInDateFormat);
				}
				break;
			default:
				auditList = new ArrayList<>();
				break;
			}
		}

		return auditList;
	}

}
