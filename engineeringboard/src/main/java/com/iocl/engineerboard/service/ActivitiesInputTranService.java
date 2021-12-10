package com.iocl.dhruva2api.service;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.iocl.dhruva2api.dao.ActivitiesInputTranDAO;
import com.iocl.dhruva2api.model.activity.ActivitiesInputData;
import com.iocl.dhruva2api.model.activity.ActivityInputTran;
import com.iocl.dhruva2api.model.activity.ActivityTranId;
import com.iocl.dhruva2api.model.activity.DhruvaActivitiesData;
import com.iocl.dhruva2api.model.employee.EmployeeMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ActivitiesInputTranService
 */
@Service
public class ActivitiesInputTranService {

	@Autowired
	private ActivitiesInputTranDAO inputTranDAO;

	@Autowired
	private EmployeeMasterService emMasterService;

	@Autowired
	private EmpJurisdictionService empJurService;

	public void saveActivityInputTran(ActivitiesInputData tran, int empId) {

		ArrayList<ActivityInputTran> tranDataList = new ArrayList<>();
		for (DhruvaActivitiesData activityData : tran.getDhruvaActivities()) {
			ActivityInputTran data = new ActivityInputTran();
			ActivityTranId tranId = new ActivityTranId(tran.getRoCode(), activityData.getActivityNo());
			data.setEmbeddedkey(tranId);
			data.setValue(activityData.getSelectedValue());
			data.setUserDetails(emMasterService.getUserDetails(empId));
			tranDataList.add(data);
		}
		inputTranDAO.saveAll(tranDataList);
	}

	public ArrayList<ActivityInputTran> getSubmittedActivitiesInput(String roCode) {
		return inputTranDAO.getActivityInputTranByEmbeddedkeyRoCode(Integer.parseInt(roCode));
	}

	public ArrayList<BigDecimal> getSubmittedRos(String user) {

		EmployeeMaster employee = emMasterService.getEmployeeMaster(Integer.parseInt(user));
		String salesGrp = employee.getSalesGroup();

		ArrayList<BigDecimal> roCodes = null;
		// Field officer in this case
		if (salesGrp != null && !salesGrp.equalsIgnoreCase("N/A") && employee.getPsaCode().equalsIgnoreCase("SL01")) {
			roCodes = inputTranDAO.getRoCodeBySalesArea((salesGrp));

		}
		if (roCodes == null) {
			String userLevel = empJurService.getUserLevelByPaAndPsa(employee.getPaCode().substring(0, 2),
					employee.getPsaCode());
			switch (userLevel) {
			case "DO":
				roCodes = inputTranDAO.getRoCodesByDoCode(employee.getLocationCode());
				break;
			case "SO":
				roCodes = inputTranDAO.getRoCodesBySoCode(employee.getLocationCode());
				break;
			case "RO":
				// For User from Regional Office, we have to show ROs from all states.
				roCodes = inputTranDAO
						.getRoCodesByRegion(String.valueOf(employee.getLocationCode()).substring(0, 1));
				break;
			case "HO":
				roCodes = inputTranDAO.findAllRoCode();
				break;
			default:
				roCodes = new ArrayList<>();
				break;
			}
		}
		return roCodes;

	}

}