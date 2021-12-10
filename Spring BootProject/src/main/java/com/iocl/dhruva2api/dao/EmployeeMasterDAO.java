package com.iocl.dhruva2api.dao;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.employee.EmployeeMaster;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * EmployeeMasterDAO
 */
@Transactional
public interface EmployeeMasterDAO extends CrudRepository<EmployeeMaster, Integer> {

	@Query(nativeQuery = true, value = "select FO_name from vw_get_ro_fo_drsm_srh where custcode = :roCode")
	String findFO(@Param("roCode") int roCode);

	@Query(nativeQuery = true, value = "select max(count) from (select count(ro_code) count,ro_code from tpa_ro_audit group by ro_code)")
	Integer findMaxAuditCount();

	@Query(nativeQuery = true, value = "select EMP_NAME, EMP_CODE from MST_EMPLOYEE where PSA_CODE = 'SL01' and EMP_STATUS_CODE = 3 and loc_code = :locCode and SALES_GROUP is null")
	ArrayList<Object[]> findEmployeeByLocCode(@Param("locCode") int locCode);
}