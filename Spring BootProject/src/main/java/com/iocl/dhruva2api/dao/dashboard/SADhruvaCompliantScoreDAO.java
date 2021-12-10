package com.iocl.dhruva2api.dao.dashboard;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.iocl.dhruva2api.model.leaderboard.SADhruvaCompliant;

public interface SADhruvaCompliantScoreDAO extends CrudRepository<SADhruvaCompliant, String> {
 
	public ArrayList<SADhruvaCompliant> getSADhruvaCompliantBySalesoffNameOrderByDhruvaCompliantDesc(String salesOffName);
} 