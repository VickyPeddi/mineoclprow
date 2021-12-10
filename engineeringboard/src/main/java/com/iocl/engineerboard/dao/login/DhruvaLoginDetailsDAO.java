package com.iocl.dhruva2api.dao.login;

import com.iocl.dhruva2api.model.login.DhruvaLoginDetails;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * DhruvaLoginDetailsDAO
 */
@Transactional
public interface DhruvaLoginDetailsDAO extends CrudRepository<DhruvaLoginDetails, Long> {

}