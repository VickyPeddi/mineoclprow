import { ScrollingModule } from '@angular/cdk/scrolling';
import { HashLocationStrategy, LocationStrategy } from '@angular/common';
import { HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http";
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ServiceWorkerModule } from '@angular/service-worker';
import { DataTablesModule } from 'angular-datatables';
import { ChartsModule } from 'ng2-charts';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { PapaParseModule } from 'ngx-papaparse';
import { MessageService } from 'primeng/api';
import { CalendarModule } from 'primeng/calendar';
import { TableModule } from 'primeng/table';
import { ToastModule } from 'primeng/toast';
import { environment } from '../environments/environment';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuditPdfsComponent } from './audit-report/audit-pdfs/audit-pdfs.component';
import { SpotCheckReportComponent } from './audit-report/spot-check-report/spot-check-report.component';
import { AuditComponent } from './audit/audit.component';
import { VendorAdminComponent } from './audit/vendor-admin/vendor-admin.component';
import { VendorAssignComponent } from './audit/vendor-assign/vendor-assign.component';
import { VendorManageComponent } from './audit/vendor-manage/vendor-manage.component';
import { AuthGuard } from './auth/auth-guard.service';
import { AuthService } from './auth/auth.service';
import { SigninComponent } from './auth/signin/signin.component';
import { ActivitiesCompletionComponent } from './dhruva/activities-completion/activities-completion.component';
import { AtrRcaComponent } from './dhruva/atr-rca/atr-rca.component';
import { AtrSpotCheckDRSMComponent } from './dhruva/atr-spot-check/atr-spot-check-drsm/atr-spot-check-drsm.component';
import { AtrSpotCheckFOComponent } from './dhruva/atr-spot-check/atr-spot-check-fo/atr-spot-check-fo.component';
import { AtrSpotCheckComponent } from './dhruva/atr-spot-check/atr-spot-check.component';
import { CaTrainingComponent } from './dhruva/ca-training/ca-training.component';
import { DhruvaComponent } from './dhruva/dhruva.component';
import { DsaSummaryComponent } from './dhruva/dsa-summary/dsa-summary.component';
import { FitTrackerFacilityComponent } from './dhruva/fit-tracker/fit-tracker-facility/fit-tracker-facility.component';
import { FitTrackerComponent } from './dhruva/fit-tracker/fit-tracker.component';
import { HelpComponent } from './dhruva/help/help.component';
import { DoEnggLeaderboardComponent } from './dhruva/leaderboard/do-engg-leaderboard/do-engg-leaderboard.component';
import { DoLeaderboardComponent } from './dhruva/leaderboard/do-leaderboard/do-leaderboard.component';
import { DoManagerLeaderboardComponent } from './dhruva/leaderboard/do-manager-leaderboard/do-manager-leaderboard.component';
import { FoLeaderboardComponent } from './dhruva/leaderboard/fo-leaderboard/fo-leaderboard.component';
import { SoEnggLeaderboardComponent } from './dhruva/leaderboard/so-engg-leaderboard/so-engg-leaderboard.component';
import { SoLeaderboardComponent } from './dhruva/leaderboard/so-leaderboard/so-leaderboard.component';
import { SoManagerLeaderboardComponent } from './dhruva/leaderboard/so-manager-leaderboard/so-manager-leaderboard.component';
import { DivisionOfficeComponent } from './dhruva/mapping/division-office/division-office.component';
import { MappingComponent } from './dhruva/mapping/mapping.component';
import { SalesAreaComponent } from './dhruva/mapping/sales-area/sales-area.component';
import { MisNoFilterComponent } from './dhruva/mis/mis-no-filter/mis-no-filter.component';
import { MisSelOffArchetypePhaseQuarterIndexConsolidateSiteComponent } from './dhruva/mis/mis-sel-off-archetype-phase-quarter-index-consolidate-site/mis-sel-off-archetype-phase-quarter-index-consolidate-site.component';
import { MisSelOffArchetypePhaseQuarterIndexParameterSiteComponent } from './dhruva/mis/mis-sel-off-archetype-phase-quarter-index-parameter-site/mis-sel-off-archetype-phase-quarter-index-parameter-site.component';
import { MisSelOffArchetypePhaseQuarterIndexSiteComponent } from './dhruva/mis/mis-sel-off-archetype-phase-quarter-index-site/mis-sel-off-archetype-phase-quarter-index-site.component';
import { MisSelOffArchetypePhaseQuarterRoundIndexSiteComponent } from './dhruva/mis/mis-sel-off-archetype-phase-quarter-round-index-site/mis-sel-off-archetype-phase-quarter-round-index-site.component';
import { MisSelOffArchetypePhaseQuarterSiteComponent } from './dhruva/mis/mis-sel-off-archetype-phase-quarter-site/mis-sel-off-archetype-phase-quarter-site.component';
import { MisSelOffArchetypePhaseComponent } from './dhruva/mis/mis-sel-off-archetype-phase/mis-sel-off-archetype-phase.component';
import { MisSelOffConsolidateSiteComponent } from './dhruva/mis/mis-sel-off-consolidate-site/mis-sel-off-consolidate-site.component';
import { MisSelOffConsolidateComponent } from './dhruva/mis/mis-sel-off-consolidate/mis-sel-off-consolidate.component';
import { MisSelOffDateRangeConsolidateComponent } from './dhruva/mis/mis-sel-off-date-range-consolidate/mis-sel-off-date-range-consolidate.component';
import { MisSelOffDateRangeComponent } from './dhruva/mis/mis-sel-off-date-range/mis-sel-off-date-range.component';
import { MisSelOffMonthRangeConsolidateComponent } from './dhruva/mis/mis-sel-off-month-range-consolidate/mis-sel-off-month-range-consolidate.component';
import { MisSelOffMonthRangeComponent } from './dhruva/mis/mis-sel-off-month-range/mis-sel-off-month-range.component';
import { MisSelOffComponent } from './dhruva/mis/mis-sel-off/mis-sel-off.component';
import { MisComponent } from './dhruva/mis/mis.component';
import { ResourceComponent } from './dhruva/resource/resource.component';
import { SpotCheckFinalComponent } from './dhruva/spot-check-final/spot-check-final.component';
import { TelecallCadenceComponent } from './dhruva/telecall-cadence/telecall-cadence.component';
import { ErrorInterceptor } from './helper/error.interceptor';
import { JWTInterceptor } from './helper/jwt.interceptor';
import { DashboardComponent } from './home/dashboard/dashboard.component';
import { DOAwesumDashboardComponent } from './home/dashboard/do-dashboard/awesum-dashboard/do-awesum-dashboard.component';
import { DODhruvaCompliantDashboardComponent } from './home/dashboard/do-dashboard/dhruva-compliant-dashboard/do-dhruva-compliant-dashboard.component';
import { DoDashboardComponent } from './home/dashboard/do-dashboard/do-dashboard.component';
import { DOFitDashboardComponent } from './home/dashboard/do-dashboard/fit-dashboard/do-fit-dashboard.component';
import { DOMasterDashboardComponent } from './home/dashboard/do-dashboard/master-dashboard/do-master-dashboard.component';
import { DOSevaDashboardComponent } from './home/dashboard/do-dashboard/seva-dashboard/do-seva-dashboard.component';
import { SaAwesumDashboardComponent } from './home/dashboard/sa-dashboard/awesum-dashboard/sa-awesum-dashboard.component';
import { SaDhruvaCompliantDashboardComponent } from './home/dashboard/sa-dashboard/dhruva-compliant-dashboard/sa-dhruva-compliant-dashboard.component';
import { SaFitDashboardComponent } from './home/dashboard/sa-dashboard/fit-dashboard/sa-fit-dashboard.component';
import { SaMasterDashboardComponent } from './home/dashboard/sa-dashboard/master-dashboard/sa-master-dashboard.component';
import { SaDashboardComponent } from './home/dashboard/sa-dashboard/sa-dashboard.component';
import { SaSevaDashboardComponent } from './home/dashboard/sa-dashboard/seva-dashboard/sa-seva-dashboard.component';
import { AwesumDashboardComponent } from './home/dashboard/so-dashboard/awesum-dashboard/awesum-dashboard.component';
import { DhruvaCompliantDashboardComponent } from './home/dashboard/so-dashboard/dhruva-compliant-dashboard/dhruva-compliant-dashboard.component';
import { FitDashboardComponent } from './home/dashboard/so-dashboard/fit-dashboard/fit-dashboard.component';
import { MasterDashboardComponent } from './home/dashboard/so-dashboard/master-dashboard/master-dashboard.component';
import { SevaDashboardComponent } from './home/dashboard/so-dashboard/seva-dashboard/seva-dashboard.component';
import { SoDashboardComponent } from './home/dashboard/so-dashboard/so-dashboard.component';
import { HomeComponent } from './home/home.component';
import { LoaderComponent } from './loader/loader.component';
import { DataExportService } from './shared/data-export.service';
import { DataProviderService } from './shared/data-provider.service';
import { NetworkStatusService } from './shared/network-status.service';
import { ColorCodePipe } from './shared/pipes/color-code.pipe';
import { DoColorCodePipe } from './shared/pipes/do-color-code.pipe';
import { FitTrackerStatusPipe } from './shared/pipes/fit-tracker-status.pipe';
import { FoColorCodePipe } from './shared/pipes/fo-color-code.pipe';
import { NameInitialsPipe } from './shared/pipes/name-initials.pipe';
import { SiteResponsiblePipe } from './shared/pipes/site-responsible.pipe';
import { SoColorCodePipe } from './shared/pipes/so-color-code.pipe';
import { AuditUserDocumentsComponent } from './audit-report/audit-user-documents/audit-user-documents.component';
import { MisSelOffArchetypePhaseIndexSiteComponent } from './dhruva/mis/mis-sel-off-archetype-phase-index-site/mis-sel-off-archetype-phase-index-site.component';
import { MisSelOffArchetypePhaseSiteComponent } from './dhruva/mis/mis-sel-off-archetype-phase-site/mis-sel-off-archetype-phase-site.component';
import { SqcAuditPdfsComponent } from './audit-report/sqc-audit-pdfs/sqc-audit-pdfs.component';
import { MisSelOffArchetypePhaseIndexParamSiteComponent } from './dhruva/mis/mis-sel-off-archetype-phase-index-param-site/mis-sel-off-archetype-phase-index-param-site.component';
import { MisSelOffArchetypePhaseYearIndexParameterSiteComponent } from './dhruva/mis/mis-sel-off-archetype-phase-year-index-parameter-site/mis-sel-off-archetype-phase-year-index-parameter-site.component';
import { MisSelOffArchetypePhaseYearIndexConsolidateSiteComponent } from './dhruva/mis/mis-sel-off-archetype-phase-year-index-consolidate-site/mis-sel-off-archetype-phase-year-index-consolidate-site.component';
import { MisSelOffArchetypePhaseYearSiteComponent } from './dhruva/mis/mis-sel-off-archetype-phase-year-site/mis-sel-off-archetype-phase-year-site.component';
import { FoAuditPdfsComponent } from './audit-report/fo-audit-pdfs/fo-audit-pdfs.component';
import { DealerAuditPdfsComponent } from './audit-report/dealer-audit-pdfs/dealer-audit-pdfs.component';


