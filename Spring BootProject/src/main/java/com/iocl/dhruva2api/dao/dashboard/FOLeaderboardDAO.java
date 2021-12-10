package com.iocl.dhruva2api.dao.dashboard;

import com.iocl.dhruva2api.model.leaderboard.FOLeaderboard;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

/**
 * FOLeaderboardDAO
 */
public interface FOLeaderboardDAO extends CrudRepository<FOLeaderboard, String> {

	ArrayList<FOLeaderboard> findAllByOrderByRank();
	FOLeaderboard getFOLeaderboardBySaMaster(String saMaster);
	ArrayList<FOLeaderboard> getFOLeaderboardByDoMasterOrderByRank(String doMaster);
}