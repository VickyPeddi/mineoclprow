package com.iocl.dhruva2api.dao.dsa;

import com.iocl.dhruva2api.model.dsa.DSASummary;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * DSASummaryDAO
 */
@Transactional
public interface DSASummaryDAO extends CrudRepository<DSASummary, Long> {

  @Modifying
  @Query(value = "delete from DSASummary")
  int deleteAllData();

  @Procedure(procedureName = "PROC_DSA_DATA_UPLOAD")
  void moveBCPToDSA();
}