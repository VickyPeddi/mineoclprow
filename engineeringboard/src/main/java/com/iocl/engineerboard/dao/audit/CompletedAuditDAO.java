package com.iocl.dhruva2api.dao.audit;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iocl.dhruva2api.model.audit.AuditMaster;

public interface CompletedAuditDAO extends CrudRepository<AuditMaster, Long> {


	ArrayList<AuditMaster> getAuditMasterBySalesAreaAndActualAuditDateBetween(String salesGrp,
			Date fromDateInDateFormat, Date toDateInDateFormat);

	ArrayList<AuditMaster> getAuditMasterBySalesAreaAndRoCodeAndActualAuditDateBetween(String salesGrp,
			int roCodeInInteger, Date fromDateInDateFormat, Date toDateInDateFormat);

	ArrayList<AuditMaster> getAuditMasterByActualAuditDateBetween(Date fromDate, Date toDate);

	ArrayList<AuditMaster> getBySoCodeAndActualAuditDateBetween(int soCode, Date fromDate, Date toDate);

	ArrayList<AuditMaster> getBySoCodeAndRoCodeAndActualAuditDateBetween(int soCode, int roCode, Date fromDate,
			Date toDate);

	ArrayList<AuditMaster> getAuditMasterByDoCodeAndActualAuditDateBetween(int locationCode, Date fromDateInDateFormat,
			Date toDateInDateFormat);

	ArrayList<AuditMaster> getAuditMasterByDoCodeAndRoCodeAndActualAuditDateBetween(String salesGrp,
			int roCodeInInteger, Date fromDateInDateFormat, Date toDateInDateFormat);

	ArrayList<AuditMaster> getAuditMasterByRoCodeAndActualAuditDateBetween(int roCode, Date fromDateInDateFormat,
			Date toDateInDateFormat);

	@Query("from AuditMaster where to_char(soCode) like :firstCharacterOfSoCode")
	ArrayList<AuditMaster> getAuditMasterByRegion(@Param("firstCharacterOfSoCode") String string);

	@Query(value = "select AUDIT_ID ,RO_CODE ,CUST_NAME ,SALESAREA_NAME ,SALESAREA ,SALESOFF ,SALESORG ,AUDIT_YEAR ,AUDIT_QUARTER ,LOCATION ,SALESOFF_NAME ,SO_NAME ,ACTUAL_AUDIT_DATE  from VW_COMPLETED_AUDIT where to_char(SALESORG) like :firstCharacterOfSoCode and ACTUAL_AUDIT_DATE BETWEEN TO_DATE (:fromDate, 'dd-mm-yyyy') AND TO_DATE (:toDate, 'dd-mm-yyyy')", nativeQuery = true)
	ArrayList<AuditMaster> getAuditMasterByRegionDateFilter(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("firstCharacterOfSoCode") String firstCharacterOfSoCode);

