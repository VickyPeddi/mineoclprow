//Author: Kaushal Dubey (00511172)

package com.iocl.dhruva2api.service.rca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iocl.dhruva2api.dao.rca.RcaAtrDao;
import com.iocl.dhruva2api.dao.rca.RcaAttributeDao;
import com.iocl.dhruva2api.model.rca.RcaAtr;
import com.iocl.dhruva2api.model.rca.RcaAtrId;
import com.iocl.dhruva2api.model.rca.RcaAttributes;
import com.iocl.dhruva2api.model.rca.RcaFormData;
import com.iocl.dhruva2api.service.EmployeeMasterService;

@Service
public class RcaAtrService {

	@Autowired
	private RcaAttributeDao rcaAttributeDao;

	@Autowired
	private RcaAtrDao rcaAtrDao;

	@Autowired
	private EmployeeMasterService emMasterService;

	public ArrayList<RcaAtr> getRcaSavedData(String roCode, int rootCauseSrNo) {
		return rcaAtrDao.findByRoCodeAndSrNo(Integer.parseInt(roCode), rootCauseSrNo);
	}

	public boolean saveRcaForm(RcaFormData entity, String user) throws ParseException {
		// Requirement makes it almost impossible to achieve full dynamic scenario. If
		// we go for making it completely db
		// driven then GOAL OF MAKING ATR TABLE AS LIGHT AS POSSIBLE is defeated. That
		// may look like a complex process, but can
		// be understood after little effort.
		// All attributes of RcaFormData entity are maintained in MST_RCA_ATTRIBUTE
		// table. Sr-No comes from there for saving.
		//

		String userDetails = emMasterService.getUserDetails(Integer.parseInt(user));
		HashMap<String, Integer> map = new HashMap<>();
		ArrayList<RcaAtr> atrList = new ArrayList<>();
		ArrayList<RcaAttributes> attributeMaster = (ArrayList<RcaAttributes>) rcaAttributeDao.findAll();
		RcaAtr rcaInstance;
		for (RcaAttributes attribute : attributeMaster) {
			map.put(attribute.getPropertyName(), attribute.getSrNo());
		}

		// This means There does not exist any data for this RO. Hence some mandatory
		// fields must be there
		boolean isComplete = true;
		if (rcaAtrDao.findByRoCodeAndSrNo(entity.getRoCode(), entity.getRootCauseSrNo()).size() == 0) {
			String[] args = { entity.getRootCause1(), entity.getRootCauseIssue1(), entity.getRootCauseIssueSupport1(),
//					entity.getRootCauseRank(), entity.getRootCause2(), entity.getRootCauseIssue2(),
//					entity.getRootCauseIssueSupport2(),entity.getRootCause3(), entity.getRootCauseIssue3(),
//					entity.getRootCauseIssueSupport3(),entity.getRootCause4(), entity.getRootCauseIssue4(),
//					entity.getRootCauseIssueSupport4(),entity.getRootCause5(), entity.getRootCauseIssue5(),entity.getRootCauseIssueSupport5(), 
					entity.getWorkScope(), entity.getTargetSupportStart(), entity.getTargetSupportEnd(),
					entity.getActualSupportStart() };
			isComplete = isComplete(args);
			if (!isComplete || isFuture(entity.getLastVisit())) {
				return false;
			}
			// Following fields will be updated only if this RO's data is being updated for
			// the first time.

//			rcaInstance = new RcaAtr();
//			rcaInstance.setEmbeddedkey(new RcaAtrId(entity.getRoCode(), map.get("rootCauseRank"),entity.getRootCauseSrNo()));
//			rcaInstance.setIsOther("N");
//			rcaInstance.setUserDetails(userDetails);
//			rcaInstance.setValue(entity.getRootCauseRank());
//			atrList.add(rcaInstance);

			rcaInstance = new RcaAtr();
			rcaInstance
					.setEmbeddedkey(new RcaAtrId(entity.getRoCode(), map.get("rootCause1"), entity.getRootCauseSrNo()));
			boolean isOtherRootCause1 = entity.getRootCause1().equals("99");
			String ultimateRootCause1 = isOtherRootCause1 ? entity.getRootCauseOther1() : entity.getRootCause1();
			if (ultimateRootCause1.equals("")) {
				return false;
			}
			rcaInstance.setIsOther(isOtherRootCause1 ? "Y" : "N");
			rcaInstance.setUserDetails(userDetails);
			rcaInstance.setValue(ultimateRootCause1);
			atrList.add(rcaInstance);
			rcaInstance = new RcaAtr();

//			rcaInstance.setEmbeddedkey(new RcaAtrId(entity.getRoCode(), map.get("rootCause2")));
//			boolean isOtherRootCause2 = entity.getRootCause1().equals("99");
//			String ultimateRootCause2 = isOtherRootCause2 ? entity.getRootCauseOther2() : entity.getRootCause2();
//			rcaInstance.setIsOther(isOtherRootCause2 ? "Y" : "N");
//			rcaInstance.setUserDetails(userDetails);
//			rcaInstance.setValue(ultimateRootCause2);
//			atrList.add(rcaInstance);
//			
//			rcaInstance = new RcaAtr();
//			rcaInstance.setEmbeddedkey(new RcaAtrId(entity.getRoCode(), map.get("rootCause3")));
//			boolean isOtherRootCause3 = entity.getRootCause3().equals("99");
//			String ultimateRootCause3 = isOtherRootCause3 ? entity.getRootCauseOther3() : entity.getRootCause3();
//			rcaInstance.setIsOther(isOtherRootCause3 ? "Y" : "N");
//			rcaInstance.setUserDetails(userDetails);
//			rcaInstance.setValue(ultimateRootCause3);
//			atrList.add(rcaInstance);
//			rcaInstance = new RcaAtr();
//			
//			rcaInstance.setEmbeddedkey(new RcaAtrId(entity.getRoCode(), map.get("rootCause4")));
//			boolean isOtherRootCause4 = entity.getRootCause4().equals("99");
//			String ultimateRootCause4 = isOtherRootCause4 ? entity.getRootCauseOther4() : entity.getRootCause4();
//			rcaInstance.setIsOther(isOtherRootCause4 ? "Y" : "N");
//			rcaInstance.setUserDetails(userDetails);
//			rcaInstance.setValue(ultimateRootCause4);
//			atrList.add(rcaInstance);
//			rcaInstance = new RcaAtr();
//			
//			rcaInstance.setEmbeddedkey(new RcaAtrId(entity.getRoCode(), map.get("rootCause5")));
//			boolean isOtherRootCause5 = entity.getRootCause5().equals("99");
//			String ultimateRootCause5 = isOtherRootCause5 ? entity.getRootCauseOther5() : entity.getRootCause5();
//			rcaInstance.setIsOther(isOtherRootCause5 ? "Y" : "N");
//			rcaInstance.setUserDetails(userDetails);
//			rcaInstance.setValue(ultimateRootCause5);
//			atrList.add(rcaInstance);

			rcaInstance = new RcaAtr();
			rcaInstance.setEmbeddedkey(
					new RcaAtrId(entity.getRoCode(), map.get("rootCauseIssue1"), entity.getRootCauseSrNo()));
			boolean isOtherRootCauseIssue1 = Integer.parseInt(entity.getRootCauseIssue1()) > 900;
			String ultimateRootCauseIssue1 = isOtherRootCauseIssue1 ? entity.getRootCauseIssueOther1()
					: entity.getRootCauseIssue1();
			if (ultimateRootCauseIssue1.equals("")) {
				return false;
			}
			rcaInstance.setIsOther(isOtherRootCauseIssue1 ? "Y" : "N");
			rcaInstance.setUserDetails(userDetails);
			rcaInstance.setValue(ultimateRootCauseIssue1);
			atrList.add(rcaInstance);

//			rcaInstance = new RcaAtr();
//			rcaInstance.setEmbeddedkey(new RcaAtrId(entity.getRoCode(), map.get("rootCauseIssue2")));
//			boolean isOtherRootCauseIssue2 = Integer.parseInt(entity.getRootCauseIssue2()) > 900;
//			String ultimateRootCauseIssue2 = isOtherRootCauseIssue2 ? entity.getRootCauseIssueOther2()
//					: entity.getRootCauseIssue2();
//			rcaInstance.setIsOther(isOtherRootCauseIssue2 ? "Y" : "N");
//			rcaInstance.setUserDetails(userDetails);
//			rcaInstance.setValue(ultimateRootCauseIssue2);
//			atrList.add(rcaInstance);
//
//			
//			rcaInstance = new RcaAtr();
//			rcaInstance.setEmbeddedkey(new RcaAtrId(entity.getRoCode(), map.get("rootCauseIssue3")));
//			boolean isOtherRootCauseIssue3 = Integer.parseInt(entity.getRootCauseIssue3()) > 900;
//			String ultimateRootCauseIssue3 = isOtherRootCauseIssue3 ? entity.getRootCauseIssueOther3()
//					: entity.getRootCauseIssue3();
//			rcaInstance.setIsOther(isOtherRootCauseIssue3 ? "Y" : "N");
//			rcaInstance.setUserDetails(userDetails);
//			rcaInstance.setValue(ultimateRootCauseIssue3);
//			atrList.add(rcaInstance);
//			
//			
//			rcaInstance = new RcaAtr();
//			rcaInstance.setEmbeddedkey(new RcaAtrId(entity.getRoCode(), map.get("rootCauseIssue4")));
//			boolean isOtherRootCauseIssue4 = Integer.parseInt(entity.getRootCauseIssue4()) > 900;
//			String ultimateRootCauseIssue4 = isOtherRootCauseIssue4 ? entity.getRootCauseIssueOther4()
//					: entity.getRootCauseIssue4();
//			rcaInstance.setIsOther(isOtherRootCauseIssue4 ? "Y" : "N");
//			rcaInstance.setUserDetails(userDetails);
//			rcaInstance.setValue(ultimateRootCauseIssue4);
//			atrList.add(rcaInstance);
//			
//			
//			rcaInstance = new RcaAtr();
//			rcaInstance.setEmbeddedkey(new RcaAtrId(entity.getRoCode(), map.get("rootCauseIssue5")));
//			boolean isOtherRootCauseIssue5 = Integer.parseInt(entity.getRootCauseIssue5()) > 900;
//			String ultimateRootCauseIssue5 = isOtherRootCauseIssue5 ? entity.getRootCauseIssueOther5()
//					: entity.getRootCauseIssue5();
//			rcaInstance.setIsOther(isOtherRootCauseIssue5 ? "Y" : "N");
//			rcaInstance.setUserDetails(userDetails);
//			rcaInstance.setValue(ultimateRootCauseIssue5);
//			atrList.add(rcaInstance);

			rcaInstance = new RcaAtr();
			rcaInstance.setEmbeddedkey(
					new RcaAtrId(entity.getRoCode(), map.get("rootCauseIssueSupport1"), entity.getRootCauseSrNo()));
			boolean isOtherRootCauseIssueSupport1 = Integer.parseInt(entity.getRootCauseIssueSupport1()) > 1000;
			String ultimateRootCauseIssueSupport1 = isOtherRootCauseIssueSupport1
					? entity.getRootCauseIssueSupportOther1()
					: entity.getRootCauseIssueSupport1();
			if (ultimateRootCauseIssueSupport1.equals("")) {
				return false;
			}
			rcaInstance.setIsOther(isOtherRootCauseIssueSupport1 ? "Y" : "N");
			rcaInstance.setUserDetails(userDetails);

			rcaInstance.setValue(ultimateRootCauseIssueSupport1);
			atrList.add(rcaInstance);

//			rcaInstance = new RcaAtr();
//			rcaInstance.setEmbeddedkey(new RcaAtrId(entity.getRoCode(), map.get("rootCauseIssueSupport2")));
//			boolean isOtherRootCauseIssueSupport2 = Integer.parseInt(entity.getRootCauseIssueSupport2()) > 1000;
//			String ultimateRootCauseIssueSupport2 = isOtherRootCauseIssueSupport2 ? entity.getRootCauseIssueSupportOther2()
//					: entity.getRootCauseIssueSupport2();
//			rcaInstance.setIsOther(isOtherRootCauseIssueSupport2 ? "Y" : "N");
//			rcaInstance.setUserDetails(userDetails);
//			rcaInstance.setValue(ultimateRootCauseIssueSupport2);
//			atrList.add(rcaInstance);
//			
//			
//			rcaInstance = new RcaAtr();
//			rcaInstance.setEmbeddedkey(new RcaAtrId(entity.getRoCode(), map.get("rootCauseIssueSupport3")));
//			boolean isOtherRootCauseIssueSupport3 = Integer.parseInt(entity.getRootCauseIssueSupport3()) > 1000;
//			String ultimateRootCauseIssueSupport3 = isOtherRootCauseIssueSupport3 ? entity.getRootCauseIssueSupportOther3()
//					: entity.getRootCauseIssueSupport3();
//			rcaInstance.setIsOther(isOtherRootCauseIssueSupport3 ? "Y" : "N");
//			rcaInstance.setUserDetails(userDetails);
//			rcaInstance.setValue(ultimateRootCauseIssueSupport3);
//			atrList.add(rcaInstance);
//
//			
//			rcaInstance = new RcaAtr();
//			rcaInstance.setEmbeddedkey(new RcaAtrId(entity.getRoCode(), map.get("rootCauseIssueSupport4")));
//			boolean isOtherRootCauseIssueSupport4 = Integer.parseInt(entity.getRootCauseIssueSupport4()) > 1000;
//			String ultimateRootCauseIssueSupport4 = isOtherRootCauseIssueSupport4 ? entity.getRootCauseIssueSupportOther4()
//					: entity.getRootCauseIssueSupport4();
//			rcaInstance.setIsOther(isOtherRootCauseIssueSupport4 ? "Y" : "N");
//			rcaInstance.setUserDetails(userDetails);
//			rcaInstance.setValue(ultimateRootCauseIssueSupport4);
//			atrList.add(rcaInstance);
//
//
//			rcaInstance = new RcaAtr();
//			rcaInstance.setEmbeddedkey(new RcaAtrId(entity.getRoCode(), map.get("rootCauseIssueSupport5")));
//			boolean isOtherRootCauseIssueSupport5 = Integer.parseInt(entity.getRootCauseIssueSupport5()) > 1000;
//			String ultimateRootCauseIssueSupport5 = isOtherRootCauseIssueSupport5 ? entity.getRootCauseIssueSupportOther5()
//					: entity.getRootCauseIssueSupport5();
//			rcaInstance.setIsOther(isOtherRootCauseIssueSupport5 ? "Y" : "N");
//			rcaInstance.setUserDetails(userDetails);
//			rcaInstance.setValue(ultimateRootCauseIssueSupport5);
//			atrList.add(rcaInstance);
//			

			rcaInstance = new RcaAtr();
			rcaInstance
					.setEmbeddedkey(new RcaAtrId(entity.getRoCode(), map.get("workScope"), entity.getRootCauseSrNo()));
			rcaInstance.setIsOther("N");
			rcaInstance.setUserDetails(userDetails);
			rcaInstance.setValue(entity.getWorkScope());
			atrList.add(rcaInstance);

			rcaInstance = new RcaAtr();
			rcaInstance.setEmbeddedkey(
					new RcaAtrId(entity.getRoCode(), map.get("targetSupportStart"), entity.getRootCauseSrNo()));
			rcaInstance.setIsOther("Y");
			rcaInstance.setUserDetails(userDetails);
			rcaInstance.setValue(formatDate(entity.getTargetSupportStart()));

			atrList.add(rcaInstance);

			rcaInstance = new RcaAtr();
			rcaInstance.setEmbeddedkey(
					new RcaAtrId(entity.getRoCode(), map.get("targetSupportEnd"), entity.getRootCauseSrNo()));
			rcaInstance.setIsOther("Y");
			rcaInstance.setUserDetails(userDetails);
			rcaInstance.setValue(formatDate(entity.getTargetSupportEnd()));
			atrList.add(rcaInstance);

			rcaInstance = new RcaAtr();
			rcaInstance.setEmbeddedkey(
					new RcaAtrId(entity.getRoCode(), map.get("actualSupportStart"), entity.getRootCauseSrNo()));
			rcaInstance.setIsOther("Y");
			rcaInstance.setUserDetails(userDetails);
			rcaInstance.setValue(formatDate(entity.getActualSupportStart()));
			atrList.add(rcaInstance);

		}

		rcaInstance = new RcaAtr();
		rcaInstance.setEmbeddedkey(
				new RcaAtrId(entity.getRoCode(), map.get("actualSupportEnd"), entity.getRootCauseSrNo()));
		rcaInstance.setIsOther("Y");
		rcaInstance.setUserDetails(userDetails);
		rcaInstance.setValue(formatDate(entity.getActualSupportEnd()));
		atrList.add(rcaInstance);

//		rcaInstance = new RcaAtr();
//		rcaInstance.setEmbeddedkey(new RcaAtrId(entity.getRoCode(), map.get("attainer"),entity.getRootCauseSrNo()));
//		rcaInstance.setIsOther("N");
//		rcaInstance.setUserDetails(userDetails);
//		rcaInstance.setValue(entity.getAttainer());
//		atrList.add(rcaInstance);

//		rcaInstance = new RcaAtr();
//		rcaInstance.setEmbeddedkey(new RcaAtrId(entity.getRoCode(), map.get("sauKaSankalp"),entity.getRootCauseSrNo()));
//		rcaInstance.setIsOther("N");
//		rcaInstance.setUserDetails(userDetails);
//		rcaInstance.setValue(entity.getSauKaSankalp());
//		atrList.add(rcaInstance);

		if (!entity.getSupportStatus().equals("")) {
			rcaInstance = new RcaAtr();
			rcaInstance.setEmbeddedkey(
					new RcaAtrId(entity.getRoCode(), map.get("supportStatus"), entity.getRootCauseSrNo()));
			boolean isOthersupportStatus = Integer.parseInt(entity.getSupportStatus()) == 999;
			String ultimateSupportStatus = isOthersupportStatus ? entity.getSupportStatusOther()
					: entity.getSupportStatus();
			rcaInstance.setIsOther(isOthersupportStatus ? "Y" : "N");
			rcaInstance.setUserDetails(userDetails);
			rcaInstance.setValue(ultimateSupportStatus);
			atrList.add(rcaInstance);
		}

		rcaInstance = new RcaAtr();
		rcaInstance
				.setEmbeddedkey(new RcaAtrId(entity.getRoCode(), map.get("approvalStatus"), entity.getRootCauseSrNo()));
		rcaInstance.setIsOther("N");
		rcaInstance.setUserDetails(userDetails);
		rcaInstance.setValue(entity.getApprovalStatus());
		atrList.add(rcaInstance);

		rcaInstance = new RcaAtr();
		rcaInstance.setEmbeddedkey(new RcaAtrId(entity.getRoCode(), map.get("pendingWith"), entity.getRootCauseSrNo()));
		rcaInstance.setIsOther("N");
		rcaInstance.setUserDetails(userDetails);
		rcaInstance.setValue(entity.getPendingWith());
		atrList.add(rcaInstance);

		rcaInstance = new RcaAtr();
		rcaInstance.setEmbeddedkey(new RcaAtrId(entity.getRoCode(), map.get("lastVisit"), entity.getRootCauseSrNo()));
		rcaInstance.setIsOther("Y");
		rcaInstance.setUserDetails(userDetails);
		rcaInstance.setValue(formatDate(entity.getLastVisit()));
		atrList.add(rcaInstance);

		rcaInstance = new RcaAtr();
		rcaInstance.setEmbeddedkey(new RcaAtrId(entity.getRoCode(), map.get("comments"), entity.getRootCauseSrNo()));
		rcaInstance.setIsOther("Y");
		rcaInstance.setUserDetails(userDetails);
		rcaInstance.setValue(entity.getComments());
		atrList.add(rcaInstance);

		rcaInstance = new RcaAtr();
		rcaInstance
				.setEmbeddedkey(new RcaAtrId(entity.getRoCode(), map.get("lastVisitDays"), entity.getRootCauseSrNo()));
		rcaInstance.setIsOther("Y");
		rcaInstance.setUserDetails(userDetails);
		rcaInstance.setValue(String.valueOf(entity.getLastVisitDays()));
		atrList.add(rcaInstance);

		rcaInstance = new RcaAtr();
		rcaInstance.setEmbeddedkey(new RcaAtrId(entity.getRoCode(), map.get("workStatus"), entity.getRootCauseSrNo()));
		rcaInstance.setIsOther("N");
		rcaInstance.setUserDetails(userDetails);
		rcaInstance.setValue(entity.getWorkStatus());
		atrList.add(rcaInstance);

		rcaInstance = new RcaAtr();
		rcaInstance.setEmbeddedkey(new RcaAtrId(entity.getRoCode(), map.get("daysDelay"), entity.getRootCauseSrNo()));
		rcaInstance.setIsOther("Y");
		rcaInstance.setUserDetails(userDetails);
		rcaInstance.setValue(String.valueOf(entity.getDaysDelay()));
		atrList.add(rcaInstance);

		rcaInstance = new RcaAtr();
		rcaInstance
				.setEmbeddedkey(new RcaAtrId(entity.getRoCode(), map.get("reconstitution"), entity.getRootCauseSrNo()));
		rcaInstance.setIsOther("N");
		rcaInstance.setUserDetails(userDetails);
		rcaInstance.setValue(String.valueOf(entity.getReconstitution()));
		atrList.add(rcaInstance);

		rcaAtrDao.saveAll(atrList);
		return isComplete;

	}

	private boolean isFuture(String lastVisit) throws ParseException {
		if ("".equals(lastVisit) || lastVisit == null) {
			return false;
		}
		SimpleDateFormat input = new SimpleDateFormat("yyyy-mm-dd");
//		SimpleDateFormat output = new SimpleDateFormat("yyyymmdd");
		Date dateValue = input.parse(lastVisit);
		if (dateValue.compareTo(new Date()) > 1) {
			return true;
		}
//		String today = output.format(new Date());

		return false;
	}

	private boolean isComplete(String[] args) {
		boolean isComplete = true;
		for (String arg : args) {
			if (!isComplete)
				break;
			if (arg == null || arg.equals(""))
				isComplete = false;
		}
		return isComplete;
	}

	private String formatDate(String inputdate) throws ParseException {
		if (inputdate == null || inputdate.equals(""))
			return "";
		SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd");
		Date dateValue = input.parse(inputdate);
		SimpleDateFormat output = new SimpleDateFormat("dd-MMM-yyyy");
		return output.format(dateValue);
	}

}
