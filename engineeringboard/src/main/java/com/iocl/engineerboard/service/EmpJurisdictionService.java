package com.iocl.dhruva2api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iocl.dhruva2api.dao.EmpJurisdictionDao;

@Service
public class EmpJurisdictionService {
	
	@Autowired
	private EmpJurisdictionDao empJurDao;
	
	public String getUserLevelByPaAndPsa(String paCode,String psaCode) {
    	return empJurDao.getUserLevelByPaAndPsa(paCode, psaCode);
    }
}
