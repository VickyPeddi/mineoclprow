package com.iocl.dhruva2api.dao.vendor;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.vendor.VendorManage;

import org.springframework.data.repository.CrudRepository;

/**
 * VendorManageDAO
 */
public interface VendorManageDAO extends CrudRepository<VendorManage, String> {

    ArrayList<VendorManage> findByVendorRole(String vendorRoles);
}