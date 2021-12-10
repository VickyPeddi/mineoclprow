package com.iocl.dhruva2api.service.vendor;

import java.util.ArrayList;

import com.iocl.dhruva2api.dao.auditor.AuditorAdminDAO;
import com.iocl.dhruva2api.dao.vendor.VendorAdminDAO;
import com.iocl.dhruva2api.dao.vendor.VendorManageDAO;
import com.iocl.dhruva2api.model.vendor.VendorManage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * VendorManageService
 */
@Service
public class VendorManageService {

	@Autowired
	private VendorManageDAO vendorManageDAO;

	@Autowired
	private VendorAdminDAO vendorAdminDAO;

	@Autowired
	private AuditorAdminDAO auditorAdminDAO;

	public ArrayList<VendorManage> getVendorManageDatas(String personnelType) {

		switch (personnelType) {
		case "0":
			return (ArrayList<VendorManage>) vendorManageDAO.findAll();
		case "1":
			return vendorManageDAO.findByVendorRole("VendorAdmin");
		case "2":
			return vendorManageDAO.findByVendorRole("Auditor");
		case "3":
			return vendorManageDAO.findByVendorRole("Reviewer");
		default:
			return new ArrayList<>();
		}
	}

	public int toggleVendorState(String vendorCode, String state) {

		if (vendorCode.contains("A") || vendorCode.contains("R")) {
			return auditorAdminDAO.toggleAuditorReviewerState(state, vendorCode);
		} else {
			return vendorAdminDAO.toggleVendorState(state, vendorCode);
		}
	}
}