@NgModule({
	declarations: [
		AppComponent,
		SigninComponent,
		HomeComponent,
		DhruvaComponent,
		ActivitiesCompletionComponent,
		AtrRcaComponent,
		TelecallCadenceComponent,
		LoaderComponent,
		MisComponent,
		SiteResponsiblePipe,
		MisSelOffComponent,
		MisSelOffDateRangeComponent,
		MisSelOffDateRangeConsolidateComponent,
		MisSelOffConsolidateComponent,
		CaTrainingComponent,
		MisSelOffMonthRangeComponent,
		MisSelOffMonthRangeConsolidateComponent,
		NameInitialsPipe,
		MisNoFilterComponent,
		SpotCheckFinalComponent,
		MisSelOffArchetypePhaseComponent,
		SoLeaderboardComponent,
		DoLeaderboardComponent,
		FoLeaderboardComponent,
		ColorCodePipe,
		DoEnggLeaderboardComponent,
		SoEnggLeaderboardComponent,
		SoManagerLeaderboardComponent,
		DoManagerLeaderboardComponent,
		DoColorCodePipe,
		SoColorCodePipe,
		FoColorCodePipe,
		FitDashboardComponent,
		SevaDashboardComponent,
		MasterDashboardComponent,
		DashboardComponent,
		AwesumDashboardComponent,
		DhruvaCompliantDashboardComponent,
		AuditPdfsComponent,
		MisSelOffConsolidateSiteComponent,
		SoDashboardComponent,
		DoDashboardComponent,
		SaDashboardComponent,
		DOMasterDashboardComponent,
		DOFitDashboardComponent,
		DOSevaDashboardComponent,
		DODhruvaCompliantDashboardComponent,
		DOAwesumDashboardComponent,
		AuditComponent,
		VendorAdminComponent,
		VendorAssignComponent,
		VendorManageComponent,
		SaMasterDashboardComponent,
		SaAwesumDashboardComponent,
		SaDhruvaCompliantDashboardComponent,
		SaFitDashboardComponent,
		SaSevaDashboardComponent,
		SpotCheckReportComponent,
		AtrSpotCheckFOComponent,
		AtrSpotCheckComponent,
		MisSelOffArchetypePhaseQuarterIndexSiteComponent,
		ResourceComponent,
		HelpComponent,
		AtrSpotCheckDRSMComponent,
		MappingComponent,
		DivisionOfficeComponent,
		SalesAreaComponent,
		FitTrackerComponent,
		FitTrackerFacilityComponent,
		FitTrackerStatusPipe,
		DsaSummaryComponent,
		MisSelOffArchetypePhaseQuarterIndexParameterSiteComponent,
		MisSelOffArchetypePhaseQuarterIndexConsolidateSiteComponent,
		MisSelOffArchetypePhaseQuarterSiteComponent,
		MisSelOffArchetypePhaseQuarterRoundIndexSiteComponent,
		AuditUserDocumentsComponent,
		MisSelOffArchetypePhaseIndexSiteComponent,
		MisSelOffArchetypePhaseSiteComponent,
		SqcAuditPdfsComponent,
		MisSelOffArchetypePhaseIndexParamSiteComponent,
		MisSelOffArchetypePhaseYearIndexParameterSiteComponent,
		MisSelOffArchetypePhaseYearIndexConsolidateSiteComponent,
		MisSelOffArchetypePhaseYearSiteComponent,
		FoAuditPdfsComponent,
		DealerAuditPdfsComponent,
	],
	imports: [
		BrowserModule,
		BrowserAnimationsModule,
		AppRoutingModule,
		FormsModule,
		ReactiveFormsModule,
		HttpClientModule,
		ScrollingModule,
		ToastModule,
		CalendarModule,
		Ng2SearchPipeModule,
		PapaParseModule,
		ChartsModule,
		TableModule,
		DataTablesModule,
		ServiceWorkerModule.register('ngsw-worker.js', { enabled: environment.production })
	],
	providers: [
		{ provide: HTTP_INTERCEPTORS, useClass: JWTInterceptor, multi: true },
		{ provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
		{ provide: LocationStrategy, useClass: HashLocationStrategy },
		AuthService, DataProviderService, AuthGuard, NetworkStatusService, DataExportService, MessageService
	],
	bootstrap: [AppComponent]
})
export class AppModule { }
