package com.iocl.dhruva2api.service.rca;

import java.util.ArrayList;

import com.iocl.dhruva2api.dao.rca.RootCauseIssueSupportOptionsDAO;
import com.iocl.dhruva2api.model.rca.RootCauseSupportOptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RootCauseIssueSupportOptionsService
 */
@Service
public class RootCauseIssueSupportOptionsService {

    @Autowired
    private RootCauseIssueSupportOptionsDAO rootCauseSupportOptionsDAO;

    public ArrayList<RootCauseSupportOptions> getRootCauseSupportOptions(int parentIssue) {
        return rootCauseSupportOptionsDAO.getByParentIssue(parentIssue);
    }
}