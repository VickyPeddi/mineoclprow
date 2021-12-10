package com.iocl.dhruva2api.service.vendor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.iocl.dhruva2api.config.JDBCDatabaseConfig;
import com.iocl.dhruva2api.dao.DhruvaCustomerDAO;
import com.iocl.dhruva2api.dao.vendor.VendorAdminDAO;
import com.iocl.dhruva2api.dao.vendor.VendorAssignDAO;
import com.iocl.dhruva2api.dao.vendor.VendorAssignErrorDAO;
import com.iocl.dhruva2api.model.DhruvaCustomer;
import com.iocl.dhruva2api.model.vendor.VendorAssign;
import com.iocl.dhruva2api.model.vendor.VendorAssignError;
import com.iocl.dhruva2api.model.vendor.VendorAssignErrorID;
import com.iocl.dhruva2api.model.vendor.VendorAssignID;
import com.iocl.dhruva2api.model.vendor.VendorAssignInputData;
import com.iocl.dhruva2api.model.vendor.VendorAssignOptionData;
import com.iocl.dhruva2api.service.EmployeeMasterService;
import com.iocl.dhruva2api.util.DateUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * VendorAssignService
 */
@Service
public class VendorAssignService {

	@Autowired
	private VendorAssignDAO vendorAssignDAO;

	@Autowired
	private VendorAssignErrorDAO vendorAssignErrorDAO;

	@Autowired
	private VendorAdminDAO vendorAdminDAO;

	@Autowired
	private DhruvaCustomerDAO dhruvaCustomerDAO;

	@Autowired
	private EmployeeMasterService emMasterService;

	@Autowired
	private JDBCDatabaseConfig databaseConfig;

	public int saveVendorAssignUploadData(ArrayList<VendorAssignInputData> inputDatas, String userId) {

		inputDatas.forEach(inputData -> {

			if (verifyVendorAssignData(userId, inputData)) {
				if ("R".equals(inputData.getAuditType())) {
					if (vendorAssignDAO.findByIdRoCodeAndIdQuarterIdAndIdVendorCode(inputData.getSapCode(),
							inputData.getAuditQuarter(), inputData.getVendorCode()) == null
							&& vendorAssignDAO.findByIdRoCodeAndIdQuarterIdAndAuditType(inputData.getSapCode(),
									inputData.getAuditQuarter(), "R") == null) {
						acceptedVendorAssignData(userId, inputData);
					} else {
						rejectedVendorAssignData(userId, inputData, "RO already allocated to vendor for the particular quarter");
					}
				} else if ("C".equals(inputData.getAuditType())) {
					if (vendorAssignDAO.findByIdRoCodeAndIdQuarterIdAndIdVendorCode(inputData.getSapCode(),
							inputData.getAuditQuarter(), inputData.getVendorCode()) == null
							&& vendorAssignDAO.findByIdRoCodeAndIdQuarterIdAndAuditType(inputData.getSapCode(),
									inputData.getAuditQuarter(), "C") == null) {
						acceptedVendorAssignData(userId, inputData);
					} else {
						rejectedVendorAssignData(userId, inputData, "RO already allocated to vendor for the particular quarter");
					}
				} else {
					rejectedVendorAssignData(userId, inputData, "Audit type not specified or invalid");
				}
			}
		});

		return 1;
	}

	private void acceptedVendorAssignData(String userId, VendorAssignInputData inputData) {
		VendorAssignID newVendorAssignID = new VendorAssignID(inputData.getAuditQuarter(), inputData.getSapCode(),
				inputData.getVendorCode());
		VendorAssign newVendorAssign = new VendorAssign(newVendorAssignID, inputData.getAuditType(),
				DateUtils.convertStringToDate(inputData.getStartDate(), "dd-MM-yyyy"),
				DateUtils.convertStringToDate(inputData.getEndDate(), "dd-MM-yyyy"),
				emMasterService.getUserDetails(Integer.parseInt(userId)), new Date());

		vendorAssignDAO.save(newVendorAssign);
	}

