package com.iocl.dhruva2api.service.mis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iocl.dhruva2api.config.JDBCDatabaseConfig;
import com.iocl.dhruva2api.model.DOMaster;
import com.iocl.dhruva2api.model.SAMaster;
import com.iocl.dhruva2api.model.SOMaster;
import com.iocl.dhruva2api.model.mis.MISReportWrapper;
import com.iocl.dhruva2api.service.SOMasterService;

/**
 * MISReportsDAO Author : 00511172
 */
@Service
public class MISReportService {

	@Autowired
	private SOMasterService soMasterService;

	@Autowired
	private JDBCDatabaseConfig databaseConfig;

	// From-to date = 0; ReportType Filter = 0;
	public MISReportWrapper getReportHeadersAndDatas(long reportId, int soCode, int doCode, String salesArea,
			int empCode) {
		String headerQuery = getHeaderQuery(reportId);
		headerQuery = replaceAuthorizationValues(headerQuery, empCode, soCode, doCode,
				salesArea.replace("'", "").replace("--", ""));
		if (headerQuery == "Unauthorized") {
			MISReportWrapper wrapper = new MISReportWrapper();
			wrapper.setValid(false);
			return wrapper;
		}
		return getWrapper(headerQuery);
	}

	// From-to date = 0; ReportType Filter = 1;
	public MISReportWrapper getReportHeadersAndDatas(long reportId, int soCode, int doCode, String salesArea,
			int empCode, String filterType) {
		String headerQuery = getHeaderQuery(reportId);
		headerQuery = replaceAuthorizationValues(headerQuery, empCode, soCode, doCode,
				salesArea.replace("'", "").replace("--", ""));
		headerQuery = replaceFilterType(headerQuery, filterType);
		if (headerQuery == "Unauthorized") {
			MISReportWrapper wrapper = new MISReportWrapper();
			wrapper.setValid(false);
			return wrapper;
		}
		return getWrapper(headerQuery);
	}

	// From-to date = 1; ReportType Filter = 0;
	public MISReportWrapper getReportHeadersAndDatas(long reportId, int soCode, int doCode, String salesArea,
			int empCode, String fromDate, String toDate) {
		String headerQuery = getHeaderQuery(reportId);
		headerQuery = replaceAuthorizationValues(headerQuery, empCode, soCode, doCode,
				salesArea.replace("'", "").replace("--", ""));
		headerQuery = replaceFromToDateValues(headerQuery, fromDate, toDate);
		if (headerQuery == "Unauthorized") {
			MISReportWrapper wrapper = new MISReportWrapper();
			wrapper.setValid(false);
			return wrapper;
		}
		return getWrapper(headerQuery);
	}

	public MISReportWrapper getReportHeadersAndDatas(long reportId, int soCode, int doCode, String salesArea,
			int empCode, String filterType, int filterSite) {
		String headerQuery = getHeaderQuery(reportId);
		headerQuery = replaceAuthorizationValues(headerQuery, empCode, soCode, doCode,
				salesArea.replace("'", "").replace("--", ""));
		// headerQuery = replaceFromToDateValues(headerQuery, fromDate, toDate);
		headerQuery = replaceFilterSite(headerQuery, filterSite);
		headerQuery = replaceFilterType(headerQuery, filterType);
		if (headerQuery == "Unauthorized") {
			MISReportWrapper wrapper = new MISReportWrapper();
			wrapper.setValid(false);
			return wrapper;
		}
		return getWrapper(headerQuery);
	}

	public MISReportWrapper getReportHeadersAndDatas(long reportId, int soCode, int doCode, String salesArea,
			int empCode, int archetype, String phase, String financialYear, int financialQuarter, int filterIndex,
			int filterSite) {
		String headerQuery = getHeaderQuery(reportId);
		headerQuery = replaceAuthorizationValues(headerQuery, empCode, soCode, doCode,
				salesArea.replace("'", "").replace("--", ""));
		headerQuery = replaceArchetypePhase(headerQuery, archetype, phase);
		headerQuery = replaceFilterSite(headerQuery, filterSite);
		headerQuery = replaceFinancialYearAndQuarter(headerQuery, financialYear, financialQuarter);
		// headerQuery = replaceAuditRound(headerQuery, auditRound);
		headerQuery = replaceAuditIndex(headerQuery, filterIndex);
		// System.out.println("\n" + headerQuery);
		if (headerQuery == "Unauthorized") {
			MISReportWrapper wrapper = new MISReportWrapper();
			wrapper.setValid(false);
			return wrapper;
		}
		return getWrapper(headerQuery);
	}

