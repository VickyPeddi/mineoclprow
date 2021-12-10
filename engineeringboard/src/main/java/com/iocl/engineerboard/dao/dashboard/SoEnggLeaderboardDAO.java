package com.iocl.dhruva2api.dao.dashboard;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.iocl.dhruva2api.model.leaderboard.SoEnggLeaderboard;

public interface SoEnggLeaderboardDAO extends CrudRepository<SoEnggLeaderboard,String> {
	ArrayList<SoEnggLeaderboard> findAllByOrderByRank();


}
