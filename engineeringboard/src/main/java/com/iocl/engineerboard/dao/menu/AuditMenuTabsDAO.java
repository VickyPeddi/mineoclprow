package com.iocl.dhruva2api.dao.menu;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.menu.AuditMenuTabs;

import org.springframework.data.repository.CrudRepository;

/**
 * AuditMenuTabsDAO
 */
public interface AuditMenuTabsDAO extends CrudRepository<AuditMenuTabs, Long> {

    ArrayList<AuditMenuTabs> findByActiveFlagOrderBySrNo(short activeFlag);
}