package com.iocl.dhruva2api.dao;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.DhruvaCustomer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * DhruvaCustomerDAO
 */
@Transactional
public interface DhruvaCustomerDAO extends CrudRepository<DhruvaCustomer, Integer> {

	ArrayList<DhruvaCustomer> getDhruvaMasterBySalesAreaCodeOrderByRoCode(String salesAreaCode);

	@Query("from DhruvaCustomer where to_char(soCode) like :firstCharacterOfSoCode")
	ArrayList<DhruvaCustomer> getDhruvaMasterByFirstCharacterOfSoCode(
			@Param("firstCharacterOfSoCode") String firstCharacterOfSoCode);

	ArrayList<DhruvaCustomer> getDhruvaMasterByDoCodeOrderByRoCode(int divOffCode);

	ArrayList<DhruvaCustomer> getDhruvaMasterBySoCodeOrderByRoCode(int stateOffCode);

	ArrayList<DhruvaCustomer> findAllByOrderByRoCode();

	@Query("from DhruvaCustomer where attainer='Y' or sauKaSankalp='Y'")
	ArrayList<DhruvaCustomer> findRcaCustomers();

	@Query("Select roCode from DhruvaCustomer where salesAreaCode =:sa ")
	ArrayList<Integer> getRoCodeBySalesAreaCodeOrderByRoCode(@Param("sa") String salesAreaCode);

	@Query("Select roCode from DhruvaCustomer where doCode =:do ")
	ArrayList<Integer> findRoCodeByDoCodeOrderByRoCode(@Param("do") int divOffCode);

	@Query("Select roCode from DhruvaCustomer where soCode =:so ")
	ArrayList<Integer> findRoCodeBySoCodeOrderByRoCode(@Param("so") int stateOffCode);

	@Query("Select roCode from DhruvaCustomer ")
	ArrayList<Integer> findRoCode();

	@Query("select roCode from DhruvaCustomer where to_char(soCode) like :firstCharacterOfSoCode")
	ArrayList<Integer> getRoCodeByFirstCharacterOfSoCode(@Param("firstCharacterOfSoCode") String firstCharacterOfSoCode);

	@Query("select distinct archetypeCode from DhruvaCustomer")
	ArrayList<Integer> findDistinctArchetypeCode();

	ArrayList<DhruvaCustomer> findByArchetypeCodeOrderByRoCode(int archetypeCode);

	ArrayList<DhruvaCustomer> findByPhaseOrderByRoCode(String phase);

	ArrayList<DhruvaCustomer> findByArchetypeCodeAndPhaseOrderByRoCode(int archetypeCode, String phase);
}