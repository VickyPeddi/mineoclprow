package com.iocl.dhruva2api.dao.rca;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.rca.SubmittedRcaAtr;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * SubmittedRcaAtrDAO
 */
public interface SubmittedRcaAtrDAO extends CrudRepository<SubmittedRcaAtr, String> {

    @Query("from SubmittedRcaAtr where ro_code =:roCode and ROOTCAUSE_SR =:rootCauseSr order by attribute_no")
    public ArrayList<SubmittedRcaAtr> findByRoCodeAndRootCauseSrNo(@Param("roCode") int roCode,@Param("rootCauseSr") int rootCauseSrNo);
    
    @Query(value = "select distinct RO_CODE,ROOTCAUSE_SR from trn_rca_atr where  ATTRIBUTE_NO=20 and value is not null",nativeQuery = true )
    public ArrayList<Object[]> findSubmittedROAndPart();
    
    
	@Query(value="select distinct ro_code,ROOTCAUSE_SR from trn_rca_atr where ro_code in (select ro_code from VW_DHRUVA_CUST_DETAILS where salesarea=:sa)"
			+ "and ATTRIBUTE_NO=20 and value is not null"
			,nativeQuery = true)
	public ArrayList<Object[]> getRoCodeBySalesArea(@Param("sa") String salesArea);
	
	@Query(value="select distinct ro_code,ROOTCAUSE_SR from trn_rca_atr where ro_code in (select ro_code from VW_DHRUVA_CUST_DETAILS where salesoff=:do)"
			+ "and ATTRIBUTE_NO=20 and value is not null"
			,nativeQuery = true)
	public ArrayList<Object[]> getRoCodesByDoCode(@Param("do") int locationCode);
	
	@Query(value="select distinct ro_code,ROOTCAUSE_SR from trn_rca_atr where ro_code in (select ro_code from VW_DHRUVA_CUST_DETAILS where salesorg=:so)"
			+ "and ATTRIBUTE_NO=20 and value is not null"
			,nativeQuery = true)
	public ArrayList<Object[]> getRoCodesBySoCode(@Param("so")int locationCode);

	@Query(value="select distinct ro_code,ROOTCAUSE_SR from trn_rca_atr where ro_code in (select ro_code from VW_DHRUVA_CUST_DETAILS where substr(salesorg,0,1)=:region)"
			+ "and ATTRIBUTE_NO=20 and value is not null"
			,nativeQuery = true)
	public ArrayList<Object[]> getRoCodesByRegion(@Param("region")String string);
}