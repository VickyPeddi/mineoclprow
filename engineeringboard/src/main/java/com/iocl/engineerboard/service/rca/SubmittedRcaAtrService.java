package com.iocl.dhruva2api.service.rca;

import java.util.ArrayList;

import com.iocl.dhruva2api.dao.rca.SubmittedRcaAtrDAO;
import com.iocl.dhruva2api.model.employee.EmployeeMaster;
import com.iocl.dhruva2api.model.rca.RcaAtrId;
import com.iocl.dhruva2api.model.rca.SubmittedRcaAtr;
import com.iocl.dhruva2api.service.EmpJurisdictionService;
import com.iocl.dhruva2api.service.EmployeeMasterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * SubmittedRcaAtrService
 */
@Service
public class SubmittedRcaAtrService {

    @Autowired
    private SubmittedRcaAtrDAO submittedRcaAtrDAO;
    
	@Autowired
	private EmployeeMasterService emMasterService;
	
	@Autowired
	private EmpJurisdictionService empJurService;
	
    public ArrayList<SubmittedRcaAtr> getSubmittedRcaAtr(String roCode,int rootCauseSrNo) {
        return submittedRcaAtrDAO.findByRoCodeAndRootCauseSrNo(Integer.parseInt(roCode),rootCauseSrNo);
    }
    
    public ArrayList<RcaAtrId> getSubmittedRos(String userId) {
		EmployeeMaster employee = emMasterService.getEmployeeMaster(Integer.parseInt(userId));
		String salesGrp = employee.getSalesGroup();
		ArrayList<Object[]> temp = null;//submittedRcaAtrDAO.findSubmittedROAndPart();
//		Field officer in this case
		if (salesGrp != null && !salesGrp.equalsIgnoreCase("N/A") && employee.getPsaCode().equalsIgnoreCase("SL01")) {
			temp = submittedRcaAtrDAO.getRoCodeBySalesArea((salesGrp));
		}
		if (temp == null) {
			String userLevel = empJurService.getUserLevelByPaAndPsa(employee.getPaCode().substring(0, 2),
					employee.getPsaCode());
			switch (userLevel) {
			case "DO":
				temp = submittedRcaAtrDAO.getRoCodesByDoCode(employee.getLocationCode());
				break;
			case "SO":
				temp = submittedRcaAtrDAO.getRoCodesBySoCode(employee.getLocationCode());
				break;
			case "RO":
				// For User from Regional Office, we have to show ROs from all states.
				temp = submittedRcaAtrDAO.getRoCodesByRegion(String.valueOf(employee.getLocationCode()).substring(0, 1));
				break;
			case "HO":
				temp = submittedRcaAtrDAO.findSubmittedROAndPart();
				break;
			default:
				temp = new ArrayList<>();
				break;
			}
		}
		return parseToReturnable(temp);
	}

	private ArrayList<RcaAtrId> parseToReturnable(ArrayList<Object[]> temp) {
		ArrayList<RcaAtrId> finalList2 = new ArrayList<>();
		for(Object[] obj : temp) {
			RcaAtrId submitted2 = new RcaAtrId();
			submitted2.setRoCode(Integer.parseInt(String.valueOf(obj[0])));
			submitted2.setRootCauseSrNo(Integer.parseInt(String.valueOf(obj[1])));
			finalList2.add(submitted2);
		}
		
		return finalList2;
	}
}