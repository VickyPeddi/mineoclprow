package com.iocl.dhruva2api.dao.dashboard;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.iocl.dhruva2api.model.leaderboard.SAFITScore;

public interface SAFITScoreDAO extends CrudRepository<SAFITScore,String>{

	public ArrayList<SAFITScore> getSAFITScoreBySalesoffNameOrderByFitDesc(String salesOffName);
}
