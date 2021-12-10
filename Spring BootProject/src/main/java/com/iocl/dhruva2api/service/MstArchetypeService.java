package com.iocl.dhruva2api.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iocl.dhruva2api.dao.MstArchetypeDAO;

@Service
public class MstArchetypeService {

	@Autowired
	private MstArchetypeDAO mstArchetypeDao;
	
	public ArrayList<Integer> getAllArchetype(){
		return mstArchetypeDao.findArchetypeCode();
	}
}
