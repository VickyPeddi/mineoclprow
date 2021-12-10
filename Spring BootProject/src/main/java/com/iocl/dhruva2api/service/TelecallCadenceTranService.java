package com.iocl.dhruva2api.service;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;

import com.iocl.dhruva2api.dao.TelecallCadenceDODao;
import com.iocl.dhruva2api.dao.TelecallCadenceDao;
import com.iocl.dhruva2api.model.TelecallCadenceDOData;
import com.iocl.dhruva2api.model.TelecallCadenceDODataId;
import com.iocl.dhruva2api.model.TelecallCadenceData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TelecallCadenceTranService
 */
@Service
public class TelecallCadenceTranService {

	@Autowired
	private TelecallCadenceDao telecallDao;

	@Autowired
	private TelecallCadenceDODao telecallDODao;

	@Autowired
	private EmployeeMasterService emMasterService;

	@Autowired
	EntityManager em;

	public void saveTelecallCadenceTran(TelecallCadenceData entity, String userId) {

		String telecallDate = entity.getTelecallDate();
		telecallDate = telecallDate.replace("-", "");
		entity.setTelecallDate(telecallDate);
		entity.setSoDate();
		entity.setUpdatedOn(new Date());
		entity.setUserDetails("To be updated Later");
		ArrayList<TelecallCadenceDOData> salesOffDataList = entity.getSalesOffDetails();
		entity.setUserDetails(emMasterService.getUserDetails(Integer.parseInt(userId)));
		// Right now we are unable to save through @OneToMany, giving error. So had to
		// do this.
		for (TelecallCadenceDOData salesOffData : salesOffDataList) {
			TelecallCadenceDODataId embeddedId = new TelecallCadenceDODataId(salesOffData.getSalesOff(),
					entity.getSoDate());
			salesOffData.setEmbeddedKey(embeddedId);
		}
		telecallDao.save(entity); // We have to implement @OneToMany for consistency in data.
		telecallDODao.saveAll(salesOffDataList);
		
	}
}