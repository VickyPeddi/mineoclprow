package com.iocl.dhruva2api.service;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import com.iocl.dhruva2api.dao.EmployeeMasterDAO;
import com.iocl.dhruva2api.model.DhruvaCustomer;
import com.iocl.dhruva2api.model.employee.EmployeeMaster;
import com.iocl.dhruva2api.model.spotcheck.ArchetypeWiseModule;
import com.iocl.dhruva2api.model.spotcheck.ArchetypeWiseSpotCheckModuleNumber;
import com.iocl.dhruva2api.service.spotcheck.ArchetypeWiseModuleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * EmployeeMasterService
 */
@Service
public class EmployeeMasterService {

	@Autowired
	public EmployeeMasterDAO masterDAO;

	@Autowired
	public DhruvaCustomerService custService;

	@Autowired
	public MstArchetypeService mstArchtypeService;

	@Autowired
	private EmpJurisdictionService empJurService;

	@Autowired
	private ArchetypeWiseModuleService moduleService;

	public EmployeeMaster getEmployeeMaster(int empCode) {
		return masterDAO.findById(empCode).orElse(new EmployeeMaster());
	}

	public String getUserDetails(int empCode) {
		EmployeeMaster em = this.getEmployeeMaster(empCode);
		return em.getEmpCode() + "---" + em.getEmpName() + "---" + em.getDesignation();
	}

	public String getUserDetails(EmployeeMaster em) {
		return em.getEmpCode() + "---" + em.getEmpName() + "---" + em.getDesignation();
	}

	public ArrayList<DhruvaCustomer> getDhruvaCustomersByEmployeeCode(int empCode) {
		EmployeeMaster employee = getEmployeeMaster(empCode);
		String salesGrp = employee.getSalesGroup();

		ArrayList<DhruvaCustomer> customers = null;
		// Field officer in this case
		if (salesGrp != null && !salesGrp.equalsIgnoreCase("N/A") && employee.getPsaCode().equalsIgnoreCase("SL01")) {
			customers = custService.getDhruvaCustomersBySalesArea(salesGrp);
		}
		if (customers == null) {
			String userLevel = empJurService.getUserLevelByPaAndPsa(employee.getPaCode().substring(0, 2),
					employee.getPsaCode());
			switch (userLevel) {
			case "DO":
				customers = custService.getDhruvaMasterByDoCode(employee.getLocationCode());
				break;
			case "SO":
				customers = custService.getDhruvaMasterBySoCode(employee.getLocationCode());
				break;
			case "RO":
				// For User from Regional Office, we have to show ROs from all states.
				customers = custService
						.getDhruvaMasterByRegion(String.valueOf(employee.getLocationCode()).substring(0, 1) + "%");
				break;
			case "HO":
				customers = custService.findAll();
				break;
			default:
				customers = new ArrayList<>();
				break;
			}
		}
		return customers;
	}

	public ArrayList<Integer> getROCodeByEmpCode(int empCode) {
		EmployeeMaster employee = getEmployeeMaster(empCode);
		String salesGrp = employee.getSalesGroup();

		ArrayList<Integer> roCodes = null;
		// Field officer in this case
		if (salesGrp != null && !salesGrp.equalsIgnoreCase("N/A") && employee.getPsaCode().equalsIgnoreCase("SL01")) {
			roCodes = custService.getRoCodesBySalesArea(salesGrp);
		}
		if (roCodes == null) {
			String userLevel = empJurService.getUserLevelByPaAndPsa(employee.getPaCode().substring(0, 2),
					employee.getPsaCode());
			switch (userLevel) {
			case "DO":
				roCodes = custService.getRoCodesByDoCode(employee.getLocationCode());
				break;
			case "SO":
				roCodes = custService.getRoCodesBySoCode(employee.getLocationCode());
				break;
			case "RO":
				// For User from Regional Office, we have to show ROs from all states.
				roCodes = custService
						.getRoCodesByRegion(String.valueOf(employee.getLocationCode()).substring(0, 1) + "%");
				break;
			case "HO":
				roCodes = custService.findRoCode();
				break;
			default:
				roCodes = new ArrayList<>();
				break;
			}
		}
		return roCodes;
	}

	public ArrayList<ArchetypeWiseSpotCheckModuleNumber> getArchetypeWiseSpotCheckModuleNumbers() {
		ConcurrentHashMap<String, ArrayList<Integer>> archetypeWiseSpotcheckModules = new ConcurrentHashMap<String, ArrayList<Integer>>();
		ArrayList<ArchetypeWiseModule> tempList = moduleService.getAllModules();
		tempList.forEach(temp -> {
			if (archetypeWiseSpotcheckModules.get(temp.getArchetypeCode()) != null) {
				archetypeWiseSpotcheckModules.get(temp.getArchetypeCode()).add(temp.getModule());
			} else {
				ArrayList<Integer> moduleList = new ArrayList<>();
				moduleList.add(temp.getModule());
				archetypeWiseSpotcheckModules.put(temp.getArchetypeCode(), moduleList);
			}
		});

		ArrayList<Integer> distinctArchetype = mstArchtypeService.getAllArchetype();
		ArrayList<ArchetypeWiseSpotCheckModuleNumber> archetypeWiseModuleNoList = new ArrayList<>();
		distinctArchetype.forEach(archetypeCode -> {
			archetypeWiseModuleNoList.add(new ArchetypeWiseSpotCheckModuleNumber(archetypeCode));
		});
		ArrayList<Integer> moduleNumbersApplicableToAll = archetypeWiseSpotcheckModules.get("*") == null
				? new ArrayList<>()
				: archetypeWiseSpotcheckModules.get("*");

		archetypeWiseModuleNoList.forEach(archetypeWiseModule -> {
			ArrayList<Integer> moduleNumbersApplicableToThisArchetype = archetypeWiseSpotcheckModules
					.get(String.valueOf(archetypeWiseModule.getArchetype())) == null ? new ArrayList<Integer>()
							: archetypeWiseSpotcheckModules.get(String.valueOf(archetypeWiseModule.getArchetype()));
			moduleNumbersApplicableToThisArchetype.addAll(moduleNumbersApplicableToAll);
			archetypeWiseModule.setModules(moduleNumbersApplicableToThisArchetype);
		});
		return archetypeWiseModuleNoList;
	}

	public String findFieldOfficer(int roCode) {
		return masterDAO.findFO(roCode);
	}

	public ArrayList<DhruvaCustomer> getRCACustomersByEmployeeCode(int empCode) {
		// Dhruva customers for RCA are required to be fetched in case of HO Only,
		// because for other users, it is synced at the time of login.

		EmployeeMaster employee = getEmployeeMaster(empCode);
		String salesGrp = employee.getSalesGroup();

		ArrayList<DhruvaCustomer> customers = null;
		String userLevel = empJurService.getUserLevelByPaAndPsa(employee.getPaCode().substring(0, 2),
				employee.getPsaCode());
		switch (userLevel) {
		case "HO":
			customers = custService.findRcaCustomers();
			break;
		default:
			customers = new ArrayList<>();
			break;
		}

		return customers;
	}

	public int findMaxAuditCount() {
		Integer value = masterDAO.findMaxAuditCount();
		return value == null ? 0 : value;
	}

	public ArrayList<Object[]> findEmployeeByLocationCode(int locationCode) {
		return masterDAO.findEmployeeByLocCode(locationCode);
	}
}