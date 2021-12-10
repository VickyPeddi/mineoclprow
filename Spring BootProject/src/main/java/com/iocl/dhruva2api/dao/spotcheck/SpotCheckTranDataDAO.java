package com.iocl.dhruva2api.dao.spotcheck;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.spotcheck.SpotCheckTranData;

import org.springframework.data.repository.CrudRepository;

/**
 * SpotCheckTranDataDAO
 */
public interface SpotCheckTranDataDAO extends CrudRepository<SpotCheckTranData, Long> {

	ArrayList<SpotCheckTranData> findByInspNoAndModuleNoAndAnswer(long inspNo, int moduleNo, String answer);

	ArrayList<SpotCheckTranData> findByInspNoAndModuleNoAndAnswerNot(long inspNo, int moduleNo, String answer);

	ArrayList<SpotCheckTranData> findByInspNoAndStatus(long inspNo, int status);
}