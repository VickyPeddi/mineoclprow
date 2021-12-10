package com.iocl.dhruva2api.dao.spotcheck;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.spotcheck.ArchetypeWiseModule;

import org.springframework.data.repository.CrudRepository;

/**
 * ArchetypeWiseModuleDAO
 */
public interface ArchetypeWiseModuleDAO extends CrudRepository<ArchetypeWiseModule, Integer> {

    public ArrayList<ArchetypeWiseModule> getCompleteModuleByArchetypeCodeIn(ArrayList<String> archetypeCode);
        
}