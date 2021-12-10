import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { Title } from '@angular/platform-browser';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { DataProviderService } from 'src/app/shared/data-provider.service';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { ApiResponse } from 'src/app/shared/model/api-response.model';

@Component({
	selector: 'app-sales-area',
	templateUrl: './sales-area.component.html',
	styleUrls: ['./sales-area.component.css']
})
export class SalesAreaComponent implements OnInit {

	saMappingDetailsForm: FormGroup;
	saList: any = [];
	divisionManagers: any = [];
	buttonDisable: boolean = false;

	constructor(private messageService: MessageService, private title: Title, private dataProviderService: DataProviderService, private http: HttpClient) {
		this.title.setTitle('Sales Area Mapping - Dhruva 2.0');
	}

	onResetForm() {
		this.saMappingDetailsForm = new FormGroup({
			'salesArea': new FormControl('', Validators.required),
			'divisionManager': new FormControl('', Validators.required)
		});
	}

	ngOnInit() {
		this.onResetForm();
		this.dataProviderService.loadMappingSalesAreas().subscribe(
			data => { this.saList = data; },
			error => { },
			() => { }
		);
		this.dataProviderService.loadMappingDivisionOfficeManagers().subscribe(
			data => { this.divisionManagers = data; },
			error => { },
			() => { }
		);
	}

	onSubmitSAMappingDetails() {
		this.buttonDisable = true;
		if (this.saMappingDetailsForm.valid) {
			const httpOptions = {
				headers: new HttpHeaders({ 'Content-Type': 'application/json;charset=UTF-8' })
			};
			this.http.post<ApiResponse>(`${environment.backEndUrl}/mapping/sales-area-mapping`, JSON.stringify(this.saMappingDetailsForm.value), httpOptions).subscribe(
				data => {
					if (data.success) {
						this.messageService.clear();
						this.messageService.add({ key: 'sa-mapping-status', severity: 'success', summary: 'Success!!!', detail: data.message });
					} else {
						this.messageService.clear();
						this.messageService.add({ key: 'sa-mapping-status', severity: 'error', summary: 'Failure!!!', detail: data.message });
					}
				},
				error => {
					this.buttonDisable = false;
					this.messageService.clear();
					this.messageService.add({ key: 'sa-mapping-status', severity: 'warn', summary: 'Failure!!!', detail: 'Failed, please contact administrator.' });
				},
				() => { this.buttonDisable = false; }
			);
		} else {
			this.buttonDisable = false;
			this.messageService.clear();
			this.messageService.add({ key: 'sa-mapping-status', severity: 'error', summary: 'Error occurred', detail: 'Error Occurred, please make sure that all fields are filled properly.' });
		}
	}

}