	public MISReportWrapper getReportHeadersAndDatas(long reportId, int soCode, int doCode, String salesArea,
			int empCode, int archetype, String phase, String financialYear, int financialQuarter, int filterIndex,
			int filterSite, int filterParameter) {
		String headerQuery = getHeaderQuery(reportId);
		headerQuery = replaceAuthorizationValues(headerQuery, empCode, soCode, doCode,
				salesArea.replace("'", "").replace("--", ""));
		headerQuery = replaceArchetypePhase(headerQuery, archetype, phase.replace("'", "").replace("--", ""));
		headerQuery = replaceFilterSite(headerQuery, filterSite);
		headerQuery = replaceFinancialYearAndQuarter(headerQuery, financialYear.replace("'", "").replace("--", ""),
				financialQuarter);
		// headerQuery = replaceAuditRound(headerQuery, auditRound);
		headerQuery = replaceAuditIndex(headerQuery, filterIndex);
		headerQuery = replaceAuditParameter(headerQuery, filterParameter);
		// System.out.println("\n" + headerQuery);
		if (headerQuery == "Unauthorized") {
			MISReportWrapper wrapper = new MISReportWrapper();
			wrapper.setValid(false);
			return wrapper;
		}
		return getWrapper(headerQuery);
	}
	
	public MISReportWrapper getReportHeadersAndDatasNineteen(long reportId, int soCode, int doCode, String salesArea,
			int empCode, int archetype, String phase, String financialYear, int filterIndex,
			int filterSite, int filterParameter) {
		String headerQuery = getHeaderQuery(reportId);
		headerQuery = replaceAuthorizationValues(headerQuery, empCode, soCode, doCode,
				salesArea.replace("'", "").replace("--", ""));
		headerQuery = replaceArchetypePhase(headerQuery, archetype, phase.replace("'", "").replace("--", ""));
		headerQuery = replaceFilterSite(headerQuery, filterSite);
		headerQuery = replaceFinancialYearAndQuarter(headerQuery, financialYear.replace("'", "").replace("--", ""),
				0);
		// headerQuery = replaceAuditRound(headerQuery, auditRound);
		headerQuery = replaceAuditIndex(headerQuery, filterIndex);
		headerQuery = replaceAuditParameter(headerQuery, filterParameter);
		// System.out.println("\n" + headerQuery);
		if (headerQuery == "Unauthorized") {
			MISReportWrapper wrapper = new MISReportWrapper();
			wrapper.setValid(false);
			return wrapper;
		}
		return getWrapper(headerQuery);
	}

	public MISReportWrapper getReportHeadersAndDatas(long reportId, int soCode, int doCode, String salesArea,
			int empCode, int archetype, String phase, String financialYear, int financialQuarter, int filterSite,
			String filterType) {
		String headerQuery = getHeaderQuery(reportId);
		headerQuery = replaceAuthorizationValues(headerQuery, empCode, soCode, doCode,
				salesArea.replace("'", "").replace("--", ""));
		headerQuery = replaceArchetypePhase(headerQuery, archetype, phase.replace("'", "").replace("--", ""));
		headerQuery = replaceFilterSite(headerQuery, filterSite);
		headerQuery = replaceFinancialYearAndQuarter(headerQuery, financialYear.replace("'", "").replace("--", ""),
				financialQuarter);
		// headerQuery = replaceAuditRound(headerQuery, auditRound);
		// headerQuery = replaceAuditIndex(headerQuery, filterIndex);
		headerQuery = replaceFilterType(headerQuery, filterType);
//		System.out.println("\n" + headerQuery);
		if (headerQuery == "Unauthorized") {
			MISReportWrapper wrapper = new MISReportWrapper();
			wrapper.setValid(false);
			return wrapper;
		}
		return getWrapper(headerQuery);
	}
	
