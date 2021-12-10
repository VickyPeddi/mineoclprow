package com.iocl.dhruva2api.dao.spotcheck;

import com.iocl.dhruva2api.model.spotcheck.SpotCheckAtr;
import com.iocl.dhruva2api.model.spotcheck.SpotCheckAtrID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * SpotCheckAtrDAO
 */
@Transactional
public interface SpotCheckAtrDAO extends CrudRepository<SpotCheckAtr, SpotCheckAtrID> {

}