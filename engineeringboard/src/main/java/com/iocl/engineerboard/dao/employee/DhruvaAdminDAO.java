package com.iocl.dhruva2api.dao.employee;

import com.iocl.dhruva2api.model.employee.DhruvaAdmin;

import org.springframework.data.repository.CrudRepository;

/**
 * DhruvaAdminDAO
 */
public interface DhruvaAdminDAO extends CrudRepository<DhruvaAdmin, Integer> {

    DhruvaAdmin findByEmpCodeAndActiveFlag(int empCode, short activeFlag);
}