	public MISReportWrapper getReportHeadersAndDatas(long reportId, int soCode, int doCode, String salesArea,
			int empCode, int archetype, String phase, String financialYear, int filterSite,
			String filterType) {
		String headerQuery = getHeaderQuery(reportId);
		headerQuery = replaceAuthorizationValues(headerQuery, empCode, soCode, doCode,
				salesArea.replace("'", "").replace("--", ""));
		headerQuery = replaceArchetypePhase(headerQuery, archetype, phase.replace("'", "").replace("--", ""));
		headerQuery = replaceFilterSite(headerQuery, filterSite);
		headerQuery = replaceFinancialYearAndQuarter(headerQuery, financialYear.replace("'", "").replace("--", ""),
				0);
		// headerQuery = replaceAuditRound(headerQuery, auditRound);
		// headerQuery = replaceAuditIndex(headerQuery, filterIndex);
		headerQuery = replaceFilterType(headerQuery, filterType);
//		System.out.println("\n" + headerQuery);
		if (headerQuery == "Unauthorized") {
			MISReportWrapper wrapper = new MISReportWrapper();
			wrapper.setValid(false);
			return wrapper;
		}
		return getWrapper(headerQuery);
	}

	public MISReportWrapper getReportHeadersAndDatas(long reportId, int soCode, int doCode, String salesArea,
			int empCode, int archetype, String phase, String financialYear, int financialQuarter, int filterSite) {

		String headerQuery = getHeaderQuery(reportId);
		headerQuery = replaceAuthorizationValues(headerQuery, empCode, soCode, doCode,
				salesArea.replace("'", "").replace("--", ""));
		headerQuery = replaceArchetypePhase(headerQuery, archetype, phase.replace("'", "").replace("--", ""));
		headerQuery = replaceFilterSite(headerQuery, filterSite);
		headerQuery = replaceFinancialYearAndQuarter(headerQuery, financialYear.replace("'", "").replace("--", ""),
				financialQuarter);
//		System.out.println("\n" + headerQuery);
		if (headerQuery == "Unauthorized") {
			MISReportWrapper wrapper = new MISReportWrapper();
			wrapper.setValid(false);
			return wrapper;
		}
		return getWrapper(headerQuery);
	}
	
	public MISReportWrapper getReportHeadersAndDatas(long reportId, int soCode, int doCode, String salesArea,
			int empCode, int archetype, String phase, String financialYear, int filterSite) {

		String headerQuery = getHeaderQuery(reportId);
		headerQuery = replaceAuthorizationValues(headerQuery, empCode, soCode, doCode,
				salesArea.replace("'", "").replace("--", ""));
		headerQuery = replaceArchetypePhase(headerQuery, archetype, phase.replace("'", "").replace("--", ""));
		headerQuery = replaceFilterSite(headerQuery, filterSite);
		headerQuery = replaceFinancialYearAndQuarter(headerQuery, financialYear.replace("'", "").replace("--", ""),
				0);
//		System.out.println("\n" + headerQuery);
		if (headerQuery == "Unauthorized") {
			MISReportWrapper wrapper = new MISReportWrapper();
			wrapper.setValid(false);
			return wrapper;
		}
		return getWrapper(headerQuery);
	}

	public MISReportWrapper getReportHeadersAndDatas(long reportId, int soCode, int doCode, String salesArea,
			int empCode, int archetype, String phase, int filterSite, int filterIndex) {

		String headerQuery = getHeaderQuery(reportId);
		headerQuery = replaceAuthorizationValues(headerQuery, empCode, soCode, doCode,
				salesArea.replace("'", "").replace("--", ""));
		headerQuery = replaceArchetypePhase(headerQuery, archetype, phase.replace("'", "").replace("--", ""));
		headerQuery = replaceFilterSite(headerQuery, filterSite);
		headerQuery = replaceAuditIndex(headerQuery, filterIndex);
//		System.out.println("\n" + headerQuery);
		if (headerQuery == "Unauthorized") {
			MISReportWrapper wrapper = new MISReportWrapper();
			wrapper.setValid(false);
			return wrapper;
		}
		return getWrapper(headerQuery);
	}

	public MISReportWrapper getReportHeadersAndDatas(long reportId, int soCode, int doCode, String salesArea,
			int empCode, int archetype, String phase, int filterSite) {

		String headerQuery = getHeaderQuery(reportId);
		headerQuery = replaceAuthorizationValues(headerQuery, empCode, soCode, doCode,
				salesArea.replace("'", "").replace("--", ""));
		headerQuery = replaceArchetypePhase(headerQuery, archetype, phase.replace("'", "").replace("--", ""));
		headerQuery = replaceFilterSite(headerQuery, filterSite);
//		System.out.println("\n" + headerQuery);
		if (headerQuery == "Unauthorized") {
			MISReportWrapper wrapper = new MISReportWrapper();
			wrapper.setValid(false);
			return wrapper;
		}
		return getWrapper(headerQuery);
	}

