package com.iocl.dhruva2api.dao.audituserdocs;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.iocl.dhruva2api.model.AuditUserMaster;

public interface RegisteredAuditUserDAO extends CrudRepository<AuditUserMaster, String> {
	
	ArrayList<AuditUserMaster> findAllByEmpStatusAndStatus(String empStatus, int status);
	
}
