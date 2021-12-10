package com.iocl.dhruva2api.dao;


import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.iocl.dhruva2api.model.activity.ActivityMaster;

/**
 * ActivityMasterDAO
 */
@Transactional
public interface ActivityMasterDAO extends CrudRepository<ActivityMaster, Integer> {

    public ArrayList<ActivityMaster> getActivityMasterByActivityNoIn(ArrayList<Integer> activityNo);
}