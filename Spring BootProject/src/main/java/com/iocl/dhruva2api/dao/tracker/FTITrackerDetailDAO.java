package com.iocl.dhruva2api.dao.tracker;

import com.iocl.dhruva2api.model.tracker.FITTracker;
import com.iocl.dhruva2api.model.tracker.FITTrackerPK;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * FTITrackerDetailDAO
 */
@Transactional
public interface FTITrackerDetailDAO extends CrudRepository<FITTracker, FITTrackerPK> {

  @Modifying
  @Query("update FITTracker set status = :status where fitTrackerPK.auditId = :auditId and fitTrackerPK.catId = :catId")
  public int toggleFITTrackerStatus(@Param("status") int status, @Param("auditId") long auditId,
      @Param("catId") int catId);
}