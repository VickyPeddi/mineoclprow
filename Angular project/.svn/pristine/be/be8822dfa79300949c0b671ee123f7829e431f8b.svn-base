import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SigninComponent } from './auth/signin/signin.component';
import { HomeComponent } from './home/home.component';
import { ActivitiesCompletionComponent } from './dhruva/activities-completion/activities-completion.component';
import { AtrRcaComponent } from './dhruva/atr-rca/atr-rca.component';
import { TelecallCadenceComponent } from './dhruva/telecall-cadence/telecall-cadence.component';
import { SpotCheckFinalComponent } from './dhruva/spot-check-final/spot-check-final.component'
import { AuthGuard } from './auth/auth-guard.service';
import { MisComponent } from './dhruva/mis/mis.component';
import { CaTrainingComponent } from './dhruva/ca-training/ca-training.component';
import { SoLeaderboardComponent } from './dhruva/leaderboard/so-leaderboard/so-leaderboard.component';
import { DoLeaderboardComponent } from './dhruva/leaderboard/do-leaderboard/do-leaderboard.component';
import { FoLeaderboardComponent } from './dhruva/leaderboard/fo-leaderboard/fo-leaderboard.component';
import { DoEnggLeaderboardComponent } from './dhruva/leaderboard/do-engg-leaderboard/do-engg-leaderboard.component';
import { SoEnggLeaderboardComponent } from './dhruva/leaderboard/so-engg-leaderboard/so-engg-leaderboard.component';
import { DoManagerLeaderboardComponent } from './dhruva/leaderboard/do-manager-leaderboard/do-manager-leaderboard.component';
import { SoManagerLeaderboardComponent } from './dhruva/leaderboard/so-manager-leaderboard/so-manager-leaderboard.component';
import { AuditPdfsComponent } from './audit-report/audit-pdfs/audit-pdfs.component';
import { DashboardComponent } from './home/dashboard/dashboard.component';
import { MasterDashboardComponent } from './home/dashboard/so-dashboard/master-dashboard/master-dashboard.component';
import { FitDashboardComponent } from './home/dashboard/so-dashboard/fit-dashboard/fit-dashboard.component';
import { SevaDashboardComponent } from './home/dashboard/so-dashboard/seva-dashboard/seva-dashboard.component';
import { AwesumDashboardComponent } from './home/dashboard/so-dashboard/awesum-dashboard/awesum-dashboard.component';
import { DhruvaCompliantDashboardComponent } from './home/dashboard/so-dashboard/dhruva-compliant-dashboard/dhruva-compliant-dashboard.component';
import { SoDashboardComponent } from './home/dashboard/so-dashboard/so-dashboard.component';
import { DoDashboardComponent } from './home/dashboard/do-dashboard/do-dashboard.component';
import { SaDashboardComponent } from './home/dashboard/sa-dashboard/sa-dashboard.component';
import { DOMasterDashboardComponent } from './home/dashboard/do-dashboard/master-dashboard/do-master-dashboard.component';
import { DOFitDashboardComponent } from './home/dashboard/do-dashboard/fit-dashboard/do-fit-dashboard.component';
import { DOSevaDashboardComponent } from './home/dashboard/do-dashboard/seva-dashboard/do-seva-dashboard.component';
import { DOAwesumDashboardComponent } from './home/dashboard/do-dashboard/awesum-dashboard/do-awesum-dashboard.component';
import { DODhruvaCompliantDashboardComponent } from './home/dashboard/do-dashboard/dhruva-compliant-dashboard/do-dhruva-compliant-dashboard.component';
import { VendorAdminComponent } from './audit/vendor-admin/vendor-admin.component';
import { VendorAssignComponent } from './audit/vendor-assign/vendor-assign.component';
import { VendorManageComponent } from './audit/vendor-manage/vendor-manage.component';
import { AuditComponent } from './audit/audit.component';
import { SaMasterDashboardComponent } from './home/dashboard/sa-dashboard/master-dashboard/sa-master-dashboard.component';
import { SaFitDashboardComponent } from './home/dashboard/sa-dashboard/fit-dashboard/sa-fit-dashboard.component';
import { SaSevaDashboardComponent } from './home/dashboard/sa-dashboard/seva-dashboard/sa-seva-dashboard.component';
import { SaAwesumDashboardComponent } from './home/dashboard/sa-dashboard/awesum-dashboard/sa-awesum-dashboard.component';
import { SaDhruvaCompliantDashboardComponent } from './home/dashboard/sa-dashboard/dhruva-compliant-dashboard/sa-dhruva-compliant-dashboard.component';
import { SpotCheckReportComponent } from './audit-report/spot-check-report/spot-check-report.component';
import { AtrSpotCheckComponent } from './dhruva/atr-spot-check/atr-spot-check.component';
import { AtrSpotCheckFOComponent } from './dhruva/atr-spot-check/atr-spot-check-fo/atr-spot-check-fo.component';
import { ResourceComponent } from './dhruva/resource/resource.component';
import { HelpComponent } from './dhruva/help/help.component';
import { AtrSpotCheckDRSMComponent } from './dhruva/atr-spot-check/atr-spot-check-drsm/atr-spot-check-drsm.component';
import { MappingComponent } from './dhruva/mapping/mapping.component';
import { DivisionOfficeComponent } from './dhruva/mapping/division-office/division-office.component';
import { SalesAreaComponent } from './dhruva/mapping/sales-area/sales-area.component';
import { FitTrackerComponent } from './dhruva/fit-tracker/fit-tracker.component';
import { DsaSummaryComponent } from './dhruva/dsa-summary/dsa-summary.component';
import { AuditUserDocumentsComponent } from './audit-report/audit-user-documents/audit-user-documents.component';
import { SqcAuditPdfsComponent } from './audit-report/sqc-audit-pdfs/sqc-audit-pdfs.component';
import { FoAuditPdfsComponent } from './audit-report/fo-audit-pdfs/fo-audit-pdfs.component';
import { DealerAuditPdfsComponent } from './audit-report/dealer-audit-pdfs/dealer-audit-pdfs.component';



