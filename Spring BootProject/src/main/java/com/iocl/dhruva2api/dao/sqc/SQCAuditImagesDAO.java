package com.iocl.dhruva2api.dao.sqc;

import org.springframework.data.repository.CrudRepository;

import com.iocl.dhruva2api.model.sqc.SQCAuditImages;
import com.iocl.dhruva2api.model.sqc.SQCAuditImagesID;

public interface SQCAuditImagesDAO extends CrudRepository<SQCAuditImages, SQCAuditImagesID> {

}
