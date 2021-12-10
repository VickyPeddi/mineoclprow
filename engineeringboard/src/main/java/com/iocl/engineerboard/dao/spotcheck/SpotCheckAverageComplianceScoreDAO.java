package com.iocl.dhruva2api.dao.spotcheck;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.spotcheck.SpotCheckAverageComplianceScore;
import com.iocl.dhruva2api.model.spotcheck.SpotCheckAverageComplianceScoreId;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * SpotCheckAverageComplianceScoreDAO
 */
public interface SpotCheckAverageComplianceScoreDAO
		extends CrudRepository<SpotCheckAverageComplianceScore, SpotCheckAverageComplianceScoreId> {

	ArrayList<SpotCheckAverageComplianceScore> findByIdInspNo(long inspNo);

	@Query(nativeQuery = true, value = "select implementaion_index  from (  " + 
			"select final.ro_code,final.insp_no,round(final.basic_care) bas,round(final.premium_care) pre,round(final.addon_care) ad,  " + 
			"final.module_count,round((final.basic_care+final.premium_care+final.addon_care)/final.module_count) implementaion_index  " + 
			" from (  " + 
			"select p.ro_code,p.insp_no,p.module_count,  " + 
			"100*sum(  " + 
			"    CASE WHEN B.MODULE_NO=5 and b.ANSWER = 'Yes' THEN 1   " + 
			"    when B.MODULE_NO=5 and b.ANSWER = 'Sometimes' THEN 0.25  " + 
			"    when B.MODULE_NO=5 and b.ANSWER = 'By Some' THEN 0.25  " + 
			"    when B.MODULE_NO=5 and b.ANSWER = 'Mostly' THEN 0.75  " + 
			"    when B.MODULE_NO=5 and b.ANSWER = 'Partly' THEN 0.5  " + 
			"    ELSE 0 END  " + 
			")/sum(decode(B.MODULE_NO,5,1,0)) basic_care,  " + 
			"100*decode(sum(decode(B.MODULE_NO,4,1,0)),0,0,sum(  " + 
			"    CASE WHEN B.MODULE_NO=4 and b.ANSWER = 'Yes' THEN 1   " + 
			"    when B.MODULE_NO=4 and b.ANSWER = 'Sometimes' THEN 0.25  " + 
			"    when B.MODULE_NO=4 and b.ANSWER = 'By Some' THEN 0.25  " + 
			"    when B.MODULE_NO=4 and b.ANSWER = 'Mostly' THEN 0.75  " + 
			"    when B.MODULE_NO=4 and b.ANSWER = 'Partly' THEN 0.5  " + 
			"    ELSE 0 END  " + 
			")/sum(decode(B.MODULE_NO,4,1,0))) premium_care,  " + 
			"100*decode(SUM(CASE WHEN B.MODULE_NO<>5 and B.MODULE_NO<>4 THEN 1 ELSE 0 END),0,0,  " + 
			"SUM(CASE WHEN B.MODULE_NO<>5 and B.MODULE_NO<>4 and b.ANSWER = 'Yes' THEN 1   " + 
			"    when B.MODULE_NO<>5 and B.MODULE_NO<>4  and b.ANSWER = 'Sometimes' THEN 0.25  " + 
			"    when B.MODULE_NO<>5 and B.MODULE_NO<>4  and b.ANSWER = 'By Some' THEN 0.25  " + 
			"    when B.MODULE_NO<>5 and B.MODULE_NO<>4  and b.ANSWER = 'Mostly' THEN 0.75  " + 
			"    when B.MODULE_NO<>5 and B.MODULE_NO<>4  and b.ANSWER = 'Partly' THEN 0.5  " + 
			"    ELSE 0 END)/SUM(CASE WHEN B.MODULE_NO<>5 and B.MODULE_NO<>4 THEN 1 ELSE 0 END)) addon_care  " + 
			"from (  " + 
			"select aa.insp_no,aa.ro_code,bb.module_count from (  " + 
			"select ro_code,updated_on,insp_no from   " + 
			"(SELECT RO_CODE,updated_on,INSP_NO FROM  " + 
			"    SPOT_TRAN_HEADER where insp_no = :inspNo) )AA, (select insp_no,count(distinct module_no) module_count from SPOT_TRAN_ANSWERS where MODULE_NO<>6 group by insp_no) BB where aa.insp_no = bb.insp_no) P  " + 
			"    ,SPOT_TRAN_ANSWERS B where p.insp_no = B.insp_no and b.module_no <> 6 group by p.ro_code, p.insp_no, p.module_count   " + 
			"    ) final) C")
	float averageDhruvaCompliantScore(@Param("inspNo") long inspNo);

}