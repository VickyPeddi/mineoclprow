package com.iocl.dhruva2api.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iocl.dhruva2api.model.employee.MstEmpJurisdiction;

public interface EmpJurisdictionDao extends CrudRepository<MstEmpJurisdiction, Integer> {
	
	//In database table we are storing just two initial characters of PA code.
	
	@Query("select userLevel from MstEmpJurisdiction where paCodeLike = :paCodeLike and psaCode = :psaCode")
	public String getUserLevelByPaAndPsa(@Param("paCodeLike") String paCode,@Param("psaCode") String psaCode);

}
