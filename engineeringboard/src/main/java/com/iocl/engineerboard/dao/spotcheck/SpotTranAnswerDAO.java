package com.iocl.dhruva2api.dao.spotcheck;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.spotcheck.SpotTranAnswer;
import com.iocl.dhruva2api.model.spotcheck.SpotTranAnswerId;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * SpotTranAnswerDAO
 */
@Transactional
public interface SpotTranAnswerDAO extends CrudRepository<SpotTranAnswer, SpotTranAnswerId> {

	ArrayList<SpotTranAnswer> findByIdInspNoAndIdModuleNo(long inspNo, int moduleNo);
}