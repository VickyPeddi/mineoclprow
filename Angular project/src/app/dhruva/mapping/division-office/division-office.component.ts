import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { Title } from '@angular/platform-browser';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { DataProviderService } from 'src/app/shared/data-provider.service';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { ApiResponse } from 'src/app/shared/model/api-response.model';
import { environment } from 'src/environments/environment';

@Component({
	selector: 'app-division-office',
	templateUrl: './division-office.component.html',
	styleUrls: ['./division-office.component.css']
})
export class DivisionOfficeComponent implements OnInit {

	doMappingDetailsForm: FormGroup;
	doList: any = [];
	stateManagers: any = [];
	buttonDisable: boolean = false;

	constructor(private messageService: MessageService, private title: Title, private dataProviderService: DataProviderService, private http: HttpClient) {
		this.title.setTitle('Division Office Mapping - Dhruva 2.0');
	}

	onResetForm() {
		this.doMappingDetailsForm = new FormGroup({
			'salesOff': new FormControl('', Validators.required),
			'stateManager': new FormControl('', Validators.required)
		});
	}

	ngOnInit() {
		this.onResetForm();
		this.dataProviderService.loadMappingDivisionOffices().subscribe(
			data => { this.doList = data; },
			error => { },
			() => { }
		);
		this.dataProviderService.loadMappingStateOfficeManagers().subscribe(
			data => { this.stateManagers = data; },
			error => { },
			() => { }
		);
	}

	onSubmitDOMappingDetails() {
		this.buttonDisable = true;
		if (this.doMappingDetailsForm.valid) {
			const httpOptions = {
				headers: new HttpHeaders({ 'Content-Type': 'application/json;charset=UTF-8' })
			};
			this.http.post<ApiResponse>(`${environment.backEndUrl}/mapping/division-office-mapping`, JSON.stringify(this.doMappingDetailsForm.value), httpOptions).subscribe(
				data => {
					if (data.success) {
						this.messageService.clear();
						this.messageService.add({ key: 'do-mapping-status', severity: 'success', summary: 'Success!!!', detail: data.message });
					} else {
						this.messageService.clear();
						this.messageService.add({ key: 'do-mapping-status', severity: 'error', summary: 'Failure!!!', detail: data.message });
					}
				},
				error => {
					this.buttonDisable = false;
					this.messageService.clear();
					this.messageService.add({ key: 'do-mapping-status', severity: 'warn', summary: 'Failure!!!', detail: 'Failed, please contact administrator.' });
				},
				() => { this.buttonDisable = false; }
			);
		} else {
			this.buttonDisable = false;
			this.messageService.clear();
			this.messageService.add({ key: 'do-mapping-status', severity: 'error', summary: 'Error occurred', detail: 'Error Occurred, please make sure that all fields are filled properly.' });
		}
	}
}
