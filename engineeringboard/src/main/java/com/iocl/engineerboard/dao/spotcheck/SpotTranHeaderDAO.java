package com.iocl.dhruva2api.dao.spotcheck;

import com.iocl.dhruva2api.model.spotcheck.SpotTranHeader;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * SpotTranHeaderDAO
 */
@Transactional
public interface SpotTranHeaderDAO extends CrudRepository<SpotTranHeader, Long> {

    @Query(value = "SELECT SPOT_INSP_NO_SEQ.nextval FROM dual", nativeQuery = true)
    public long getInspNo();

    @Query(value = "SELECT NVL(MAX(INSP_NO), 0) FROM SPOT_TRAN_HEADER  WHERE RO_CODE = :roCode AND USER_DETAILS like '%:empCode%' AND SYSDATE - UPDATED_ON <= 7 ", nativeQuery = true)
    public long getInspNo(@Param("roCode") int roCode, @Param("empCode") String empCode);
}