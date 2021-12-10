package com.iocl.dhruva2api.dao.tracker;

import com.iocl.dhruva2api.model.tracker.FITTrackerPK;
import com.iocl.dhruva2api.model.tracker.FITTrackerRemarks;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * FITTrackerRemarkDAO
 */
@Transactional
public interface FITTrackerRemarkDAO extends CrudRepository<FITTrackerRemarks, FITTrackerPK> {

}