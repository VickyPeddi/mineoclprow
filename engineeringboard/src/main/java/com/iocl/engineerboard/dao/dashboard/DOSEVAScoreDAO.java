package com.iocl.dhruva2api.dao.dashboard;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.iocl.dhruva2api.model.leaderboard.DOSEVAScore;

public interface DOSEVAScoreDAO extends CrudRepository<DOSEVAScore,String>{

	public ArrayList<DOSEVAScore> getDOSEVAScoreBySalesOrgNameOrderBySevaDesc(String salesOrgName);
}
