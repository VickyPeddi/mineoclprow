package com.iocl.dhruva2api.dao.rca;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.iocl.dhruva2api.model.rca.RootCauseSupportOptions;

/**
 * RootCauseIssueSupportOptionsDAO
 */
@Transactional
public interface RootCauseIssueSupportOptionsDAO extends CrudRepository<RootCauseSupportOptions, Integer> {

    public ArrayList<RootCauseSupportOptions> getByParentIssue(int parentIssue);
}