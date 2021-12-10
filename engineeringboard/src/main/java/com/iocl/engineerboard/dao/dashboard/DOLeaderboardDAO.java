package com.iocl.dhruva2api.dao.dashboard;

import com.iocl.dhruva2api.model.leaderboard.DOLeaderboard;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * DOLeaderboardDAO
 */
public interface DOLeaderboardDAO extends CrudRepository<DOLeaderboard, String> {

	ArrayList<DOLeaderboard> findAllByOrderByRank();

	ArrayList<DOLeaderboard> findBySoMasterOrderByRank(String soMaster);
	
	DOLeaderboard findByDoMasterOrderByRank(String doMaster);
	@Query("select doMaster from DOLeaderboard order by doMaster")
	ArrayList<String> getAllDo();
}