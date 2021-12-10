package com.iocl.dhruva2api.service.rca;

import java.util.ArrayList;

import com.iocl.dhruva2api.dao.rca.RootCauseIssuesDAO;
import com.iocl.dhruva2api.model.rca.RootCauseIssues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RootCauseIssuesService
 */
@Service
public class RootCauseIssuesService {

    @Autowired
    private RootCauseIssuesDAO rootCauseIssuesDAO;

    public ArrayList<RootCauseIssues> getRootCauseIssues(int parentCause) {
        return rootCauseIssuesDAO.getByParentCause(parentCause);
    }
}