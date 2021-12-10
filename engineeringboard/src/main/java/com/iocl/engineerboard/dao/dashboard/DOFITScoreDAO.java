package com.iocl.dhruva2api.dao.dashboard;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.iocl.dhruva2api.model.leaderboard.DOFITScore;

public interface DOFITScoreDAO extends CrudRepository<DOFITScore,String>{

	public ArrayList<DOFITScore> getDOFITScoreBySalesOrgNameOrderByFitDesc(String salesOrgName);
}