	public MISReportWrapper getReportHeadersAndDatas(long reportId, int soCode, int doCode, String salesArea,
			int empCode, int archetype, String phase, int filterIndex, int filterParameter, int filterSite) {

		String headerQuery = getHeaderQuery(reportId);
		headerQuery = replaceAuthorizationValues(headerQuery, empCode, soCode, doCode,
				salesArea.replace("'", "").replace("--", ""));
		headerQuery = replaceArchetypePhase(headerQuery, archetype, phase.replace("'", "").replace("--", ""));
		headerQuery = replaceFilterSite(headerQuery, filterSite);
		headerQuery = replaceAuditIndex(headerQuery, filterIndex);
		headerQuery = replaceAuditParameter(headerQuery, filterParameter);
//		System.out.println("\n" + headerQuery);
		if (headerQuery == "Unauthorized") {
			MISReportWrapper wrapper = new MISReportWrapper();
			wrapper.setValid(false);
			return wrapper;
		}
		return getWrapper(headerQuery);
	}

	private String replaceFilterSite(String headerQuery, int filterSite) {
		switch (filterSite) {
		case 0:
			headerQuery = headerQuery.replace("IIIIII", "");
			break;
		case 1:
			headerQuery = headerQuery.replace("IIIIII", " and SITE = 'A' ");
			break;
		case 2:
			headerQuery = headerQuery.replace("IIIIII", " and SITE = 'B' ");
			break;
		case 3:
			headerQuery = headerQuery.replace("IIIIII", " and SITE = 'COCO' ");
			break;
		default:
			headerQuery = headerQuery.replace("IIIIII", "");
			break;
		}
		return headerQuery;
	}

	private String replaceFinancialYearAndQuarter(String headerQuery, String financialYear, int financialQuarter) {

		if (!"0".equals(financialYear)) {
			headerQuery = headerQuery.replace("JJJJJJJJ", " and AUDIT_YEAR = '" + financialYear + "' ");
		} else {
			headerQuery = headerQuery.replace("JJJJJJJJ", "");
		}

		switch (financialQuarter) {
		case 0:
			headerQuery = headerQuery.replace("KKKKKKKK", "");
			break;
		case 1:
			headerQuery = headerQuery.replace("KKKKKKKK", " and Audit_quarter =  'Q1' ");
			break;
		case 2:
			headerQuery = headerQuery.replace("KKKKKKKK", " and Audit_quarter =  'Q2' ");
			break;
		case 3:
			headerQuery = headerQuery.replace("KKKKKKKK", " and Audit_quarter =  'Q3' ");
			break;
		case 4:
			headerQuery = headerQuery.replace("KKKKKKKK", " and Audit_quarter =  'Q4' ");
			break;
		default:
			headerQuery = headerQuery.replace("KKKKKKKK", "");
			break;
		}

		return headerQuery;
	}

	// private String replaceAuditRound(String headerQuery, int auditRound) {
	//
	// if (auditRound != 0) {
	// headerQuery = headerQuery.replace("MMMMMMMM", " and round_of_audit = " +
	// auditRound + " ");
	// } else {
	// headerQuery = headerQuery.replace("MMMMMMMM", "");
	// }
	//
	// return headerQuery;
	// }
	//
	private String replaceAuditIndex(String headerQuery, int auditIndex) {

		if (auditIndex != 0) {
			headerQuery = headerQuery.replace("DDDDDDDD", " and index_id = " + auditIndex + " ");
		} else {
			headerQuery = headerQuery.replace("DDDDDDDD", "");
		}

		return headerQuery;
	}

	private String replaceAuditParameter(String headerQuery, int parameter) {

		if (parameter != 0) {
			headerQuery = headerQuery.replace("EEEEEEEE", " and param_id = " + parameter + " ");
		} else {
			headerQuery = headerQuery.replace("EEEEEEEE", "");
		}

		return headerQuery;
	}

