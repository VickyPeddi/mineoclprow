package com.iocl.dhruva2api.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.iocl.dhruva2api.model.activity.MstArchetypeWiseActivity;

/**
 * ArchetypeWiseActivityDao
 */
@Transactional
public interface ArchetypeWiseActivityDao extends CrudRepository<MstArchetypeWiseActivity, Integer>{

    public ArrayList<MstArchetypeWiseActivity> getActivityNoByArchetypeCodeIn(ArrayList<String> archetypeCode);
}