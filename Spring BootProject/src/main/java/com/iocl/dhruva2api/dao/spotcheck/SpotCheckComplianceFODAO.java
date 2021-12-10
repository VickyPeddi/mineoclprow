package com.iocl.dhruva2api.dao.spotcheck;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.spotcheck.SpotCheckComplianceFO;

import org.springframework.data.repository.CrudRepository;

/**
 * SpotCheckComplianceFODAO
 */
public interface SpotCheckComplianceFODAO extends CrudRepository<SpotCheckComplianceFO, Long> {

	ArrayList<SpotCheckComplianceFO> findBySalesAreaCode(String salesAreaCode);
}