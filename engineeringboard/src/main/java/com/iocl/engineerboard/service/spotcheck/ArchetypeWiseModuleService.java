package com.iocl.dhruva2api.service.spotcheck;

import java.util.ArrayList;

import com.iocl.dhruva2api.dao.spotcheck.ArchetypeWiseModuleDAO;
import com.iocl.dhruva2api.model.spotcheck.ArchetypeWiseModule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ArchetypeWiseModuleService
 */
@Service
public class ArchetypeWiseModuleService {

	@Autowired
	private ArchetypeWiseModuleDAO archetypeWiseModuleDAO;

	public ArrayList<ArchetypeWiseModule> getModules(String archetypeCode) {
		ArrayList<String> archetypeCodes = new ArrayList<>();
		archetypeCodes.add("*");
		archetypeCodes.add(archetypeCode);
		return archetypeWiseModuleDAO.getCompleteModuleByArchetypeCodeIn(archetypeCodes);
	}

	public ArrayList<ArchetypeWiseModule> getAllModules() {
		return (ArrayList<ArchetypeWiseModule>) archetypeWiseModuleDAO.findAll();
	}
}