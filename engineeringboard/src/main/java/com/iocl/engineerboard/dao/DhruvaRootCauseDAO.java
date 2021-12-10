package com.iocl.dhruva2api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.iocl.dhruva2api.model.rca.DhruvaRootCauseData;

/**
 * DhruvaRootCauseDAO
 */
@Transactional
public interface DhruvaRootCauseDAO extends CrudRepository<DhruvaRootCauseData, Integer> {

}