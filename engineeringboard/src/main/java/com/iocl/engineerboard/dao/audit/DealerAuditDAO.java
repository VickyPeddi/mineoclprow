package com.iocl.dhruva2api.dao.audit;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iocl.dhruva2api.model.audit.DealerAuditMaster;

public interface DealerAuditDAO extends CrudRepository<DealerAuditMaster, Long> {

	ArrayList<DealerAuditMaster> getDealerAuditMasterBySalesArea(String salesGrp);

	ArrayList<DealerAuditMaster> getDealerAuditMasterByDoCode(int locationCode);

	ArrayList<DealerAuditMaster> getDealerAuditMasterBySoCode(int locationCode);

	@Query("from DealerAuditMaster where to_char(soCode) like :firstCharacterOfSoCode")
	ArrayList<DealerAuditMaster> getDealerAuditMasterByRegion(@Param("firstCharacterOfSoCode") String string);

}
