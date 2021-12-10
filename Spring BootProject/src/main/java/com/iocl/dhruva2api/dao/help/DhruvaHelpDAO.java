package com.iocl.dhruva2api.dao.help;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.help.DhruvaHelp;

import org.springframework.data.repository.CrudRepository;

/**
 * DhruvaHelpDAO
 */
public interface DhruvaHelpDAO extends CrudRepository<DhruvaHelp, Integer> {

	ArrayList<DhruvaHelp> findByActiveFlag(char activeFlag);
}