import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import * as moment from 'moment';
import { MessageService } from 'primeng/api';
import { AuditWiseFITDetail } from 'src/app/shared/model/audit-wise-fit-detail.model';
import { environment } from 'src/environments/environment';
import { ApiResponse } from 'src/app/shared/model/api-response.model';
import { AuthService } from 'src/app/auth/auth.service';

@Component({
	selector: 'app-fit-tracker-facility',
	templateUrl: './fit-tracker-facility.component.html',
	styleUrls: ['./fit-tracker-facility.component.css']
})
export class FitTrackerFacilityComponent implements OnInit {

	protected backEndUrl: string = environment.backEndUrl;

	@Input() data: AuditWiseFITDetail;
	@Input() planStartDate: string;
	@Input() actualAuditDate: string;
	@Input() index: number;

	fitDetailForm: FormGroup;

	buttonDisable: boolean = false;
	selectedFile: FileList;
	protected currentFileUpload: File;

	imageFormats: string[] = ['jpg', 'jpeg', 'gif', 'png', 'tiff'];
	isFormatInValid: boolean = true;
	submitted: boolean = false;
	userLevel: string;
	isPhotoAvailable: boolean = false;

	constructor(private http: HttpClient, private messageService: MessageService, private authService: AuthService) { }

	ngOnInit() {
		this.userLevel = this.authService.userLevel == 'DO' ? 'FO' : this.authService.userLevel;
		//Now they want DO to have same role as FO in this..... Had we known this earlier code would have been so concise. User groups are supposed to mull well before finalising 
		//requirement for initial release

		this.fitDetailForm = new FormGroup({
			'fitTrackerPK': new FormControl(this.data.fitTrackerPK),
			'userLevel': new FormControl(this.userLevel),
			'facility': new FormControl({ value: this.data.categoryText, disabled: true }),
			// 'previousTPCScore': new FormControl({ value: '0', disabled: true }),
			'latestTPCScore': new FormControl({ value: this.data.score, disabled: true }),
			'stage': new FormControl({ value: 'MT', disabled: true }),
			'plannedStartDate': new FormControl({ value: this.planStartDate ? moment(this.planStartDate, 'DD-MMM-YYYY').format('YYYY-MM-DD') : '', disabled: true }),
			'actualStartDate': new FormControl({
				value: this.data.actualStartDate ? moment(this.data.actualStartDate, 'DD-MMM-YYYY').format('YYYY-MM-DD') : '',
				disabled: this.data.status != 100 || this.userLevel == 'DO'
			}, this.data.status != 100 || this.userLevel == 'DO' ? null : Validators.required),
			'plannedCompletionDate': new FormControl({ value: this.data.planTargetDate ? moment(this.data.planTargetDate, 'DD-MMM-YYYY').format('YYYY-MM-DD') : '', disabled: true }),
			'actualCompletionDate': new FormControl({
				value: this.data.actualCompleteDate ? moment(this.data.actualCompleteDate, 'DD-MMM-YYYY').format('YYYY-MM-DD') : '',
				disabled: this.data.status != 100 || this.userLevel == 'DO'
			}, this.data.status != 100 || this.userLevel == 'DO' ? null : Validators.required),
			'actionPlan': new FormControl({ value: this.data.actionPlan, disabled: true }),
			'status': new FormControl(this.data.status),
			'remarks': new FormControl({
				value: '',
				disabled: ((this.userLevel == 'FO') && this.data.status != 100) || (this.userLevel == 'DO' && this.data.status != 200)
			}, ((this.userLevel == 'FO') && this.data.status != 100) || (this.userLevel == 'DO' && this.data.status != 200) ? null : Validators.required)
		});

		this.http.get<ApiResponse>(`${environment.backEndUrl}/fit-tracker/check-photo-fit/${this.data.fitTrackerPK.auditId}/${this.data.fitTrackerPK.catId}`).subscribe(
			data => {
				this.isPhotoAvailable = data.success;
			}, error => {
				console.error(error);
			}, () => { }
		)
	}

	onSelectFile(event: any) {
		this.selectedFile = event.target.files;
		this.onUploadActivityFile();
	}

