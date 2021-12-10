package com.iocl.dhruva2api.service.mis;

import java.util.ArrayList;

import com.iocl.dhruva2api.dao.mis.ParameterMasterDAO;
import com.iocl.dhruva2api.model.mis.ParameterMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ParameterMasterService
 */
@Service
public class ParameterMasterService {

	@Autowired
	private ParameterMasterDAO parameterMasterDAO;

	public ArrayList<ParameterMaster> getParameters() {
		ArrayList<ParameterMaster> temp = (ArrayList<ParameterMaster>) parameterMasterDAO.findAll();
		return temp;
	}
}