	private void rejectedVendorAssignData(String userId, VendorAssignInputData inputData, String reason) {
		VendorAssignErrorID newVendorAssignID = new VendorAssignErrorID(inputData.getAuditQuarter(), inputData.getSapCode(),
				inputData.getVendorCode());
		VendorAssignError newVendorAssign = new VendorAssignError(newVendorAssignID, inputData.getAuditType(),
				DateUtils.convertStringToDate(inputData.getStartDate(), "dd-MM-yyyy"),
				DateUtils.convertStringToDate(inputData.getEndDate(), "dd-MM-yyyy"),
				emMasterService.getUserDetails(Integer.parseInt(userId)), new Date(), reason);

		vendorAssignErrorDAO.save(newVendorAssign);
	}

	private boolean verifyVendorAssignData(String userId, VendorAssignInputData inputData) {

		Date fromDate = null;
		Date toDate = null;

		if (!dhruvaCustomerDAO.existsById(Integer.parseInt(inputData.getSapCode()))) {
			rejectedVendorAssignData(userId, inputData, "Invalid or not a Dhruva RO");
			return false;
		}

		// if (vendorAdminDAO
		// .findOne(new VendorAdminId(inputData.getVendorCode(),
		// DateUtils.fetchCurrentQuarter())) == null) {
		if (!vendorAdminDAO.existsById(inputData.getVendorCode())) {
			rejectedVendorAssignData(userId, inputData, "Invalid or Vendor not assigned for audit");
			return false;
		}

		if (checkQuarterErrorStatus(userId, inputData) > 0) {
			return false;
		}

		try {
			fromDate = new SimpleDateFormat("dd-MM-yyyy").parse(inputData.getStartDate());
		} catch (ParseException e) {
			rejectedVendorAssignData(userId, inputData, "Invalid or no from date present");
			return false;
		}

		try {
			toDate = new SimpleDateFormat("dd-MM-yyyy").parse(inputData.getEndDate());
		} catch (ParseException e) {
			rejectedVendorAssignData(userId, inputData, "Invalid or no to date present");
			return false;
		}

		if (fromDate.compareTo(DateUtils.fetchCurrentDate()) < 0) {
			rejectedVendorAssignData(userId, inputData, "From date is of past date");
			return false;
		}

		if (fromDate.compareTo(toDate) > 0) {
			rejectedVendorAssignData(userId, inputData, "From date is after To date");
			return false;
		}

		if (!verifyDate(inputData.getStartDate(), inputData.getAuditQuarter())) {
			rejectedVendorAssignData(userId, inputData, "From date not under given financial quarter");
			return false;
		}

		if (!verifyDate(inputData.getEndDate(), inputData.getAuditQuarter())) {
			rejectedVendorAssignData(userId, inputData, "To date not under given financial quarter");
			return false;
		}

		return true;
	}

	private boolean verifyDate(String providedDate, String auditQuarter) {

		int providedYear = Integer.parseInt(providedDate.split("-")[2]);
		int providedMonth = Integer.parseInt(providedDate.split("-")[1]);
		int providedQuarter = Integer.parseInt(auditQuarter.substring(11));

		if (DateUtils.fetchCurrentFinancialYear() == providedYear
				|| DateUtils.fetchCurrentFinancialYear() == (providedYear - 1)) {

			return DateUtils.isMonthInQuarterRange(providedMonth, providedQuarter);
		} else {
			return false;
		}
	}

