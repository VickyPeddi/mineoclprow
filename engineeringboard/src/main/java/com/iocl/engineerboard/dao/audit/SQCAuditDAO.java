package com.iocl.dhruva2api.dao.audit;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iocl.dhruva2api.model.audit.SQCAuditMaster;

public interface SQCAuditDAO extends CrudRepository<SQCAuditMaster, Long> {

	ArrayList<SQCAuditMaster> getSQCAuditMasterBySalesArea(String salesGrp);

	ArrayList<SQCAuditMaster> getSQCAuditMasterByDoCode(int locationCode);

	ArrayList<SQCAuditMaster> getSQCAuditsMasterBySoCode(int locationCode);

	@Query("from SQCAuditMaster where to_char(soCode) like :firstCharacterOfSoCode")
	ArrayList<SQCAuditMaster> getSQCAuditMasterByRegion(@Param("firstCharacterOfSoCode") String string);

}
