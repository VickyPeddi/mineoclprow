package com.iocl.dhruva2api.dao.dashboard;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.iocl.dhruva2api.model.leaderboard.DOManagerLeaderboard;

public interface DOManagerLeaderboardDAO extends CrudRepository<DOManagerLeaderboard, Integer> {

	public ArrayList<DOManagerLeaderboard> findAllByOrderByRank();
}
