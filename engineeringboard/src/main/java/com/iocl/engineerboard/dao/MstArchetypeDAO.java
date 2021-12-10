package com.iocl.dhruva2api.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.iocl.dhruva2api.model.common.MstArchetype;

public interface MstArchetypeDAO extends CrudRepository<MstArchetype, Integer> {

	@Query("select archetypeCode from MstArchetype")
	public ArrayList<Integer> findArchetypeCode();
}
