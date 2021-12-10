package com.iocl.dhruva2api.service.employee;

import com.iocl.dhruva2api.dao.employee.DhruvaAdminDAO;
import com.iocl.dhruva2api.model.employee.DhruvaAdmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DhruvaAdminService
 */
@Service
public class DhruvaAdminService {

    @Autowired
    private DhruvaAdminDAO dhruvaAdminDAO;

    public DhruvaAdmin getDhruvaAdmin(int empCode) {
        return dhruvaAdminDAO.findByEmpCodeAndActiveFlag(empCode, (short) 1);
    }
}