	onUploadActivityFile() {

		if (this.selectedFile == undefined) {
			this.messageService.add({ key: 'fit-tracker', severity: 'error', summary: 'Error occurred', detail: 'Please select a file!' });
			return false;
		}

		this.currentFileUpload = this.selectedFile.item(0);

		if (this.currentFileUpload == undefined) {
			this.messageService.add({ key: 'fit-tracker', severity: 'error', summary: 'Error occurred', detail: 'Please select a file!' });
			return false;
		}

		this.isFormatInValid = true;

		for (var i = 0; i < this.imageFormats.length; i++) {
			if (this.currentFileUpload.name.split('.').pop().toUpperCase() === this.imageFormats[i].toUpperCase()) {
				this.isFormatInValid = false;
				break;
			}
		}

		if (this.isFormatInValid) {
			this.messageService.add({ key: 'fit-tracker', severity: 'warn', summary: 'Fail!!!', detail: 'Please upload "image" files only' });
			this.selectedFile = undefined;
			return;
		}

		if (this.currentFileUpload.size > 10485760) {
			this.messageService.add({ key: 'fit-tracker', severity: 'error', summary: 'Error occurred', detail: 'Please select file less than 2MB!' });
			this.selectedFile = undefined;
			return false;
		}

		const formdata: FormData = new FormData();
		formdata.append('file', this.currentFileUpload);
		formdata.append('auditId', String(this.data.fitTrackerPK.auditId));
		formdata.append('categoryId', String(this.data.fitTrackerPK.catId));

		this.http.post<ApiResponse>(`${environment.backEndUrl}/fit-tracker/fit-tracker-file`, formdata).subscribe(
			data => {
				this.messageService.add({ key: 'fit-tracker', severity: 'success', summary: 'Success', detail: data.message });
				if (data.success) {
					this.isPhotoAvailable = true;
				} else {
					this.isPhotoAvailable = false;
				}
			},
			error => {
				this.messageService.add({ key: 'fit-tracker', severity: 'error', summary: 'Error occurred', detail: error });
				this.selectedFile = undefined;
				this.isPhotoAvailable = false;
			},
			() => {
				this.selectedFile = undefined;
			});
	}

	get f() {
		return this.fitDetailForm.controls;
	}

	onSubmitForm() {

		this.submitted = true;
		this.buttonDisable = true;

		if (!this.isPhotoAvailable) {
			this.messageService.clear();
			this.messageService.add({ key: 'fit-tracker', severity: 'error', summary: 'Error occurred', detail: 'Please upload some photo first!' });
			this.buttonDisable = false;
			return;
		}

		if (this.fitDetailForm.invalid) {

			this.buttonDisable = false;
			return;
		}

		const httpOptions = {
			headers: new HttpHeaders({ 'Content-Type': 'application/json;charset=UTF-8' })
		};
		this.http.post<ApiResponse>(`${environment.backEndUrl}/fit-tracker/fit-tracker-detail`, JSON.stringify(this.fitDetailForm.value), httpOptions).subscribe(
			data => {
				if (data.success) {
					this.messageService.clear();
					this.messageService.add({ key: 'fit-tracker', severity: 'success', summary: 'Success!!!', detail: data.message });
					this.buttonDisable = false;
					this.submitted = false;
				} else {
					this.messageService.clear();
					this.messageService.add({ key: 'fit-tracker', severity: 'error', summary: 'Failure!!!', detail: data.message });
					this.buttonDisable = false;
				}
			},
			error => {
				this.messageService.clear();
				this.messageService.add({
					key: 'fit-tracker', severity: 'error', summary: 'Failure!!!', detail: 'Update Failed, if system keeps on showing this error '
						+ 'then please contact administrator.'
				});
				this.buttonDisable = false;
			}
		);
	}

	onRevertToFO() {

		this.submitted = true;
		this.buttonDisable = true;

		if (this.fitDetailForm.invalid) {

			this.buttonDisable = false;
			return;
		}

		const httpOptions = {
			headers: new HttpHeaders({ 'Content-Type': 'application/json;charset=UTF-8' })
		};
		this.http.post<ApiResponse>(`${environment.backEndUrl}/fit-tracker/fit-tracker-detail/revert`, JSON.stringify(this.fitDetailForm.value), httpOptions).subscribe(
			data => {
				if (data.success) {
					this.messageService.clear();
					this.messageService.add({ key: 'fit-tracker', severity: 'success', summary: 'Success!!!', detail: data.message });
					this.buttonDisable = false;
					this.submitted = false;
				} else {
					this.messageService.clear();
					this.messageService.add({ key: 'fit-tracker', severity: 'error', summary: 'Failure!!!', detail: data.message });
					this.buttonDisable = false;
				}
			},
			error => {
				this.messageService.clear();
				this.messageService.add({
					key: 'fit-tracker', severity: 'error', summary: 'Failure!!!', detail: 'Update Failed, if system keeps on showing this error '
						+ 'then please contact administrator.'
				});
				this.buttonDisable = false;
			}
		);
	}

	onEditValues() {
		this.userLevel = 'FO';
		this.data.status = 100;
		this.f['actualStartDate'].enable();
		this.f['actualCompletionDate'].enable();
		this.f['remarks'].enable();
		this.f['status'].setValue(this.data.status);
	}

}
