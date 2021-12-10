package com.iocl.dhruva2api.dao;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.iocl.dhruva2api.model.activity.ActivityInputTran;
import com.iocl.dhruva2api.model.activity.ActivityTranId;

/**
 * ActivitiesInputTranDAO
 */
@Transactional
public interface ActivitiesInputTranDAO extends CrudRepository<ActivityInputTran, ActivityTranId> {

	public ArrayList<ActivityInputTran> getActivityInputTranByEmbeddedkeyRoCode(int roCode);
	

	
	@Query(value="select distinct ro_code from TRN_ACTIVITY_INPUT where ro_code not in (select distinct ro_code from trn_activity_input where VALUE='N') and ro_code in (select ro_code from VW_DHRUVA_CUST_DETAILS where salesarea=:sa)"
			,nativeQuery = true)
	public ArrayList<BigDecimal> getRoCodeBySalesArea(@Param("sa") String salesArea);

	@Query(value="select distinct ro_code from TRN_ACTIVITY_INPUT where ro_code not in (select distinct ro_code from trn_activity_input where VALUE='N') and ro_code in (select ro_code from VW_DHRUVA_CUST_DETAILS where salesoff=:do)"
			,nativeQuery = true)
	public ArrayList<BigDecimal> getRoCodesByDoCode(@Param("do") int locationCode);
	
	@Query(value="select distinct ro_code from TRN_ACTIVITY_INPUT where ro_code not in (select distinct ro_code from trn_activity_input where VALUE='N') and ro_code in (select ro_code from VW_DHRUVA_CUST_DETAILS where salesorg=:so)"
			,nativeQuery = true)
	public ArrayList<BigDecimal> getRoCodesBySoCode(@Param("so")int locationCode);

	@Query(value="select distinct ro_code from TRN_ACTIVITY_INPUT where ro_code not in (select distinct ro_code from trn_activity_input where VALUE='N') and ro_code in (select ro_code from VW_DHRUVA_CUST_DETAILS where substr(salesorg,0,1)=:region)"
			,nativeQuery = true)
	public ArrayList<BigDecimal> getRoCodesByRegion(@Param("region")String string);

	@Query(value="select distinct ro_code from TRN_ACTIVITY_INPUT where ro_code not in (select distinct ro_code from trn_activity_input where VALUE='N')",nativeQuery = true)
	public ArrayList<BigDecimal> findAllRoCode();
}