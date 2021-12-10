import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
import * as moment from 'moment';
import { MessageService } from 'primeng/api';
import { AuthService } from 'src/app/auth/auth.service';
import { DataProviderService } from 'src/app/shared/data-provider.service';
import { AuditWiseFITDetail } from 'src/app/shared/model/audit-wise-fit-detail.model';
import { TrackerRoMaster } from 'src/app/shared/model/tracker-ro-master.model';

@Component({
	selector: 'app-fit-tracker',
	templateUrl: './fit-tracker.component.html',
	styleUrls: ['./fit-tracker.component.css']
})
export class FitTrackerComponent implements OnInit {

	currentAuditNo: number;
	currentRoCode: number;
	currentRoName: string;
	currentPlanStartDate: string;
	currentActualAuditDate: string;
	isLoadingFitDetails: boolean = false;
	isLoadingTrackerDatas: boolean = false;

	dhruvaFitTrackerDatas: TrackerRoMaster[] = [];
	currentAudit: TrackerRoMaster;
	currentAuditWiseFITDetails: AuditWiseFITDetail[] = [];

	constructor(private route: ActivatedRoute, protected http: HttpClient, protected title: Title, protected dataProviderService: DataProviderService,
		protected authService: AuthService, private messageService: MessageService) {

		this.title.setTitle('FIT Tracker - Dhruva 2.0');
	}

	ngOnInit(): void {
		this.route.queryParams.subscribe(params => {
			if (params.token && params.user) {
				this.authService.accessToken = params.token;
				this.authService.empCode = params.user;
				this.authService.isCOISLogin = true;
			}
		});

		this.isLoadingTrackerDatas = true;
		this.dataProviderService.getLatestSubmittedAudits().subscribe(data => {
			this.dhruvaFitTrackerDatas = data;
		}, error => {
			this.isLoadingTrackerDatas = false;
		}, () => {
			this.isLoadingTrackerDatas = false;
		});

		$(document).ready(function () {
			window.history.pushState(null, "", window.location.href);
			window.onpopstate = function () {
				window.history.pushState(null, "", window.location.href);
			};
		});
	}

	selectRoCode(item: TrackerRoMaster) {
		this.currentAuditWiseFITDetails = [];
		this.currentAuditNo = item.auditNo;
		this.currentRoCode = item.roCode;
		this.currentRoName = item.roName;
		this.currentPlanStartDate = item.planStartDate;
		this.currentActualAuditDate = item.actualAuditDate;
		this.currentAudit = item;
		this.loadAuditWiseFitDetails(this.currentAuditNo);
	}

	loadAuditWiseFitDetails(currentAuditNo: number): any {
		this.isLoadingFitDetails = true;
		this.dataProviderService.loadAuditWiseFitDetails(currentAuditNo).subscribe(data => {
			if (data.length > 0) {
				this.currentAuditWiseFITDetails = data;
			}
		}, error => {
			this.isLoadingFitDetails = false;
		}, () => {
			this.isLoadingFitDetails = false;
		});
	}

}
