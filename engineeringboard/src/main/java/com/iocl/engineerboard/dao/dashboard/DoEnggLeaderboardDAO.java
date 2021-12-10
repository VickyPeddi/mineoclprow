package com.iocl.dhruva2api.dao.dashboard;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.iocl.dhruva2api.model.leaderboard.DoEnggLeaderboard;

public interface DoEnggLeaderboardDAO  extends CrudRepository<DoEnggLeaderboard, String> {

	ArrayList<DoEnggLeaderboard> findAllByOrderByRank();

}