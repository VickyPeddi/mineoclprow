package com.iocl.dhruva2api.dao.dashboard;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.iocl.dhruva2api.model.leaderboard.DOAWESUMScore;

public interface DOAWESUMScoreDAO extends CrudRepository<DOAWESUMScore, String> {

	ArrayList<DOAWESUMScore> getDOAWESUMScoreBySalesorgNameOrderByAwesumDesc(String salesOrgName);

}
