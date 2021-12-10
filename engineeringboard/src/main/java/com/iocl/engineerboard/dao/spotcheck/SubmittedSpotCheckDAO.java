package com.iocl.dhruva2api.dao.spotcheck;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.spotcheck.SubmittedSpotCheck;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SubmittedSpotCheckDAO extends CrudRepository<SubmittedSpotCheck, Long>{

	@Query("from SubmittedSpotCheck where retailOutlet.salesAreaCode = :salesGroup and to_char(inspDate,'yyyymmdd') between :fromDate and :toDate")
	ArrayList<SubmittedSpotCheck> getSubmittedSpotCheckBySalesArea(@Param("salesGroup") String salesGrp,@Param("fromDate") String from,
			@Param("toDate") String to);
	
	@Query("from SubmittedSpotCheck where retailOutlet.doCode = :locationCode and to_char(inspDate,'yyyymmdd') between :fromDate and :toDate")
	ArrayList<SubmittedSpotCheck> getSubmittedSpotCheckByDoCode(@Param("locationCode") int locationCode,@Param("fromDate") String from,
			@Param("toDate") String to);

	@Query("from SubmittedSpotCheck where substr(retailOutlet.soCode,0,1) = :locationCode and to_char(inspDate,'yyyymmdd') between :fromDate and :toDate")
	ArrayList<SubmittedSpotCheck> getSubmittedSpotCheckByRegion(@Param("locationCode") String firstCharacter,@Param("fromDate") String from,
			@Param("toDate") String to);

	@Query("from SubmittedSpotCheck where retailOutlet.soCode = :locationCode and to_char(inspDate,'yyyymmdd') between :fromDate and :toDate")
	ArrayList<SubmittedSpotCheck> getSubmittedSpotCheckBySoCode(@Param("locationCode") int locationCode,@Param("fromDate") String from,
			@Param("toDate") String to);
	
	@Query("from SubmittedSpotCheck where to_char(inspDate,'yyyymmdd') between :fromDate and :toDate")
	ArrayList<SubmittedSpotCheck> getAllSubmittedSpotCheck(@Param("fromDate") String from,
			@Param("toDate") String to);

	
}
