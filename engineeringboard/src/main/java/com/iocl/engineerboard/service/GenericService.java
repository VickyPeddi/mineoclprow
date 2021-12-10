package com.iocl.dhruva2api.service;

import java.util.ArrayList;

import com.iocl.dhruva2api.dao.GenericDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * GenericService
 */
@Service
public class GenericService {

    @Autowired
    private GenericDAO genericDAO;

    public ArrayList<String> getTableHeaders(String query) {
        return genericDAO.getTableHeaders(query);
    }
}