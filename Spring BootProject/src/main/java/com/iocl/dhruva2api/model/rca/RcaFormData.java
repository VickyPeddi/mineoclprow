package com.iocl.dhruva2api.model.rca;

/*import com.itextpdf.styledxmlparser.jsoup.Jsoup;

import com.itextpdf.styledxmlparser.jsoup.safety.Whitelist;*/

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

//Before adding any new property, please add in MST_RCA_ATTRIBUTES table. That will be used for saving data in tran table.
public class RcaFormData {

	private int roCode;
	private String attainer;
	private String sauKaSankalp;
	private String rootCauseRank;
	private int rootCauseSrNo;

	private String rootCause1;
	private String rootCauseOther1;
	private String rootCauseIssue1;
	private String rootCauseIssueOther1;
	private String rootCauseIssueSupport1;
	private String rootCauseIssueSupportOther1;

	// private String rootCause2;
	// private String rootCauseOther2;
	// private String rootCauseIssue2;
	// private String rootCauseIssueOther2;
	// private String rootCauseIssueSupport2;
	// private String rootCauseIssueSupportOther2;
	//
	// private String rootCause3;
	// private String rootCauseOther3;
	// private String rootCauseIssue3;
	// private String rootCauseIssueOther3;
	// private String rootCauseIssueSupport3;
	// private String rootCauseIssueSupportOther3;
	//
	// private String rootCause4;
	// private String rootCauseOther4;
	// private String rootCauseIssue4;
	// private String rootCauseIssueOther4;
	// private String rootCauseIssueSupport4;
	// private String rootCauseIssueSupportOther4;
	//
	private String rootCause5;
	private String rootCauseOther5;
	private String rootCauseIssue5;
	private String rootCauseIssueOther5;
	private String rootCauseIssueSupport5;
	private String rootCauseIssueSupportOther5;

	private String workScope;
	private String targetSupportStart;
	private String targetSupportEnd;
	private String approvalStatus;
	private String pendingWith;
	private String lastVisit;
	private String supportStatus;
	private String comments;
	private int lastVisitDays;
	private String workStatus;
	private String supportStatusOther;
	private int daysDelay;
	private String reconstitution;
	private String actualSupportStart;
	private String actualSupportEnd;

	public int getRootCauseSrNo() {
		return rootCauseSrNo;
	}

	public void setRootCauseSrNo(int rootCauseSrNo) {
		this.rootCauseSrNo = rootCauseSrNo;
	}

	public int getRoCode() {
		return roCode;
	}

	public void setRoCode(int roCode) {
		this.roCode = roCode;
	}

	public String getAttainer() {
		return attainer;
	}

	public void setAttainer(String attainer) {
		this.attainer = attainer;
	}

	public String getSauKaSankalp() {
		return sauKaSankalp;
	}

	public void setSauKaSankalp(String sauKaSankalp) {
		this.sauKaSankalp = sauKaSankalp;
	}

	public String getRootCauseRank() {
		return rootCauseRank;
	}

	public void setRootCauseRank(String rootCauseRank) {
		this.rootCauseRank = rootCauseRank;
	}

	public String getRootCause1() {
		return rootCause1;
	}

	public void setRootCause1(String rootCause1) {
		this.rootCause1 = rootCause1;
	}

	public String getRootCauseOther1() {
		return rootCauseOther1;
	}

	public void setRootCauseOther1(String rootCauseOther1) {
		this.rootCauseOther1 = rootCauseOther1;
	}

	public String getRootCauseIssue1() {
		return rootCauseIssue1;
	}

	public void setRootCauseIssue1(String rootCauseIssue1) {
		this.rootCauseIssue1 = rootCauseIssue1;
	}

	public String getRootCauseIssueOther1() {
		return rootCauseIssueOther1;
	}

	public void setRootCauseIssueOther1(String rootCauseIssueOther1) {
		this.rootCauseIssueOther1 = rootCauseIssueOther1;
	}

	public String getRootCauseIssueSupport1() {
		return rootCauseIssueSupport1;
	}

	public void setRootCauseIssueSupport1(String rootCauseIssueSupport1) {
		this.rootCauseIssueSupport1 = rootCauseIssueSupport1;
	}

