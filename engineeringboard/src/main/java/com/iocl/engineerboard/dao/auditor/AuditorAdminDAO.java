package com.iocl.dhruva2api.dao.auditor;

import com.iocl.dhruva2api.model.auditor.AuditorAdmin;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * AuditorAdminDAO
 */
@Transactional
public interface AuditorAdminDAO extends CrudRepository<AuditorAdmin, String> {

    @Modifying
    @Query("update AuditorAdmin set empStatus = :empStat where userId = :userId")
    public int toggleAuditorReviewerState(@Param("empStat") String empStat, @Param("userId") String userId);
}