package com.iocl.dhruva2api.dao.dashboard;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.leaderboard.SOFITScore;

import org.springframework.data.repository.CrudRepository;

/**
 * SOFITScoreDAO
 */
public interface SOFITScoreDAO extends CrudRepository<SOFITScore, Integer> {

    public ArrayList<SOFITScore> findAllByOrderByFit();

	public ArrayList<SOFITScore> findAllByOrderByFitDesc();
}