	// From-to date = 1; ReportType Filter = 2;
	public MISReportWrapper getReportHeadersAndDatas(long reportId, int soCode, int doCode, int empCode,
			String fromDate, String toDate) {
		String headerQuery = getHeaderQuery(reportId);
		headerQuery = replaceAuthorizationValues2(headerQuery, empCode, soCode, doCode);
		headerQuery = replaceFromToDateValues(headerQuery, fromDate, toDate);
		if (headerQuery == "Unauthorized") {
			MISReportWrapper wrapper = new MISReportWrapper();
			wrapper.setValid(false);
			return wrapper;
		}
		return getWrapper(headerQuery);
	}

	// From-to date = 1; ReportType Filter = 1;
	public MISReportWrapper getReportHeadersAndDatas(long reportId, int soCode, int doCode, String salesArea,
			int empCode, String fromDate, String toDate, String filterType) {
		String headerQuery = getHeaderQuery(reportId);
		headerQuery = replaceAuthorizationValues(headerQuery, empCode, soCode, doCode, salesArea);
		headerQuery = replaceFromToDateValues(headerQuery, fromDate, toDate);
		headerQuery = replaceFilterType(headerQuery, filterType);
		if (headerQuery == "Unauthorized") {
			MISReportWrapper wrapper = new MISReportWrapper();
			wrapper.setValid(false);
			return wrapper;
		}
		return getWrapper(headerQuery);
	}

	// From-to date = 0; ReportType Filter = 8;
	public MISReportWrapper getReportHeadersAndDatas(long reportId, int soCode, int doCode, String salesArea,
			int empCode, int archetype, String phase) {
		String headerQuery = getHeaderQuery(reportId);
		headerQuery = replaceAuthorizationValues(headerQuery, empCode, soCode, doCode, salesArea);
		headerQuery = replaceArchetypePhase(headerQuery, archetype, phase);
		if (headerQuery == "Unauthorized") {
			MISReportWrapper wrapper = new MISReportWrapper();
			wrapper.setValid(false);
			return wrapper;
		}
		return getWrapper(headerQuery);
	}

