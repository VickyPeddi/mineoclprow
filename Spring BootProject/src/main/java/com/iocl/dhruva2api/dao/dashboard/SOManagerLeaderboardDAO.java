package com.iocl.dhruva2api.dao.dashboard;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.iocl.dhruva2api.model.leaderboard.SOManagerLeaderboard;

public interface SOManagerLeaderboardDAO extends CrudRepository<SOManagerLeaderboard, Integer> {

	public ArrayList<SOManagerLeaderboard> findAllByOrderByRank();
}
