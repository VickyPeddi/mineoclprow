package com.iocl.dhruva2api.dao.audit;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iocl.dhruva2api.model.audit.FOAuditMaster;



public interface FOAuditDAO extends CrudRepository<FOAuditMaster, Long> {

	ArrayList<FOAuditMaster> getFOAuditMasterBySalesArea(String salesGrp);

	ArrayList<FOAuditMaster> getFOAuditMasterByDoCode(int locationCode);

	ArrayList<FOAuditMaster> getFOAuditMasterBySoCode(int locationCode);

	@Query("from FOAuditMaster where to_char(soCode) like :firstCharacterOfSoCode")
	ArrayList<FOAuditMaster> getFOAuditMasterByRegion(@Param("firstCharacterOfSoCode") String string);


}
