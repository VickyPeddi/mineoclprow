package com.iocl.dhruva2api.dao.dashboard;

import com.iocl.dhruva2api.model.leaderboard.SOLeaderboard;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

/**
 * SOLeaderboardDAO
 */
public interface SOLeaderboardDAO extends CrudRepository<SOLeaderboard, String> {

	ArrayList<SOLeaderboard> findAllByOrderByRank();

	SOLeaderboard findBySoMaster(String soMaster);
}