package com.iocl.dhruva2api.dao.vendor;

import com.iocl.dhruva2api.model.vendor.VendorAdmin;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * VendorAdminDAO
 */
@Transactional
public interface VendorAdminDAO extends CrudRepository<VendorAdmin, String> {

	@Modifying
	@Query("update VendorAdmin set empStatus = :empStat where vendorCode = :vendCode")
	public int toggleVendorState(@Param("empStat") String empStat, @Param("vendCode") String vendCode);
}