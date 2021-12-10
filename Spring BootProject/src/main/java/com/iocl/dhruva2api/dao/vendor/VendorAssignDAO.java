package com.iocl.dhruva2api.dao.vendor;

import com.iocl.dhruva2api.model.vendor.VendorAssign;
import com.iocl.dhruva2api.model.vendor.VendorAssignID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * VendorAssignDAO
 */
@Transactional
public interface VendorAssignDAO extends CrudRepository<VendorAssign, VendorAssignID> {

    VendorAssign findByIdRoCodeAndIdQuarterId(String roCode, String quarterId);

    VendorAssign findByIdRoCodeAndIdQuarterIdAndIdVendorCode(String roCode, String quarterId, String vendorCode);

    VendorAssign findByIdRoCodeAndIdQuarterIdAndAuditType(String roCode, String quarterId, String auditType);
}