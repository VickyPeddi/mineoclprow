import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { DataProviderService } from 'src/app/shared/data-provider.service';
import { MessageService } from 'primeng/api';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ComplianceRemark } from 'src/app/shared/model/compliance-remark.model';
import { ApiResponse } from 'src/app/shared/model/api-response.model';
import { environment } from 'src/environments/environment';

@Component({
	selector: 'app-atr-spot-check-drsm',
	templateUrl: './atr-spot-check-drsm.component.html',
	styleUrls: ['./atr-spot-check-drsm.component.css']
})
export class AtrSpotCheckDRSMComponent implements OnInit {

	spotCheckDRSMComplianceDatas: any = [];
	searchText: string;

	currentInspNo: number;
	currentRoCode: number;
	currentRoName: string;

	spotCheckDRSMCompliancePoints: any = [];

	constructor(private title: Title, private dataProviderService: DataProviderService, private http: HttpClient, private messageService: MessageService) {
		this.title.setTitle('ATR on Spot Check by DRSM - Dhruva 2.0');
	}

	ngOnInit() {
		this.populateDRSMComplianceDatas();
	}

	onSelectInspection(listItem: any) {
		this.currentInspNo = listItem.inspNo;
		this.currentRoCode = listItem.roCode;
		this.currentRoName = listItem.roName;

		this.populateDRSMCompliancePoints();
	}


	onSubmitCompliancePoint(index: number, point: any) {

		if ((document.getElementById('complyCheck' + index) as any).checked) {

			let complianceRemark: ComplianceRemark = new ComplianceRemark(point.inspNo, point.moduleNo, point.questionNo, (document.getElementById('complyRemark' + index) as any).value);

			const httpOptions = {
				headers: new HttpHeaders({ 'Content-Type': 'application/json;charset=UTF-8' })
			};

			this.http.post<ApiResponse>(`${environment.backEndUrl}/spot-check/spot-check-drsm-compliance`, JSON.stringify(complianceRemark), httpOptions).subscribe(
				data => {
					if (data.success) {
						this.messageService.clear();
						this.messageService.add({ key: 'spot-atr-entry', severity: 'success', summary: 'Success', detail: 'Successfully Updated' });
					} else {
						this.messageService.clear();
						this.messageService.add({ key: 'spot-atr-entry', severity: 'error', summary: 'Error occurred', detail: 'Update failed!!' });
					}
				}, error => { },
				() => {
					this.populateDRSMCompliancePoints();
				}
			);

		} else {
			this.messageService.clear();
			this.messageService.add({ key: 'spot-atr-entry', severity: 'error', summary: 'Error occurred', detail: 'Please comply the point beDRSMre submitting...' });
		}
	}

	private populateDRSMComplianceDatas() {
		this.dataProviderService.loadSpotCheckDRSMComplianceDatas().subscribe(
			data => {
				if (data.length > 0) {
					this.spotCheckDRSMComplianceDatas = data;
				}
				else {
					this.spotCheckDRSMComplianceDatas = [];
				}
			},
			error => { },
			() => { });
	}

	private populateDRSMCompliancePoints() {
		this.dataProviderService.loadSpotCheckDRSMCompliancePoints(this.currentInspNo).subscribe(
			data => {
				this.spotCheckDRSMCompliancePoints = data;
			},
			error => { },
			() => {
				if (this.spotCheckDRSMCompliancePoints.length == 0) {
					this.populateDRSMComplianceDatas();
				}
			}
		);
	}
}
