package com.iocl.dhruva2api.service.audituserdocs;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iocl.dhruva2api.dao.audituserdocs.AuditUserDocumentsDAO;
import com.iocl.dhruva2api.dao.audituserdocs.RegisteredAuditUserDAO;
import com.iocl.dhruva2api.dao.vendor.VendorAdminDAO;
import com.iocl.dhruva2api.model.AuditUserDocuments;
import com.iocl.dhruva2api.model.AuditUserMaster;
import com.iocl.dhruva2api.model.vendor.VendorAdmin;

@Service
public class RegisteredAuditUserService {

	@Autowired
	private RegisteredAuditUserDAO registeredAuditUserDAO;

	@Autowired
	private AuditUserDocumentsDAO auditUserDocumentsDAO;

	@Autowired
	private VendorAdminDAO vendorAdminDAO;

	public ArrayList<AuditUserMaster> getRegisteredAuditUsers() {
		ArrayList<AuditUserMaster> auditUsersList = registeredAuditUserDAO.findAllByEmpStatusAndStatus("A", 2);
		auditUsersList.forEach(auditUser -> {
			auditUser.setVendorAdminName(
					vendorAdminDAO.findById(auditUser.getVendorAdminCode()).orElse(new VendorAdmin()).getVendorName());
		});
		return auditUsersList;
	}

	public byte[] getAuditUserDocuments(String auditUserId, String documentName) {
		AuditUserDocuments auditUserDocuments = auditUserDocumentsDAO.findById(auditUserId).orElse(new AuditUserDocuments());
		if (documentName.equals("id-proof")) {
			return auditUserDocuments.getIdProof();
		} else if (documentName.equals("education-proof")) {
			return auditUserDocuments.getEducationProof();
		} else if (documentName.equals("photograph")) {
			return auditUserDocuments.getPhotograph();
		}
		return null;
	}

}
