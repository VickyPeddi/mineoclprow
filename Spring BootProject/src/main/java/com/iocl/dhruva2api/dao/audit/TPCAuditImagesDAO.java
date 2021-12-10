package com.iocl.dhruva2api.dao.audit;

import org.springframework.data.repository.CrudRepository;

import com.iocl.dhruva2api.model.audit.TPCAuditImages;
import com.iocl.dhruva2api.model.audit.TPCAuditImagesID;

public interface TPCAuditImagesDAO extends CrudRepository<TPCAuditImages, TPCAuditImagesID> {

}