	private int verifyQuarterData(String quarter) {

		try {
			String data[] = quarter.split("/");
			if (data != null && data.length == 2) {

				String originalFinancialYear = DateUtils.fetchCurrentFinancialYear() + "-"
						+ (DateUtils.fetchCurrentFinancialYear() + 1);

				if (!data[0].equals(originalFinancialYear)) {
					return 1;
				}

				// String yeardata[] = data[0].split("-");

				// if (yeardata != null && yeardata.length == 2) {
				// if ((Integer.parseInt(yeardata[0]) + 1) != Integer.parseInt(yeardata[1])) {
				// return false;
				// }
				// } else {
				// return false;
				// }

				if ("Q1".equals(data[1]) || "Q2".equals(data[1]) || "Q3".equals(data[1]) || "Q4".equals(data[1])) {

					if (Integer.parseInt(data[1].substring(1)) >= Integer
							.parseInt(DateUtils.fetchCurrentFinancialQuarter().substring(11))) {
						return 0;
					} else {
						return 2;
					}
				} else {
					return 3;
				}
			} else {
				return 4;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 5;
		}
	}

	private int checkQuarterErrorStatus(String userId, VendorAssignInputData inputData) {
		int quarterErrorStatus = verifyQuarterData(inputData.getAuditQuarter());

		switch (quarterErrorStatus) {
		case 0:
			return 0;
		case 1:
			rejectedVendorAssignData(userId, inputData, "Given year range is not in current financial year");
			return 1;
		case 2:
			rejectedVendorAssignData(userId, inputData, "Given financial quarter is of past value");
			return 2;
		case 3:
			rejectedVendorAssignData(userId, inputData, "Given financial quarter is invalid");
			return 3;
		case 4:
			rejectedVendorAssignData(userId, inputData, "Given audit quarter format is invalid");
			return 4;
		case 5:
			rejectedVendorAssignData(userId, inputData, "Error occured in audit quarter data");
			return 5;
		default:
			return -1;
		}
	}

	public ArrayList<DhruvaCustomer> fetchRetailOutletsForAssignment(String salesOrg, String salesOff, String salesArea,
			String archetype, String phase) {

		ArrayList<DhruvaCustomer> dhruvaCustomers = new ArrayList<>();

		String query = "SELECT ro_code, cust_name, arche_name, phase FROM VW_DHRUVA_CUST_DETAILS where 1=1";

		if (!salesArea.equals("0")) {
			query += " and salesarea = '" + salesArea + "'";
		} else if (!salesOff.equals("0")) {
			query += " and salesoff = " + salesOff;
		} else if (!salesOrg.equals("0")) {
			query += " and salesorg = " + salesOrg;
		}

		if (!archetype.equals("0")) {
			query += " and archetype_code = " + archetype;
		}

		if (!phase.equals("0")) {
			query += " and phase = '" + phase + "'";
		}

		try (Connection con = databaseConfig.getJDBCDatabaseConnection();
				PreparedStatement ps1 = con.prepareStatement(query);
				ResultSet rs1 = ps1.executeQuery()) {

			if (rs1.next()) {
				do {
					DhruvaCustomer customer = new DhruvaCustomer();

					customer.setRoCode(rs1.getInt("ro_code"));
					customer.setRoName(rs1.getString("cust_name"));
					customer.setDoName("");
					customer.setSalesAreaName("");
					customer.setArchetypeName(rs1.getString("arche_name"));
					customer.setPhase(rs1.getString("phase"));

					dhruvaCustomers.add(customer);
				} while (rs1.next());
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return dhruvaCustomers;
	}

	public int saveVendorAssignOptionData(VendorAssignOptionData vendorAssignOptionData, String userId) {

		vendorAssignOptionData.getRoList().forEach(roCode -> {

			VendorAssignID newVendorAssignID = new VendorAssignID(
					vendorAssignOptionData.getAuditYear() + "/" + vendorAssignOptionData.getAuditQuarter(), roCode.toString(),
					vendorAssignOptionData.getVendorCode());
			VendorAssign newVendorAssign = new VendorAssign(newVendorAssignID, vendorAssignOptionData.getAuditType(),
					DateUtils.convertStringToDate(vendorAssignOptionData.getStartDate(), "yyyy-MM-dd"),
					DateUtils.convertStringToDate(vendorAssignOptionData.getEndDate(), "yyyy-MM-dd"),
					emMasterService.getUserDetails(Integer.parseInt(userId)), new Date());
			vendorAssignDAO.save(newVendorAssign);
		});

		return 1;
	}
}