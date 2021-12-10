package com.iocl.dhruva2api.dao.spotcheck;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.spotcheck.SpotCheckComplianceDRSM;

import org.springframework.data.repository.CrudRepository;

/**
 * SpotCheckComplianceDRSMDAO
 */
public interface SpotCheckComplianceDRSMDAO extends CrudRepository<SpotCheckComplianceDRSM, Long> {

  ArrayList<SpotCheckComplianceDRSM> findBySalesAreaCode(String salesAreaCode);
}