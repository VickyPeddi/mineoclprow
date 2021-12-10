import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { StateDhruvaIndex } from './model/state-dhruva-index.model';
import { DivisionDhruvaIndex } from './model/division-dhruva-index.model';
import { DivisionEnggIndex } from './model/division-engg-index.model';
import { StateEnggIndex } from './model/state-engg-index.model';
import { SoManagerDhruvaIndex } from './model/state-manager-index.model';
import { WeightageData } from './model/weightage-data.model';
import { DoManagerIndex } from './model/division-manager-index.model';
import { AuditMaster } from './model/audit-master.model';
import { AuditorMenuItem } from './model/auditor-menu.model';
import { VendorDetails } from './model/vendor-details.model';
import { VendorPersonnel } from './model/vendor-manage.model';
import { ApiResponse } from './model/api-response.model';
import { DhruvaResourceCategory } from './model/dhruva-resource-category.model';
import { DivisionDhruvaAWESUMIndex } from './model/division-dhruva-awesum-index.model';
import { StateDhruvaAWESUMIndex } from './model/state-dhruva-awesum-index.model';
import { SalesAreaDhruvaAWESUMIndex } from './model/sales-area-dhruva-awesum-index.model';
import { DhruvaComplianceIndex } from './model/dhruva-compliance-points.model';
import { DhruvaHelpPersonnel } from './model/dhruva-help-personnel.model';
import { SideBarMenu } from './model/side-bar-menu.model';
import { TrackerRoMaster } from './model/tracker-ro-master.model';
import { AuditWiseFITDetail } from './model/audit-wise-fit-detail.model';
import { AuditUserMaster } from './model/auditor-master.model';
import { SQCAuditMaster } from './model/sqc-audit-master.model';
import { FOAuditMaster } from './model/fo-audit-master.model';
import { DealerAuditMaster } from './model/dealer-audit-master.model';

@Injectable()
export class DataProviderService {

	public healthStatus: Observable<string>;

	constructor(private http: HttpClient) {
		this.healthStatus = this.loadAPIHealthStatus();
	}

	//This method is being used in tracker	
	loadAuditWiseFitDetails(currentAuditNo: number): Observable<AuditWiseFITDetail[]> {
		const httpOptions = {
			headers: new HttpHeaders({ 'Content-Type': 'application/json;charset=UTF-8' })
		};
		return this.http.post<AuditWiseFITDetail[]>(`${environment.backEndUrl}/fit-tracker/audit-wise-fit-details`,
			'{"currentAudit" : "' + currentAuditNo + '"}', httpOptions);
	}

	getPdf(reportName: string, auditMaster: AuditMaster): Observable<any> {
		const httpOptions = {
			responseType: 'blob' as 'json', headers: new HttpHeaders({ 'Content-Type': 'application/json;charset=UTF-8' })
		};
		return this.http.post(`${environment.auditBackEndUrl}/report/${reportName}`, JSON.stringify(auditMaster), httpOptions);
	}

	getSQCReport(reportName: string, sqcAuditMaster: SQCAuditMaster): Observable<any> {
		const httpOptions = {
			responseType: 'blob' as 'json', headers: new HttpHeaders({ 'Content-Type': 'application/json;charset=UTF-8' })
		};
		return this.http.post(`${environment.auditBackEndUrl}/sqc-audit/${reportName}`, JSON.stringify(sqcAuditMaster), httpOptions);
	}

	getFOSelfAuditReport(reportName: string, foAuditMaster: FOAuditMaster): Observable<any> {
		const httpOptions = {
			responseType: 'blob' as 'json', headers: new HttpHeaders({ 'Content-Type': 'application/json;charset=UTF-8' })
		};
		return this.http.post(`${environment.auditBackEndUrl}/fo-self-audit/${reportName}`, JSON.stringify(foAuditMaster), httpOptions);
	}