	@Query(value = "select AUDIT_ID ,RO_CODE ,CUST_NAME ,SALESAREA_NAME ,SALESAREA ,SALESOFF ,SALESORG ,AUDIT_YEAR ,AUDIT_QUARTER ,LOCATION ,SALESOFF_NAME ,SO_NAME ,ACTUAL_AUDIT_DATE  from VW_COMPLETED_AUDIT where to_char(SALESORG) like :firstCharacterOfSoCode and RO_CODE = :roCode and ACTUAL_AUDIT_DATE BETWEEN TO_DATE (:fromDate, 'dd-mm-yyyy') AND TO_DATE (:toDate, 'dd-mm-yyyy')", nativeQuery = true)
	ArrayList<AuditMaster> getAuditMasterByRegionRoSpecific(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("roCode") String roCode,
			@Param("firstCharacterOfSoCode") String firstCharacterOfSoCode);
	
	
	
//	ArrayList<AuditMaster> getAuditMasterBySalesArea(String salesGrp);
//	ArrayList<AuditMaster> getAuditMasterByDoCode(int locationCode);
//	ArrayList<AuditMaster> getAuditsMasterBySoCode(int locationCode);
//	@Query(value = "select AUDIT_ID ,RO_CODE ,CUST_NAME ,SALESAREA_NAME ,SALESAREA ,SALESOFF ,SALESORG ,AUDIT_YEAR ,AUDIT_QUARTER ,LOCATION ,SALESOFF_NAME ,SO_NAME ,ACTUAL_AUDIT_DATE  from VW_COMPLETED_AUDIT where RO_CODE = :roCode and ACTUAL_AUDIT_DATE BETWEEN TO_DATE (:fromDate, 'dd-mm-yyyy') AND TO_DATE (:toDate, 'dd-mm-yyyy')", nativeQuery = true)
//	ArrayList<AuditMaster> getAuditMasterByBoth(@Param("fromDate") String fromDate, @Param("toDate") String toDate,
//			@Param("roCode") String roCode);
//	@Query(value = "select AUDIT_ID ,RO_CODE ,CUST_NAME ,SALESAREA_NAME ,SALESAREA ,SALESOFF ,SALESORG ,AUDIT_YEAR ,AUDIT_QUARTER ,LOCATION ,SALESOFF_NAME ,SO_NAME ,ACTUAL_AUDIT_DATE  from VW_COMPLETED_AUDIT where SALESOFF = :salesOff  and ACTUAL_AUDIT_DATE BETWEEN TO_DATE (:fromDate, 'dd-mm-yyyy') AND TO_DATE (:toDate, 'dd-mm-yyyy')", nativeQuery = true)
//	ArrayList<AuditMaster> getAuditMasterByDoCodeDateFilter(@Param("fromDate") String fromDate,
//			@Param("toDate") String toDate, @Param("salesOff") String salesOff);

//	@Query(value = "select AUDIT_ID ,RO_CODE ,CUST_NAME ,SALESAREA_NAME ,SALESAREA ,SALESOFF ,SALESORG ,AUDIT_YEAR ,AUDIT_QUARTER ,LOCATION ,SALESOFF_NAME ,SO_NAME ,ACTUAL_AUDIT_DATE  from VW_COMPLETED_AUDIT where SALESOFF = :salesOff and RO_CODE = :roCode and ACTUAL_AUDIT_DATE BETWEEN TO_DATE (:fromDate, 'dd-mm-yyyy') AND TO_DATE (:toDate, 'dd-mm-yyyy')", nativeQuery = true)
//	ArrayList<AuditMaster> getAuditMasterByDoCodeRoSpecific(@Param("fromDate") String fromDate,
//			@Param("toDate") String toDate, @Param("roCode") String roCode, @Param("salesOff") String salesOff);

//	@Query(value = "select AUDIT_ID ,RO_CODE ,CUST_NAME ,SALESAREA_NAME ,SALESAREA ,SALESOFF ,SALESORG ,AUDIT_YEAR ,AUDIT_QUARTER ,LOCATION ,SALESOFF_NAME ,SO_NAME ,ACTUAL_AUDIT_DATE  from VW_COMPLETED_AUDIT where SALESAREA = :salesArea  and ACTUAL_AUDIT_DATE BETWEEN TO_DATE (:fromDate, 'dd-mm-yyyy') AND TO_DATE (:toDate, 'dd-mm-yyyy')", nativeQuery = true)
//	ArrayList<AuditMaster> getAuditMasterBySalesAreaDateFilter(@Param("fromDate") String fromDate,
//			@Param("toDate") String toDate, @Param("salesArea") String salesArea);
//
//	@Query(value = "select AUDIT_ID ,RO_CODE ,CUST_NAME ,SALESAREA_NAME ,SALESAREA ,SALESOFF ,SALESORG ,AUDIT_YEAR ,AUDIT_QUARTER ,LOCATION ,SALESOFF_NAME ,SO_NAME ,ACTUAL_AUDIT_DATE  from VW_COMPLETED_AUDIT where SALESAREA = :salesArea and RO_CODE = :roCode and ACTUAL_AUDIT_DATE BETWEEN TO_DATE (:fromDate, 'dd-mm-yyyy') AND TO_DATE (:toDate, 'dd-mm-yyyy')", nativeQuery = true)
//	ArrayList<AuditMaster> getAuditMasterBySalesAreaSpecific(@Param("fromDate") String fromDate,
//			@Param("toDate") String toDate, @Param("roCode") String roCode, @Param("salesArea") String salesArea);

}
