package com.iocl.dhruva2api.service.mapping;

import java.util.ArrayList;
import java.util.List;

import com.iocl.dhruva2api.dao.SAMasterDAO;
import com.iocl.dhruva2api.dao.mapping.DivisionOfficeMappingDAO;
import com.iocl.dhruva2api.dao.mapping.SalesAreaMappingDAO;
import com.iocl.dhruva2api.model.DOMaster;
import com.iocl.dhruva2api.model.SAMaster;
import com.iocl.dhruva2api.model.mapping.DivisionOfficeMapping;
import com.iocl.dhruva2api.model.mapping.SalesAreaMapping;
import com.iocl.dhruva2api.service.DOMasterService;
import com.iocl.dhruva2api.service.EmployeeMasterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MappingService
 */
@Service
public class MappingService {

	@Autowired
	private EmployeeMasterService employeeMasterService;

	@Autowired
	private SAMasterDAO saMasterDAO;

	@Autowired
	private DOMasterService doMasterService;

	@Autowired
	private SalesAreaMappingDAO salesAreaMappingDAO;

	@Autowired
	private DivisionOfficeMappingDAO divisionOfficeMappingDAO;

	public List<Object[]> populateEligibleEmployees(int empCode) {
		return employeeMasterService
				.findEmployeeByLocationCode(employeeMasterService.getEmployeeMaster(empCode).getLocationCode());
	}

	public ArrayList<SAMaster> populateEligibleSalesAreas(int empCode) {
		return saMasterDAO
				.getSAMasterBySalesOff(String.valueOf(employeeMasterService.getEmployeeMaster(empCode).getLocationCode()));
	}

	public ArrayList<DOMaster> populateEligibleDivisionOffices(int empCode) {
		return doMasterService
				.getDOList(String.valueOf(employeeMasterService.getEmployeeMaster(empCode).getLocationCode()));
	}

	public SalesAreaMapping saveSalesAreaMappingDetails(SalesAreaMapping mapping, String userId) {
		mapping.setUpdatedBy(employeeMasterService.getUserDetails(Integer.parseInt(userId)));
		return salesAreaMappingDAO.save(mapping);
	}

	public DivisionOfficeMapping saveDivisionOfficeMappingDetails(DivisionOfficeMapping mapping, String userId) {
		mapping.setUpdatedBy(employeeMasterService.getUserDetails(Integer.parseInt(userId)));
		return divisionOfficeMappingDAO.save(mapping);
	}

}