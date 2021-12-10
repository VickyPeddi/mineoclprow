package com.iocl.dhruva2api.dao.dashboard;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.leaderboard.SOSEVAScore;

import org.springframework.data.repository.CrudRepository;

/**
 * SOSEVAScoreDAO
 */
public interface SOSEVAScoreDAO extends CrudRepository<SOSEVAScore, Integer> {

    ArrayList<SOSEVAScore> findAllByOrderBySevaDesc();
}