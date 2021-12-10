package com.iocl.dhruva2api.service;

import java.util.ArrayList;

import com.iocl.dhruva2api.dao.DOMasterDAO;
import com.iocl.dhruva2api.dao.SAMasterDAO;
import com.iocl.dhruva2api.dao.SOMasterDAO;
import com.iocl.dhruva2api.model.DOMaster;
import com.iocl.dhruva2api.model.SAMaster;
import com.iocl.dhruva2api.model.SOMaster;
import com.iocl.dhruva2api.model.employee.EmployeeMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * SODOMasterService
 */
@Service
public class SOMasterService {

    @Autowired
    private SOMasterDAO soMasterDAO;
    
    @Autowired
    private EmployeeMasterService empMasterService;
    
    @Autowired
    private SAMasterDAO	saMasterDao;
    
    @Autowired
    private DOMasterDAO doMasterDao;
    
    @Autowired
    private EmpJurisdictionService empJurService;

    public ArrayList<SOMaster> getSoList() {
        return (ArrayList<SOMaster>) soMasterDAO.findAll();
    }

//    public ArrayList<Object[]> getSO() {
//        return soMasterDAO.findAll();
//    }

	public ArrayList<SOMaster> getSoList(int empCode) {
		EmployeeMaster employee = empMasterService.getEmployeeMaster(empCode);
		String salesGrp = employee.getSalesGroup();
		
		//Field officer in this case
		if (salesGrp != null && !salesGrp.equalsIgnoreCase("N/A") && employee.getPsaCode().equalsIgnoreCase("SL01")) {
			SOMaster soMaster = new SOMaster(String.valueOf(employee.getCurrCompCode()),employee.getCurrCompanyName());
			DOMaster doMaster = new DOMaster(String.valueOf(employee.getLocationCode()),employee.getLocationName());
			SAMaster saMaster = saMasterDao.findById(employee.getSalesGroup()).orElse(new SAMaster());
			ArrayList<SAMaster> saMasterList = new ArrayList<SAMaster>();
			saMasterList.add(saMaster);
			doMaster.setSalesAreas(saMasterList);
			ArrayList<DOMaster> doMasterList = new ArrayList<DOMaster>();
			doMasterList.add(doMaster);
			soMaster.setSalesOffs(doMasterList);
			ArrayList<SOMaster> soMasterList = new ArrayList<SOMaster>();
			soMasterList.add(soMaster);
			return soMasterList;
		}
		String userLevel = empJurService.getUserLevelByPaAndPsa(employee.getPaCode().substring(0, 2), employee.getPsaCode());
		switch (userLevel) {
		case "DO":
			return returnSoMasterByDO(employee);
		case "SO":
			return returnSoMasterBySO(employee);
		case "RO":
			return returnSoMasterByRO(employee); //For User from Regional Office, we have to show all states in that area.	
		case "HO":
	        return (ArrayList<SOMaster>) soMasterDAO.findAll();
		default:
			return null;
		}	
		
		
	}

	private ArrayList<SOMaster> returnSoMasterByRO(EmployeeMaster employee) {
		ArrayList<SOMaster> soMasterList = soMasterDAO.getStateOfficesByFirstCharacterOfSoCode(String.valueOf(employee.getLocationCode()).substring(0, 1)+"%");
		return soMasterList;
	}

	private ArrayList<SOMaster> returnSoMasterBySO(EmployeeMaster employee) {
		ArrayList<SOMaster> soMasterList = new ArrayList<SOMaster>();
		ArrayList<DOMaster> doMasterList = doMasterDao.getBySalesOrg(String.valueOf(employee.getCurrCompCode()));
		SOMaster soMaster = new SOMaster(String.valueOf(employee.getCurrCompCode()),employee.getCurrCompanyName());
		soMaster.setSalesOffs(doMasterList);
		soMasterList.add(soMaster);
		return soMasterList;
	}

	private ArrayList<SOMaster> returnSoMasterByDO(EmployeeMaster employee) {
		ArrayList<SAMaster> saMasterList = saMasterDao.getSAMasterBySalesOff(String.valueOf(employee.getLocationCode())); 
		ArrayList<DOMaster> doMasterList = new ArrayList<DOMaster>();
		ArrayList<SOMaster> soMasterList = new ArrayList<SOMaster>();
		SOMaster soMaster = new SOMaster(String.valueOf(employee.getCurrCompCode()),employee.getCurrCompanyName());
		DOMaster doMaster = new DOMaster(String.valueOf(employee.getLocationCode()),employee.getLocationName());
		doMaster.setSalesAreas(saMasterList);
		doMasterList.add(doMaster);
		soMaster.setSalesOffs(doMasterList);
		soMasterList.add(soMaster);
		return soMasterList;
	}

}