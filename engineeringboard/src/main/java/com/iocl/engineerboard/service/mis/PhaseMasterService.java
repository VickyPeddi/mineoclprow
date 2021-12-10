package com.iocl.dhruva2api.service.mis;

import java.util.ArrayList;

import com.iocl.dhruva2api.dao.mis.PhaseMasterDAO;
import com.iocl.dhruva2api.model.mis.PhaseMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PhaseMasterService
 */
@Service
public class PhaseMasterService {

    @Autowired
    private PhaseMasterDAO phaseMasterDAO;

    public ArrayList<PhaseMaster> getPhaseMasters() {
        return (ArrayList<PhaseMaster>) phaseMasterDAO.findAll();
    }
}