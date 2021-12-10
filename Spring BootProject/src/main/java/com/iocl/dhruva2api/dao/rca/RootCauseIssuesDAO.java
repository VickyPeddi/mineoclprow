package com.iocl.dhruva2api.dao.rca;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.iocl.dhruva2api.model.rca.RootCauseIssues;

/**
 * RootCauseIssuesDAO
 */
@Transactional
public interface RootCauseIssuesDAO extends CrudRepository<RootCauseIssues, Integer> {

    public ArrayList<RootCauseIssues> getByParentCause(int parentCause);

}