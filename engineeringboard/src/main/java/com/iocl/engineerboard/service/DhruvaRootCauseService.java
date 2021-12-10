package com.iocl.dhruva2api.service;

import java.util.ArrayList;

import com.iocl.dhruva2api.dao.DhruvaRootCauseDAO;
import com.iocl.dhruva2api.model.rca.DhruvaRootCauseData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DhruvaRootCauseService
 */
@Service
public class DhruvaRootCauseService {

    @Autowired
    private DhruvaRootCauseDAO rootCauseDataDAO;



    public ArrayList<DhruvaRootCauseData> getDhruvaRootCauseDatas() {
        return (ArrayList<DhruvaRootCauseData>) rootCauseDataDAO.findAll();
    }

	
}