package com.iocl.dhruva2api.dao.resource;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.resource.DhruvaResourceFile;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * DhruvaResourceFileDAO
 */
@Transactional
public interface DhruvaResourceFileDAO extends CrudRepository<DhruvaResourceFile, Long> {

	ArrayList<DhruvaResourceFile> findAllByActiveFlag(char activeFlag);

	@Query(nativeQuery = true, value = "select RESOURCE_DATA from DHRUVA_RESOURCE_FILE where RESOURCE_ID = :id and ACTIVE_FLAG = :af")
	byte[] findResourceFile(@Param("id") long id, @Param("af") char af);

	DhruvaResourceFile findByResourceIdAndActiveFlag(long resourceId, char activeFlag);
}