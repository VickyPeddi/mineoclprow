package com.iocl.dhruva2api.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.iocl.dhruva2api.model.activity.ActivityFileId;
import com.iocl.dhruva2api.model.activity.ActivityFileTran;

/**
 * ActivitiesFileTranDAO
 */
@Transactional
public interface ActivitiesFileTranDAO extends CrudRepository<ActivityFileTran, ActivityFileId> {

    @Query("select docName from ActivityFileTran where embeddedKey.roCode = :roCode")
    public ArrayList<String> getDocNameByRoCode(@Param("roCode") int roCode);

    public ActivityFileTran getByDocName(String docName);
}