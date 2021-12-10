package com.iocl.dhruva2api.dao.tracker;

import com.iocl.dhruva2api.model.tracker.FITTrackerPK;
import com.iocl.dhruva2api.model.tracker.FITTrackerPhoto;

import org.springframework.data.repository.CrudRepository;

/**
 * FITTrackerPhotoDAO
 */
public interface FITTrackerPhotoDAO extends CrudRepository<FITTrackerPhoto, FITTrackerPK> {

}