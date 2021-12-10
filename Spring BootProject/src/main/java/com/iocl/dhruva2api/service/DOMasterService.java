package com.iocl.dhruva2api.service;

import java.util.ArrayList;

import com.iocl.dhruva2api.dao.DOMasterDAO;
import com.iocl.dhruva2api.model.DOMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DOMasterService
 */
@Service
public class DOMasterService {

    @Autowired
    private DOMasterDAO doMasterDAO;

    public ArrayList<DOMaster> getDOList(String salesOrg) {
        return doMasterDAO.getBySalesOrg(salesOrg);
    }
}