	private String replaceAuthorizationValues(String headerQuery, int empCode, int soCode, int doCode,
			String salesArea) {
		headerQuery = headerQuery.replace(";", "");
		salesArea = salesArea.replace("'", "").replace("--", "");// Just for preventing sql injection
		// Fields : So Code, DO Code, Sales area are zero in case user selects "All" in
		ArrayList<SOMaster> soMasterList = soMasterService.getSoList(empCode);
		StringBuilder replaceQuery = new StringBuilder("");
		if (soCode != 0) {
			boolean isAuthorizedForThisStateOffice = false;
			/*
			 * Though we are allowing user to send only those state-office codes for which
			 * he/she is authorized. But for server site security we are doing this.
			 */
			SOMaster currentStateOffice = null;
			for (SOMaster stateOffice : soMasterList) {
				if (stateOffice.getSalesOrg().equals(String.valueOf(soCode))) {
					currentStateOffice = stateOffice;
					isAuthorizedForThisStateOffice = true;
					break;
				}
			}
			if (!isAuthorizedForThisStateOffice) {
				return "Unauthorized";
			}
			replaceQuery.append(" and salesorg = ").append(soCode).append(" ");
			if (doCode != 0) {
				boolean isAuthorizedForThisDivisionalOffice = false;
				/*
				 * Though we are allowing user to send only those divisional-office codes for
				 * which he/she is authorized. But for server site security we are doing this.
				 */
				DOMaster currentDivisionalOffice = null;
				for (DOMaster divisionalOffice : currentStateOffice.getSalesOffs()) {
					if (Integer.parseInt(divisionalOffice.getSalesoff()) == doCode) {
						currentDivisionalOffice = divisionalOffice;
						isAuthorizedForThisDivisionalOffice = true;
						break;
					}
				}
				if (!isAuthorizedForThisDivisionalOffice) {
					return "Unauthorized";
				}
				replaceQuery.append(" and salesoff = ").append(doCode).append(" ");
				if (!salesArea.equals("0")) {
					boolean isAuthorizedForThisSalesArea = false;
					for (SAMaster currentSalesArea : currentDivisionalOffice.getSalesAreas()) {
						if (currentSalesArea.getSalesArea().equals(salesArea)) {
							isAuthorizedForThisSalesArea = true;
							break;
						}
					}
					if (!isAuthorizedForThisSalesArea) {
						return "Unauthorized";
					}
					replaceQuery.append(" and salesarea = '").append(salesArea).append("' ");
				} else {
					List<SAMaster> saMasterList = currentDivisionalOffice.getSalesAreas();
					int salesAreaCount = saMasterList.size();
					replaceQuery.append(" and salesarea in (");
					for (int i = 0; i < salesAreaCount; i++) {
						replaceQuery.append("'");
						replaceQuery.append(saMasterList.get(i).getSalesArea());
						replaceQuery.append("'");
						if (i != salesAreaCount - 1)
							replaceQuery.append(",");
					}
					replaceQuery.append(")");
				}
			} else {

				replaceQuery.append(" and salesoff in (");
				for (int i = 0; i < currentStateOffice.getSalesOffs().size(); i++) {
					replaceQuery.append("'");
					replaceQuery.append(currentStateOffice.getSalesOffs().get(i).getSalesoff());
					replaceQuery.append("'");
					if (i != currentStateOffice.getSalesOffs().size() - 1)
						replaceQuery.append(",");
				}
				replaceQuery.append(")");
				if (currentStateOffice.getSalesOffs().size() > 1) {
					/*
					 * user is state office level, don't need to impose any restriction on sales
					 * area
					 */
				} else if (currentStateOffice.getSalesOffs().get(0).getSalesAreas().size() > 1) {
					/*
					 * user is divisional office level, don't need to impose any restriction on
					 * sales area
					 */
				} else {

					ArrayList<SAMaster> saMasterList = (ArrayList<SAMaster>) soMasterList.get(0).getSalesOffs().get(0)
							.getSalesAreas();
					replaceQuery.append(" and salesarea = '");
					replaceQuery.append(saMasterList.get(0).getSalesArea());
					replaceQuery.append("'");
				}
			}
		} else {

			replaceQuery.append(" and salesorg in (");
			for (int i = 0; i < soMasterList.size(); i++) {
				replaceQuery.append("'");
				replaceQuery.append(soMasterList.get(i).getSalesOrg());
				replaceQuery.append("'");
				if (i != soMasterList.size() - 1)
					replaceQuery.append(",");
			}
			replaceQuery.append(")");

			/*
			 * Following things could be achieved with out using these if-else conditions by
			 * going upto salesarea level for all the users, but that will increase length
			 * of query. You see, tradeoffs...
			 */

			if (soMasterList.size() > 1) {
				/*
				 * user is either HO level or Regional Office level, don't need to impose any
				 * restriction on divisional office
				 */
			} else if (soMasterList.get(0).getSalesOffs().size() > 1) {
				/*
				 * user is state office level, don't need to impose any restriction on
				 * divisional office
				 */
			} else {
				/*
				 * user is either divisional office level or sales area level. So lets include
				 * all salesarea under her jurisdiction.
				 */
				ArrayList<SAMaster> saMasterList = (ArrayList<SAMaster>) soMasterList.get(0).getSalesOffs().get(0)
						.getSalesAreas();
				int salesAreaCount = saMasterList.size();
				replaceQuery.append(" and salesarea in (");
				for (int i = 0; i < salesAreaCount; i++) {
					replaceQuery.append("'");
					replaceQuery.append(saMasterList.get(i).getSalesArea());
					replaceQuery.append("'");
					if (i != salesAreaCount - 1)
						replaceQuery.append(",");
				}
				replaceQuery.append(")");
			}

		}
		return headerQuery.replace("PPPPPPPP", replaceQuery);
	}

