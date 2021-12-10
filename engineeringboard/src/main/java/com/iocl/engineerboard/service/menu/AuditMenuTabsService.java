package com.iocl.dhruva2api.service.menu;

import java.util.ArrayList;

import com.iocl.dhruva2api.dao.menu.AuditMenuTabsDAO;
import com.iocl.dhruva2api.model.menu.AuditMenuTabs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AuditMenuTabsService
 */
@Service
public class AuditMenuTabsService {

    @Autowired
    private AuditMenuTabsDAO auditMenuTabsDAO;

    public ArrayList<AuditMenuTabs> getAuditMenuTabs() {
        return auditMenuTabsDAO.findByActiveFlagOrderBySrNo((short) 1);
    }

}