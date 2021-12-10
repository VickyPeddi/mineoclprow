package com.iocl.dhruva2api.service.menu;

import com.iocl.dhruva2api.dao.menu.MISMenuItemsDAO;
import com.iocl.dhruva2api.model.MISMenuItems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MISMenuItemsService
 */
@Service
public class MISMenuItemsService {

    @Autowired
    private MISMenuItemsDAO misMenuItemsDAO;

    public MISMenuItems getReport(long id) {
        // return misMenuItemsDAO.findOne(id);
        return misMenuItemsDAO.findByActiveFlagAndRepId((short) 1, id);
    }
}