const routes: Routes = [
	{ path: '', pathMatch: 'full', redirectTo: '/signin' },
	{ path: 'signin', component: SigninComponent },
	{
		path: 'home', component: HomeComponent, canActivate: [AuthGuard], children: [
			{
				path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard], children: [
					{
						path: 'state-office', component: SoDashboardComponent, canActivate: [AuthGuard], children: [
							{ path: 'master-dashboard', component: MasterDashboardComponent, canActivate: [AuthGuard] },
							{ path: 'fit-dashboard', component: FitDashboardComponent, canActivate: [AuthGuard] },
							{ path: 'seva-dashboard', component: SevaDashboardComponent, canActivate: [AuthGuard] },
							{ path: 'awesum-dashboard', component: AwesumDashboardComponent, canActivate: [AuthGuard] },
							{ path: 'dhruva-compliant-dashboard', component: DhruvaCompliantDashboardComponent, canActivate: [AuthGuard] }
						]
					},
					{
						path: 'division-office', component: DoDashboardComponent, canActivate: [AuthGuard], children: [
							{ path: 'master-dashboard', component: DOMasterDashboardComponent, canActivate: [AuthGuard] },
							{ path: 'fit-dashboard', component: DOFitDashboardComponent, canActivate: [AuthGuard] },
							{ path: 'seva-dashboard', component: DOSevaDashboardComponent, canActivate: [AuthGuard] },
							{ path: 'awesum-dashboard', component: DOAwesumDashboardComponent, canActivate: [AuthGuard] },
							{ path: 'dhruva-compliant-dashboard', component: DODhruvaCompliantDashboardComponent, canActivate: [AuthGuard] }
						]
					},
					{
						path: 'sales-area', component: SaDashboardComponent, canActivate: [AuthGuard], children: [
							{ path: 'master-dashboard', component: SaMasterDashboardComponent, canActivate: [AuthGuard] },
							{ path: 'fit-dashboard', component: SaFitDashboardComponent, canActivate: [AuthGuard] },
							{ path: 'seva-dashboard', component: SaSevaDashboardComponent, canActivate: [AuthGuard] },
							{ path: 'awesum-dashboard', component: SaAwesumDashboardComponent, canActivate: [AuthGuard] },
							{ path: 'dhruva-compliant-dashboard', component: SaDhruvaCompliantDashboardComponent, canActivate: [AuthGuard] }
						]
					}
				]
			},
			{
				path: 'vendor', component: AuditComponent, canActivate: [AuthGuard], children: [
					{ path: 'admin', component: VendorAdminComponent, canActivate: [AuthGuard] },
					{ path: 'assign', component: VendorAssignComponent, canActivate: [AuthGuard] },
					{ path: 'manage', component: VendorManageComponent, canActivate: [AuthGuard] }
				]
			},
			{ path: 'act-comp', component: ActivitiesCompletionComponent, canActivate: [AuthGuard] },
			{ path: 'atr-rca', component: AtrRcaComponent, canActivate: [AuthGuard] },
			{ path: 'tel-cad', component: TelecallCadenceComponent, canActivate: [AuthGuard] },
			{ path: 'spot-check-final', component: SpotCheckFinalComponent, canActivate: [AuthGuard] },
			{ path: 'fit-tracker', component: FitTrackerComponent, canActivate: [AuthGuard] },
			{
				path: 'atr-spot-check', component: AtrSpotCheckComponent, canActivate: [AuthGuard], children: [
					{ path: 'field-officer', component: AtrSpotCheckFOComponent, canActivate: [AuthGuard] },
					{ path: 'region-manager', component: AtrSpotCheckDRSMComponent, canActivate: [AuthGuard] }
				]
			},
			{
				path: 'mapping', component: MappingComponent, canActivate: [AuthGuard], children: [
					{ path: 'division-office', component: DivisionOfficeComponent, canActivate: [AuthGuard] },
					{ path: 'sales-area', component: SalesAreaComponent, canActivate: [AuthGuard] }
				]
			},
			{ path: 'ca-train', component: CaTrainingComponent, canActivate: [AuthGuard] },
			{ path: 'dsa-summary', component: DsaSummaryComponent, canActivate: [AuthGuard] },
			{ path: 'so-leaderboard', component: SoLeaderboardComponent, canActivate: [AuthGuard] },
			{ path: 'do-leaderboard', component: DoLeaderboardComponent, canActivate: [AuthGuard] },
			{ path: 'fo-leaderboard', component: FoLeaderboardComponent, canActivate: [AuthGuard] },
			{ path: 'do-engg-leaderboard', component: DoEnggLeaderboardComponent, canActivate: [AuthGuard] },
			{ path: 'do-manager-leaderboard', component: DoManagerLeaderboardComponent, canActivate: [AuthGuard] },
			{ path: 'so-manager-leaderboard', component: SoManagerLeaderboardComponent, canActivate: [AuthGuard] },
			{ path: 'audit-pdfs', component: AuditPdfsComponent, canActivate: [AuthGuard] },
			{ path: 'spot-check-reports', component: SpotCheckReportComponent, canActivate: [AuthGuard] },
			{ path: 'so-engg-leaderboard', component: SoEnggLeaderboardComponent, canActivate: [AuthGuard] },
			{ path: 'resources', component: ResourceComponent, canActivate: [AuthGuard] },
			{ path: 'help', component: HelpComponent, canActivate: [AuthGuard] },
			{ path: 'mis/report/:id', component: MisComponent, canActivate: [AuthGuard] },
			{ path: 'audit-user-docs', component: AuditUserDocumentsComponent, canActivate: [AuthGuard] },
			{ path: 'sqc-audit-pdfs', component: SqcAuditPdfsComponent, canActivate: [AuthGuard] },
			{ path: 'fo-audit-pdfs', component: FoAuditPdfsComponent, canActivate: [AuthGuard] },
			{ path: 'dealer-audit-pdfs', component: DealerAuditPdfsComponent, canActivate: [AuthGuard] },
		]
	},
	{ path: 'cois/activity-completion', component: ActivitiesCompletionComponent },
	{ path: 'cois/spot-check', component: SpotCheckFinalComponent },
	{ path: 'cois/audit-pdfs', component: AuditPdfsComponent },
	{ path: 'cois/fit-tracker', component: FitTrackerComponent },
	{ path: 'cois/audit-user-docs', component: AuditUserDocumentsComponent },
	{ path: 'cois/sqc-audit-pdfs', component: SqcAuditPdfsComponent },
	{ path: 'cois/fo-audit-pdfs', component: FoAuditPdfsComponent },
	{ path: 'cois/dealer-audit-pdfs', component: DealerAuditPdfsComponent },
	{ path: '**', redirectTo: '/signin' }
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule { }
