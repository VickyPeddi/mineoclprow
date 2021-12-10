package com.iocl.dhruva2api.dao.dashboard;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.iocl.dhruva2api.model.leaderboard.SASEVAScore;

public interface SASEVAScoreDAO extends CrudRepository<SASEVAScore, String> {
	public ArrayList<SASEVAScore> getSASEVAScoreBySalesoffNameOrderBySevaDesc(String salesOffName);


}
