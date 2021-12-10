package com.iocl.dhruva2api.service;

import java.util.ArrayList;

import com.iocl.dhruva2api.dao.ActivityMasterDAO;
import com.iocl.dhruva2api.model.activity.ActivityMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ActivityMasterService
 */
@Service
public class ActivityMasterService {

    @Autowired
    public ActivityMasterDAO masterDAO;

    public ArrayList<ActivityMaster> getActivityMasters(ArrayList<Integer> activityNos) {
        return (ArrayList<ActivityMaster>) masterDAO.getActivityMasterByActivityNoIn(activityNos);
    }
}