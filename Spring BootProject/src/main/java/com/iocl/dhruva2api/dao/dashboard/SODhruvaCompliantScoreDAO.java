package com.iocl.dhruva2api.dao.dashboard;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.leaderboard.SODhruvaCompliantScore;

import org.springframework.data.repository.CrudRepository;

/**
 * SODhruvaCompliantScoreDAO
 */
public interface SODhruvaCompliantScoreDAO extends CrudRepository<SODhruvaCompliantScore, Integer> {

    ArrayList<SODhruvaCompliantScore> findAllByOrderByDhruvaCompliantDesc();
}