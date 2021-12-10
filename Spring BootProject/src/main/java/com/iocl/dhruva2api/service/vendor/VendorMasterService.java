package com.iocl.dhruva2api.service.vendor;

import com.iocl.dhruva2api.dao.vendor.VendorMasterDAO;
import com.iocl.dhruva2api.model.vendor.VendorMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * VendorMasterService
 */
@Service
public class VendorMasterService {

	@Autowired
	private VendorMasterDAO vendorMasterDAO;

	public VendorMaster getVendormaster(String vendorCode) {
		return vendorMasterDAO.findById(vendorCode).orElse(new VendorMaster());
	}

}