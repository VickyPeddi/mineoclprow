package com.iocl.dhruva2api.dao;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.DOMaster;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * DOMasterDAO
 */
@Transactional
public interface DOMasterDAO extends CrudRepository<DOMaster, String> {

    public ArrayList<DOMaster> getBySalesOrg(String salesOrg);
}