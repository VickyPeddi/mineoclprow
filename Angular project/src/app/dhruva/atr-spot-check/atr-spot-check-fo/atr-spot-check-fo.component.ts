import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { DataProviderService } from 'src/app/shared/data-provider.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { MessageService } from 'primeng/api';
import { ComplianceRemark } from 'src/app/shared/model/compliance-remark.model';
import { environment } from 'src/environments/environment';
import { ApiResponse } from 'src/app/shared/model/api-response.model';

@Component({
	selector: 'app-atr-spot-check-fo',
	templateUrl: './atr-spot-check-fo.component.html',
	styleUrls: ['./atr-spot-check-fo.component.css']
})
export class AtrSpotCheckFOComponent implements OnInit {

	spotCheckFOComplianceDatas: any = [];
	searchText: string;

	currentInspNo: number;
	currentRoCode: number;
	currentRoName: string;

	spotCheckFOCompliancePoints: any = [];

	// spotCheckFOComplianceForm: FormGroup;

	constructor(private title: Title, private dataProviderService: DataProviderService, private http: HttpClient, private messageService: MessageService) {
		this.title.setTitle('ATR on Spot Check by FO - Dhruva 2.0');
	}

	ngOnInit() {
		this.populateFOComplianceDatas();
	}

	onSelectInspection(listItem: any) {
		this.currentInspNo = listItem.inspNo;
		this.currentRoCode = listItem.roCode;
		this.currentRoName = listItem.roName;

		this.populateFoCompliancePoints();
	}


	onSubmitCompliancePoint(index: number, point: any) {

		if ((document.getElementById('complyCheck' + index) as any).checked) {

			let complianceRemark: ComplianceRemark = new ComplianceRemark(point.inspNo, point.moduleNo, point.questionNo, (document.getElementById('complyRemark' + index) as any).value);

			const httpOptions = {
				headers: new HttpHeaders({ 'Content-Type': 'application/json;charset=UTF-8' })
			};

			this.http.post<ApiResponse>(`${environment.backEndUrl}/spot-check/spot-check-fo-compliance`, JSON.stringify(complianceRemark), httpOptions).subscribe(
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
					this.populateFoCompliancePoints();
				}
			);

		} else {
			this.messageService.clear();
			this.messageService.add({ key: 'spot-atr-entry', severity: 'error', summary: 'Error occurred', detail: 'Please comply the point before submitting...' });
		}
	}

	private populateFOComplianceDatas() {
		this.dataProviderService.loadSpotCheckFOComplianceDatas().subscribe(
			data => {
				if (data.length > 0) {
					this.spotCheckFOComplianceDatas = data;
				}
				else {
					this.spotCheckFOComplianceDatas = [];
				}
			},
			error => { },
			() => { });
	}

	private populateFoCompliancePoints() {
		this.dataProviderService.loadSpotCheckFOCompliancePoints(this.currentInspNo).subscribe(
			data => {
				this.spotCheckFOCompliancePoints = data;
			},
			error => { },
			() => {
				if (this.spotCheckFOCompliancePoints.length == 0) {
					this.populateFOComplianceDatas();
				}
			});
	}
}