	private String replaceAuthorizationValues2(String headerQuery, int empCode, int soCode, int doCode) {
		headerQuery = headerQuery.replace(";", "");

		// Fields : So Code, DO Code, Sales area are zero in case user selects "All" in
		ArrayList<SOMaster> soMasterList = soMasterService.getSoList(empCode);
		StringBuilder replaceQuery = new StringBuilder("");
		if (soCode != 0) {
			boolean isAuthorizedForThisStateOffice = false;
			/*
			 * Though we are allowing user to send only those state-office codes for which
			 * he/she is authorized. But for server site security we are doing this.
			 */
			SOMaster currentStateOffice = null;
			for (SOMaster stateOffice : soMasterList) {
				if (stateOffice.getSalesOrg().equals(String.valueOf(soCode))) {
					currentStateOffice = stateOffice;
					isAuthorizedForThisStateOffice = true;
					break;
				}
			}
			if (!isAuthorizedForThisStateOffice) {
				return "Unauthorized";
			}
			replaceQuery.append(" and c.salesorg = ").append(soCode).append(" ");
			if (doCode != 0) {
				boolean isAuthorizedForThisDivisionalOffice = false;
				/*
				 * Though we are allowing user to send only those divisional-office codes for
				 * which he/she is authorized. But for server site security we are doing this.
				 */
				DOMaster currentDivisionalOffice = null;
				for (DOMaster divisionalOffice : currentStateOffice.getSalesOffs()) {
					if (Integer.parseInt(divisionalOffice.getSalesoff()) == doCode) {
						currentDivisionalOffice = divisionalOffice;
						isAuthorizedForThisDivisionalOffice = true;
						break;
					}
				}
				if (!isAuthorizedForThisDivisionalOffice) {
					return "Unauthorized";
				}
				replaceQuery.append(" and c.salesoff = ").append(doCode).append(" ");

			} else {

				replaceQuery.append(" and c.salesoff in (");
				for (int i = 0; i < currentStateOffice.getSalesOffs().size(); i++) {
					replaceQuery.append("'");
					replaceQuery.append(currentStateOffice.getSalesOffs().get(i).getSalesoff());
					replaceQuery.append("'");
					if (i != currentStateOffice.getSalesOffs().size() - 1)
						replaceQuery.append(",");
				}
				replaceQuery.append(")");
				if (currentStateOffice.getSalesOffs().size() > 1) {
					/*
					 * user is state office level, don't need to impose any restriction on sales
					 * area
					 */
				} else if (currentStateOffice.getSalesOffs().get(0).getSalesAreas().size() > 1) {
					/*
					 * user is divisional office level, don't need to impose any restriction on
					 * sales area
					 */
				}
			}
		} else {

			replaceQuery.append(" and c.salesorg in (");
			for (int i = 0; i < soMasterList.size(); i++) {
				replaceQuery.append("'");
				replaceQuery.append(soMasterList.get(i).getSalesOrg());
				replaceQuery.append("'");
				if (i != soMasterList.size() - 1)
					replaceQuery.append(",");
			}
			replaceQuery.append(")");

			/*
			 * Following things could be achieved with out using these if-else conditions by
			 * going upto salesarea level for all the users, but that will increase length
			 * of query. You see, tradeoffs...
			 */

			if (soMasterList.size() > 1) {
				/*
				 * user is either HO level or Regional Office level, don't need to impose any
				 * restriction on divisional office
				 */
			} else if (soMasterList.get(0).getSalesOffs().size() > 1) {
				/*
				 * user is state office level, don't need to impose any restriction on
				 * divisional office
				 */
			}

		}
		return headerQuery.replace("PPPPPPPP", replaceQuery);
	}

	private String replaceFromToDateValues(String headerQuery, String fromDate, String toDate) {
		// headerQuery = headerQuery.replace("FFFFFFFF", "to_date('" + fromDate +
		// "','yyyy-mm-dd')");
		headerQuery = headerQuery.replace("FFFFFFFF", fromDate.replace("-", ""));
		// headerQuery = headerQuery.replace("TTTTTTTT", "to_date('" + toDate +
		// "','yyyy-mm-dd')");
		headerQuery = headerQuery.replace("TTTTTTTT", toDate.replace("-", ""));
		return headerQuery;
	}

	private String replaceFromToMonthValues(String headerQuery, String fromMonth, String toMonth) {
		headerQuery = headerQuery.replace("FFFMMM", fromMonth.replace("-", "").replace("'", "").replace("--", ""));
		headerQuery = headerQuery.replace("TTTMMM", toMonth.replace("-", "").replace("'", "").replace("--", ""));
		return headerQuery;
	}

