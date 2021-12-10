package com.iocl.dhruva2api.service;

import java.util.ArrayList;

import com.iocl.dhruva2api.dao.MstFacilityWiseActivityDAO;
import com.iocl.dhruva2api.model.activity.MstFacilityWiseActivity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MstFacilityWiseActivityService
 */
@Service
public class MstFacilityWiseActivityService {

    @Autowired
    private MstFacilityWiseActivityDAO facilityWiseActivityDAO;

    public ArrayList<MstFacilityWiseActivity> getActivityNoByParameterNameIn(ArrayList<String> parameterList) {
        return facilityWiseActivityDAO.getActivityNoByParameterNameIn(parameterList);
    }
}