package com.iocl.dhruva2api.dao.vendor;

import com.iocl.dhruva2api.model.vendor.VendorAssignError;
import com.iocl.dhruva2api.model.vendor.VendorAssignErrorID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * VendorAssignErrorDAO
 */
@Transactional
public interface VendorAssignErrorDAO extends CrudRepository<VendorAssignError, VendorAssignErrorID> {

}