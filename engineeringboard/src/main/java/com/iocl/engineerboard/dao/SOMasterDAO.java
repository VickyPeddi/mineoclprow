package com.iocl.dhruva2api.dao;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.SOMaster;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * SODOMasterDAO
 */
@Transactional
public interface SOMasterDAO extends CrudRepository<SOMaster, String> {

//    @Query(value = "select * from VW_SO", nativeQuery = true)
//    public ArrayList<Object[]> getSO();
	
	@Query("from SOMaster where to_char(salesOrg) like :firstCharacterOfSoCode")
	public ArrayList<SOMaster> getStateOfficesByFirstCharacterOfSoCode(@Param("firstCharacterOfSoCode") String firstCharacterOfSoCode);
   
}