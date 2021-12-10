package com.iocl.dhruva2api.service.tracker;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iocl.dhruva2api.dao.tracker.AuditWiseFitScoreDAO;
import com.iocl.dhruva2api.model.tracker.AuditWiseFitDetails;

@Service
public class AuditWiseFitDetailsService {

	@Autowired
	private AuditWiseFitScoreDAO auditWiseFitScoreDAO;

	public ArrayList<AuditWiseFitDetails> getAuditWiseFitDetails(long auditId) {
		return auditWiseFitScoreDAO.getAuditWiseFitDetailsByFitTrackerPKAuditId(auditId);
	}

}
