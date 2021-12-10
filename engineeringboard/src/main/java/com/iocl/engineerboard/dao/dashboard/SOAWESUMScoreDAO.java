package com.iocl.dhruva2api.dao.dashboard;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.leaderboard.SOAWESUMScore;

import org.springframework.data.repository.CrudRepository;

/**
 * SOAWESUMScoreDAO
 */
public interface SOAWESUMScoreDAO extends CrudRepository<SOAWESUMScore, Integer> {

    public ArrayList<SOAWESUMScore> findAllByOrderByAwesumDesc();

    SOAWESUMScore findBySoMaster(String soMaster);
}