	public String getRootCauseIssueSupportOther1() {
		return rootCauseIssueSupportOther1;
	}

	public void setRootCauseIssueSupportOther1(String rootCauseIssueSupportOther1) {
		this.rootCauseIssueSupportOther1 = rootCauseIssueSupportOther1;
	}

	// public String getRootCause2() {
	// return rootCause2;
	// }
	// public void setRootCause2(String rootCause2) {
	// this.rootCause2 = rootCause2;
	// }
	// public String getRootCauseOther2() {
	// return rootCauseOther2;
	// }
	// public void setRootCauseOther2(String rootCauseOther2) {
	// this.rootCauseOther2 = rootCauseOther2;
	// }
	// public String getRootCauseIssue2() {
	// return rootCauseIssue2;
	// }
	// public void setRootCauseIssue2(String rootCauseIssue2) {
	// this.rootCauseIssue2 = rootCauseIssue2;
	// }
	// public String getRootCauseIssueOther2() {
	// return rootCauseIssueOther2;
	// }
	// public void setRootCauseIssueOther2(String rootCauseIssueOther2) {
	// this.rootCauseIssueOther2 = rootCauseIssueOther2;
	// }
	// public String getRootCauseIssueSupport2() {
	// return rootCauseIssueSupport2;
	// }
	// public void setRootCauseIssueSupport2(String rootCauseIssueSupport2) {
	// this.rootCauseIssueSupport2 = rootCauseIssueSupport2;
	// }
	// public String getRootCauseIssueSupportOther2() {
	// return rootCauseIssueSupportOther2;
	// }
	// public void setRootCauseIssueSupportOther2(String
	// rootCauseIssueSupportOther2) {
	// this.rootCauseIssueSupportOther2 = rootCauseIssueSupportOther2;
	// }
	// public String getRootCause3() {
	// return rootCause3;
	// }
	// public void setRootCause3(String rootCause3) {
	// this.rootCause3 = rootCause3;
	// }
	// public String getRootCauseOther3() {
	// return rootCauseOther3;
	// }
	// public void setRootCauseOther3(String rootCauseOther3) {
	// this.rootCauseOther3 = rootCauseOther3;
	// }
	// public String getRootCauseIssue3() {
	// return rootCauseIssue3;
	// }
	// public void setRootCauseIssue3(String rootCauseIssue3) {
	// this.rootCauseIssue3 = rootCauseIssue3;
	// }
	// public String getRootCauseIssueOther3() {
	// return rootCauseIssueOther3;
	// }
	// public void setRootCauseIssueOther3(String rootCauseIssueOther3) {
	// this.rootCauseIssueOther3 = rootCauseIssueOther3;
	// }
	// public String getRootCauseIssueSupport3() {
	// return rootCauseIssueSupport3;
	// }
	// public void setRootCauseIssueSupport3(String rootCauseIssueSupport3) {
	// this.rootCauseIssueSupport3 = rootCauseIssueSupport3;
	// }
	// public String getRootCauseIssueSupportOther3() {
	// return rootCauseIssueSupportOther3;
	// }
	// public void setRootCauseIssueSupportOther3(String
	// rootCauseIssueSupportOther3) {
	// this.rootCauseIssueSupportOther3 = rootCauseIssueSupportOther3;
	// }
	// public String getRootCause4() {
	// return rootCause4;
	// }
	// public void setRootCause4(String rootCause4) {
	// this.rootCause4 = rootCause4;
	// }
	// public String getRootCauseOther4() {
	// return rootCauseOther4;
	// }
	// public void setRootCauseOther4(String rootCauseOther4) {
	// this.rootCauseOther4 = rootCauseOther4;
	// }
	// public String getRootCauseIssue4() {
	// return rootCauseIssue4;
	// }
	// public void setRootCauseIssue4(String rootCauseIssue4) {
	// this.rootCauseIssue4 = rootCauseIssue4;
	// }
	// public String getRootCauseIssueOther4() {
	// return rootCauseIssueOther4;
	// }
	// public void setRootCauseIssueOther4(String rootCauseIssueOther4) {
	// this.rootCauseIssueOther4 = rootCauseIssueOther4;
	// }
	// public String getRootCauseIssueSupport4() {
	// return rootCauseIssueSupport4;
	// }
	// public void setRootCauseIssueSupport4(String rootCauseIssueSupport4) {
	// this.rootCauseIssueSupport4 = rootCauseIssueSupport4;
	// }
	// public String getRootCauseIssueSupportOther4() {
	// return rootCauseIssueSupportOther4;
	// }
	// public void setRootCauseIssueSupportOther4(String
	// rootCauseIssueSupportOther4) {
	// this.rootCauseIssueSupportOther4 = rootCauseIssueSupportOther4;
	// }
	public String getRootCause5() {
		return rootCause5;
	}

