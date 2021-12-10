package com.iocl.dhruva2api.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.iocl.dhruva2api.model.activity.MstFacilityWiseActivity;

/**
 * MstFacilityWiseActivityDAO
 */
@Transactional
public interface MstFacilityWiseActivityDAO extends CrudRepository<MstFacilityWiseActivity, Integer> {

    public ArrayList<MstFacilityWiseActivity> getActivityNoByParameterNameIn(ArrayList<String> parameterList);
}