	getDealerSelfAuditReport(reportName: string, dealerAuditMaster: DealerAuditMaster): Observable<any> {
		const httpOptions = {
			responseType: 'blob' as 'json', headers: new HttpHeaders({ 'Content-Type': 'application/json;charset=UTF-8' })
		};
		return this.http.post(`${environment.auditBackEndUrl}/dealer-self-audit/${reportName}`, JSON.stringify(dealerAuditMaster), httpOptions);
	}

	getAuditUserDocuments(documentName: string, auditUserMaster: AuditUserMaster): Observable<any> {
		const httpOptions = {
			responseType: 'blob' as 'json', headers: new HttpHeaders({ 'Content-Type': 'application/json;charset=UTF-8' })
		};
		return this.http.post(`${environment.backEndUrl}/audit-user/documents/${documentName}`, JSON.stringify(auditUserMaster), httpOptions);
	}

	loadAPIHealthStatus(): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/health`);
	}

	loadCaptcha(): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/auth/generate-captcha`);
	}

	loadSubmittedActivityInputDatas(roCode: number): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/activity/submitted-activities-input/${roCode}`);
	}
	loadROsWhereActivitiesHaveBeenSubmitted(): any {
		return this.http.get(`${environment.backEndUrl}/activity/submitted-ros`);
	}

	loadROsAndAttributesWhereRCAHaveBeenSubmitted(): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/root-cause/submitted-ros`);
	}

	loadRootCausesData(): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/root-cause/root-cause-datas`);
	}

	loadRootCauseIssuesData(causeId: number): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/root-cause/issues/${causeId}`);
	}

	loadRootCauseIssueSupportOptions(issueId: number): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/root-cause/issue/support/${issueId}`);
	}

	loadSubmittedRootCauseDatas(roCode: number, part: number): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/root-cause/root-cause-data/${roCode}/${part}`);
	}

	loadMISArchetypes(): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/mis/archetype-list`);
	}

	loadMISPhases(): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/mis/phase-list`);
	}

	loadMISParameters(): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/mis/parameter-list`);
	}

	loadMISReport(id: number): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/menus/mis-tab/report/${id}`);
	}

	loadSODOSAMaster(): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/mis/so-do-sa-list`);
	}

	loadSideBarInputMenus(): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/menus/input-tabs`);
	}

	loadSideBarLeaderboardMenus(): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/menus/leaderboard-tabs`);
	}

	loadSideBarMISMenus(): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/menus/mis-tabs`);
	}

	loadSideBarAuditorMenus(): Observable<AuditorMenuItem[]> {
		return this.http.get<AuditorMenuItem[]>(`${environment.backEndUrl}/menus/audit-tabs`);
	}

	// loadMISReportValues1(reportId: number, soCode: number, doCode: number, salesArea: string): Observable<any> {
	//     return this.http.get(`${environment.backEndUrl}/mis/show-mis-report/${reportId}/${soCode}/${doCode}/${salesArea}`);
	// }

	// loadMISReportValues2(reportId: number, soCode: number, doCode: number, salesArea: string, fromDate: string, toDate: string): Observable<any> {
	//     return this.http.get(`${environment.backEndUrl}/mis/show-mis-report/${reportId}/${soCode}/${doCode}/${salesArea}/${fromDate}/${toDate}`);
	// }

	loadMISReportValues(reportId: number, soCode: number, doCode: number, salesArea: string, reportType: number, fromDate?: string, toDate?: string, filterType?: number, archetype?: number, phase?: string, filterSite?: number, financialYear?: string, financialQuarter?: string, filterIndex?: number, parameter?: number): Observable<any> {

		switch (reportType) {
			case 1:
				// console.log('report type 1 ');
				return this.http.get(`${environment.backEndUrl}/mis/show-mis-report/${reportId}/${soCode}/${doCode}/${salesArea}`);
			// break;
			case 2:
				// console.log('report type 2 ');
				return this.http.get(`${environment.backEndUrl}/mis/show-mis-report/${reportId}/${soCode}/${doCode}`,
					{
						params: new HttpParams().set('fromDate', fromDate).set('toDate', toDate)
					});
			// return this.http.get(`${environment.backEndUrl}/mis/show-mis-report/${reportId}/${soCode}/${doCode}/${fromDate}/${toDate}`);
			// break;
			case 3:
				// console.log('report type 3 ');
				return this.http.get(`${environment.backEndUrl}/mis/show-mis-report/${reportId}/${soCode}/${doCode}/${salesArea}/${fromDate}/${toDate}/${filterType}`);
			// break;
			case 4:
				// console.log('report type 4 ');
				return this.http.get(`${environment.backEndUrl}/mis/show-mis-report/${reportId}/${soCode}/${doCode}/${salesArea}/${filterType}`);
			// break;
			case 5:
				// console.log('report type 5 ');
				return this.http.get(`${environment.backEndUrl}/mis/show-mis-report/${reportId}/${soCode}/${doCode}/${salesArea}/${fromDate}/${toDate}`);
			// break;
			case 6:
				// console.log('report type 6 ');
				return this.http.get(`${environment.backEndUrl}/mis/show-mis-report/${reportId}/${soCode}/${doCode}/${salesArea}/${fromDate}/${toDate}/${filterType}`);
			// break;
			case 7:
				// console.log('report type 7 ');
				return this.http.get(`${environment.backEndUrl}/mis/show-mis-report/${reportId}/${soCode}/${doCode}/${salesArea}`);
			case 8:
				// console.log('report type 8 ');
				return this.http.get(`${environment.backEndUrl}/mis/show-mis-report/${reportId}`,
					{
						params: new HttpParams()
							.set('salesOrg', String(soCode))
							.set('salesOff', String(doCode))
							.set('salesArea', String(salesArea))
							.set('archetypeCode', String(archetype))
							.set('phase', phase)
					});
			case 9:
				// console.log('report type 9 ');
				return this.http.get(`${environment.backEndUrl}/mis/show-mis-report/${reportId}/${soCode}`,
					{
						params: new HttpParams()
							.set('salesOff', String(doCode))
							.set('salesArea', String(salesArea))
							.set('filterType', String(filterType))
							.set('filterSite', String(filterSite))
					});
			case 10:
				// console.log('report type 9 ');
				return this.http.get(`${environment.backEndUrl}/mis/show-mis-report-class-ten/${reportId}/${soCode}/${doCode}/${salesArea}/${archetype}/${phase}`,
					{
						params: new HttpParams()
							.set('financialYear', financialYear)
							.set('financialQuarter', financialQuarter)
							.set('filterIndex', String(filterIndex))
							.set('filterSite', String(filterSite))
					});
			case 11:
				// console.log('report type 9 ');
				return this.http.get(`${environment.backEndUrl}/mis/show-mis-report-class-eleven/${reportId}/${soCode}/${doCode}/${salesArea}/${archetype}/${phase}`,
					{
						params: new HttpParams()
							.set('financialYear', financialYear)
							.set('financialQuarter', financialQuarter)
							.set('filterIndex', String(filterIndex))
							.set('filterSite', String(filterSite))
							.set('filterParameter', String(parameter))
					});
			case 12:
				// console.log('report type 9 ');
				return this.http.get(`${environment.backEndUrl}/mis/show-mis-report-class-twelve/${reportId}/${soCode}/${doCode}/${salesArea}/${archetype}/${phase}`,
					{
						params: new HttpParams()
							.set('financialYear', financialYear)
							.set('financialQuarter', financialQuarter)
							.set('filterSite', String(filterSite))
							.set('filterType', String(filterType))
					});
			case 13:
				// console.log('report type 9 ');
				return this.http.get(`${environment.backEndUrl}/mis/show-mis-report-class-thirteen/${reportId}/${soCode}/${doCode}/${salesArea}/${archetype}/${phase}`,
					{
						params: new HttpParams()
							.set('financialYear', financialYear)
							.set('financialQuarter', financialQuarter)
							.set('filterSite', String(filterSite))
					});
			case 14:
				// console.log('report type 14 ');
				return this.http.get(`${environment.backEndUrl}/mis/show-mis-report-class-fourteen/${reportId}/${soCode}/${doCode}/${salesArea}/${archetype}/${phase}`,
					{
						params: new HttpParams()
							.set('filterIndex', String(filterIndex))
							.set('filterSite', String(filterSite))
					});
			case 15:
				console.log('report type 15 ');
				return this.http.get(`${environment.backEndUrl}/mis/show-mis-report-class-fifteen/${reportId}/${soCode}/${doCode}/${salesArea}/${archetype}/${phase}`,
					{
						params: new HttpParams()
							.set('filterSite', String(filterSite))
					});
			case 16:
				console.log('report type 16 ');
				return this.http.get(`${environment.backEndUrl}/mis/show-mis-report-class-sixteen/${reportId}/${soCode}/${doCode}/${salesArea}/${archetype}/${phase}`,
					{
						params: new HttpParams()
							.set('filterIndex', String(filterIndex))
							.set('filterParameter', String(parameter))
							.set('filterSite', String(filterSite))
					});
			case 17:
				// console.log('report type 17 ');
				return this.http.get(`${environment.backEndUrl}/mis/show-mis-report-class-seventeen/${reportId}/${soCode}/${doCode}/${salesArea}/${archetype}/${phase}`,
					{
						params: new HttpParams()
							.set('financialYear', financialYear)
							.set('filterSite', String(filterSite))
					});

			case 18:
				// console.log('report type 18 ');
				return this.http.get(`${environment.backEndUrl}/mis/show-mis-report-class-eighteen/${reportId}/${soCode}/${doCode}/${salesArea}/${archetype}/${phase}`,
					{
						params: new HttpParams()
							.set('financialYear', financialYear)
							.set('filterSite', String(filterSite))
							.set('filterType', String(filterType))
					});
			case 19:
				// console.log('report type 19 ');
				return this.http.get(`${environment.backEndUrl}/mis/show-mis-report-class-nineteen/${reportId}/${soCode}/${doCode}/${salesArea}/${archetype}/${phase}`,
					{
						params: new HttpParams()
							.set('financialYear', financialYear)
							.set('filterIndex', String(filterIndex))
							.set('filterSite', String(filterSite))
							.set('filterParameter', String(parameter))
					});
			default:
				break;
		}
	}

	loadSpotCheckDatas(archetypeCode: number): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/spot-check/spot-check-datas/${archetypeCode}`);
	}

	loadSpotCheckInspNumber(roCode: number): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/spot-check/generate-insp-no/${roCode}`);
	}

	loadStateDhruvaIndex(): Observable<StateDhruvaIndex[]> {
		return this.http.get<StateDhruvaIndex[]>(`${environment.backEndUrl}/dashboard/state-dhruva-index`);
	}

	loadStateEnggIndex(): Observable<StateEnggIndex[]> {
		return this.http.get<StateEnggIndex[]>(`${environment.backEndUrl}/dashboard/state-engg-index`);
	}

	loadStateManagerIndex(): Observable<SoManagerDhruvaIndex[]> {
		return this.http.get<SoManagerDhruvaIndex[]>(`${environment.backEndUrl}/dashboard/so-manager-index`);
	}

	loadDivisionDhruvaIndex(): Observable<DivisionDhruvaIndex[]> {
		return this.http.get<DivisionDhruvaIndex[]>(`${environment.backEndUrl}/dashboard/division-dhruva-index`);
	}

	loadDivisionDhruvaIndexByState(soMaster: string): Observable<DivisionDhruvaIndex[]> {
		return this.http.get<DivisionDhruvaIndex[]>(`${environment.backEndUrl}/dashboard/division-dhruva-index/${soMaster}`);
	}

	loadDivisionEnggIndex(): Observable<DivisionEnggIndex[]> {
		return this.http.get<DivisionEnggIndex[]>(`${environment.backEndUrl}/dashboard/division-engg-index`);
	}

	loadDoManagerIndex(): Observable<DoManagerIndex[]> {
		return this.http.get<DoManagerIndex[]>(`${environment.backEndUrl}/dashboard/do-manager-index`);
	}

	loadFieldDhruvaIndex(): Observable<FieldDhruvaIndex[]> {
		return this.http.get<FieldDhruvaIndex[]>(`${environment.backEndUrl}/dashboard/field-dhruva-index`);
	}

	loadWeightageData(): Observable<WeightageData> {
		return this.http.get<WeightageData>(`${environment.backEndUrl}/dashboard/weightage-data`);
	}

	loadStateLeaderboardData(soName: string): Observable<StateDhruvaIndex> {
		return this.http.get<StateDhruvaIndex>(`${environment.backEndUrl}/dashboard/state-dhruva-index/${soName}`);
	}

	loadDivisionLeaderboardDataByDoName(doName: string): Observable<DivisionDhruvaIndex> {
		return this.http.get<DivisionDhruvaIndex>(`${environment.backEndUrl}/dashboard/division-dhruva-index-by-doname/${doName}`);
	}

	loadFieldLeaderboardDataBySaName(saName: string): Observable<FieldDhruvaIndex> {
		return this.http.get<FieldDhruvaIndex>(`${environment.backEndUrl}/dashboard/field-dhruva-index-by-saname/${saName}`);
	}

	loadStateFITScoreData(): Observable<StateDhruvaIndex[]> {
		return this.http.get<StateDhruvaIndex[]>(`${environment.backEndUrl}/dashboard/state-fit-score`);
	}

	loadDivisionFITScoreData(soName: string): Observable<DivisionDhruvaIndex[]> {
		return this.http.get<DivisionDhruvaIndex[]>(`${environment.backEndUrl}/dashboard/division-fit-score/${soName}`);
	}

	loadDivisionSEVAScoreData(soName: string): Observable<DivisionDhruvaIndex[]> {
		return this.http.get<DivisionDhruvaIndex[]>(`${environment.backEndUrl}/dashboard/division-seva-score/${soName}`);
	}

	loadStateSEVAScoreData(): Observable<StateDhruvaIndex[]> {
		return this.http.get<StateDhruvaIndex[]>(`${environment.backEndUrl}/dashboard/state-seva-score`);
	}

	loadStateAWESUMScoreDatas(): Observable<StateDhruvaAWESUMIndex[]> {
		return this.http.get<StateDhruvaAWESUMIndex[]>(`${environment.backEndUrl}/dashboard/state-awesum-score`);
	}

	loadStateAWESUMScoreData(soName: string): Observable<StateDhruvaAWESUMIndex> {
		return this.http.get<StateDhruvaAWESUMIndex>(`${environment.backEndUrl}/dashboard/state-awesum-score/${soName}`);
	}

	loadDivisionOfficeAwesumDataBySoName(soName: string): Observable<DivisionDhruvaAWESUMIndex[]> {
		return this.http.get<DivisionDhruvaAWESUMIndex[]>(`${environment.backEndUrl}/dashboard/division-awesum-score/${soName}`);
	}

	loadDivisionOfficeAwesumDataByDoName(doName: string): Observable<DivisionDhruvaAWESUMIndex> {
		return this.http.get<DivisionDhruvaAWESUMIndex>(`${environment.backEndUrl}/dashboard/division-awesum-score/division/${doName}`);
	}

	loadSaAwesumDataByDoName(doName: string): Observable<FieldDhruvaIndex[]> {
		return this.http.get<FieldDhruvaIndex[]>(`${environment.backEndUrl}/dashboard/sa-awesum-score/${doName}`);
	}

	loadSaAwesumDataBySaName(saName: string): Observable<SalesAreaDhruvaAWESUMIndex> {
		return this.http.get<SalesAreaDhruvaAWESUMIndex>(`${environment.backEndUrl}/dashboard/sa-awesum-score/sa/${saName}`);
	}

	loadSafitDataByDoName(doName: string): Observable<FieldDhruvaIndex[]> {
		return this.http.get<FieldDhruvaIndex[]>(`${environment.backEndUrl}/dashboard/sa-fit-score/${doName}`);
	}

	loadSaSevaDataByDoName(doName: string): Observable<FieldDhruvaIndex[]> {
		return this.http.get<FieldDhruvaIndex[]>(`${environment.backEndUrl}/dashboard/sa-seva-score/${doName}`);
	}

	loadSaDhruvaCompliantDataByDoName(doName: string): Observable<FieldDhruvaIndex[]> {
		return this.http.get<FieldDhruvaIndex[]>(`${environment.backEndUrl}/dashboard/sa-dhruva-compliant-score/${doName}`);
	}

	loadStateDhruvaCompliantScoreData(): Observable<StateDhruvaIndex[]> {
		return this.http.get<StateDhruvaIndex[]>(`${environment.backEndUrl}/dashboard/state-dhruva-compliant-score`);
	}

	loadDivisionDhruvaCompliantScoreData(soName: string): Observable<DivisionDhruvaIndex[]> {
		return this.http.get<DivisionDhruvaIndex[]>(`${environment.backEndUrl}/dashboard/division-dhruva-compliant-score/${soName}`);
	}

	loadFieldDhruvaIndexByDoName(doname: string): Observable<FieldDhruvaIndex[]> {
		return this.http.get<FieldDhruvaIndex[]>(`${environment.backEndUrl}/dashboard/field-dhruva-index-by-doname/${doname}`);
	}

	getSubmittedAudits(): Observable<any> {
		return this.http.get<AuditMaster[]>(`${environment.backEndUrl}/submitted-audits`);
	}

	getSubmittedAuditsPost(fromDate: any, toDate: any, roCode: string): Observable<any> {
		let body = new HttpParams();
		body = body.set('from', fromDate);
		body = body.set('to', toDate);
		body = body.set('ro', roCode);
		return this.http.post<AuditMaster[]>(`${environment.backEndUrl}/submitted-audits-post`,body);
	}

	getSQCSubmittedAudits(): Observable<any> {
		return this.http.get<SQCAuditMaster[]>(`${environment.backEndUrl}/sqc-submitted-audits`);
	}

	getFOSubmittedAudits(): Observable<any> {
		return this.http.get<FOAuditMaster[]>(`${environment.backEndUrl}/fo-submitted-audits`);
	}

	getDealerSubmittedAudits(): Observable<any> {
		return this.http.get<DealerAuditMaster[]>(`${environment.backEndUrl}/dealer-submitted-audits`);
	}

	getRegisteredAuditUsers(): Observable<any> {
		return this.http.get<AuditUserMaster[]>(`${environment.backEndUrl}/audit-user/registered-users`);
	}

	getLatestSubmittedAudits(): Observable<TrackerRoMaster[]> {
		return this.http.get<TrackerRoMaster[]>(`${environment.backEndUrl}/fit-tracker/latest-submitted-audits`);
	}

	loadVendorDetails(vendorCode: string): Observable<VendorDetails> {
		return this.http.get<VendorDetails>(`${environment.backEndUrl}/vendor/vendor-details/${vendorCode}`);
	}

	loadDoNames(): any {
		return this.http.get(`${environment.backEndUrl}/dashboard/do-list`);
	}

	loadSubmittedSpotChecks(fromDate: string, toDate: string): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/spot-check/submitted-spot-check/${fromDate}/${toDate}`);
	}

	getSpotCheckReportPdf(inspNo: number): Observable<any> {
		const httpOptions = {
			responseType: 'blob' as 'json'
		};
		return this.http.get(`${environment.backEndUrl}/spot-check/spot-check-report/${inspNo}`, httpOptions);
	}

	loadVendorPersonnelDatas(personnelType: number): Observable<VendorPersonnel[]> {
		return this.http.get<VendorPersonnel[]>(`${environment.backEndUrl}/vendor/vendor-manage-details/${personnelType}`);
	}

	togglePersonnelState(vendorCode: string, initialState: string): Observable<ApiResponse> {
		if (initialState === 'DEACTIVE') {
			return this.http.get<ApiResponse>(`${environment.backEndUrl}/vendor/vendor-manage/activate/${vendorCode}`)
		} else if (initialState === 'ACTIVE') {
			return this.http.get<ApiResponse>(`${environment.backEndUrl}/vendor/vendor-manage/deactivate/${vendorCode}`)
		}
	}

	loadDhruvaResourceDatas(): Observable<DhruvaResourceCategory[]> {
		return this.http.get<DhruvaResourceCategory[]>(`${environment.backEndUrl}/resource/categories`);
	}

	loadDhruvaResourceFile(resourceId: number): Observable<any> {
		const httpOptions = {
			responseType: 'blob' as 'json'
		};
		return this.http.get(`${environment.backEndUrl}/resource/file/${resourceId}`, httpOptions);
	}

	loadSpotCheckFOComplianceDatas(): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/spot-check/fo-compliance-datas`);
	}

	loadSpotCheckFOCompliancePoints(inspNo: number): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/spot-check/fo-compliance-points/${inspNo}`);
	}

	loadStateIndices(soName: string): Observable<DhruvaComplianceIndex> {
		return this.http.get<DhruvaComplianceIndex>(`${environment.backEndUrl}/dashboard/so-indices/${soName}`);
	}

	loadDivisionIndices(doName: string): Observable<DhruvaComplianceIndex> {
		return this.http.get<DhruvaComplianceIndex>(`${environment.backEndUrl}/dashboard/do-indices/${doName}`);
	}

	loadSalesAreaIndices(saName: string): Observable<DhruvaComplianceIndex> {
		return this.http.get<DhruvaComplianceIndex>(`${environment.backEndUrl}/dashboard/sa-indices/${saName}`);
	}

	loadDhruvaHelpPersonnel(): Observable<DhruvaHelpPersonnel[]> {
		return this.http.get<DhruvaHelpPersonnel[]>(`${environment.backEndUrl}/help/personnel`);
	}

	loadSpotCheckDRSMComplianceDatas(): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/spot-check/drsm-compliance-datas`);
	}

	loadSpotCheckDRSMCompliancePoints(inspNo: number): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/spot-check/drsm-compliance-points/${inspNo}`);
	}

	loadEmployeeDhruvaRODatas(): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/employee/`);
	}

	loadRcaROs(): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/rca-customers/`);
	}

	loadSideBarMenus(): Observable<SideBarMenu[]> {
		return this.http.get<SideBarMenu[]>(`${environment.backEndUrl}/menus/menu-tabs`);
	}

	loadMappingSalesAreas(): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/mapping/sales-areas`);
	}

	loadMappingDivisionOffices(): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/mapping/division-offices`);
	}

	loadMappingDivisionOfficeManagers(): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/mapping/division-office-managers`);
	}

	loadMappingStateOfficeManagers(): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/mapping/state-office-managers`);
	}

	loadSpotCheckModules(): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/spot-check/spot-check-modules`);
	}

	loadSpotCheckQuestions(): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/spot-check/spot-check-questions`);
	}

	loadRetailOutletsForVendorAssignment(salesOrg: string, salesOff: string, salesArea: string, archetypeCode: string, phase: string): Observable<any> {
		return this.http.get(`${environment.backEndUrl}/vendor/vendor-assign-list/${salesOrg}/${salesOff}/${salesArea}/${archetypeCode}/${phase}`);
	}

	checkSpotCheckEligibility(): Observable<ApiResponse> {
		return this.http.get<ApiResponse>(`${environment.backEndUrl}/spot-check/check-spot-check-eligibility`);
	}
}