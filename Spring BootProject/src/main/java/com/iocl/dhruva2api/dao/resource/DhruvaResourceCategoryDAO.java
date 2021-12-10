package com.iocl.dhruva2api.dao.resource;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.resource.DhruvaResourceCategory;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * DhruvaResourceCategoryDAO
 */
@Transactional
public interface DhruvaResourceCategoryDAO extends CrudRepository<DhruvaResourceCategory, Long> {

	@Query("from DhruvaResourceCategory where activeFlag = :activeFlag order by categoryId")
	ArrayList<DhruvaResourceCategory> findAllByActiveFlagByOrderByCategoryId(@Param("activeFlag") char activeFlag);
}