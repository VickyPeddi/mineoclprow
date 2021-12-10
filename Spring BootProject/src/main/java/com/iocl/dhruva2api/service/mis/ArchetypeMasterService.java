package com.iocl.dhruva2api.service.mis;

import java.util.ArrayList;

import com.iocl.dhruva2api.dao.mis.ArchetypeMasterDAO;
import com.iocl.dhruva2api.model.mis.ArchetypeMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ArchetypeMasterService
 */
@Service
public class ArchetypeMasterService {

    @Autowired
    private ArchetypeMasterDAO archetypeMasterDAO;

    public ArrayList<ArchetypeMaster> getArchetypeMasters() {
        return (ArrayList<ArchetypeMaster>) archetypeMasterDAO.findAll();
    }
}