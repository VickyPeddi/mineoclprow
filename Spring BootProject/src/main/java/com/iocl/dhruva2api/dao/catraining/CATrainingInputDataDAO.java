package com.iocl.dhruva2api.dao.catraining;

import com.iocl.dhruva2api.model.catraining.CATrainingInputData;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * CATrainingInputDataDAO
 */
@Transactional
public interface CATrainingInputDataDAO extends CrudRepository<CATrainingInputData, String> {

}