	private String replaceFilterType(String headerQuery, String filterType) {
		switch (Integer.parseInt(filterType)) {
		case 0:
			headerQuery = headerQuery.replace("SSSSSSSS", " ");
			headerQuery = headerQuery.replace("GGGGGGG", "group by 1");
			headerQuery = headerQuery.replace("TSSSSSST", " ");
			headerQuery = headerQuery.replace("LLLLLLL", "1=1");
			break;
		case 1:
			headerQuery = headerQuery.replace("SSSSSSSS", " a.salesorg_name \"State Office\", ");
			headerQuery = headerQuery.replace("GGGGGGG", " group by salesorg_name ");
			headerQuery = headerQuery.replace("TSSSSSST", "a.salesorg_name, ");
			headerQuery = headerQuery.replace("LLLLLLL", "a.salesorg_name = q.salesorg_name");
			break;
		case 2:
			headerQuery = headerQuery.replace("SSSSSSSS",
					" a.salesorg_name \"State Office\",a.salesoff_name \"Divisional Office\", ");
			headerQuery = headerQuery.replace("GGGGGGG",
					" group by salesorg_name,salesoff_name order by salesorg_name");
			headerQuery = headerQuery.replace("TSSSSSST", "a.salesorg_name,a.salesoff_name,  ");
			headerQuery = headerQuery.replace("LLLLLLL", "a.salesoff_name = q.salesoff_name");
			break;
		case 3:
			headerQuery = headerQuery.replace("SSSSSSSS",
					" a.salesorg_name \"State Office\",a.salesoff_name \"Divisional Office\",a.salesarea_name \"Sales Area\", ");
			headerQuery = headerQuery.replace("GGGGGGG", "group by salesorg_name,salesoff_name,salesarea_name");
			headerQuery = headerQuery.replace("TSSSSSST", "a.salesorg_name,a.salesoff_name,a.salesarea_name,  ");
			headerQuery = headerQuery.replace("LLLLLLL", "a.salesarea_name = q.salesarea_name");
		}

		return headerQuery;
	}

	private String replaceArchetypePhase(String headerQuery, int archetype, String phase) {
		phase = phase.replace("'", "").replace("--", "");
		if (archetype != 0) {
			headerQuery = headerQuery.replace("AAAAAAAA", " and archetype_code = " + archetype);
		} else {
			headerQuery = headerQuery.replace("AAAAAAAA", "");
		}
		if (!"0".equals(phase)) {
			headerQuery = headerQuery.replace("HHHHHHHH", " and phase = '" + phase + "'");
		} else {
			headerQuery = headerQuery.replace("HHHHHHHH", "");
		}
		return headerQuery;
	}

	private String getHeaderQuery(long reportId) {
		String headerQuery = null;
		String reportQuery = "select REP_QUERY1, REP_QUERY2, REP_QUERY3 from DHRUVA_REPORTS_MENUS where REP_ID = ?";
		try (Connection con = databaseConfig.getJDBCDatabaseConnection();
				PreparedStatement ps1 = con.prepareStatement(reportQuery)) {
			ps1.setLong(1, reportId);
			try (ResultSet rs1 = ps1.executeQuery()) {
				if (rs1.next()) {
					headerQuery = new StringBuilder(rs1.getString("REP_QUERY1")).append(" ")
							.append(rs1.getString("REP_QUERY2") == null ? "" : rs1.getString("REP_QUERY2")).append(" ")
							.append(rs1.getString("REP_QUERY3") == null ? "" : rs1.getString("REP_QUERY3")).toString();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return headerQuery.replace(";", "");
	}

	private MISReportWrapper getWrapper(String headerQuery) {
		// System.out.println(headerQuery);
		ArrayList<String> headers = new ArrayList<>();
		ArrayList<ArrayList<Object>> rowdatas = new ArrayList<>();
		MISReportWrapper wrapper = new MISReportWrapper();
		try (Connection con = databaseConfig.getJDBCDatabaseConnection();
				PreparedStatement ps2 = con.prepareStatement(headerQuery);
				ResultSet rs2 = ps2.executeQuery()) {
			if (rs2.next()) {
				int totalColumns = rs2.getMetaData().getColumnCount();
				for (int i = 1; i <= totalColumns; i++) {
					headers.add(rs2.getMetaData().getColumnLabel(i));
				}
				wrapper.setReportHeaders(headers);

				do {
					ArrayList<Object> row = new ArrayList<>();
					for (int i = 1; i <= totalColumns; i++) {
						row.add(rs2.getObject(i));
					}
					rowdatas.add(row);
				} while (rs2.next());
				wrapper.setReportDatas(rowdatas);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return wrapper;
	}

}