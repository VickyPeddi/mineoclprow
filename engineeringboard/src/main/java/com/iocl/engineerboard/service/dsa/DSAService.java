package com.iocl.dhruva2api.service.dsa;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.iocl.dhruva2api.dao.SOMasterDAO;
import com.iocl.dhruva2api.dao.dsa.DSASummaryDAO;
import com.iocl.dhruva2api.model.SOMaster;
import com.iocl.dhruva2api.model.dsa.DSASummary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DSAService
 */
@Service
public class DSAService {

	@Autowired
	private DSASummaryDAO dsaSummaryDAO;

	@Autowired
	private SOMasterDAO soMasterDAO;

	public String saveDSASummaryData(List<DSASummary> dsaSummaryPayload) {

		List<SOMaster> validSalesOrgList = (List<SOMaster>) soMasterDAO.findAll();

		List<Integer> salesOrgList = validSalesOrgList.stream().map(so -> Integer.parseInt(so.getSalesOrg()))
				.collect(Collectors.toList());

//		System.out.println(salesOrgList);

		for (DSASummary dsaSummary : dsaSummaryPayload) {

			if (Collections.binarySearch(salesOrgList, dsaSummary.getSalesOrgCode()) > -1) {

				if ("Active".equals(dsaSummary.getUserStatus()) || "Disabled".equals(dsaSummary.getUserStatus())) {

					dsaSummary.setUpdatedOn(new Date());
				} else {
					return "User status invalid or not available!!!";
				}
			} else {
				return "State office invalid or not available!!!";
			}
		}

		if (dsaSummaryDAO.deleteAllData() > -1) {

			if (dsaSummaryDAO.saveAll(dsaSummaryPayload) != null) {
				dsaSummaryDAO.moveBCPToDSA();
				return "OK";
			} else {
				return "Server error!!!";
			}
		} else {
			return "Server error!!!";
		}
	}
}