package com.iocl.dhruva2api.dao.dashboard;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.iocl.dhruva2api.model.leaderboard.SAAWESUMScore;

public interface SAAWESUMScoreDAO extends CrudRepository<SAAWESUMScore, String> {

	public ArrayList<SAAWESUMScore> getSAAWESUMScoreBySalesoffNameOrderByAwesumDesc(String salesOffName);
}