	public void setRootCause5(String rootCause5) {
		this.rootCause5 = rootCause5;
	}

	public String getRootCauseOther5() {
		return rootCauseOther5;
	}

	public void setRootCauseOther5(String rootCauseOther5) {
		this.rootCauseOther5 = rootCauseOther5;
	}

	public String getRootCauseIssue5() {
		return rootCauseIssue5;
	}

	public void setRootCauseIssue5(String rootCauseIssue5) {
		this.rootCauseIssue5 = rootCauseIssue5;
	}

	public String getRootCauseIssueOther5() {
		return rootCauseIssueOther5;
	}

	public void setRootCauseIssueOther5(String rootCauseIssueOther5) {
		this.rootCauseIssueOther5 = rootCauseIssueOther5;
	}

	public String getRootCauseIssueSupport5() {
		return rootCauseIssueSupport5;
	}

	public void setRootCauseIssueSupport5(String rootCauseIssueSupport5) {
		this.rootCauseIssueSupport5 = rootCauseIssueSupport5;
	}

	public String getRootCauseIssueSupportOther5() {
		return rootCauseIssueSupportOther5;
	}

	public void setRootCauseIssueSupportOther5(String rootCauseIssueSupportOther5) {
		this.rootCauseIssueSupportOther5 = rootCauseIssueSupportOther5;
	}

	public String getWorkScope() {
		return workScope;
	}

	public void setWorkScope(String workScope) {
		this.workScope = workScope;
	}

	public String getTargetSupportStart() {
		return targetSupportStart;
	}

	public void setTargetSupportStart(String targetSupportStart) {
		this.targetSupportStart = targetSupportStart;
	}

	public String getTargetSupportEnd() {
		return targetSupportEnd;
	}

	public void setTargetSupportEnd(String targetSupportEnd) {
		this.targetSupportEnd = targetSupportEnd;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getPendingWith() {
		return pendingWith;
	}

	public void setPendingWith(String pendingWith) {
		this.pendingWith = pendingWith;
	}

	public String getLastVisit() {
		return lastVisit;
	}

	public void setLastVisit(String lastVisit) {
		this.lastVisit = lastVisit;
	}

	public String getSupportStatus() {
		return supportStatus;
	}

	public void setSupportStatus(String supportStatus) {
		this.supportStatus = supportStatus;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = Jsoup.clean(comments, Whitelist.none());
	}

	public int getLastVisitDays() {
		return lastVisitDays;
	}

	public void setLastVisitDays(int lastVisitDays) {
		this.lastVisitDays = lastVisitDays;
	}

	public String getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

	public String getSupportStatusOther() {
		return supportStatusOther;
	}

	public void setSupportStatusOther(String supportStatusOther) {
		this.supportStatusOther = supportStatusOther;
	}

	public int getDaysDelay() {
		return daysDelay;
	}

	public void setDaysDelay(int daysDelay) {
		this.daysDelay = daysDelay;
	}

	public String getReconstitution() {
		return reconstitution;
	}

	public void setReconstitution(String reconstitution) {
		this.reconstitution = reconstitution;
	}

	public String getActualSupportStart() {
		return actualSupportStart;
	}

	public void setActualSupportStart(String actualSupportStart) {
		this.actualSupportStart = actualSupportStart;
	}

	public String getActualSupportEnd() {
		return actualSupportEnd;
	}

	public void setActualSupportEnd(String actualSupportEnd) {
		this.actualSupportEnd = actualSupportEnd;
	}

}
