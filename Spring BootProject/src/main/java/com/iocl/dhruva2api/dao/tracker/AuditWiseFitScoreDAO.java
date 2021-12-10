package com.iocl.dhruva2api.dao.tracker;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.tracker.AuditWiseFitDetails;

import org.springframework.data.repository.CrudRepository;

public interface AuditWiseFitScoreDAO extends CrudRepository<AuditWiseFitDetails, Integer> {

	ArrayList<AuditWiseFitDetails> getAuditWiseFitDetailsByFitTrackerPKAuditId(long auditId);
}
