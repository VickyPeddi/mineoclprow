package com.iocl.dhruva2api.service.vendor;

import java.util.Date;

import com.iocl.dhruva2api.dao.vendor.VendorAdminDAO;
import com.iocl.dhruva2api.model.vendor.VendorAdmin;
import com.iocl.dhruva2api.model.vendor.VendorAdminInputData;
import com.iocl.dhruva2api.service.EmployeeMasterService;
import com.iocl.dhruva2api.service.mail.EmailService;
import com.iocl.dhruva2api.util.DateUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * VendorAdminService
 */
@Service
public class VendorAdminService {

	@Autowired
	private VendorAdminDAO vendorAdminDAO;

	@Autowired
	private EmployeeMasterService emMasterService;

	@Autowired
	private EmailService emailService;

	public int saveVendorAdminDetails(VendorAdminInputData vendorDetails, String userId) {

		// VendorAdminId vendorAdminId = new
		// VendorAdminId(vendorDetails.getVendorCode(),
		// DateUtils.fetchCurrentQuarter());

		VendorAdmin vendorAdminDetails = new VendorAdmin(vendorDetails.getVendorCode(),
				DateUtils.fetchCurrentFinancialQuarter(), vendorDetails.getVendorName(), vendorDetails.getVendorAddress(),
				vendorDetails.getVendorWorkOrder(),
				DateUtils.convertStringToDate(vendorDetails.getVendorValidFrom(), "yyyy-MM-dd"),
				DateUtils.convertStringToDate(vendorDetails.getVendorValidTo(), "yyyy-MM-dd"),
				vendorDetails.getVendorAdminName(), vendorDetails.getVendorAdminEmail(),
				Long.parseLong(vendorDetails.getVendorAdminCell()), emMasterService.getUserDetails(Integer.parseInt(userId)),
				new Date(), "", "", "A");

		vendorAdminDAO.save(vendorAdminDetails);

		new Thread(() -> {
			sendVendorAdminMail(vendorAdminDetails);
		}).start();

		return 1;
	}

	private void sendVendorAdminMail(VendorAdmin vendorAdminDetails) {

		String from = "retaildashboard@indianoil.in";
		String subject = "Vendor Administration Assignment for M/s " + vendorAdminDetails.getVendorName();
		String portalLink = "https://uat.indianoil.co.in/DhruvaVendorAdminPortal";

		String body = "Dear <b>" + vendorAdminDetails.getVendorAdminName() + "</b>,<br/><br/>"
				+ "You have been assigned the role of the Admin for M/s <b>" + vendorAdminDetails.getVendorName() + "</b><br/>"
				+ "Kindly complete the registration by clicking at the below link:<br/><a href='" + portalLink + "'>"
				+ portalLink + "</a>" + "<br/><br/>" + "Regards,<br/>Team IOCL";

		emailService.sendSimpleMessage(from, vendorAdminDetails.getVendorAdminEmail(), null, subject, body, true);
	}
}